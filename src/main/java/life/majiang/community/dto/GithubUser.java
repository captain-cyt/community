package life.majiang.community.dto;

import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-06 11:57
 */
@Data
public class GithubUser {
    public String name;
    public Long id;
    public String bio;
    public String avatarUrl;
}
