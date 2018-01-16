package feup.com.flash_sales;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import feup.com.flash_sales.adapter.PreferencesAdapter;
import feup.com.flash_sales.utils.Mock;

/**
 * Created by jhonny on 15-01-2018.
 */

public class PreferencesActivity extends AppCompatActivity {
    PreferencesAdapter preferencesAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.preferencesRV)
    RecyclerView preferencesRV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setRecyclerView();
    }

    private void setRecyclerView(){
        preferencesRV.setHasFixedSize(true);
        LinearLayoutManager shopLayoutManager = new LinearLayoutManager(this);
        preferencesRV.setLayoutManager(shopLayoutManager);
        preferencesAdapter = new PreferencesAdapter(this, Mock.getPreferences());
        preferencesRV.setAdapter(preferencesAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send_action:
                Toast.makeText(this,"Preferencias salvas!",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
