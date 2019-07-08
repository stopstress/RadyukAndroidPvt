package by.stress.radyukandroidpvt.dz6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.stress.radyukandroidpvt.R
import org.jetbrains.anko.toast

class Dz6EditActivity : AppCompatActivity() {

    private lateinit var currentId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6_edit)

        currentId = intent.getStringExtra("id")

        toast(currentId)

    }
}
