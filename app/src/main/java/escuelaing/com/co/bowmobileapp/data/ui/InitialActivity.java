package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.LoginWrapper;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;
import escuelaing.com.co.bowmobileapp.data.network.RetrofitNetwork;

public class InitialActivity extends AppCompatActivity {
    private RetrofitNetwork retrofitNetwork;
    private Button buttonSignIn;
    private Button buttonLogIn;
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        componentsInitialization();
        actionListenersInitialization();

    }

    void componentsInitialization() {
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.idText);
        retrofitNetwork = new RetrofitNetwork();
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
                startActivity(intent);
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
        });
    }


}
