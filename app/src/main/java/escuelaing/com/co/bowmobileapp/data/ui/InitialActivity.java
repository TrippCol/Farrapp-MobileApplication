package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;
import escuelaing.com.co.bowmobileapp.data.network.RetrofitNetwork;

public class InitialActivity extends AppCompatActivity {
    public static final RetrofitNetwork retrofitNetwork = new RetrofitNetwork();
    private Button buttonSignIn;
    private Button buttonLogIn;
    private EditText emailText;
    private EditText passwordText;

    private List<Party> parties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        componentsInitialization();
        actionListenersInitialization();
        setPartiesFromServer();

    }

    private void setPartiesFromServer() {
        InitialActivity.retrofitNetwork.getParties(new RequestCallback<Map<Integer,Party>>() {
            @Override
            public void onSuccess(Map<Integer,Party> response) {
                //for(Integer p: response.keySet()){
                  //  System.out.println(response.get(p).getPartyName());
                //}
                Collection partiesValues = response.values();
                if (partiesValues instanceof List)
                    parties = (List)partiesValues;
                else
                    parties = new ArrayList(partiesValues);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }

    void componentsInitialization() {
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.idText);
        //retrofitNetwork = new RetrofitNetwork();
        buttonSignIn = (Button) findViewById((R.id.buttonSignUp));
        buttonLogIn = (Button) findViewById(R.id.buttonLogIn);
    }

    void actionListenersInitialization() {


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InitialActivity.this,SignInActivity.class );
                startActivity(intent);
            }
        });

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credentialValidation();
            }
        });
    }

    private void credentialValidation() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        LoginWrapper loginWrapper = new LoginWrapper(email, password);
        retrofitNetwork.login(loginWrapper, new RequestCallback<Token>() {
            @Override
            public void onSuccess(Token response) {
                System.out.println(response.getAccessToken());
                Intent intent= new Intent(InitialActivity.this,PartyListActivity.class );
                intent.putExtra("parties", (Serializable) parties);
                startActivity(intent);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }


}
