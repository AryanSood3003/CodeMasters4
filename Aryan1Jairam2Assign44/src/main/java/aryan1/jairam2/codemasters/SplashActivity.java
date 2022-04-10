//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA

package aryan1.jairam2.codemasters;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private Handler handler =new  Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        handler.postDelayed(runnable,2000);
    }

    @Override
    public void onResume() {

        super.onResume();
    }


    public Runnable runnable =new Runnable() {
        @Override
        public void run() {
            Log.d("TAG", "run: ");
            if (!isFinishing()) {
                Intent intent = new Intent(getApplicationContext(), Aryan1Jairam2Activity.class);
                startActivity(intent);
                finish(); //so that splash screen doesn't open on resuming
            }
        }
    };
}