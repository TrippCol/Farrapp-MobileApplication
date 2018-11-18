package escuelaing.com.co.bowmobileapp.data.network;

public interface RequestCallback<T>
{

    void onSuccess( T response );

    void onFailed( NetworkException e );

}
