package feup.com.flash_sales;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jhonny on 15-01-2018.
 */

public class SignUpActivity extends AppCompatActivity{
    @BindView(R.id.birthDateET)
    EditText birthDateET;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ButterKnife.bind(this);
    }

    public void dobBT(View view){
        Calendar cal = Calendar.getInstance();
        new SpinnerDatePickerDialogBuilder()
                .context(this)
                .callback((view1, year, monthOfYear, dayOfMonth) -> {
                    String stringDate = dayOfMonth+"/"+monthOfYear+"/"+year;
                    birthDateET.setText(stringDate);
                })
                .spinnerTheme(R.style.NumberPickerStyle)
                .defaultDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH))
                .maxDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH))
                .minDate(1900, 0, 1)
                .build()
                .show();
    }

    public void signUp(View view){
        Toast.makeText(this, "Cadastro realizado!",Toast.LENGTH_SHORT).show();
        finish();
    }
}
