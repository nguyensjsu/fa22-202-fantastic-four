import greenfoot.*;

public interface IPowerupState{
    void activate();
    void expire();

    void pickupFS1();
    void pickupFS2();
    // void pickupFS3();
    void pickupShield();
}