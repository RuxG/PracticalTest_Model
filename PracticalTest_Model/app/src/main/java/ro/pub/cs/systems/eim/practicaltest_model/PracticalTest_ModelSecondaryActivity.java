package ro.pub.cs.systems.eim.practicaltest_model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest_ModelSecondaryActivity extends AppCompatActivity {

    TextView pressedNo;
    Button okButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_model_secondary);

        Intent intent = getIntent();
        String pressedString = intent.getStringExtra("TOTAL_PRESSED");
        pressedNo = (TextView) findViewById(R.id.totalPressed);
        pressedNo.setText(pressedString);

        okButton = (Button) findViewById(R.id.ok);
        cancelButton = (Button) findViewById(R.id.cancel);
        MyButtonListener listener = new MyButtonListener();
        okButton.setOnClickListener(listener);
        cancelButton.setOnClickListener(listener);

    }

    private class MyButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ok) {
                Intent intentToParent = new Intent();
                setResult(RESULT_OK, intentToParent);
                finish();
            } else if (v.getId() == R.id.cancel) {
                Intent intentToParent = new Intent();
                setResult(RESULT_CANCELED, intentToParent);
                finish();
            }
        }
    }

}
