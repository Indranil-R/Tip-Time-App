package corp.thunder.tiptime

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateAmount(view: View) {
        val stringInField = baseCost.editableText.toString()
        val cost = stringInField.toDoubleOrNull()
        if (cost == null) {
            tipAmount.text = ""
            return
        }
        val tipPercentage =
            when (tipOptions.checkedRadioButtonId) {
                R.id.amazing -> 0.20
                R.id.good -> 0.18
                else -> 0.15
            }

        var tip = cost * tipPercentage
        if (roundUpTip.isChecked) tip = kotlin.math.ceil(tip)

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}
