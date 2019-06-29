package by.stress.radyukandroidpvt.dz5

import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.stress.radyukandroidpvt.R
import kotlinx.android.synthetic.main.activity_dz5b.*

class Dz5bActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz5b)
    }

    override fun onResume() {
        super.onResume()
        (blinkingOwlImageView.background as AnimationDrawable).start()
        Log.d("Dz5b", "start animation")
    }

    override fun onPause() {
        super.onPause()
        (blinkingOwlImageView.background as AnimationDrawable).stop()
        Log.d("Dz5b", "stop animation")
    }
}
