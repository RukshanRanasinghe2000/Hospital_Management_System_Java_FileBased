// 22ug1-0238 R.K.N.R.Ranasinghe

package Dao;

import Entity.Admit;
import Entity.Patient;

import java.io.*;

public class AdmitDao {

    public static boolean save(Admit admit, String fileLocation) {
        boolean x = false;

        Patient patient = admit.getPatient();
        try {
            FileWriter fw = new FileWriter(fileLocation, true);
            BufferedWriter bw = new BufferedWriter(fw);

                String rec = patient.getPid()+","+patient.getPname()+","+patient.getAge()+
                        ","+patient.getGender()+","+patient.getDisease()+","+patient.getAdmit_status()+","+patient.getDate();
            bw.write(rec);
            bw.newLine();
            x = true;
            bw.close();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return x;
    }

    public static Patient getPatient(int pId) {
        Patient patient = null;
        try {

            File file = new File("data_store/admit_patient.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");

                if (pId == Integer.parseInt(data[0])){

                    patient = new Patient();
                    patient.setPid((data[0]));
                    patient.setPname(data[1]);
                    patient.setGender(data[3]);
                    patient.setAge(Integer.parseInt(data[2]));
                    patient.setDisease(data[4]);
                    patient.setAdmit_status(data[5]);
                    break;

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patient;
    }


    public static Patient getDischargedPatient(int pId) {
        Patient patient = null;
        try {

            File file = new File("data_store/discharged_list.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");

                if (pId == Integer.parseInt(data[0])){

                    patient = new Patient();
                    patient.setPid((data[0]));
                    patient.setPname(data[1]);
                    patient.setGender(data[3]);
                    patient.setAge(Integer.parseInt(data[2]));
                    patient.setDisease(data[4]);
                    patient.setAdmit_status(data[5]);
                    break;

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patient;
    }




}
