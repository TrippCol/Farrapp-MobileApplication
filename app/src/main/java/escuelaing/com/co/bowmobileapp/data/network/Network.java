package escuelaing.com.co.bowmobileapp.data.network;

import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;

public interface Network
{
    void login(LoginWrapper loginWrapper, RequestCallback<Token> requestCallback );

    void getParties(RequestCallback<Map<Integer,Party>> requestCallback);
}