package project.adrian.com.android_kotlin_jetpack_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOpenSecondPage.setOnClickListener {
            view -> view.findNavController().navigate(R.id.action_mainActivity_to_secondActivity)
        }
//        Navigation.fin
    }

    override fun onSupportNavigateUp()
            = findNavController(R.id.my_nav_host_fragment).navigateUp()
}
