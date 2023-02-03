// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Bed;

import java.io.*;

public class BedDao {



    public static boolean save(Bed bed) {
        boolean x = false;


        try {
            FileWriter fw = new FileWriter("data_store/allocated_bed.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String rec = bed.getBid()+","+bed.getPid();

            bw.write(rec);
            bw.newLine();
            x = true;
            bw.close();
            System.out.println("Successfully allocated");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return x;
    }

    public static Bed checkAvailableBeds(String bId) {
        Bed bed = null;
        try {

            File file = new File("data_store/allocated_bed.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");

                if (bId == data[0]){
                    bed = new Bed();
                    bed.setPid((data[0]));
                    bed.setBid(data[1]);

                    break;

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bed;
    }


    public static void showDoctors() {

        try {

            File file = new File("data_store/beds.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                System.out.print("ID :- "+data[0]+"   "+"\n");

            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
