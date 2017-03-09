/***
 * By Feilong
 *
 */

package cn.edu.cqu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /**
     * Our calculator has two values, valueOne and valueTwo.
     * These values hold the numbers to be operated on.
     * Both values are of type double, so they can hold numbers
     * with and without decimals. We set valueOne to the special
     * Double value NaN (not a number)
     */
    private double valueOne = Double.NaN;
    private double valueTwo;

    /**
     * This simple calculator can only perform operations of either addition,
     * subtraction, multiplication or division. So we define four static chars
     * to represent these operations, and a CURRENT_ACTION variable,
     * which holds the next operation we intend to perform.
     */
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    /**
     * Use the DecimalFormat class to format the output of our calculator
     */
    private DecimalFormat decimalFormat;

    /**
     * The views we need to use
     */
    Button buttonZero, buttonOne, buttonTwo, buttonThree,
            buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine,
            buttonEqual, buttonDivide, buttonMultiply,
            buttonSubtract, buttonAdd, buttonClear;

    EditText editText;
    TextView infoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        editText = (EditText) findViewById(R.id.editText);

        infoTextView = (TextView) findViewById(R.id.infoTextView);


    }


    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            } catch (Exception e) {
            }
        }
    }

    public void one(View view) {
        //Todo: your code here
    }

    public void two(View view) {
        //Todo: your code here
    }

    public void three(View view) {
        //Todo: your code here
    }

    public void four(View view) {
        //Todo: your code here
    }

    public void five(View view) {
        //Todo: your code here
    }

    public void six(View view) {
        //Todo: your code here
    }

    public void seven(View view) {
        //Todo: your code here
    }

    public void eight(View view) {
        //Todo: your code here
    }

    public void nine(View view) {
        editText.setText(editText.getText() + "9");
    }


    public void dot(View view) {
        editText.setText(editText.getText() + ".");
    }

    public void zero(View view) {
        editText.setText(editText.getText() + "0");
    }

    public void equal(View view) {
        computeCalculation();
        infoTextView.setText(infoTextView.getText().toString() +
                decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
        valueOne = Double.NaN;
        CURRENT_ACTION = '0';
    }

    public void divide(View view) {
        //Todo: your code here

    }

    public void multiply(View view) {
        //Todo: your code here
    }

    public void subtract(View view) {
        computeCalculation();
        CURRENT_ACTION = SUBTRACTION;
        infoTextView.setText(decimalFormat.format(valueOne) + "-");
        editText.setText(null);
    }

    public void add(View view) {
        //Todo: your code here
    }

    public void clear(View view) {

        if (editText.getText().length() > 0) {
            CharSequence currentText = editText.getText();
            editText.setText(currentText.subSequence(0, currentText.length() - 1));
        } else {
            valueOne = Double.NaN;
            valueTwo = Double.NaN;
            editText.setText("");
            infoTextView.setText("");
        }
    }


}
