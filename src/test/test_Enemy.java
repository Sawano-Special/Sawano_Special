package test;

import java.util.Random;

//import test.Character;
import DTO.enemy;

public class test_Enemy extends DTO.enemy  {

    public test_Enemy(Integer id, String name, int level, int speed, String finish_word, int attack_value, int hp, int max_hp) {
        super(id, name, level, speed, finish_word, attack_value, hp,max_hp);
        // TODO 自動生成されたコンストラクター・スタブ

        b.setId(id);
        b.setName(name);
        b.setLevel(level);
        b.setSpeed(speed);
        b.setFinish_word(finish_word);
        b.setAttack_value(attack_value);
        b.setHp(hp);
        b.setMax_hp(max_hp);

    }

    public test_Enemy(String name, int level, int attack_value) {
        super(name, level, attack_value);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    enemy b = new enemy();

    public test_Enemy() {

    }

    public test_Enemy(enemy b) {
        super();
        this.b = b;
    }

    public int attack() {

        Random rand = new Random();

        double[] result = {0.2,0.4,0.6,0.8,1.0};

        double mag = result[(int)(Math.random()*5)];

        System.out.println(mag);

        double damege = b.getAttack_value() * mag;

        //int damege = rand.nextInt(b.getAttack_value())+1;


        //int damege = b.getAttack_value();

        System.out.println( b.getName() +"は" + damege +"のダメージを与えた.");

        return (int)damege;
    }

}
