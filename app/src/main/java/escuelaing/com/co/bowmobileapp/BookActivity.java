package escuelaing.com.co.bowmobileapp;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {


    Button bookButton, buttonBack, buttonValidate;
    LinearLayout table;
    EditText friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        componentsInitialization();
        actionListenersInitialization();
    }


    void componentsInitialization(){
        buttonBack = (Button) findViewById((R.id.buttonBack2));
        bookButton = (Button) findViewById((R.id.bookButton));
        buttonValidate=(Button) findViewById(R.id.buttonValidate);

        table=(LinearLayout) findViewById(R.id.guestTable);

        friend=(EditText) findViewById(R.id.editTextFriends);

    }
    void actionListenersInitialization() {
        final BookActivity self=this;
        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView titleView = new TextView(self);
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                titleView.setLayoutParams(lparams);
                titleView.setText(friend.getText());
                titleView.setTextColor(self.getResources().getColor(R.color.colorAccent));
                friend.setText("");
                table.addView(titleView);
            }
        }
        );
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(BookActivity.this, ConfirmationActivity.class );
                startActivity(intent);
            }
        });
    }


}
