// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Doctor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DoctorDao {

    public static Doctor getDoctor(int docId) {
        Doctor doctor = null;
        try {

            File file = new File("doctor.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");


                if (docId == Integer.parseInt(data[0])){

                    doctor = new Doctor();

                    doctor.setDid((data[0]));
                    doctor.setDname((data[1]));
                    doctor.setSpecilist((data[2]));


                    break;

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public static void showDoctors() {

        try {

            File file = new File("data_store/doctor.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                System.out.print("ID :- "+data[0]+"|   "+data[1]+"\t"+data[2]+"\n");

            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
