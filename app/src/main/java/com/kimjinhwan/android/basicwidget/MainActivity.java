package com.kimjinhwan.android.basicwidget;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    //1. 위젯 변수를 선언
    Button btnDog, btnPig, btnHorse;
    ToggleButton toggleButton;
    RadioGroup radioGroup; //라디오 버튼으로 다중선택을 하게 하는 행위는 표준 UI에 어긋남. (다중선택은 체크박스로 할 것.)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //2. 위젯변수를 화면과 연결
        btnDog = (Button) findViewById(R.id.btnDog);
        btnPig = (Button) findViewById(R.id.btnPig);
        btnHorse = (Button) findViewById(R.id.btnHorse);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        //3. 클릭리스너 연결
        btnDog.setOnClickListener(this);  //setOnClickListener에게 this(뭔가)를 넘겼다. 여기서 this는 MainActivity 클래스.
        btnPig.setOnClickListener(this);    // 리스너에 this(뭔가)를 넘겨주면 해당 이벤트가 발생시 this(뭔가)를 호출해준다.
        btnHorse.setOnClickListener(this);

        toggleButton.setOnCheckedChangeListener(this);

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {  //시스템의 이벤트 리스너를 통해 호출해준다.
       switch(v.getId()){
           case R.id.btnDog:
               Toast.makeText(this, "멍멍~", Toast.LENGTH_SHORT).show(); // Toast : 휴대폰 화면에 띄워줌. Toast.LENGTH_를 통해 보여지는 시간 조절 가능.
               break;
           case R.id.btnPig:
               Toast.makeText(this, "꿀꿀~", Toast.LENGTH_SHORT).show();
               break;
           case R.id.btnHorse:
               Toast.makeText(this, "히힝~", Toast.LENGTH_SHORT).show();
               break;

       }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {    //ToggleButton은 CompoundButton을 상속받는다.
        switch(buttonView.getId()){
            case R.id.toggleButton:
                if(isChecked){
                    Toast.makeText(this, "스위치가 켜졌습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "스위치가 꺼졌습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(group.getId() == R.id.radioGroup){
                switch (checkedId){
                    case R.id.radioRed:
                        Toast.makeText(this, "빨간불~~", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioGreen:
                        Toast.makeText(this, "초록불~~", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBlue:
                        Toast.makeText(this, "파란불~~", Toast.LENGTH_SHORT).show();
                        break;
                }
        }
    }
}
