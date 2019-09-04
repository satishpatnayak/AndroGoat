package owasp.sat.agoat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class InputValidationsOSCMDInjectionMain2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_validations_oscmdinjection_main2)
        val runButton=findViewById<Button>(R.id.run)
        val result=findViewById<TextView>(R.id.result)
        val ip=findViewById<EditText>(R.id.ip)
        runButton.setOnClickListener{
            val ip1:String="ping "+ip.text.toString()
            val output1=StringBuffer()
            try {

                val p:Process=Runtime.getRuntime().exec(ip1,null,null)
                p.waitFor();
                val reader:BufferedReader= BufferedReader(InputStreamReader(p.inputStream))
                val line:String=reader.readLine()
                while (line!=null)
                {
                    output1.append(line+"n")

                }
                //result.text=p.inputStream.bufferedReader().readText();
            }
            catch(e:Exception)
            {
                e.printStackTrace()
            }
            result.text=output1.toString()
            }
        }
    }

