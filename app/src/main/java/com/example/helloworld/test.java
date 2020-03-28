package com.example.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class test extends AppCompatActivity {
    Button bt1,bt2,bt3;
    String answer;
    TextView t1_question,timer;
    int total=1;
    int wrong=0;
    int correct=0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*   mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Question question=dataSnapshot.getValue(Question.class);
                t1_question.setText(question.getQuestion());
                bt1.setText(question.getOpt_1());
                bt2.setText(question.getOpt_2());
                bt3.setText(question.getOpt_3());
                answer= question.getAnswer();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                // ...
            }
        };*/

       // reference= FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        bt1=(Button)findViewById(R.id.Bt1);
        bt2=(Button)findViewById(R.id.Bt2);
        bt3=(Button)findViewById(R.id.Bt3);
        t1_question=(TextView)findViewById(R.id.questiontext);
        timer=(TextView)findViewById(R.id.timer);
        updateQuestion();

    }

    private void updateQuestion() {
      //  total++;
        if (total>2)
        {
            //open the result activity
            Intent i = new Intent(test.this,Result.class);
            startActivity(i);


        }
        else
        {
            reference= FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     final Question question=dataSnapshot.getValue(Question.class);

                        t1_question.setText(question.getQuestion());

                        bt1.setText(question.getOption1());


                        bt2.setText(question.getOption1());

                        bt3.setText(question.getOption3());


                    bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if (bt1.getText().toString().equals(question.getAnswer()))
                                {
                                    bt1.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            bt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();

                                        }
                                    },1500);



                                }
                                else
                                    {
                                        //answer is wrong ....and find the correct answer and make it GREEN


                                        wrong++;
                                        bt1.setBackgroundColor(Color.RED);
                                        if (bt2.getText().toString().equals(question.getAnswer()))
                                        {
                                            bt2.setBackgroundColor(Color.RED);
                                        }
                                        else if (bt3.getText().toString().equals(question.getAnswer()))
                                        {
                                            bt3.setBackgroundColor(Color.RED);
                                        }

                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                correct++;
                                                bt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                bt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                bt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                updateQuestion();
                                            }
                                        },1500);


                                    }


                        }
                    });

                    bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if (bt2.getText().toString().equals(question.getAnswer()))
                                {
                                    bt2.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            bt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();

                                        }
                                    },1500);



                                }
                                else
                                {
                                    //answer is wrong ....and find the correct answer and make it GREEN


                                    wrong++;
                                    bt2.setBackgroundColor(Color.RED);
                                    if (bt2.getText().toString().equals(question.getAnswer()))
                                    {
                                        bt2.setBackgroundColor(Color.RED);
                                    }
                                    else if (bt3.getText().toString().equals(question.getAnswer()))
                                    {
                                        bt3.setBackgroundColor(Color.RED);
                                    }

                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            bt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            bt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            bt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);


                                }


                        }
                    });

                    bt3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if (bt3.getText().toString().equals(question.getAnswer()))
                                {
                                    bt3.setBackgroundColor(Color.GREEN);
                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            bt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();

                                        }
                                    },1500);



                                }
                                else
                                {
                                    //answer is wrong ....and find the correct answer and make it GREEN


                                    wrong++;
                                    bt3.setBackgroundColor(Color.RED);
                                    if (bt3.getText().toString().equals(question.getAnswer()))
                                    {
                                        bt3.setBackgroundColor(Color.RED);
                                    }
                                    else if (bt3.getText().toString().equals(question.getAnswer()))
                                    {
                                        bt3.setBackgroundColor(Color.RED);
                                    }

                                    Handler handler=new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            bt1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            bt2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            bt3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);


                                }

                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }


    }




  //  public void onFinith()
    {




    }
}
