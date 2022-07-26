package cd.wayupdev.esis_android_tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvLogin;
    private TextView tvId;
    private EditText edId;
    private Button btnSubmit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_api);

        initialisation();
        setEcouteurEvenement();
    }

    private void setEcouteurEvenement(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = edId.getText().toString();
                if(idText.isEmpty()){
                    Toast.makeText(RestApiActivity.this, "L'id ne peux etre vide", Toast.LENGTH_SHORT).show();
                }else {
                    int id = Integer.parseInt(idText);
                    recupererGithubUser(id);
                }
            }
        });
    }

    private void recupererGithubUser(int id) {
        progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubUserService userService = retrofit.create(GithubUserService.class);
        GithubUser user = userService.getUser(id);

        tvName.setText("Name" + user.getName());
        tvLogin.setText("Login" + user.getLogin());
        tvId.setText("Id : " + user.getId());
        progressBar.setVisibility(View.GONE);
    }

    private void initialisation(){
        tvName = findViewById(R.id.tvName);
        tvLogin = findViewById(R.id.tvLogin);
        tvId = findViewById(R.id.tvId);
        edId = findViewById(R.id.etId);
        btnSubmit = findViewById(R.id.btnSubmit);
        progressBar = findViewById(R.id.progressbar);
    }
}