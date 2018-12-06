package escuelaing.com.co.bowmobileapp.data.fragments;


import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import escuelaing.com.co.bowmobileapp.R;


public class NewPartyFragment extends Fragment {

    Button createButton;
    EditText partyName, partyDescription, partySite, partyAddress, partyDate, partyHour, PartyCover;

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
        PartyCover = (EditText) view.findViewById(R.id.partyCover);
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
        Log.e("aaa","lol");
    }

}
