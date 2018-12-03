package escuelaing.com.co.bowmobileapp.data.ui;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.User;
import escuelaing.com.co.bowmobileapp.data.network.NetworkException;
import escuelaing.com.co.bowmobileapp.data.network.RequestCallback;
import escuelaing.com.co.bowmobileapp.data.persistence.LocalStorage;

public class SignInActivity extends AppCompatActivity {

    Button buttonBack;
    Button signUpButton;
    EditText emailText, nameText,idText, passwordText,confirmPassText;
    TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        componentsInitialization();
        actionListenersInitialization();

    }




    private void setUserInServer() {
        String email= emailText.getText().toString();
        String name = nameText.getText().toString();
        Integer id = Integer.parseInt(idText.getText().toString());
        String password= passwordText.getText().toString();
        String confirmation= confirmPassText.getText().toString();

        if (email==""||name==""||id==null||password==""||confirmation==""){
            dialogText.setText("Datos incompletos o erroneos");
        }
        else if(!password.equals(confirmation)){
            passwordText.setText("");
            confirmPassText.setText("");
            dialogText.setText("Las contraseñas no coinciden!");
        }
        else {
            User user = new User(email, name, id, password, confirmation);

            LocalStorage.retrofitNetwork.addNewUser(user, new RequestCallback<User>() {
                @Override
                public void onSuccess(User response) {

                    Intent intent = new Intent(SignInActivity.this, InitialActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailed(NetworkException e) {

                    e.printStackTrace();
                }
            });
        }

    }




    void componentsInitialization() {
        buttonBack = (Button) findViewById((R.id.buttonBack));
        signUpButton= (Button) findViewById(R.id.signUpButton);
        emailText=(EditText) findViewById(R.id.emailText);
        nameText=(EditText) findViewById(R.id.nameText);
        idText=(EditText) findViewById(R.id.idText);
        passwordText=(EditText) findViewById(R.id.passwordText);
        confirmPassText=(EditText) findViewById(R.id.confirmPassText);
        dialogText=(TextView) findViewById(R.id.dialogText);

    }

    void actionListenersInitialization() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setUserInServer();

            }
        });
    }
}
