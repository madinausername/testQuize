package uz.itschool.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import uz.itschool.myapplication.Model.Test
import uz.itschool.testquize.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var test_list= arrayListOf<Test>()
    var index=0
    lateinit var question:TextView
    lateinit var answer_1:TextView
    lateinit var answer_2:TextView
    lateinit var answer_3:TextView
    lateinit var next_b:Button
    lateinit var radioGroup: RadioGroup
    lateinit var check: Button
    lateinit var linear_layout_question_number:LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question=findViewById(R.id.text_question)
        answer_1=findViewById(R.id.answer_1)
        answer_2=findViewById(R.id.answer_2)
        answer_3=findViewById(R.id.answer_3)
        next_b=findViewById(R.id.next_button)
        radioGroup=findViewById(R.id.radio_group)
        check=findViewById(R.id.button)
        linear_layout_question_number=findViewById(R.id.linear_layout_question_number)


        radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(applicationContext," On checked change :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            })
        check.setOnClickListener{
            var id: Int = radioGroup.checkedRadioButtonId
            if (id!=-1){
                val radio: RadioButton = findViewById(id)
                Toast.makeText(applicationContext,"On button click :" +
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"On button click :" +
                        " nothing selected",
                    Toast.LENGTH_SHORT).show()
            }
        }
        fun radio_button_click(view: View){
        val radio: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }
        test_list.add(Test("Which element is found more in Earth?","Nitrogen","Oxygen","Hydrogen","Oxygen"))
        test_list.add(Test("What is the diameter of Sun?","1,392,684 km","145,263,987 km","2,598,745 km","1,392,684 km"))
        test_list.add(Test("At how much speed Moon moves across the Sun?","4,250 km per hour","250 km per hour","2,250 km per hour","2,250 km per hour"))
        test_list.add(Test("Solve the problem:  1+0=?","1","0","10","1"))
        createNumber(test_list.size)
        createTest(index)

        next_b.setOnClickListener {
            if(index<test_list.size-1){
                index++
            }
            createTest(index)

        }
    }




    fun createTest(n:Int){
        var test=test_list[n]
        question.text=test.question
        answer_1.text=test.answer1
        answer_2.text=test.answer2
        answer_3.text=test.answer3
    }

    fun createNumber(n:Int){
        for(i in 0 until n){
            var button=Button(this)
            button.id=i
            button.text="${i+1}"
            button.tag="$i"
            button.setOnClickListener(this)
            linear_layout_question_number.addView(button)


        }



    }

    override fun onClick(p0: View?) {
        var button=findViewById<Button>(p0!!.id)
        index=button.tag.toString().toInt()
        createTest(index)
    }

   /* fun Check(index_of_massiv:Int, answer_selected:String){
        if(answer_1.getCheckedRadioButtonId()){

        }
    }*/
}

