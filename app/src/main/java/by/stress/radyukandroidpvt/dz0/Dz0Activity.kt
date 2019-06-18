package by.stress.radyukandroidpvt.dz0

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.stress.radyukandroidpvt.R
import kotlinx.android.synthetic.main.activity_dz0.*

class Dz0Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz0)

        textView1.setOnClickListener() {
            replaceTextAndColor()
        }

        textView2.setOnClickListener() {
            replaceTextAndColor()
        }

        button.setOnClickListener() {
            replaceTextAndColor()
        }
    }

    fun replaceTextAndColor() {

        val text1 = textView1.text
        val color1 = textView1.background

        textView1.text = textView2.text
        textView2.text = text1

        textView1.background = textView2.background
        textView2.background = color1
    }
}
