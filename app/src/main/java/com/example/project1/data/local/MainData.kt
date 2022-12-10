package com.example.project1.data.local

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project1.databinding.MainDataBinding
import com.example.project1.domain.LogIn
import kotlinx.coroutines.*

class MainData(): AppCompatActivity() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.main_data, container, false)
//    }
    private lateinit var appDb : AppDatabase
    private lateinit var binding : MainDataBinding




    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDb = AppDatabase.getDatabase(this)
        binding.btnWriteData.setOnClickListener {
            writeData()
        }

        binding.btnReadData.setOnClickListener {
            readData()
        }

        binding.btnDeleteAll.setOnClickListener {

            GlobalScope.launch {

                appDb.loginDao().deleteAll()

            }

        }

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun writeData(){

        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val rollNo = binding.etRollNo.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()     ) {
            val user = LogIn(
                null, firstName, lastName, rollNo.toInt()
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.loginDao().insert(user)
            }

            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etRollNo.text.clear()

            Toast.makeText(this@MainData,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@MainData,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun readData(){

        val rollNo = binding.etRollNoRead.text.toString()

        if (rollNo.isNotEmpty()){

            lateinit var user : LogIn

            GlobalScope.launch {

                user = appDb.loginDao().findByRoll(rollNo.toInt())
                Log.d("Robin Data",user.toString())
                displayData(user)

            }

        }else Toast.makeText(this@MainData,"Please enter the data", Toast.LENGTH_SHORT).show()

    }

    private suspend fun displayData(user: LogIn){

        withContext(Dispatchers.Main){

            binding.tvFirstName.text = user.firstName
            binding.tvLastName.text = user.lastName
            binding.tvRollNo.text = user.password.toString()

        }

    }


  }