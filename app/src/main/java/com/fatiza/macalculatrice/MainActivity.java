package com.fatiza.macalculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare attributes
    private int valeur1;
    private int valeur2;
    private String operation;
    private boolean isOp1 = true;

    // Declare views
    private TextView mainView,secView;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,bequal,bplus,bmin,bmul,bdiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        // operandView = findViewById(R.id.operand_view);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bequal = findViewById(R.id.bequal);
        bplus = findViewById(R.id.bplus);
        bmin = findViewById(R.id.bmin);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);
        bc=findViewById(R.id.bc);
        mainView=findViewById(R.id.tvmain);
        secView=findViewById(R.id.tvsec);

        // Method to reset the display to its initial state
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valeur1 = 0;
                valeur2 = 0;
                operation = "";
                afficherMain();
                afficherSec();
            }
        });

    }


    // Method to display the current operand
    private void afficherMain() {
        String currentOperand = isOp1 ? String.valueOf(valeur1) : String.valueOf(valeur2);
        mainView.setText(currentOperand);
    }
    private void afficherSec() {
        String currentOperand = isOp1 ? String.valueOf(valeur1) : String.valueOf(valeur2);
        secView.setText(currentOperand);
    }

    // Method to set the operator based on the button clicked
  /*  public void setOperator(View view) {
        Button operatorBtn = (Button) view;
        operation = operatorBtn.getText().toString();
        isOp1 = false;
    }*/
    public void setOperator(View view) {
        if (view instanceof Button) {
            Button operatorBtn = (Button) view;
            operation = operatorBtn.getText().toString();
            isOp1 = false;
        }
    }

    // Method to add a digit to the current operand
    public void ajouterNbr(View view) {
        Button digitBtn = (Button) view;
        int digit = Integer.parseInt(digitBtn.getText().toString());
        if (isOp1) {
            valeur1 = valeur1 * 10 + digit;
        } else {
            valeur2 = valeur2 * 10 + digit;
        }
        afficherSec();
    }

    // Method to perform the calculation and update the display
    public void calculer(View view) {
        int result = 0;
        switch (operation) {
            case "+":
                result = valeur1 + valeur2;
                break;
            case "-":
                result = valeur1 - valeur2;
                break;
            case "*":
                result = valeur1 * valeur2;
                break;
            case "/":
                result = valeur1 / valeur2;
                break;
        }
        secView.setText(valeur1+" "+operation+" "+valeur2);
        valeur1 = result;
        valeur2 = 0;
        isOp1 = true;
        afficherMain();
    }



}
