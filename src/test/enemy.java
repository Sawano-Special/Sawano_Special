package test;

//import test.Character;

public class enemy extends DTO.enemy  {

    public enemy(Integer id, String name, int level, int speed, String finish_word, int attack_value, int hp, int max_hp) {
        super(id, name, level, speed, finish_word, attack_value, hp,max_hp);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public enemy(String name, int level, int attack_value) {
        super(name, level, attack_value);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    enemy b = new enemy();

    public enemy() {

    }

    public enemy(enemy b) {
        super();
        this.b = b;
    }

    public int attack() {

        int damege = b.getAttack_value();

        System.out.println( b.getName() +"は" + damege +"のダメージを与えた");

        return damege;
    }

}
