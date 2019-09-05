package nl.hva.fdmci.mobiledevelopment.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TableLayout
import android.widget.Toast
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_logica.*

class LogicaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica)
        initViews()
    }

    private fun initViews() {
        submitButton.setOnClickListener { onSubmitBtn() }
    }

    private fun onSubmitBtn() {
        if (checkValidity()) {
            if (answerField1.text.toString() == "T") {
                if (answerField2.text.toString() == "F") {
                    if (answerField3.text.toString() == "F") {
                        if (answerField4.text.toString() == "F") {
                            onAnswerCorrect()
                            return
                        }
                    }
                }
            }
            onAnswerIncorrect()
        } else{
            onNoAnswer()
        }

    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }

    private fun checkValidity(): Boolean {

        val editTexts = arrayListOf<EditText>(answerField1, answerField2, answerField3, answerField4)

        for (editText in editTexts) {
            if (editText.text.toString().isBlank()) {
                return false
            }
        }

        return true
    }

    private fun onNoAnswer() {
        Toast.makeText(this, getString(R.string.noAnswer), Toast.LENGTH_SHORT).show()
    }
}
