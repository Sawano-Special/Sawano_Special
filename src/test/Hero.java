package test;
import DTO.DTO;

public class Hero extends DTO  {

    DTO a = new DTO();
public Hero(int id,String name,int level,int attack_value) {
        //super(id,name,level,offence); //Characterクラスのコンストラクタを呼び出し
        a.setId(id);
        a.setName(name);
        a.setLevel(level);
        a.setAttack_value(attack_value);

    }

    public int attack() {

        int damege = a.getAttack_value();
        System.out.println( a.getName() +"は" + damege +"のダメージを与えた");

        return damege;
    }

}
