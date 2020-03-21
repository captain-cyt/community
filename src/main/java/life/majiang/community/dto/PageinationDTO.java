package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c_sir
 * @create 2020-03-16 14:58
 */
@Data
public class PageinationDTO {
    private List<QuestionDTO> questions;
    private boolean showFirstPage;
    private boolean showPrevious;
    private boolean showNext;
    private boolean showEndPage;
    private List<Integer> pages = new ArrayList<>();
    private Integer page;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        //  控制底部页码如何显示
        if(page < 1){
            page = 1;
        }else if (page > totalPage){
            page = totalPage;
        }
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //防止数组越界
//        if (page < 1) {
//            page = 1;
//        }
//        if (page >= totalPage) {
//            page = totalPage;
//        }

        //是否展示上一页button
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页button
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示首页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示尾页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
