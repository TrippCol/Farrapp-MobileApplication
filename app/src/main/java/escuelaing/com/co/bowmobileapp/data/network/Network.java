package escuelaing.com.co.bowmobileapp.data.network;

import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.entities.User;

public interface Network
{
    void login(LoginWrapper loginWrapper, RequestCallback<Token> requestCallback );
    void getParties(RequestCallback<Map<Integer,Party>> requestCallback);

    void getUserParties(String emailUser, RequestCallback<List<Party>> requestCallback);

    void addNewUser(User user, RequestCallback<User> requestCallback );

    void getUserByEmail(String emailUser, RequestCallback<User> requestCallback);

    void bookUserInParty(Integer idParty,User user, RequestCallback<Void> requestCallback);

    void addNewParty(Party myParty, RequestCallback<Party> requestCallback);
}