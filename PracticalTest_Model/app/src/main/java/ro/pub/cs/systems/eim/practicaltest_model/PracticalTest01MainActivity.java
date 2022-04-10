package ro.pub.cs.systems.eim.practicaltest_model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01MainActivity extends AppCompatActivity {

    EditText zeroText;
    EditText oneText;
    Button zeroButton;
    Button oneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_model_main);

        zeroText = (EditText)findViewById(R.id.text_view_0);
        oneText = (EditText)findViewById(R.id.text_view_1);
        zeroButton = (Button)findViewById(R.id.button_0);
        oneButton = (Button)findViewById(R.id.button_1);

        PressMeListener listener = new PressMeListener();
        zeroButton.setOnClickListener(listener);
        oneButton.setOnClickListener(listener);
    }

    private class PressMeListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.button_0) {
                int pressedNo = Integer.parseInt(zeroText.getText().toString());
                pressedNo++;
                zeroText.setText(String.valueOf(pressedNo));
            } else if (v.getId() == R.id.button_1) {
                int pressedNo = Integer.parseInt(oneText.getText().toString());
                pressedNo++;
                oneText.setText(String.valueOf(pressedNo));
            }
        }
    }


}