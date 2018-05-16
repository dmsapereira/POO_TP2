package User;

public enum Plan {
    BASIC(1,2), STANDARD(2,5), PREMIUM(4,5);

    int deviceNum;
    int profileNum;

     Plan(int deviceNum, int profileNum ){
         this.deviceNum=deviceNum;
         this.profileNum=profileNum;
     }

     int getDeviceNum(){return deviceNum;}

     int getProfileNum(){return profileNum;}
}
