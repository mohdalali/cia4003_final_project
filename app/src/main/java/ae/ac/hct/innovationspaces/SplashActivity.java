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

        TextureVideoView cropTextureView = (TextureVideoView) findViewById(R.id.cropTextureView);
// Use `setScaleType` method to crop video
        cropTextureView.setScaleType(TextureVideoView.ScaleType.TOP);
// Use `setDataSource` method to set data source, this could be url, assets folder or path
        cropTextureView.setDataSource("http://www.w3schools.com/html/mov_bbb.mp4");
        cropTextureView.play();
    }
}
