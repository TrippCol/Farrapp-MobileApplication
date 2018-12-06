package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.fragments.CreatorPartyListFragment;
import escuelaing.com.co.bowmobileapp.data.fragments.NewPartyFragment;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class CreatorsActivity extends AppCompatActivity {

    List<Party> parties;

    Toolbar toolBar;

    CreatorsActivity selfAct;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.my_parties:
                    fragment = new CreatorPartyListFragment();
                    break;
                case R.id.new_party:
                    fragment = new NewPartyFragment(selfAct);
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creators);
        selfAct = this;
        loadFragment(new CreatorPartyListFragment());
        setViewComponents();
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void setViewComponents() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        parties = LocalStorage.getLoadedParties();
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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

    public void cleanFormularyInfo(){
        loadFragment(new NewPartyFragment(selfAct) );
    }

}
