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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout rootView=(RelativeLayout) findViewById(R.id.rootLayout);
        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);

        FrameLayout.LayoutParams rootViewParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
        int videoWidth=864;
        int videoHeight=1280;

        if ((float)videoWidth/(float)videoHeight<(float)size.x/(float)size.y) {
            rootViewParams.width=size.x;
            rootViewParams.height=videoHeight*size.x/videoWidth;
            rootView.setX(0);
            rootView.setY((rootViewParams.height-size.y)/2*-1);
        } else {
            rootViewParams.width=videoWidth*size.y/videoHeight;
            rootViewParams.height=size.y;
            rootView.setX((rootViewParams.width-size.x)/2*-1);
            rootView.setY(0);
        }
        rootView.setLayoutParams(rootViewParams);


        final VideoView mVideoView=(VideoView)findViewById(R.id.splashVideo);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash));
        mVideoView.requestFocus();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mVideoView.start();
            }
        });
    }
}
