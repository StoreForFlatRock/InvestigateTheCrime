package crimeapp.flatrocktech.com.investigatethecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySelectSuspect extends AppCompatActivity {

    private TextView mTextSuspectName;
    private Button mBtnTheMaid, mBtnTheCook, mBtnTheGardner, mBtnTheElectrician;
    private Button mBtnSolveCase;
    private String mSelectedSuspect;


    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ActivitySelectSuspect.class);
        context.startActivity(intent);
    }

    private View.OnClickListener mListenerSuspectSelected = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_the_maid:
                    mSelectedSuspect = ((Button) v).getText().toString();
                    setTextSuspectName(mSelectedSuspect);
                    break;
                case R.id.btn_the_cook:
                    mSelectedSuspect = ((Button) v).getText().toString();
                    setTextSuspectName(mSelectedSuspect);
                    break;
                case R.id.btn_the_gardner:
                    mSelectedSuspect = ((Button) v).getText().toString();
                    setTextSuspectName(mSelectedSuspect);
                    break;
                case R.id.btn_the_electrician:
                    mSelectedSuspect = ((Button) v).getText().toString();
                    setTextSuspectName(mSelectedSuspect);
                    break;
                case R.id.btn_solve_the_case:
                    if(mSelectedSuspect == null){
                        Toast.makeText(ActivitySelectSuspect.this, R.string.toast_text_message, Toast.LENGTH_SHORT).show();
                    } else {
                        solveTheCase(mSelectedSuspect);
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_suspect);
        initViews();
        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTextSuspectName.setText(R.string.text_select_suspect);
    }


    private void initViews() {
        mBtnTheMaid = findViewById(R.id.btn_the_maid);
        mBtnTheCook = findViewById(R.id.btn_the_cook);
        mBtnTheGardner = findViewById(R.id.btn_the_gardner);
        mBtnTheElectrician = findViewById(R.id.btn_the_electrician);
        mTextSuspectName = findViewById(R.id.tv_selected_suspect);
        mBtnSolveCase = findViewById(R.id.btn_solve_the_case);
    }

    private void setListeners() {
        mBtnTheMaid.setOnClickListener(mListenerSuspectSelected);
        mBtnTheGardner.setOnClickListener(mListenerSuspectSelected);
        mBtnTheCook.setOnClickListener(mListenerSuspectSelected);
        mBtnTheElectrician.setOnClickListener(mListenerSuspectSelected);
        mBtnSolveCase.setOnClickListener(mListenerSuspectSelected);
    }

    private void setTextSuspectName(String suspectName) {
        mTextSuspectName.setText(suspectName);
    }

    private void solveTheCase(String supsectName) {
        ActivityCaseSolved.newInstance(this, supsectName);
    }


}
