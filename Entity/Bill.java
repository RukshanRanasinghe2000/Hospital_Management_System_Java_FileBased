package Entity;

public class Bill {
    private String date,pName,spendTime;
    private float price;
    private int noOfDates,pId;

    public int getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = Integer.parseInt(pId);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }



    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNoOfDates() {
        return noOfDates;
    }

    public void setNoOfDates(int noOfDates) {
        this.noOfDates = noOfDates;
    }
}
