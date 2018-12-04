package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RecyclerAdapter;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class PartyListActivity extends AppCompatActivity {
    //Button buttonBack;
    List<Party> parties;
    //Button partyRock;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolBar;
    TextView mTitle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.parties:
                    parties = LocalStorage.getLoadedParties();
                    setListToAdapter();
                    return true;
                case R.id.my_parties:
                    parties = LocalStorage.getAccountUser().getMyParties();
                    //parties.add(new Party(666, "Juan David Ramirez", "Escudos test", "Fiesta de graduados", "12/11/18", "21:00", "Cra 15 - #93", "Sutton club", 25000, "Reprogramada"));
                    setListToAdapter();
                    return true;
                //case R.id.settings:
                    //mTextMessage.setText(R.string.title_notifications);
                    //return true;
            }
            return false;
        }
    };

    private void setListToAdapter() {
        adapter = new RecyclerAdapter(parties);
        ((RecyclerAdapter) adapter).setOnClick(new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                Intent intent= new Intent(getApplicationContext(),PartyActivity.class );
                //Log.e("ABCD", parties.get(position).getId().toString());
                LocalStorage.setSelectedParty(parties.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);
        setViewComponents();
        setRecyclerViewComponents();
        //actionListenersInitialization();


    }

    private void setViewComponents() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        parties = LocalStorage.getLoadedParties();
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        mTitle = (TextView) toolBar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolBar);
        //mTitle.setText("Fiestas");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //BACK ARROW
        /*if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/
    }

    private void setRecyclerViewComponents() {
        //partyRock = (Button) findViewById(R.id.partyButton);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        setListToAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //BACK ARROW
    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        /*if(menu.getItemId() ==  android.R.id.home){
            finish();
        }*/
        switch(menu.getItemId()){
            case R.id.action_sign_out:
                LocalStorage.setAccountUser(null);
                Intent intent = new Intent(this, InitialActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(menu);
    }
}
