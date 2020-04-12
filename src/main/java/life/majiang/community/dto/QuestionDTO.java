package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-15 12:58
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
