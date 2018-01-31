package feedback;
 
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Feedback extends Remote
{
    public String getFeedback(String nameOfCaller) throws RemoteException;
}
