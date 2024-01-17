package app;

import model.*;
import model.atm.Atm;
import model.exception.InsufficientBalanceException;
import model.payment.PaySlip;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Client holder1 = new Client("Manuela", "236.785.425-08", new BigDecimal("22800"), ClientType.PERSONAL);
        System.out.println(holder1.getLastUpdate());

        Client holder2 = new Client("Luigi", "495.674.224-90", new BigDecimal("502000"), ClientType.PERSONAL);

        Atm atm = new Atm();        // utility instantiation

        // creating a new investment acc for holder1
        InvestmentAcc investmentAcc1 = new InvestmentAcc(holder1, "566-9", 142);

        // creating a new workerOneSalary acc for holder1
        SalaryAcc salaryAcc1 = new SalaryAcc(holder1, "566-9", 485);
        System.out.println(salaryAcc1.getBalance());

        // creating a new special acc for holder2
        SpecialAcc specialAcc1 = new SpecialAcc(holder2, "566-9", 322, new BigDecimal("5000"));

        // depositing money into specialAcc
        specialAcc1.deposit(new BigDecimal("80000"));
        Atm.printInfo(specialAcc1);

        try {       // modeling exceptions if any transaction isn't allowed

            // paying
            PaySlip workerOneSalary = new PaySlip(holder2, new BigDecimal("120"), 180);
            Atm.paySalary(workerOneSalary, specialAcc1, salaryAcc1);
            System.out.println(workerOneSalary.getTotalValue());
            Atm.printInfo(specialAcc1);
            Atm.printInfo(salaryAcc1);

            // transferring the salary from the SalaryAcc to another acc
            salaryAcc1.transferSalary(salaryAcc1, investmentAcc1);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error! we couldn't run this operation: " + e.getMessage());

        }

        Atm.printInfo(salaryAcc1);
        Atm.printInfo(investmentAcc1);

    }
}
