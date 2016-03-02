package com.example.testplayer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
public class Main3 extends Activity implements OnClickListener,
OnPreparedListener, OnErrorListener, OnCompletionListener {
 
    MediaPlayer mp;
    ProgressDialog pd;
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main3);
    Button bt = (Button)findViewById(R.id.play);
    bt.setOnClickListener(this);
}
 
   @Override
   public void onPrepared(MediaPlayer mp) {
       Log.i("StreamAudioDemo", "prepare finished");
       pd.setMessage("Playing.....");
       mp.start();
  }
 
  @Override
  public void onClick(View v) {
       try
        {
            pd = new ProgressDialog(this);
            pd.setMessage("Buffering.....");
            pd.show();
            mp = new MediaPlayer();
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnPreparedListener(this);
            mp.setOnErrorListener(this);
            mp.setDataSource("http://192.168.220.1:8080/RESTfulExample/rest/file/");
            mp.prepareAsync();
            mp.setOnCompletionListener(this);
        }
        catch(Exception e)
        {
            Log.e("StreamAudioDemo", e.getMessage());
        }
    }
 
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
      pd.dismiss();
      return false;
    }
 
    @Override
    public void onCompletion(MediaPlayer mp) {
        pd.dismiss();
        Toast.makeText(getApplicationContext(), "Completed", Toast.LENGTH_LONG).show();     
    }
}