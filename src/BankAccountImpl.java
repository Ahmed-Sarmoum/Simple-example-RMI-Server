import java.rmi.RemoteException;

public class BankAccountImpl implements BankAccount{

    private double amount = 120;

    @Override
    public void deposit(double amount) throws RemoteException {
        this.amount+= amount;
    }

    @Override
    public void withdraw(double amount) throws RemoteException {
        this.amount -= amount;
    }

    @Override
    public double getBalance() throws RemoteException {
        return amount;
    }
}
