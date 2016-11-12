package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText editTextUsername, editTextPassword, editTextConfirmPassword;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // get Instance  of Database Adapter
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

        findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRegister();
            }
        });


    }

    private void doRegister() {
        if (isValid()) {
            // TODO Auto-generated method stub

            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            String confirmPassword = editTextConfirmPassword.getText().toString();


            // check if both password matches
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_LONG).show();
                return;
            } else {
                // Save the Data in Database
                loginDataBaseAdapter.insertEntry(username, password);
                Toast.makeText(getApplicationContext(), "Akun berhasil dibuat. Silakan Login.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        }
    }

    private boolean isValid() {
        boolean valid = true;


        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        String cpassword = editTextConfirmPassword.getText().toString();

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

        if (cpassword.isEmpty()) {
            editTextConfirmPassword.setError("Konfirmasi Password belum diisi");
            valid = false;
        } else if (cpassword.length() < 8) {
            editTextConfirmPassword.setError("Konfirmasi Password kurang. Minimal 8 karakter");
            valid = false;
        } else {
            editTextConfirmPassword.setError(null);
        }
        return valid;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}
