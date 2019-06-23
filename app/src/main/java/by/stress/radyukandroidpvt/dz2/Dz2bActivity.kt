package by.stress.radyukandroidpvt.dz2

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_dz2b.*
import org.jetbrains.anko.longToast

class Dz2bActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(by.stress.radyukandroidpvt.R.layout.activity_dz2b)
    }

    override fun onResume() {
        super.onResume()
        progressBarDz2b.visibility = INVISIBLE
    }

    override fun onStart() {
        super.onStart()

        buttonDz2b.setOnClickListener {

            progressBarDz2b.visibility = View.VISIBLE

            val imgUri = editTextDz2b.text.toString()

            Glide.with(this)
                .load(imgUri)

                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBarDz2b.visibility = GONE
                        longToast("Не удалось загрузить изображение")
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBarDz2b.visibility = INVISIBLE
                        longToast("Изображение успешно загружено")
                        return false
                    }
                })
                .apply(RequestOptions.circleCropTransform())
                .into(imageViewDz2b)
        }
    }
}
