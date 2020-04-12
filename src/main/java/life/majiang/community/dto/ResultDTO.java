package life.majiang.community.dto;

import com.mysql.cj.protocol.Message;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import lombok.Data;

import javax.xml.transform.Result;

/**
 * @author c_sir
 * @create 2020-03-31 11:06
 */
@Data
public class ResultDTO {
    private Integer code;   //自定义的登录状态码
    private String message;
    public static ResultDTO errorOf(Integer code, String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }
    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }
    public static ResultDTO OkOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功！");
        return resultDTO;
    }


}
