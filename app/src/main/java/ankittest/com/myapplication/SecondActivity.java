package ankittest.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        TextView name = findViewById(R.id.txt_name);
        TextView mail = findViewById(R.id.txt_mail);
        TextView gender = findViewById(R.id.txt_gender);
        TextView about = findViewById(R.id.txt_about);
        DBHelper dbHelper = new DBHelper(SecondActivity.this);

        FormPOJO data = dbHelper.getData();
        name.setText(data.getCOL_NAME());
        mail.setText(data.getCOL_MAIl());
        gender.setText(data.getCOL_GENDER());
        about.setText(data.getCOL_ABOUT());
    }
}
