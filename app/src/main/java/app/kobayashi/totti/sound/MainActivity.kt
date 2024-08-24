package app.kobayashi.totti.sound

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.kobayashi.totti.sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply{setContentView(this.root)}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drumSound: MediaPlayer = MediaPlayer.create(this,R.raw.drum_sound)

        binding.drumImage.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.drumImage.setImageResource(R.drawable.drum_playing_image)

                drumSound.seekTo(0)
                drumSound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }

        val pianoSound = MediaPlayer.create(this,R.raw.piano_sound)

        binding.pianoImage.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.pianoImage.setImageResource(R.drawable.piano_playing_image)

                pianoSound.seekTo(0)
                pianoSound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.pianoImage.setImageResource(R.drawable.piano_image)
            }
            true
        }

        val guitarSound = MediaPlayer.create(this,R.raw.guitar_sound)

        binding.guitarImage.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.guitarImage.setImageResource(R.drawable.guitar_playing_image)

                guitarSound.seekTo(0)
                guitarSound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.guitarImage.setImageResource(R.drawable.guitar_image)
            }
            true
        }
    }
}