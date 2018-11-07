package escuelaing.com.co.bowmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    Button buttonSignIn;
    Button buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        componentsInitialization();
        actionListenersInitialization();

    }

    void componentsInitialization() {
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
                Intent intent= new Intent(InitialActivity.this,LogInActivity.class );
                startActivity(intent);
            }
        });
    }


}
