package life.majiang.community.service;

import life.majiang.community.dto.PageinationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c_sir
 * @create 2020-03-15 13:01
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PageinationDTO list(Integer page, Integer size) {
        PageinationDTO pageinationDTO = new PageinationDTO();
        Integer totalCount = questionMapper.count();
        pageinationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page =  1;
        }
        if (page > pageinationDTO.getTotalPage()) {
            page = pageinationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1); //分页功能
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);    //把question里面的对象拷贝进questionDTO，相当于questionDTO.set()
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageinationDTO.setQuestions(questionDTOList);


        return pageinationDTO;

    }

    public PageinationDTO  list(Integer userId, Integer page, Integer size) {
        PageinationDTO pageinationDTO = new PageinationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        pageinationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page =  1;
        }
        if (page >= pageinationDTO.getTotalPage()) {
            page = pageinationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1); //分页功能
        List<Question> questions = questionMapper.listByUserId(userId,offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);    //把question里面的对象拷贝进questionDTO，相当于questionDTO.set()
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageinationDTO.setQuestions(questionDTOList);


        return pageinationDTO;

    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);//把question复制到questionDTO
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            //如果没有这个问题的id我们就创建这个问题
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.create(question);
        }else{
            //如果有这个问题我们就对这个问题进行更新
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.update(question);

        }
    }
}

