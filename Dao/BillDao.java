// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Bill;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BillDao {

    public static boolean save(Bill bill) {
        boolean x = false;

        try {
            FileWriter fw = new FileWriter("data_store/bill.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String rec = bill.getpId()+","+bill.getDate()+","+bill.getpName()+
                    ","+bill.getNoOfDates()+","+bill.getPrice();
            bw.write(rec);
            bw.newLine();
            x = true;
            bw.close();
            System.out.println("....Successfully saved....");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return x;
    }
    
}
