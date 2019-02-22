package cn.wong.androidcustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.wong.androidcustomview.customview1.CheckView;

public class MainActivity extends AppCompatActivity {

    boolean isCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckView checkView = findViewById(R.id.test_view);
        checkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCheck) {
                    checkView.unCheck();
                } else {
                    checkView.check();
                }
            }
        });
    }
}
