package by.stress.radyukandroidpvt.dz6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.stress.radyukandroidpvt.R
import by.stress.radyukandroidpvt.dz6.Dz6Data.ITEM_MAP
import by.stress.radyukandroidpvt.dz6.Dz6Data.deleteItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_dz3.*
import kotlinx.android.synthetic.main.activity_dz6_details.*
import org.jetbrains.anko.toast

class Dz6DetailsActivity : AppCompatActivity() {

    private lateinit var currentId: String
    private lateinit var currentStudent: Dz6Data.StudentItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6_details)

        currentId = intent.getStringExtra("id")
        currentStudent = ITEM_MAP[currentId]!!
    }

    override fun onStart() {
        super.onStart()

        studentName.text = currentStudent.name

        studentAge.text = currentStudent.age.toString()

        Glide.with(this)
            .load(currentStudent.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(studentPortrait)
    }

    override fun onResume() {
        super.onResume()

        buttonEdit.setOnClickListener {
            val intent = Intent(this, Dz6EditActivity::class.java)
            intent.putExtra("id", currentId)
            startActivity(intent)
        }

        buttonDelete.setOnClickListener {
            deleteItem(currentId)
            val intent = Intent(this, Dz6ListActivity::class.java)
            startActivity(intent)
        }
    }
}