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
import escuelaing.com.co.bowmobileapp.data.entities.Item;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class PartyActivity extends AppCompatActivity {
    Button buttonBook;
    //ImageView imagenFiesta;
    //TextView nombreFiesta;
    //RatingBar ratingBar;
    //TextView partyDate;
    //TextView partyAddress;
    //TextView partyPlace;
    //TextView partyPrice;
    //TextView partyDescription;
    private Party party;
    private TextView dressCode;
    private TextView minAge;
    private TextView partyName;
    private RatingBar barRating;
    private TextView partyCreator;
    private TextView partyCategories;
    private TextView cartaDeProductos;
    private TextView barAddress;
    private TextView barName;
    private TextView partyDateAndTime;
    private TextView partyDescription;
    private TextView partyDresscode;
    private TextView coverPrice;
    private ImageView partyImage;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_test);
        componentsInitialization();
        actionListenersInitialization();
    }

    void componentsInitialization() {
        viewComponentsInit();

        //partyDescription.setText(party.getDescription());
        //partyPrice.setText("$" + party.getPrice() + " COP");
        //partyPlace.setText(party.getPlace());
        //partyAddress.setText(party.getAddress());
        //partyDate.setText(party.getEventDate());
        //ratingBar.setRating(party.getRating());
        //imagenFiesta.setImageResource(R.drawable.party_image);
        //nombreFiesta.setText(party.getPartyName());

    }

    private void viewComponentsInit() {
        partyName = findViewById(R.id.partyName);
        barRating = findViewById(R.id.barRating);
        partyCreator = findViewById(R.id.partyCreator);
        partyCategories = findViewById(R.id.partyCategories);
        cartaDeProductos = findViewById(R.id.cartaDeProductos);
        barAddress = findViewById(R.id.barAddress);
        barName = findViewById(R.id.barName);
        partyDateAndTime = findViewById(R.id.partyDateAndTime);
        partyDescription = findViewById(R.id.partyDescription);
        partyDresscode = findViewById(R.id.partyDresscode);
        partyImage = findViewById(R.id.partyImage);
        coverPrice = findViewById(R.id.coverPrice);
        toolBar = findViewById(R.id.app_bar_1);
        initToolbar();
        party = LocalStorage.getSelectedParty();
        buttonBook = findViewById((R.id.bookButton));
        dressCode = findViewById(R.id.partyDresscode);
        minAge = findViewById(R.id.minAge);
        partyName.setText(party.getPartyName());
        barRating.setRating(party.getRating());
        partyCreator.setText(party.getCreator());
        setCategoriesHashtags();
        setProductPrices();

        dressCode.setText(party.getDressCode());
        minAge.setText("+" + party.getMinAge());
        barAddress.setText(party.getAddress());
        barName.setText(party.getPlace());
        partyDateAndTime.setText(party.getEventDate() + " " + party.getEventHour());
        partyDescription.setText(party.getDescription());
        //TODO
        //partyDresscode.setText(party.getDresscode());
        partyImage.setImageResource(R.drawable.party_image);
        System.out.println(party.getPrice());
        coverPrice.setText("$" + party.getPrice() + " COP");



    }

    private void setProductPrices() {
        for(Item i: party.getCartaDeProductos()){
            cartaDeProductos.setText(cartaDeProductos.getText() + " -" + i.getName() + ": $" + i.getPrice() + " COP, ");
        }
        //cartaDeProductos.setText(party.getCartaDeProductos());
    }

    private void setCategoriesHashtags() {
        for(String s: party.getCategories()){
            partyCategories.setText(partyCategories.getText() + " #" + s);
        }
    }

    private void initToolbar() {
        setSupportActionBar(toolBar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
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