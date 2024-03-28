package com.example.videostreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private VideoView videoView;
    private ImageView playbutton;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferprogress;
    private Uri videouri;
    private boolean isPlaying;
    private int duration=0;
    private TextView mov_title,description;
    private ImageView interstellar;
    private ImageView titanic;
    private ImageView dangal;
    private ImageView sultan;
    private ImageView chennai;
    private ImageView three;
    private ImageView kgf;
    private ImageView vr;
    private ImageView kantara;
    private ImageView kirik;
    ConstraintLayout l;


    public void run_movie(Uri videouri,String title)
    {
        Toast.makeText(MainActivity.this,"ENJOY WATCHING "+ title+"!!", Toast.LENGTH_SHORT).show();
        bufferprogress.setVisibility(View.VISIBLE);
        new VideoProgress().execute();
        mov_title.setText(title);
        videoView.setVideoURI(videouri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
                bufferprogress.setVisibility(View.GONE);
                duration = mp.getDuration() / 1000;
                String durationstring = String.format("%02d:%02d", duration / 60, duration % 60);
                durationTimer.setText(durationstring);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPlaying=false;
        videoView=findViewById(R.id.videoView);
        playbutton=findViewById(R.id.playbtn);
        currentTimer=findViewById(R.id.currentTimer);
        durationTimer=findViewById(R.id.durationTimer);
        currentProgress=findViewById(R.id.videoProgress);
        currentProgress.setMax(100);
        bufferprogress=findViewById(R.id.progressBar3);
        ImageView inception = findViewById(R.id.inception);
        ImageView tenet = findViewById(R.id.tenet);
        interstellar=findViewById(R.id.intersteller);
        titanic=findViewById(R.id.titanic);
        dangal=findViewById(R.id.dangal);
        sultan=findViewById(R.id.sultan);
        chennai=findViewById(R.id.chennai);
        three=findViewById(R.id.three_ediots);
        kgf=findViewById(R.id.kgf);
        vr=findViewById(R.id.vr);
        kirik=findViewById(R.id.kirik_party);
        kantara=findViewById(R.id.kantara);
        mov_title=findViewById(R.id.movi_title);
        l=findViewById(R.id.l);
        l.setBackgroundColor(Color.BLACK);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/earth%20revolving.mp4?alt=media&token=0a39ec9f-60fe-445a-9ca2-45b773bfd28f");
        run_movie(videouri,"EARTH REVOLVING");

        inception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate%5B1%5D.mp4?alt=media&token=10943525-92dc-4545-8836-84b81cb8983e");
                String mtitle="INCEPTION";
                run_movie(videouri,mtitle);

            }
        });
        tenet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/tenet.mp4?alt=media&token=16130af2-31a4-4b0f-818e-04bc7f400016");
                run_movie(videouri,"TENET");
            }
        });
        interstellar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/interstellar.mp4?alt=media&token=6f1e73af-9dde-41ae-9b40-cfe4c8971079");
                run_movie(videouri,"INTERSTELLAR");
            }
        });
        titanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/Titanic.mp4?alt=media&token=c7b6f62b-32ca-4751-b6c0-ecfbc210f7da");
                run_movie(videouri,"TITANIC");
            }
        });
        dangal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/dangal.mp4?alt=media&token=dc70d339-56b0-4550-bb77-86738279d2e6");
                run_movie(videouri,"DANGAL");
            }
        });
        sultan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/sulthan.mp4?alt=media&token=2b7e715f-24ef-4665-ae5e-4873903f1d14");
                run_movie(videouri,"SULTAN");
            }
        });
        chennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/chennai%20express.mp4?alt=media&token=50d9998d-20cf-4025-a8a0-8dbd4b213a6c");
                run_movie(videouri,"CHENNAI EXPRESS");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/three%20idiots.mp4?alt=media&token=dee5685d-091f-401c-a92b-5eabe013114b");
                run_movie(videouri,"THREE IDIOTS");
            }
        });
        kgf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/kgf.mp4?alt=media&token=d39ec3fc-519a-4d0f-994a-ee74ffbb6a39");
                run_movie(videouri,"KGF");
            }
        });
        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/Vikranth%20rona.mp4?alt=media&token=f97f7f29-12b7-4500-b79e-7a1e1361a17b");
                run_movie(videouri,"VIKRANT RONA");
            }
        });
        kantara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/Kanthara.mp4?alt=media&token=677dc604-eb49-4e74-8549-f047850494bc");
                run_movie(videouri,"KANTARA");
            }
        });
        kirik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-72893.appspot.com/o/kirik%20party.mp4?alt=media&token=bddbb2f3-5a67-4668-918e-c77ae2cc7612");
                run_movie(videouri,"KIRIK PARTY");
            }
        });

        isPlaying=true;
        playbutton.setImageResource(R.drawable.img);
        new VideoProgress().execute();
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying)
                {
                    videoView.pause();
                    isPlaying=false;
                    playbutton.setImageResource(R.drawable.img_1);
                }
                else
                {
                    videoView.start();
                    isPlaying=true;
                    playbutton.setImageResource(R.drawable.img);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        isPlaying=false;
    }

    public class VideoProgress extends AsyncTask<Void,Integer,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            do {
                if(isPlaying)
                {
                    int current = videoView.getCurrentPosition() / 1000;
                    try{
                        int currentPercent= current *100/duration;
                        publishProgress(currentPercent);
                    }
                    catch (Exception ignored)
                    {

                    }}

            }while(currentProgress.getProgress()<=100);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values);
            try{
                int currentPercent=values[0]*100/duration;
                currentProgress.setProgress(currentPercent);
                String currentString=String.format("%02d:%02d",values[0]/60,values[0]%60);
                currentTimer.setText(currentString);}
            catch (Exception ignored)
            {

            }
        }
    }
}