package jp.co.japantaxi.ffmpegsampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arthenica.mobileffmpeg.FFmpeg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FFmpeg.execute("-version")
        val rc = FFmpeg.getLastReturnCode()
        val output = FFmpeg.getLastCommandOutput()

        when (rc) {
            FFmpeg.RETURN_CODE_SUCCESS -> {
                Log.i("FFmpeg", "Success!")
            }
            FFmpeg.RETURN_CODE_CANCEL -> {
                Log.e("FFmpeg", output)
            }
            else -> {
                Log.e("FFmpeg", output)
            }
        }
    }
}
