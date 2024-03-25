package com.wenshan;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        user.createUser("root", "Aa123456", "424433081@qq.com");
        // user.createUser("admin", "Aa23456", "42443308@qq.com");
        // user.createUser("demo_user_001", "Pa$$w0rd_Demo001", "demo.user001@example.com");
        // user.createUser("example_guest_01", "ExamplePass_12guest", "guest01@example.net");
        // user.createUser("trial_account_A", "TrialAcc_@B3c0m3!", "trial.account.A+random@gmail.com");
        // user.createUser("test_profile_B2", "TestPr0File_9$ecure", "test.profile.B2@example.org");
        // user.createUser("demo_identity_X9", "DemoId_XZ!ampl3_", "demo.identity.X9@example.co.uk");

    }
}