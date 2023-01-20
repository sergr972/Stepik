package com.Mail;

import java.util.logging.Logger;

public class Test {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        MailService spy = new Spy(Logger.getLogger(Class.class.getName()));
        Thief thief = new Thief(10);
        MailService inspector = new Inspector();
        MailService[] msArray = {spy, thief, inspector};
        MailMessage mail1 = new MailMessage("Romeo", "Juliet", "I love you!");
        MailMessage mail2 = new MailMessage("Austin Powers", "James Bond", "Big secret!");
        MailPackage mail3 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 15));
        MailPackage mail4 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 25));
        MailPackage mail5 = new MailPackage("Austin Powers", "James Bond", new Package("weapons", 5));

        UntrustworthyMailWorker umw = new UntrustworthyMailWorker(msArray);
        try {
            umw.processMail(mail1);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail2);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail3);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail4);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        System.out.println("Thief have stolen $" + thief.getStolenValue() + "!");
    }
}
