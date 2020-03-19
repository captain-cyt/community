package life.majiang.community.model;

import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-07 13:55
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    public String avatarUrl;
}
