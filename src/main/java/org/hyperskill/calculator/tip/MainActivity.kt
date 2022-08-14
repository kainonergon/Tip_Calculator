package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider

const val HUNDRED = 100

class MainActivity : AppCompatActivity() {
    private lateinit var bill: EditText
    private lateinit var tip: Slider
    private lateinit var textView: TextView
    private lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bill = findViewById(R.id.edit_text)
        tip = findViewById(R.id.slider)
        textView = findViewById(R.id.text_view)
        message = getString(R.string.message)

        bill.doAfterTextChanged { afterInputChanged() }
        tip.addOnChangeListener {_, _, _ -> afterInputChanged() }
    }

    private fun afterInputChanged() {
        if (bill.text.isEmpty()) {
            textView.text = ""
        } else {
            val tipAmount = bill.text.toString().toDouble() * tip.value.toInt() / HUNDRED
            textView.text = message.format(tipAmount)
        }
    }
}