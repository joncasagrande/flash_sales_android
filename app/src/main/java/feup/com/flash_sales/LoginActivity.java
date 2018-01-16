package feup.com.flash_sales;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import feup.com.flash_sales.adapter.PromotionAdapter;

/**
 * Created by jhonny on 15-01-2018.
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    PromotionAdapter promotionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }

    public void signUp(View view){
        finish();
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void login(View view){
        Toast.makeText(this, "Login realizado!",Toast.LENGTH_SHORT).show();
        finish();
    }
}
