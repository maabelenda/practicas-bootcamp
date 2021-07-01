package Entity;

import Exceptions.NegativeSaldoException;
import Exceptions.NullAccountException;

public interface CheckingAccount {

    void ingreso(double balance) throws NegativeSaldoException;

    void egreso(double balance) throws NegativeSaldoException;

    void reintegro(double balance,  CheckingAccountImp account) throws NullAccountException, NegativeSaldoException;

    void transferencia(CheckingAccountImp cuentaCorriente, double saldo) throws NegativeSaldoException, NullAccountException;
}
