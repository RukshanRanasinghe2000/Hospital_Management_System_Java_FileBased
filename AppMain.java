/**
 * Author:- R.K.Navod Rukshan Ranasinghe undergraduate Software Engineering at Sri Lanka Technological Campus (22ug1-0238 R.K.N.R.Ranasinghe)
 *
 */
import Controller.PatientController;
import Dao.*;
import Entity.*;

import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;


public class AppMain {

    public static void main(String[] args) {



        while (true){

        Calendar calendar = Calendar.getInstance();

        String months[] = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };


        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("            *** Welcome to Hospital Management System Project in Java ***");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        System.out.println("\n                                    MAIN MENU");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. Admit a Patient\n2. Allocate a Doctor\n3. View patient history\n4. Add prescription\n5. Discharge\n6. Generate  bill\n7. Exit ");
        System.out.println("-----------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        int noOfDate;
        String aid,choice, pid,name,age,gender,email,mobile,admit_status,doctor,drug,bid;
        String disease = null;
        String conf;
        float price,quantity;


        choice = input.next();


            switch (choice){
                case "1":
                {
                    Patient patient = new Patient();
                    System.out.println("\n                     Admit a Patient\n");

                    System.out.println("Enter pId");
                    pid = input.next();

                    if (PatientController.getAdmitedPatient(Integer.parseInt(pid))== null){
                        System.out.println("Enter name");
                        name = input.next();

                        System.out.println("Enter age");
                        age = input.next();

                        System.out.println("Enter gender");
                        gender = input.next();

                        System.out.println("Enter admit status");
                        admit_status = input.next();

                        System.out.println("Enter disease");
                        disease = input.next();

                        patient.setPid(pid);
                        patient.setPname(name);
                        patient.setAge(Integer.parseInt(age));
                        patient.setGender(gender);
                        patient.setDisease(disease);
                        patient.setAdmit_status(admit_status);

                        String date =  months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);
                        patient.setDate(date);


                        Admit admit = new Admit();
                        admit.setPatient(patient);
                        PatientController.savePatient(admit);

                        System.out.println("Allocate a bed for the patient");
                        System.out.println("Here is available beds in hospital\nPlease select one");
                        BedDao.showDoctors();
                        System.out.println("\nEnter a bed Id");
                        bid = input.next();
                        System.out.println("Enter Entity.Patient ID");
                        pid = input.next();

                        Bed bed = new Bed();
                        bed.setBid(bid);
                        bed.setPid(pid);
                        BedDao.save(bed);

                    }else {
                        System.out.println("This Patient ID is already exists please enter another ID");
                    }


                    break;

                }
                case "2":
                {

                    Allocate allocate = new Allocate();
                    System.out.println("\n                     Allocate a Entity.Patient\n");

                    System.out.println("Enter allocate number");
                    aid = input.next();

                    System.out.println("Enter name");
                    name = input.next();

                    System.out.println("Enter age");
                    age = input.next();

                    System.out.println("Enter gender");
                    gender = input.next();

                    System.out.println("Enter Mobile");
                    mobile = input.next();

                    System.out.println("Enter Email");
                    email = input.next();


                    System.out.println("\nEnter a Doctor's ID \n");
                    DoctorDao.showDoctors();
                    System.out.println("\nType the number ");
                    doctor = input.next();

                    allocate.setAId(Integer.parseInt(aid));
                    allocate.setAName(name);
                    allocate.setAAge(age);
                    allocate.setAGender(gender);
                    allocate.setAMobile(mobile);
                    allocate.setAEmail(email);
                    allocate.setADoctor(doctor);
                    AlloctionDao.save(allocate);



                    break;
                }
                case "3":
                {
                    System.out.println("\n                     View patient history\n");
                    System.out.println("Enter the patient id :");
                    pid = input.next();
                    Patient patient = AdmitDao.getPatient(Integer.parseInt(pid));
                    System.out.println("Name :- "+patient.getPname()+"\nAge :- "+patient.getAge()+"\nGender :- "+
                            patient.getGender()+"\nDisease :- "+ patient.getDisease()+"\nStatus :- "+patient.getAdmit_status());

                    break;
                }
                case "4":
                {
                    System.out.println("\n                     Add prescription\n");
                    System.out.println("Today is " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
                    String date =  months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);

                    System.out.println("Enter patient's name :");
                    name = input.next();
                    System.out.println("Enter patient's age :");
                    age = input.next();

                    System.out.println("\nNow type the doctor's name :");
                    doctor = input.next();

                    System.out.println("Enter drug name :");
                    drug = input.next();

                    System.out.println("\nEnter a Doctor's Name \n");
                    DoctorDao.showDoctors();

                    System.out.println("Enter drug quantity :");
                    quantity = input.nextFloat();

                    System.out.println("Enter net price :");
                    price = input.nextFloat();

                    Prescription prescription = new Prescription();

                    prescription.setDate(date);
                    prescription.setpName(name);
                    prescription.setAge(age);
                    prescription.setDrugName(drug);
                    prescription.setDoctorName(doctor);
                    prescription.setPrice(price);
                    prescription.setQuentity(quantity);
                    PrescriptionDao.save(prescription);

                    System.out.println(
                            "\n        ...Hospital..."+
                                    "\nDate :- "+date+
                                    "\nEntity.Patient's name :- "+name+
                                    "\nAge :- "+age+
                                    "\nEntity.Doctor ID :- LKR."+doctor+
                                    "\nNet price :- LKR."+price+
                                    "\nQuantity :- "+quantity+
                                    "\n\nThank you"+ "\n  ...Have a Good Day...");








                    break;
                }
                case "5":
                {
                    System.out.println("\n                     Discharge\n");
                    System.out.println("Enter PID :-");
                    pid = input.next();
                    Patient patient;
                    patient =  PatientController.getAdmitedPatient(Integer.parseInt(pid));
                    String date =  months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);


                        System.out.println("Date :- "+date+
                                "\nEntity.Patient Id :- " + patient.getPid()
                                        + "\nName :- " + patient.getPname()
                                        + "\nAge :- " + patient.getAge()
                                        + "\nGender :- " + patient.getGender()
                                        + "\nEntity.Admit status :- " + patient.getAdmit_status()
                                        + "\nDisease :- " + patient.getDisease());

                        System.out.println("Are you sure to discharge this patient ? [Y] or [N]\n");

                        String confi = input.next();
                        if (Objects.equals(confi, "Y") || Objects.equals(confi, "y")) {
                            if (!PatientController.isExistDischargedPatient(Integer.parseInt(pid))) {

                                patient.setPid(Integer.toString(patient.getPid()));
                                patient.setDate(date);
                                patient.setPname(patient.getPname());
                                patient.setAge(patient.getAge());
                                patient.setGender(patient.getGender());
                                patient.setDisease(patient.getDisease());
                                patient.setAdmit_status("Discharged");
                                Admit admit = new Admit();
                                admit.setPatient(patient);
                                PatientController.saveDischargedPatient(admit);
                                System.out.println("Successfully Discharged");
                            }else {
                                System.out.println("This Entity.Patient is already discharged.");
                            }
                        }



                    break;
                }
                case "6":
                {
                    System.out.println("\n                    Generate  bill\n");

                    System.out.println("Today is " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR)+"\n");
                   String date =  months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);

