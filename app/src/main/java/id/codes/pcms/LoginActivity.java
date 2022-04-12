package id.codes.pcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsername.getText().toString().equals("")||etPassword.getText().toString().equals("")){
                    etUsername.setError("Isi Terlebih Dahulu");
                    etPassword.setError("Isi Terlebih Dahulu");
                }else if (etUsername.getText().toString().equals("admin")&&etPassword.getText().toString().equals("pcms")){
                    startActivity(new Intent(LoginActivity.this,MainMenuActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
    }
}