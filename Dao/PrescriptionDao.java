// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Prescription;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PrescriptionDao {


    public static boolean save(Prescription prescription) {
        boolean x = false;

        try {
            FileWriter fw = new FileWriter("data_store/prescription.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String rec = prescription.getDate()+","+
                         prescription.getpName()+","+
                         prescription.getAge()+","+
                         prescription.getDoctorName()+","+
                         prescription.getDrugName()+","+
                         prescription.getQuentity()+","+
                         prescription.getPrice();

            bw.write(rec);
            bw.newLine();
            x = true;
            bw.close();
            System.out.println("....Successfully Saved....");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return x;
    }


}
