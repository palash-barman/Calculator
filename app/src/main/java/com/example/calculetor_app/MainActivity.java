package com.example.calculetor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private TextView screen;
        private Button  AC,Power,Back,Div,Mul,Plus,Min,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Point,Ans,Equeal;
        private String input,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=findViewById(R.id.screen_id);
        AC=findViewById(R.id.acBtn_id);
        Power=findViewById(R.id.paworBtn_id);
        Back=findViewById(R.id.backBtn_id);
        Div=findViewById(R.id.divBtn_id);
        Mul=findViewById(R.id.mulBtn_id);
        Plus=findViewById(R.id.plusBtn_id);
        Min=findViewById(R.id.minBtn_id);
        One=findViewById(R.id.oneBtn_id);
        Two=findViewById(R.id.twoBtn_id);
        Three=findViewById(R.id.threeBtn_id);
        Four=findViewById(R.id.fourBtn_id);
        Five=findViewById(R.id.fiveBtn_id);
        Six=findViewById(R.id.sixBtn_id);
        Seven=findViewById(R.id.sevenBtn_id);
        Eight=findViewById(R.id.eightBtn_id);
        Nine=findViewById(R.id.nineBtn_id);
        Zero=findViewById(R.id.zeroBtn_id);
        Point=findViewById(R.id.pointBtn_id);
        Ans=findViewById(R.id.ansBtn_id);
        Equeal=findViewById(R.id.equalBtn_id);

    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){

            case"AC":
                input="";
                break;
            case "Ans":
                Solve();
                Answer=input;
                break;

            case "*":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            case "←":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")){
                    Solve();
                }
                input+=data;

        }
        screen.setText(input);

    }
    private void Solve(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input=mul+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double pow=Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input=pow+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input=sum+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        else if (input.split("-").length>1){
            String number[]=input.split("-");
            if (number[0]==""&& number.length==2){
                number[0]=0+"";
            }
            try {
                double sub=0;
                if (number.length==2){
                    sub=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                }
                else if (number.length==2){
                    sub= -Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                }
                input=sub+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }
        String n[]=input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input=n[0];
            }
        }
        screen.setText(input);
    }
}