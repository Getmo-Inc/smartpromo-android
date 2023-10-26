package br.com.getmo.smartpromo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import br.com.getmo.smartpromo.models.FSPConsumer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun actionOpen(view: View) {
        val smartPromo = SmartPromo()
        smartPromo.setupAccessKeyAndSecretKey("{accessKey}", "{secretKey}")

        smartPromo.setColor(ContextCompat.getColor(this, R.color.colorPrimary))

        val consumer = FSPConsumer()
        consumer.cpf = "{cpf}"
        smartPromo.setConsumer(consumer)

        smartPromo.go("{campaignID}", this)
    }
}