                    System.out.println("Price per day = LKR.3500/=");

                    System.out.println("Enter pId :");
                    pid = input.next();
                    Patient patient = PatientController.getAdmitedPatient(Integer.parseInt(pid));
                    if (patient != null ){
                        System.out.println("Enter patient name "+patient.getPname());
                        System.out.println("Enter the number of dates spent in hospital");
                        noOfDate = input.nextInt();
                        price = noOfDate*3500;
                        Bill bill = new Bill();
                        bill.setpId(pid);
                        bill.setpName(patient.getPname());
                        bill.setDate(date);
                        bill.setNoOfDates(noOfDate);
                        bill.setPrice(price);
                        boolean f = BillDao.save(bill);
                        if (f){
                            System.out.println(
                                    "\n        ...Hospital..."+
                                            "\nDate :- "+date+
                                            "\nEntity.Patient's id :- "+pid+
                                            "\nEntity.Patient's name :- "+patient.getPname()+
                                            "\nNumber of dates spent in hospital :- "+noOfDate+
                                            "\nNet price :- LKR."+price+
                                            "\n\nThank you"+ "\n  ...Have a Good Day...");
                            }
                    }else {
                        System.out.println("Invalid patient ID please try again");
                    }

                    break;
                }
                case "7":
                {
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Invalid input please try again");
                    System.exit(0);
                }

            }

        }


    }



}
