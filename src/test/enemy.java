package test;

//import test.Character;
import DTO.DTO;

public class enemy extends Character {

    DTO a = new DTO();

    public enemy() {

    }

    public enemy(int id,String name,int level,int attack_value) {

        //super(id,name,level,offence);

        a.setId(id);
        a.setName(name);
        a.setLevel(level);
        a.setAttack_value(attack_value);
    }

}
