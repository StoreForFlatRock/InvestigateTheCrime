package crimeapp.flatrocktech.com.investigatethecrime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityCrimeScene extends AppCompatActivity {

    private Button mBtnSolveTheMistery;

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_solve_the_mistery){
                navigate();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_scene);
        mBtnSolveTheMistery = findViewById(R.id.btn_solve_the_mistery);
        mBtnSolveTheMistery.setOnClickListener(mClickListener);
    }

    private void navigate() {
        ActivitySelectSuspect.newInstance(this);
    }
}
