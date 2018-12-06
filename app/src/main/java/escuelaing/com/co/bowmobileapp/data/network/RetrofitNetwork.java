package escuelaing.com.co.bowmobileapp.data.network;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.entities.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetwork
        implements Network {
    //Corriendo el app desde localhost (cambiar la direccion ip por la direccion de localhost pero sin poner localhost o 127.0.0.1)
    //private static final String BASE_URL = "http://ip_de_sus_maquinas/";

    //Conectandose al deploy de Heroku.
    private static final String BASE_URL = "https://farrapp-api.herokuapp.com";

    private NetworkService networkService;

    private ExecutorService backgroundExecutor = Executors.newFixedThreadPool(2);

    public RetrofitNetwork() {
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        networkService = retrofit.create(NetworkService.class);
    }

    @Override
    public void login(final LoginWrapper loginWrapper, final RequestCallback<Token> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {

                Call<Token> call = networkService.login(loginWrapper);
                try {

                    Response<Token> execute = call.execute();
                    if (execute.body()!=null) {
                        requestCallback.onSuccess(execute.body());
                    }
                    else{
                        throw new Exception();
                    }


                } catch (Exception e) {

                    requestCallback.onFailed(new NetworkException("Usuario o contraseña Incorrecta", e));

                }

            }
        });

    }

    @Override
    public void getParties(final RequestCallback<Map<Integer, Party>> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<Map<Integer, Party>> call = networkService.getParties();
                try {
                    Response<Map<Integer, Party>> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void getUserParties(final String emailUser, final RequestCallback<List<Party>> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<List<Party>> call = networkService.getUserParties(emailUser);
                try {
                    Response<List<Party>> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void addNewUser(final User user, final RequestCallback<User> requestCallback) {

        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                User myUser = user;
                Call call = networkService.addUser(myUser);
                try {
                    Response<User> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    Log.e("ABCD", e.toString());
                    requestCallback.onFailed(new NetworkException("Error añadiendo usuario", e));
                }
            }
        });
    }

    @Override
    public void getUserByEmail(final String emailUser, final RequestCallback<User> requestCallback) {
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<User> call = networkService.getUserByEmail(emailUser);
                try {
                    Response<User> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });
    }

    @Override
    public void bookUserInParty(final Integer idParty,final User user,  final RequestCallback<Void> requestCallback){
        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Call<Void> call = networkService.bookUserIntoParty(user,idParty);

                try {
                    Response<Void> execute = call.execute();
                    requestCallback.onSuccess(execute.body());
                } catch (Exception e) {
                    Log.e("ABCD", e.getMessage());
                    requestCallback.onFailed(new NetworkException(null, e));
                }
            }
        });

    }

    @Override
    public void addNewParty(final Party myParty, final RequestCallback<Party> requestCallback) {

        backgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {

                Call call = networkService.addParty(myParty);
                try {
                    Response<User> execute = call.execute();
                    requestCallback.onSuccess(null);
                } catch (Exception e) {
                    Log.e("ABCD", e.toString());
                    requestCallback.onFailed(new NetworkException("Error añadiendo fiesta", e));
                }
            }
        });
    }


}