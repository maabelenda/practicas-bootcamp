package Entity;

import Exceptions.NegativeSaldoException;
import Exceptions.NullAccountException;
import Utils.ErrorMessage;

public class CheckingAccountImp implements CheckingAccount {

    private double balance;

    private long accountNumber;

    private String currency;

    private String fullName;



    public CheckingAccountImp() {
        this.balance = 0;
        this.accountNumber = 0;
        this.currency = Currency.ARS.getCurrency();
        this.fullName = "";
    }

    public CheckingAccountImp(double balance, long accountNumber, String currency, String fullName) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.fullName = fullName;
    }

    public CheckingAccountImp(CheckingAccountImp account) throws NullAccountException {
        if(account == null) {
            throw new NullAccountException(ErrorMessage.NULL_ACCOUNT.getMessage(), ErrorMessage.NULL_ACCOUNT.getCode());
        }
        this.balance = account.getBalance();
        this.accountNumber = account.getAccountNumber();
        this.currency = account.getCurrency();
        this.fullName = account.getFullName();
    }

    @Override
    public void ingreso(double balance) throws NegativeSaldoException {
        if(balance <= 0) {
            throw new NegativeSaldoException(ErrorMessage.NEGATIVE_INPUT.getMessage(), ErrorMessage.NEGATIVE_INPUT.getCode());
        }
        this.balance += balance;
    }

    @Override
    public void egreso(double balance) throws NegativeSaldoException {
        if(balance <= 0) {
            throw new NegativeSaldoException(ErrorMessage.NEGATIVE_INPUT.getMessage(), ErrorMessage.NEGATIVE_INPUT.getCode());
        }
        if(this.balance < balance) {
            throw new NegativeSaldoException(ErrorMessage.NEGATIVE_BALANCE.getMessage(), ErrorMessage.NEGATIVE_BALANCE.getCode());
        }
        this.balance -=balance;
    }

    @Override
    public void reintegro(double balance, CheckingAccountImp account) throws NullAccountException, NegativeSaldoException {
        if(account == null) {
            throw new NullAccountException(ErrorMessage.NULL_ACCOUNT.getMessage(), ErrorMessage.NULL_ACCOUNT.getCode());
        }
        account.egreso(balance);
        this.ingreso(balance);
    }

    @Override
    public void transferencia(CheckingAccountImp account, double balance) throws NegativeSaldoException, NullAccountException {
        if(account == null) {
            throw new NullAccountException(ErrorMessage.NULL_ACCOUNT.getMessage(), ErrorMessage.NULL_ACCOUNT.getCode());
        }
        this.egreso(balance);
        account.ingreso(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
