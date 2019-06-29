package by.stress.radyukandroidpvt.dz5

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import by.stress.radyukandroidpvt.R
import kotlinx.android.synthetic.main.activity_dz5a.textViewNumbersShow
import kotlinx.android.synthetic.main.activity_dz5a.buttonAddNumber
import kotlinx.android.synthetic.main.activity_dz5a.editTextAddNumber
import kotlinx.android.synthetic.main.activity_dz5a.buttonDrawChart
import kotlinx.android.synthetic.main.activity_dz5a.chart
import org.jetbrains.anko.toast

class Dz5aActivity : AppCompatActivity() {
    val numbers: MutableList<Int> = mutableListOf(10, 20, 30)
    var numbersTextString = ""

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz5a)
        textViewNumbersShow.text = formatNumText(numbers)

        buttonAddNumber.setOnClickListener {
            if (editTextAddNumber.text.toString() != "") {
                val newNumber = editTextAddNumber.text.toString().toInt()
                numbers.add(newNumber)
                textViewNumbersShow.text = formatNumText(numbers)
                editTextAddNumber.text.clear()
                editTextAddNumber.clearFocus()
            } else {
                toast("Необходимо ввести число")
            }
        }

        buttonDrawChart.setOnClickListener {
            editTextAddNumber.text.clear()
            editTextAddNumber.clearFocus()
            chart.setData(numbers)
            chart.invalidate()
        }
    }

    fun formatNumText(numbers: MutableList<Int>): String {
        val numbersText = StringBuilder()
        numbersText.append("Numbers Array: ")
        numbersText.append(numbers.toString())
        numbersTextString = numbersText.toString()
        numbersTextString = numbersTextString.replace("[", "")
        numbersTextString = numbersTextString.replace("]", "")
        return numbersTextString
    }
}