package ae.ac.hct.innovationspaces;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView videoview = (VideoView) findViewById(R.id.splashVideo);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
        videoview.setVideoURI(uri);
        videoview.start();
    }
}
