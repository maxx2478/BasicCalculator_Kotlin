package com.manohar.calculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var editText:EditText? = null
    var isNew= true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_query)

    }


    fun buttonevent(view: View)
    {

        if (isNew)
        {
            editText!!.setText("")
        }
        isNew = false

        val butSelected = view as TextView
        var buClickValue:String= editText!!.text.toString()
        when(butSelected.id)
        {
            R.id.zero ->  buClickValue += "0"
            R.id.one ->  buClickValue += "1"
            R.id.two ->  buClickValue += "2"
            R.id.three ->  buClickValue += "3"
            R.id.four ->  buClickValue += "4"
            R.id.five ->  buClickValue += "5"
            R.id.six ->  buClickValue += "6"
            R.id.seven ->  buClickValue += "7"
            R.id.eight ->  buClickValue += "8"
            R.id.nine ->  buClickValue += "9"
            R.id.dot -> {

                if (buClickValue.contains(".")) {
                    buClickValue = buClickValue.replace(".", "")
                } else {
                    buClickValue += "."
                }
            }

            R.id.plusminus -> {
                if (buClickValue.contains("-"))
                {
                    buClickValue = buClickValue.replace("-","")
                }
                else
                {
                    buClickValue = "-" + buClickValue}
                }
        }

        editText!!.setText(buClickValue)

    }

    var op="+"
    var oldNum = ""
    fun opevent(view: View)
    {
        val buSelect = view as TextView
        when(buSelect.id)
        {
            R.id.add -> {op = "+" }
            R.id.sub -> op = "-"
            R.id.mul -> op = "*"
            R.id.div -> op = "/"
        }

        oldNum = editText!!.text.toString()
        isNew = true

    }

    fun equalevent(view: View)
    {

        var newnumber = editText!!.text.toString()
        if (newnumber.isEmpty() || oldNum.isEmpty())
        {

        }
        else
        {
            var finalnumb:Double?=null
            when(op)
            {
                "+" -> finalnumb = oldNum.toDouble() + newnumber.toDouble()
                "-" -> finalnumb = oldNum.toDouble() - newnumber.toDouble()
                "*" -> finalnumb = oldNum.toDouble() * newnumber.toDouble()
                "/" -> finalnumb = oldNum.toDouble() / newnumber.toDouble()
            }
            editText!!.setText(finalnumb.toString())
        }


    }

    fun cleanentries(view: View) { editText!!.setText("0")
    isNew = true}

    fun mod(view: View) { var modnum = editText!!.text.toString().toDouble()/100
    editText!!.setText(modnum.toString())}


}