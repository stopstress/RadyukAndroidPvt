package by.stress.radyukandroidpvt.dz6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import by.stress.radyukandroidpvt.R
import by.stress.radyukandroidpvt.dz6.Dz6Data.ITEM_MAP
import by.stress.radyukandroidpvt.dz6.Dz6Data.checkStudentFields
import by.stress.radyukandroidpvt.dz6.Dz6Data.createItem
import by.stress.radyukandroidpvt.dz6.Dz6Data.updateItem
import kotlinx.android.synthetic.main.activity_dz6_edit.*
import org.jetbrains.anko.toast

class Dz6CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6_create)

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        toolBar.title = "Добавить новую запись"

        buttonSave.setOnClickListener { createNewRecord() }
    }


    fun createNewRecord() {

        // сначала проверяем возраст (пустое поле вызывает обрушение приложения)
        if (editTextAge.text.isNullOrBlank()) {
            toast("Необходимо указать возраст студента.")
            return
        }

        // создаём объект StudentItem
        val newStudent = StudentItem(
            "0",
            editTextImageUrl.text.toString(),
            editTextName.text.toString(),
            editTextAge.text.toString().toInt()
        )

        // проверяем правильность заполнения полей
        val msg = checkStudentFields(newStudent)

        // если есть ошибки - выводим сообщение и остаёмся на странице редактирования
        if (msg != "") {
            toast(msg)

        // если данные введены правильно...
        } else {

            // пытаемся добавить запись и выводим сообщение о результатах
            val itemWasCreated: Boolean = createItem(newStudent)
            if (itemWasCreated) {
                toast("Запись была успешно добавлена")
            } else {
                toast("Не удалось добавить запись")
            }

            // переходим на список студентов
            val intent = Intent(this, Dz6ListActivity::class.java)
            startActivity(intent)
        }
    }

}

/*

        editTextId.setText(currentStudent.id)

        editTextId.setOnClickListener { toast("Значение этого поля генерируется приложением автоматически " +
                "и поэтому недоступно для редактирования.") }

        editTextImageUrl.setText(currentStudent.imageUrl)

        editTextName.setText(currentStudent.name)

        editTextAge.setText(currentStudent.age.toString())


    }

}


*/