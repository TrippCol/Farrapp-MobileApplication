package escuelaing.com.co.bowmobileapp.data.network;

public class NetworkException extends Exception{
    public NetworkException(String message, Throwable e){
        super(message,e);
    }
}
