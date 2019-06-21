package by.stress.radyukandroidpvt.dz2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_dz2b.*

class Dz2bActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(by.stress.radyukandroidpvt.R.layout.activity_dz2b)
    }

    override fun onStart() {
        super.onStart()

        buttonDz2b.setOnClickListener {

            val imgUri = editTextDz2b.text.toString()

            Picasso.get()
                .load(imgUri)
                .transform(RoundedTransformation(400, 0))
                .fit()
                .into(imageViewDz2b)

            
        }
    }
}
