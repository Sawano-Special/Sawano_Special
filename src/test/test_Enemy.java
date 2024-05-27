package test;

import DTO.enemy;

//import test.Character;

public class test_Enemy extends enemy  {

    public test_Enemy(Integer id, String name, int level, int speed, String finish_ward, int attack_value, int hp, int max_hp) {
        super(id, name, level, speed, finish_ward, attack_value, hp,max_hp);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public test_Enemy(String name, int level, int attack_value) {
        super(name, level, attack_value);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    enemy b = new enemy();

    public test_Enemy() {

    }

    public test_Enemy(test_Enemy b) {
        super();
        this.b = b;
    }

    public int attack() {

        int damege = b.getAttack_value();

        System.out.println( b.getName() +"は" + damege +"のダメージを与えた");

        return damege;
    }

}
