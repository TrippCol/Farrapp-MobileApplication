package escuelaing.com.co.bowmobileapp.data.network;

import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface NetworkService
{
    @POST( "users/login" )
    Call<Token> login(@Body LoginWrapper user );
}
