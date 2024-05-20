package test;

public class Character {

    //フィールド設定
    private int id;
    private String name;
    private int level;
    private int offence;

    //引数なしコンストラクタ
    public Character() {

    }

    //引数ありコンストラクタ
    public Character(int id,String name,int level,int offence) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.offence = offence;

    }

//Getter,Setterの設定r
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOffence() {
        return offence;
    }

    public void setOffence(int offence) {
        this.offence = offence;
    }





}
