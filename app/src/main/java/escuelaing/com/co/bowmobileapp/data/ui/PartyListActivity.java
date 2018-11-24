package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RecyclerAdapter;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;

public class PartyListActivity extends AppCompatActivity {
    //Button buttonBack;
    List<Party> parties;
    //Button partyRock;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_demo);

        setViewComponents();
        setRecyclerViewComponents();


    }

    private void setViewComponents() {
        parties = (List<Party>) getIntent().getSerializableExtra("parties");
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setRecyclerViewComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(parties);
        ((RecyclerAdapter) adapter).setOnClick(new RecyclerAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                Intent intent= new Intent(getApplicationContext(),PartyActivity.class );
                intent.putExtra("party", parties.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        if(menu.getItemId() ==  android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(menu);
    }



    /*void componentsInitialization() {
        buttonBack = (Button) findViewById((R.id.buttonBack));
        partyRock = (Button) findViewById(R.id.partyButton);

    }*/

    /*void actionListenersInitialization() {

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
    }*/
}
