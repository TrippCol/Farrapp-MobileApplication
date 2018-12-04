package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.network.RecyclerAdapter;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class CreatorsActivity extends AppCompatActivity {

    List<Party> parties;

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
                case R.id.my_parties:
                    return true;
                case R.id.new_party:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creators);
        setViewComponents();
        setRecyclerViewComponents();
    }

    private void setViewComponents() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        parties = LocalStorage.getLoadedParties();
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        mTitle = (TextView) toolBar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolBar);
        mTitle.setText("Fiestas");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setRecyclerViewComponents() {
        //partyRock = (Button) findViewById(R.id.partyButton);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(parties);
        ((RecyclerAdapter) adapter).setOnClick(new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), PartyActivity.class);
                LocalStorage.setSelectedParty(parties.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //BACK ARROW
    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case R.id.action_sign_out:
                LocalStorage.setAccountUser(null);
                Intent intent = new Intent(this, InitialActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(menu);
    }


}
