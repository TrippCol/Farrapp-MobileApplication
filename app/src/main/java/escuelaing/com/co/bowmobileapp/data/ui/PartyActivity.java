package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class PartyActivity extends AppCompatActivity {
    //Button buttonBack;
    Button buttonBook;
    ImageView imagenFiesta;
    TextView nombreFiesta;
    RatingBar ratingBar;
    TextView partyDate;
    TextView partyAddress;
    TextView partyPlace;
    TextView partyPrice;
    TextView partyDescription;
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
        //imagenFiesta = (ImageView)findViewById(R.id.imagenFiesta);
        partyDescription = (TextView)findViewById(R.id.partyDesc);
        partyPrice = (TextView)findViewById(R.id.partyPrice);
        partyPlace = (TextView)findViewById(R.id.partyPlace);
        partyAddress = (TextView)findViewById(R.id.partyAddress);
        partyDate = (TextView)findViewById(R.id.partyDate);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        nombreFiesta = (TextView)findViewById(R.id.nombreFiesta);
        toolBar = (Toolbar) findViewById(R.id.app_bar_1);
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        party = LocalStorage.getSelectedParty();
        partyDescription.setText(party.getDescription());
        partyPrice.setText("$" + party.getPrice() + " COP");
        partyPlace.setText(party.getPlace());
        partyAddress.setText(party.getAddress());
        partyDate.setText(party.getEventDate());
        ratingBar.setRating(party.getRating());
        //imagenFiesta.setImageResource(R.drawable.party_image);
        nombreFiesta.setText(party.getPartyName());
        buttonBook = (Button) findViewById((R.id.bookButton));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        if(menu.getItemId() == android.R.id.home){
            finish();
        }
        else if(menu.getItemId() == R.id.action_sign_out){
            LocalStorage.setAccountUser(null);
            Intent intent = new Intent(this, InitialActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void actionListenersInitialization() {
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PartyActivity.this,BookActivity.class );
                startActivity(intent);
            }
        });
    }


}