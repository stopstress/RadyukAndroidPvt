package by.stress.radyukandroidpvt.dz6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import by.stress.radyukandroidpvt.R
import by.stress.radyukandroidpvt.dz6.Dz6Data.ITEM_MAP
import by.stress.radyukandroidpvt.dz6.Dz6Data.checkStudentFields

import kotlinx.android.synthetic.main.activity_dz6_edit.*
import org.jetbrains.anko.toast

class Dz6EditActivity : AppCompatActivity() {

    private lateinit var currentId: String
    private lateinit var currentStudent: StudentItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6_edit)

        currentId = intent.getStringExtra("id")
        currentStudent = ITEM_MAP[currentId]!!

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        toolBar.title = "Редактирование студента"

        editTextId.setText(currentStudent.id)

        editTextId.setOnClickListener { toast("Значение этого поля генерируется приложением автоматически " +
                "и поэтому недоступно для редактирования.") }

        editTextImageUrl.setText(currentStudent.imageUrl)

        editTextName.setText(currentStudent.name)

        editTextAge.setText(currentStudent.age.toString())

        buttonSave.setOnClickListener { saveDataAfterEditing() }
    }

    fun saveDataAfterEditing() {

        // сначала проверяем возраст (пустое поле вызывает обрушение приложения)
        if (editTextAge.text.isNullOrBlank()) {
            toast("Необходимо указать возраст студента.")
            return
        }

        // создаём объект StudentItem
        val studentAfterEditing = StudentItem(
            currentId,
            editTextImageUrl.text.toString(),
            editTextName.text.toString(),
            editTextAge.text.toString().toInt()
        )

        // проверяем правильность заполнения полей
        val msg = checkStudentFields(studentAfterEditing)

        // если есть ошибки - выводим сообщение и остаёмся на странице редактирования
        if (msg != "") {
            toast(msg)

        // если всё правильно - сохраняем данные и возвращаемся на страницу с детальной информацией
        } else {
            toast("OK!")
            val intent = Intent(this, Dz6DetailsActivity::class.java)
            intent.putExtra("id", currentId)
            startActivity(intent)
        }
    }
}
