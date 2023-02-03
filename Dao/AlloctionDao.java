// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Allocate;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class AlloctionDao {
    public static boolean save(Allocate allocate) {
        boolean x = false;


        try {
            FileWriter fw = new FileWriter("data_store/allocation.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String rec = allocate.getAId()+","+allocate.getAName()+","+allocate.getAAge()+","
                    +allocate.getAGender()+","+allocate.getAMobile()+","+allocate.getAEmail()+","+allocate.getADoctor();
            bw.write(rec);
            bw.newLine();
            x = true;
            bw.close();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return x;
    }
}
