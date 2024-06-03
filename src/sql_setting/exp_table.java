package sql_setting;

import javax.persistence.EntityManager;

import DTO.DTO;
import utils.DBUtils;

public class exp_table {

    public static String exp_update(int id,int stage,String name) {
        EntityManager em = DBUtils.createEntityManager();
        id = 1; //ここに変更するidを入力
        DTO d = em.find(DTO.class, id);

        // 新しいの設定
        int total_exp =d.getTotal_exp();
        int exp =d.getExp();
        try {

            // 該当のIDのメッセージ1件のみをデータベースから取得
            if(stage==1) {
                exp+=1;
                d.setExp(exp);
                total_exp+=1;
                d.setTotal_exp(total_exp);
            }else if(stage==2) {
                exp+=2;
                d.setExp(exp);
                total_exp+=2;
                d.setTotal_exp(total_exp);

            }else if(stage==3) {
                exp+=4;
                d.setExp(exp);
                total_exp+=4;
                d.setTotal_exp(total_exp);

            }else if(stage==4) {
                exp+=7;
                d.setExp(exp);
                total_exp+=7;
                d.setTotal_exp(total_exp);
            }else {
                exp+=10;
                d.setExp(exp);
                total_exp+=10;
                d.setTotal_exp(total_exp);
            }
            // 変更をコミット
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("データの更新が完了しました.");

        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        System.out.println("exp:"+exp);
        if(stage==1) {
            return name+"は経験値を1獲得した！";
        }else if(stage==2) {
            return name+"は経験値を2獲得した！";
        }else if(stage==3) {
            return name+"は経験値を4獲得した！";
        }else if(stage==4) {
            return name+"は経験値を7獲得した！";
        }else {
            return name+"は経験値を10獲得した！";
        }
    }
}