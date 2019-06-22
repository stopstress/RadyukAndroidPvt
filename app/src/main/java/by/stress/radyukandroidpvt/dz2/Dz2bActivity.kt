package by.stress.radyukandroidpvt.dz2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

            Glide.with(this)
                .load(imgUri)
/*
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(p0: GlideException?, p1: Any?, target: Target<Drawable>?, p3: Boolean): Boolean {
                        progressBar.visibility = View.GONE
                        Toast.makeText(this@Dz2bActivity, "Failed to load image", Toast.LENGTH_SHORT).show()
                        return false
                    }

                    override fun onResourceReady(p0: Drawable?, p1: Any?, target: Target<Drawable>?, p3: DataSource?, p4: Boolean): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }
                })           */
                .apply(RequestOptions.circleCropTransform())
                .into(imageViewDz2b)
        }
    }
}
