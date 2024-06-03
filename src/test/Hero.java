package test;
import java.util.Random;

import DTO.DTO;

public class Hero extends DTO  {

    DTO a = new DTO();
public Hero(int id ,String name, int level, int defence, int speed, String finish_word, int attack_value, int hp, int max_hp) {
        //super(id,name,level,offence); //Characterクラスのコンストラクタを呼び出し
        a.setId(id);
        a.setName(name);
        a.setLevel(level);
        a.setDefence(defence);
        a.setSpeed(speed);
        a.setFinish_word(finish_word);
        a.setAttack_value(attack_value);
        a.setHp(hp);
        a.setMax_hp(max_hp);

    }


   public int attack_value(){
       int attack=0;
       return attack;

   }
    public int attack() {

        Random rand = new Random();

        double[] result = {0.2,0.4,0.6,0.8,1.0};

        double mag = result[(int)(Math.random()*5)];

        System.out.println(mag);
        double damage = 0.0;
if(mag==0) {
	damage = a.getAttack_value() * mag;
}else {
	damage = a.getAttack_value() * mag;
}

        //Random rand = new Random();
        //int damage = rand.nextInt(a.getAttack_value())+1;

        //int damage = a.getAttack_value();

        System.out.println( a.getName() +"は" + damage +"のダメージを与えた");

        return (int)damage;
    }

    public String finish_word() {
        String word = a.getFinish_word();
        return word;
    }

    public int defence(int hp,int damage) {
        int HP = hp;

        return HP;
    }

    public int recovery(int hp) {
        int recovery = hp + 30;
        System.out.println("recovery:"+recovery);
        return recovery;
    }

}
