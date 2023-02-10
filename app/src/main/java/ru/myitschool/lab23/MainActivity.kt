package ru.myitschool.lab23

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.getRandomNums.setOnClickListener{ getRandomValue() }

    }

    private fun getRandomValue() {
        val sizeText = binding.content.sizeParam.text.toString()
        val shapeText = binding.content.shapeParam.text.toString()
        val rateText = binding.content.rateParam.text.toString()

        val n: Int = if(sizeText == "") 0 else sizeText.toInt()
        val k: Int = if(shapeText == "") 0 else shapeText.toInt()
        val r: Double = if(rateText == "") 0.0 else rateText.toDouble()

        val calcResult = DoubleArray(n)

        repeat(n) {
            calcResult[it] = calc(k, r)
            Log.d("RRR", calcResult[it].toString())
        }

        /*
        Здесь нужен вызов явного Intent с передачей массива
         */

    }

    private fun calc(kk: Int, rr: Double): Double {
        var total = 0.0
        repeat(kk) {
            val rand = Math.random() // 0..1
            total += Math.log(rand)
        }
        return -total/rr
    }
}