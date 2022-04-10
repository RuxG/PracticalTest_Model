package ro.pub.cs.systems.eim.practicaltest_model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends AppCompatActivity {

    EditText zeroText;
    EditText oneText;
    Button zeroButton;
    Button oneButton;
    Button navigate;

    final private static int SECONDARY_ACTIVITY_REQUEST_CODE = 2022;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_model_main);

        zeroText = (EditText)findViewById(R.id.text_view_0);
        oneText = (EditText)findViewById(R.id.text_view_1);
        zeroButton = (Button)findViewById(R.id.button_0);
        oneButton = (Button)findViewById(R.id.button_1);
        navigate = (Button)findViewById(R.id.navigate);

        PressMeListener listener = new PressMeListener();
        zeroButton.setOnClickListener(listener);
        oneButton.setOnClickListener(listener);
        navigate.setOnClickListener(listener);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("ZeroText");
        if (value != null) {
            zeroText.setText(value);
        }
        value = savedInstanceState.getString("OneText");
        if (value != null) {
            oneText.setText(value);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("ZeroText", zeroText.getText().toString());
        savedInstanceState.putString("OneText", oneText.getText().toString());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case SECONDARY_ACTIVITY_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

        }
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
            } else if (v.getId() == R.id.navigate) {
                int pressedNo = Integer.parseInt(zeroText.getText().toString());
                pressedNo += Integer.parseInt(oneText.getText().toString());

                Intent intent = new Intent(getApplicationContext(), PracticalTest_ModelSecondaryActivity.class);
                intent.putExtra("TOTAL_PRESSED", String.valueOf(pressedNo));
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }


}