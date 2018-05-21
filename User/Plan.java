package User;

public enum Plan {
    BASIC(1,2,"Basic"), STANDARD(2,5,"Standard"), PREMIUM(4,5,"Premium");

    int deviceNum;
    int profileNum;
    String name;

     Plan(int deviceNum, int profileNum,String name ){
         this.deviceNum=deviceNum;
         this.profileNum=profileNum;
         this.name=name;
     }

    public int getDeviceNum(){return deviceNum;}

     public int getProfileNum(){return profileNum;}

     public String toString(){
        return name;
     }
}
