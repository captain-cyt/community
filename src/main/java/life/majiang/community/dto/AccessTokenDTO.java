package life.majiang.community.dto;

import lombok.Data;

/**
 * @author c_sir
 * @create 2020-03-06 11:10
 * 数据传输对象模型
 */
@Data
public class AccessTokenDTO {
    public String client_id;
    public String client_secret;
    public String code;
    public String redirect_uri;
    public String state;


}
