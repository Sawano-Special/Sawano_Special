package test;
import DTO.DTO;

public class Hero extends DTO  {

    DTO a = new DTO();
public Hero(int id ,String name, int level, int defence, int speed, String finish_ward, int attack_value, int hp, int max_hp) {
        //super(id,name,level,offence); //Characterクラスのコンストラクタを呼び出し
        a.setId(id);
        a.setName(name);
        a.setLevel(level);
        a.setDefence(defence);
        a.setSpeed(speed);
        a.setFinish_ward(finish_ward);
        a.setAttack_value(attack_value);
        a.setHp(hp);
        a.setMax_hp(max_hp);

    }


   public int attack_value(){
       int attack=0;
       return attack;

   }
    public int attack() {

        int damege = a.getAttack_value();

        System.out.println( a.getName() +"は" + damege +"のダメージを与えた");

        return damege;
    }

    public String finish_ward() {
        String ward = a.getFinish_ward();
        return ward;
    }

    public int defence(int hp,int damage) {
        int HP = hp;

        return HP;
    }

}
