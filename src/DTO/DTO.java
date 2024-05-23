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
        name = "getAllhero",
        query = "SELECT d FROM DTO AS d ORDER BY d.id DESC"

    )
})
@Table(name = "hero")
public class DTO {
    public DTO(String name, int level, int defence, int speed, String finish_ward, int attack_value, int hp) {
        super();
        this.name = name;
        this.level = level;
        this.defence = defence;
        this.speed = speed;
        this.finish_ward = finish_ward;
        this.attack_value = attack_value;
        this.hp = hp;
    }
    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getFinish_ward() {
        return finish_ward;
    }
    public void setFinish_ward(String finish_ward) {
        this.finish_ward = finish_ward;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public DTO(Integer id, String name, int level, int defence, int speed, String finish_ward, int attack_value,
            int hp) {
        super();
        this.id = id;
        this.name = name;
        this.level = level;
        this.defence = defence;
        this.speed = speed;
        this.finish_ward = finish_ward;
        this.attack_value = attack_value;
        this.hp = hp;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "Level")
    private int level;

    @Column(name = "defence")
    private int defence;

    @Column(name = "speed")
    private int speed;

    @Column(name = "finish_ward")
    private String finish_ward;

    @Column(name = "attack_value")
    private int attack_value;

    @Column(name = "hp")
    private int hp;



    public DTO(String name, int level, int attack_value) {
        super();
        this.name = name;
        this.level = level;
        this.attack_value = attack_value;
    }
    public DTO() {
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