import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws RemoteException, UnknownHostException, MalformedURLException {
        BankAccountImpl bankAccount = new BankAccountImpl();
        BankAccount remoteObject = (BankAccount) UnicastRemoteObject.exportObject(bankAccount, 0);
        Registry registry = LocateRegistry.createRegistry(52334);
        String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52334/BankAccount";
        Naming.rebind(url, remoteObject);

        System.out.println("Waiting for the client's call....");
    }
}
