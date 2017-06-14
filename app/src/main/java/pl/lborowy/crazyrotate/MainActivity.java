package pl.lborowy.crazyrotate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private int value;
    private TextView moreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moreText = (TextView) findViewById(R.id.moreText);
        refreshText();
    }

    public void more(View view) {
        value++;
        refreshText();
    }

    private void refreshText() {
        moreText.setText(Integer.toString(value));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("liczba", value);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        value = savedInstanceState.getInt("liczba", Integer.MIN_VALUE); // jeżeli nie ma liczby, to zwracamy (kod błędu - może być np. -1)
        refreshText();
    }
}
