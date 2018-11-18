package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.Token;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;

public class PartyListActivity extends AppCompatActivity {
    Button buttonBack;
    List<Party> parties;
    Button partyRock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_list);
        componentsInitialization();
        actionListenersInitialization();
        setPartiesFromServer();
    }

    private void setPartiesFromServer() {
        InitialActivity.retrofitNetwork.getParties(new RequestCallback<Map<Integer,Party>>() {
            @Override
            public void onSuccess(Map<Integer,Party> response) {
                for(Integer p: response.keySet()){
                    System.out.println(response.get(p).getPartyName());
                }
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
        buttonBack = (Button) findViewById((R.id.buttonBack));
        partyRock = (Button) findViewById(R.id.partyButton);

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
                Intent intent= new Intent(PartyListActivity.this,PartyActivity.class );
                startActivity(intent);
            }
        });
    }
}
