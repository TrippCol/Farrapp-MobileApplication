package escuelaing.com.co.bowmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    Button buttonBack;

    Button partyRock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_list);
        componentsInitialization();
        actionListenersInitialization();
    }
    void componentsInitialization() {
        buttonBack = (Button) findViewById((R.id.buttonBack));
        partyRock = (Button) findViewById(R.id.eciButton);

    }

    void actionListenersInitialization() {

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        partyRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LogInActivity.this,PartyActivity.class );
                startActivity(intent);
            }
        });
    }
}
