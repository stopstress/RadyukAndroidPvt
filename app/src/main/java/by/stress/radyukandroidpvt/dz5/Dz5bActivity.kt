package by.stress.radyukandroidpvt.dz5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import by.stress.radyukandroidpvt.R
import kotlinx.android.synthetic.main.activity_dz5b.*


class Dz5bActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz5b)

        (blinkingOwlImageView.getBackground() as AnimationDrawable).start()
    }
}