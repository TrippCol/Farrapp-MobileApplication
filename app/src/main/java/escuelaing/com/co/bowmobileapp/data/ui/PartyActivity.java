package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;

public class PartyActivity extends AppCompatActivity {
    //Button buttonBack;
    Button buttonBook;
    private Party party;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_test);
        componentsInitialization();
        actionListenersInitialization();
    }

    void componentsInitialization() {
        toolBar = (Toolbar) findViewById(R.id.app_bar_1);
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        party = (Party) getIntent().getSerializableExtra("party");
        //buttonBack = (Button) findViewById((R.id.buttonBack));
        buttonBook = (Button) findViewById((R.id.bookButton));
        //ScrollView sv = (ScrollView) findViewById(R.id.partyScrollView);
        //sv.smoothScrollTo(0,300);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        if(menu.getItemId() ==  android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(menu);
    }

    void actionListenersInitialization() {

        /*buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PartyActivity.this,BookActivity.class );
                startActivity(intent);
            }
        });
    }
}