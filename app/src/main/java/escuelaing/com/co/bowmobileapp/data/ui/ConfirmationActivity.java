package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import escuelaing.com.co.bowmobileapp.R;

public class ConfirmationActivity extends AppCompatActivity {
    Button continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        componentsInitialization();
        actionListenersInitialization();
    }


    void componentsInitialization(){

        continueButton = (Button) findViewById((R.id.continueButton));

    }
    void actionListenersInitialization() {

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ConfirmationActivity.this, PartyListActivity.class );
                startActivity(intent);
            }
        });

    }
}
