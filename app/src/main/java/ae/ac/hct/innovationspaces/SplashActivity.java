package ae.ac.hct.innovationspaces;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = findViewById(R.id.splashVideo);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    private void setDimension() {
        float videoProportion = getVideoProportion();
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        float screenProportion = (float) screenHeight / (float) screenWidth;
        android.view.ViewGroup.LayoutParams lp = videoView.getLayoutParams();

        if (videoProportion < screenProportion) {
            lp.height= screenHeight;
            lp.width = (int) ((float) screenHeight / videoProportion);
        } else {
            lp.width = screenWidth;
            lp.height = (int) ((float) screenWidth * videoProportion);
        }
        videoView.setLayoutParams(lp);
    }

    private float getVideoProportion(){
        return 1.5f;
    }
}
