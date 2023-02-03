// 22ug1-0238 R.K.N.R.Ranasinghe

package Controller;

import Dao.AdmitDao;
import Entity.Admit;
import Entity.Patient;

public class PatientController {
    public static void savePatient(Admit admit){
        String fileLocation = "data_store/admit_patient.csv";
        AdmitDao.save(admit,fileLocation);
    }
    public static boolean isExistPatient(int pid){
        boolean x = false;
        if (AdmitDao.getPatient(pid)!=null){
            x= true;
        }
        return x;

    }

    public static boolean isExistDischargedPatient(int pid){
        boolean x = false;
        if (AdmitDao.getDischargedPatient(pid)!=null){
            x= true;
        }
        return x;

    }


    public static Patient getAdmitedPatient(int pid){
        Patient patient = null;
        if (isExistPatient(pid)) {
            patient = AdmitDao.getPatient(pid);
        }
        return patient;
    }

    public static void saveDischargedPatient(Admit admit){
        String fileLocation = "data_store/discharged_list.csv";
        AdmitDao.save(admit,fileLocation);
    }

}
