package escuelaing.com.co.bowmobileapp.data.network;

import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.entities.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface NetworkService
{
    @POST( "users/login" )
    Call<Token> login(@Body LoginWrapper user );

    @GET( "parties")
    Call<Map<Integer,Party>> getParties();

    @GET( "users/{emailUser}/parties" )
    Call<List<Party>> getUserParties(@Path("emailUser") String emailUser);

    @POST("/users")
    Call<Void> addUser(@Body User user);

    @GET( "users/{emailUser}" )
    Call<User> getUserByEmail(@Path("emailUser") String emailUser);

    @POST("parties/party/{idParty}")
    Call<Void> bookUserIntoParty(@Body User user,@Path("idParty") Integer idParty);


}
