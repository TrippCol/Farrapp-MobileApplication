package escuelaing.com.co.bowmobileapp.data.network;

import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Token;

public interface Network
{
    void login(LoginWrapper loginWrapper, RequestCallback<Token> requestCallback );
}