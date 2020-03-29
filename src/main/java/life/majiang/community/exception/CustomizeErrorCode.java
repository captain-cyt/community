package life.majiang.community.exception;

/**
 * @author c_sir
 * @create 2020-03-25 15:28
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

     QUESTION_NOT_FOUND("你要找的问题不存在，要不换一个试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
