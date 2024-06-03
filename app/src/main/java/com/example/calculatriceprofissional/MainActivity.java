package com.example.calculatriceprofissional;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false); // clavi ywli mayjikch


    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart(); // ta3tik position ta3 cursor
        String leftStr = oldStr.substring(0,cursorPos); // exp: ...subtring(0,3) fi "haithem" ta3tik "hai"
        String rightStr = oldStr.substring(cursorPos); //exp: ...substring(3) fi "haithem" ta3tik "them"
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr)); // hadi tari9a bach taficher plusiur string
        display.setSelection(cursorPos + 1); // traj3 cursor ypwanti ll droit dima
    }

    public void zeroBTN(View view){
        updateText("0");

    }
    public void oneBTN(View view){
        updateText("1");

    }
    public void twoBTN(View view){
        updateText("2");

    }
    public void threeBTN(View view){
        updateText("3");

    }
    public void fourBTN(View view){
        updateText("4");

    }
    public void fiveBTN(View view){
        updateText("5");

    }
    public void sixBTN(View view){
        updateText("6");

    }
    public void sevenBTN(View view){
        updateText("7");

    }
    public void eightBTN(View view){
        updateText("8");

    }
    public void nineBTN(View view){
        updateText("9");

    }
    public void multiBTN(View view){
        updateText("×");

    }
    public void dividBTN(View view){
        updateText("÷");

    }
    public void mainisBTN(View view){
        updateText("-");

    }
    public void negativBTN(View view){
        updateText("-");

    }
    public void addBTN(View view){
        updateText("+");

    }
    public void pointBTN(View view){
        updateText(".");

    }
    public void equalsBTN(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate()); // casting mn double ll string

        display.setText(result);
        display.setSelection(result.length());

    }
    public void powerBTN(View view){
        updateText("^");

    }
    public void parentsBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i< cursorPos; i++) {
            if (display.getText().toString().substring(i, i+1).equals("(")) {
                openPar = openPar + 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")) {
                closedPar = closedPar + 1;
            }
        }
        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText("(");
        }
        else if (openPar > closedPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText(")");
        }
        display.setSelection(cursorPos + 1);

    }
    public void cBTN(View view){
        display.setText("");

    }
    public void deleteBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText(); //hna rak creet strign 9abla lltamadod
            selection.replace(cursorPos - 1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

}