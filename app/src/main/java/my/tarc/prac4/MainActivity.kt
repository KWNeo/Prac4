package my.tarc.prac4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ActivityChooserView
import androidx.databinding.DataBindingUtil
import my.tarc.prac4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactList = ArrayList<Contact>()
    private var index = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.btnAdd.setOnClickListener {
            if (binding.txtName.text.isEmpty() || binding.txtPhone.text.isEmpty()){
                binding.txtName.error = getString(R.string.error)
                binding.txtPhone.error = getString(R.string.error)
                return@setOnClickListener
            }
            val newContact = Contact(binding.txtName.text.toString(), binding.txtPhone.text.toString())
            contactList.add(newContact)
            binding.txtName.setText("")
            binding.txtPhone.setText("")
        }
        binding.btnNext.setOnClickListener {
            if (contactList.size > 0 && index < contactList.size -1){
                index += 1
                showRecord(contactList.get(index))
            }
        }
        binding.btnPrev.setOnClickListener {
            if (contactList.size > 0 && index > 0){
                index -= 1
                showRecord(contactList.get(index))
            }
        }
    }
    private fun showRecord(contact: Contact){
        //binding.myContact = contact
        //binding.invalidateAll()
        binding.apply {
            myContact = contact
            invalidateAll()
        }
    }
}