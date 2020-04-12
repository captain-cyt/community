package life.majiang.community.dto;

import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-30 19:15
 */
@Data

public class CommentDTO {
    private Long parentId;
    private String content;
    private int type;
}
