package Entity;

public class Patient {
    private String  pname,gender, disease, sex, admit_status,date;
    private int age,pid;

    public int getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = Integer.parseInt(pid);
    }

    public String getPname() {
        return pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAdmit_status() {
        return admit_status;
    }

    public void setAdmit_status(String admit_status) {
        this.admit_status = admit_status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
