package ankittest.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //this is pull request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FormPOJO formPOJO = new FormPOJO();
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edt_name = findViewById(R.id.edt_name);
                EditText edt_mail = findViewById(R.id.edt_mail);
                EditText edt_pwd = findViewById(R.id.edt_pwd);
                EditText edt_about = findViewById(R.id.edt_about);
                RadioGroup group = findViewById(R.id.radio_grp);

                if (edt_name.getText().toString().trim().length() < 0) {
                    edt_name.setError("Name Compulsory");
                } else if (edt_mail.getText().toString().trim().length() < 0) {
                    edt_mail.setError("Email Compulsory");
                } else if (edt_pwd.getText().toString().trim().length() < 0) {
                    edt_pwd.setError("Password Compulsory");
                } else if (edt_about.getText().toString().trim().length() < 0) {
                    edt_about.setError("About Compulsory");
                }else
                {
                    int selectedId = group.getCheckedRadioButtonId();

                    RadioButton radioSexButton = (RadioButton) findViewById(selectedId);
                    formPOJO.setCOL_NAME(edt_name.getText().toString());
                    formPOJO.setCOL_MAIl(edt_mail.getText().toString());
                    formPOJO.setCOL_PWD(edt_pwd.getText().toString());
                    formPOJO.setCOL_ABOUT(edt_about.getText().toString());
                    formPOJO.setCOL_GENDER(radioSexButton.getText().toString());

                    DBHelper dbHelper = new DBHelper(MainActivity.this);
                    dbHelper.insertDetails(formPOJO);
                    dbHelper.getData();


                    startActivity(new Intent(MainActivity.this,SecondActivity.class));

                }


            }
        });
    }
}
