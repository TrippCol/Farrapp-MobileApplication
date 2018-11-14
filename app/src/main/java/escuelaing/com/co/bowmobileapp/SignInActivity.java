package escuelaing.com.co.bowmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity {

    Button buttonBack;
    Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        componentsInitialization();
        actionListenersInitialization();
    }

    void componentsInitialization() {
        buttonBack = (Button) findViewById((R.id.buttonBack));
        signUpButton= (Button) findViewById(R.id.signUpButton);
    }

    void actionListenersInitialization() {

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignInActivity.this,PartyListActivity.class );
                startActivity(intent);
            }
        });
    }
}
