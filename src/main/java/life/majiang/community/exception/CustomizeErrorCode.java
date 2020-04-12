package life.majiang.community.exception;

/**
 * @author c_sir
 * @create 2020-03-25 15:28
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你要找的问题不存在，要不换一个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "用户未登录不能评论，请先登录！！！！"),
    SYS_ERROR(2004,"服务器冒烟了！要不稍后再试试？"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"你需要回复的评论不存在");

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
