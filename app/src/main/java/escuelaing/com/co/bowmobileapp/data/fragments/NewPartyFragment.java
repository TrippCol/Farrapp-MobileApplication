package escuelaing.com.co.bowmobileapp.data.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Item;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;
import escuelaing.com.co.bowmobileapp.data.ui.CreatorsActivity;


@SuppressLint("ValidFragment")
public class NewPartyFragment extends Fragment {

    Button createButton;
    EditText partyName, partyDescription, partySite, partyAddress, partyDate, partyHour, partyCover;
    CreatorsActivity creator;

    @SuppressLint("ValidFragment")
    public NewPartyFragment(CreatorsActivity creator){
        this.creator=creator;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View view = inflater.inflate(R.layout.fragment_new_party, null);
        componentsInitialization(view);
        actionListenersInitialization();
        return view;
    }


    void componentsInitialization(View view) {
        partyName = (EditText) view.findViewById(R.id.partyName);
        partyDescription = (EditText) view.findViewById(R.id.partyDesc);
        partySite = (EditText) view.findViewById(R.id.partySite);
        partyAddress = (EditText) view.findViewById(R.id.partyAddress);
        partyDate = (EditText) view.findViewById(R.id.partyDate);
        partyHour = (EditText) view.findViewById(R.id.partyHour);
        partyCover = (EditText) view.findViewById(R.id.partyCover);
        createButton = (Button) view.findViewById((R.id.createButton));
    }

    void actionListenersInitialization() {
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postParty();
            }
        });
    }

    void postParty() {
        // Post the party here
        String parName= partyName.getText().toString();
        String parDesc = partyDescription.getText().toString();
        String parSite = partySite.getText().toString();
        String parAddress = partyAddress.getText().toString();
        String parDate=partyDate.getText().toString();;
        String parHour=partyHour.getText().toString();;
        String parCover=partyCover.getText().toString();;



        if (parName.length()==0|| parDesc.length()==0|| parSite.length()==0|| parAddress.length()==0|| parDate.length()==0|| parHour.length()==0|| parCover.length()==0) {

        }

        else {

            int id= LocalStorage.getLoadedParties().size();
            ArrayList<Item> items = new ArrayList<Item>();
            Party newParty = new Party(id, "", parName, parDesc, parDate, parHour, parAddress, parSite, Integer.parseInt(parCover), items );

            LocalStorage.retrofitNetwork.addNewParty(newParty, new RequestCallback<Party>() {
            @Override
            public void onSuccess(Party response) {
                Log.e("ABCD", "Se añadió la fiesta correctamente");
                creator.cleanFormularyInfo();
            }

            @Override
            public void onFailed(NetworkException e) {
                e.printStackTrace();
            }
            });
        }
    }

}
