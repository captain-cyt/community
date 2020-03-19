package life.majiang.community.model;

import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-10 20:49
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}
