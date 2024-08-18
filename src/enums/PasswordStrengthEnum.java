package enums;

public enum PasswordStrengthEnum {

    FAIL(0),//0
    LOW(10),//ordinal:0-->1
    MEDIUM(50),//1-->2
    HIGH(100);//2-->3

    private final int level;//field

    //getter
    public int getLevel() {
        return level;
    }

    //param const
    PasswordStrengthEnum(int level){
        this.level=level;
    }




}