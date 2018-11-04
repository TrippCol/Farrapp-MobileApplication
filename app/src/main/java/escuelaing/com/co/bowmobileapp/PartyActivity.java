package escuelaing.com.co.bowmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartyActivity extends AppCompatActivity {
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
        componentsInitialization();
        actionListenersInitialization();
    }

    void componentsInitialization() {
        buttonBack = (Button) findViewById((R.id.buttonBack));
    }

    void actionListenersInitialization() {

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}