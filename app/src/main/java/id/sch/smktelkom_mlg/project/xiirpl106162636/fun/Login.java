package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create a instance of SQLite Database
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        editTextUsername = (EditText) findViewById(R.id.editTextUsernameToLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPasswordToLogin);


        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get The User name and Password
                doLogin();

            }
        });

        SpannableString ss = new SpannableString("Belum terdaftar? Silakan register disini");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        //ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);
        ss.setSpan(clickableSpan, 34, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

    }

    private void doLogin() {
        if (isValid()) {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            // fetch the Password form database for respective user name
            String storedPassword = loginDataBaseAdapter.getSinlgeEntry(username);

            // check if the Stored password matches with  Password entered by user
            if (password.equals(storedPassword)) {
                Toast.makeText(getApplicationContext(), "Login Berhasil!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Username atau Password tidak cocok.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;


        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.isEmpty()) {
            editTextUsername.setError("Username belum diisi");
            valid = false;
        } else if (username.length() < 5) {
            editTextUsername.setError("Username kurang. Minimal 5 karakter");
            valid = false;
        } else {
            editTextUsername.setError(null);
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password belum diisi");
            valid = false;
        } else if (password.length() < 8) {
            editTextPassword.setError("Password kurang. Minimal 8 karakter");
            valid = false;
        } else {
            editTextPassword.setError(null);
        }

        return valid;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}