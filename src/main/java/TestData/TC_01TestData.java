package TestData;


public class TC_01TestData {
    private String location;
    private String medicine;
    private String couponCode;
    public String getLocation(){
        System.out.println("Getting location: " + location);
        return location;
    }
    public String getMedicine(){
        return medicine;
    }
    public String getCouponCode(){
        return couponCode;
    }
}

