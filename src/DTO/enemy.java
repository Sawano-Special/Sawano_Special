package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllenemy",
        query = "SELECT e FROM enemy AS e ORDER BY e.id DESC"

    )
})
@Table(name = "enemy")
public class enemy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "Level")
    private int level;

    @Column(name = "speed")
    private int speed;

    @Column(name = "finish_word")
    private String finish_word;

    @Column(name = "attack_value")
    private int attack_value;

    @Column(name = "hp")
    private int hp;

    @Column(name = "max_hp")
    private int max_hp;


    public enemy(String name, int level, int speed, String finish_word, int attack_value, int hp, int max_hp) {
        super();
        this.name = name;
        this.level = level;
        this.speed = speed;
        this.finish_word = finish_word;
        this.attack_value = attack_value;
        this.hp = hp;
        this.max_hp = max_hp;
        System.out.print("登録");
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getFinish_word() {
        return finish_word;
    }
    public void setFinish_word(String finish_word) {
        this.finish_word = finish_word;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public enemy(Integer id, String name, int level, int speed, String finish_word, int attack_value,
            int hp, int max_hp) {
        super();
        this.id = id;
        this.name = name;
        this.level = level;
        this.speed = speed;
        this.finish_word = finish_word;
        this.attack_value = attack_value;
        this.hp = hp;
        this.max_hp = max_hp;
    }





    public enemy(String name, int level, int attack_value) {
        super();
        this.name = name;
        this.level = level;
        this.attack_value = attack_value;
    }
    public int getMax_hp() {
        return max_hp;
    }
    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }
    public enemy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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



    public int getAttack_value() {
        return attack_value;
    }

    public void setAttack_value(int attack_value) {
        this.attack_value = attack_value;
    }




}