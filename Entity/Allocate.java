package Entity;

public class Allocate {
    private String pName,pAge,pGender,pEmail,pMobile;

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }
    private int aId;
    private String doctor;

    public String getAName() {
        return pName;
    }

    public void setAName(String pName) {
        this.pName = pName;
    }

    public String getAAge() {
        return pAge;
    }

    public void setAAge(String pAge) {
        this.pAge = pAge;
    }

    public String getAGender() {
        return pGender;
    }

    public void setAGender(String pGender) {
        this.pGender = pGender;
    }

    public String getAEmail() {
        return pEmail;
    }

    public void setAEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getAMobile() {
        return pMobile;
    }

    public void setAMobile(String pMobile) {
        this.pMobile = pMobile;
    }

    public String getADoctor() {
        return doctor;
    }

    public void setADoctor(String doctor) {
        this.doctor = doctor;
    }
}
