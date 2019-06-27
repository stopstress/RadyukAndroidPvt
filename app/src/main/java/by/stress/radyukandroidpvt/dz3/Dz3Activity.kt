package by.stress.radyukandroidpvt.dz3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.stress.radyukandroidpvt.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_dz3.*

class Dz3Activity : AppCompatActivity() {

    private val imgUri = "https://cdn.pixabay.com/photo/2016/11/29/03/52/beard-1867175_960_720.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz3)
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this)
            .load(imgUri)
            .apply(RequestOptions.circleCropTransform())
            .into(imageViewDz3)
    }
}
