package life.majiang.community.enums;

/**
 * @author c_sir
 * @create 2020-03-31 11:31
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commenttypeEnum : CommentTypeEnum.values()) {
            if (commenttypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
