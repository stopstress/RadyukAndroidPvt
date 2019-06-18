package by.stress.radyukandroidpvt.dz2

//import sun.security.krb5.internal.KDCOptions.with
//import com.squareup.picasso.Callback as Callback1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.stress.radyukandroidpvt.R
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

            buttonDz2b.text = "12345678"
            //editTextDz2b.text
            //imageViewDz2b.setImageDrawable()
            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageViewDz2b)

            //Picasso.get().load(R.drawable.login_bg).into(imageViewDz2b)
            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageViewDz2b)


            // val callBack = Callback1() {
            //     fun onSuccess() {
            //         Toast.makeText("Картинка загрузилась", Toast.LENGTH_LONG).show()
            //     }
            //
            //     fun onError() {}
            // }
            //

            //Picasso.setIndicatorsEnabled(true)
            //Picasso.get().setIndicatorsEnabled()
            /// https://cdn.pixabay.com/photo/2016/12/04/21/58/rabbit-1882699_960_720.jpg

            Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.login_bg)
                .error(R.drawable.login_logo)
                .fit()
                .into(imageViewDz2b)

            // load the image with Picasso
            // Picasso.get()
            //
            //     with(this) // give it the context
            //     .load("https://i.imgur.com/H981AN7.jpg") // load the image
            //     .into(myImageView) // select the ImageView to load it into

            /*
            картинки:
            https://cdn.pixabay.com/photo/2019/04/20/18/46/the-squirrel-4142446_960_720.jpg
            https://cdn.pixabay.com/photo/2016/12/04/21/58/rabbit-1882699_960_720.jpg

            инструкции:
            https://edu.kiparo.by/index.php?module=edu&method=show_lesson&lesson_id=74

            http://square.github.io/picasso/
            https://www.journaldev.com/13759/android-picasso-tutorial
            http://java-help.ru/android-picasso/
            http://bikshanov.com/libraries/displaying-images-with-picasso-library/
            http://developer.alexanderklimov.ru/android/library/picasso.php



            */
        }

    }


}
