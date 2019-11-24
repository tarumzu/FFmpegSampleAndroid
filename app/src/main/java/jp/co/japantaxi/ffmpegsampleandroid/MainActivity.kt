package jp.co.japantaxi.ffmpegsampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arthenica.mobileffmpeg.FFmpeg
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val filename = filesDir.path + File.separator + "1574239826605.wav"

            FFmpeg.execute("-i $filename -af volumedetect -f null NULL")
            val rc = FFmpeg.getLastReturnCode()
            val output = FFmpeg.getLastCommandOutput()

            when (rc) {
                FFmpeg.RETURN_CODE_SUCCESS -> {
                    text.text = "FFmpeg Success!\n $output"
                }
                FFmpeg.RETURN_CODE_CANCEL -> {
                    text.text = "FFmpeg Cancel\n $output"
                }
                else -> {
                    text.text = "FFmpeg Error\n $output"
                }
            }
        }
    }
}
