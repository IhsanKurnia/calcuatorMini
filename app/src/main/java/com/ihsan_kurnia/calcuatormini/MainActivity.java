package com.ihsan_kurnia.calcuatormini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //variabel gloabal
    private TextView screen;
    private Button AC, Power, Back, bagi, kali, tambah, kurang, koma, samadengan, nol, satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan, Ans;
    private String input, jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //full mode
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Inisalisasi
        screen = findViewById(R.id.layar);
        AC = findViewById(R.id.ac);
        /*Inisialisasi pada tombol selanjutnya*/
        Back = findViewById(R.id.back);
        bagi = findViewById(R.id.bagi);
        kali = findViewById(R.id.kali);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        koma = findViewById(R.id.koma);
        samadengan = findViewById(R.id.samadengan);
        nol = findViewById(R.id.nol);
        satu = findViewById(R.id.satu);
        dua = findViewById(R.id.dua);
        tiga = findViewById(R.id.tiga);
        empat = findViewById(R.id.empat);
        lima = findViewById(R.id.lima);
        enam = findViewById(R.id.enam);
        tujuh = findViewById(R.id.tujuh);
        delapan = findViewById(R.id.delapan);
        sembilan = findViewById(R.id.sembilan);
        Ans = findViewById(R.id.ans);
    }

    // untuk onCLickListener untuk button input
    public void ButtonOnclick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = "";
                break;
            case "Ans":
                input += jawaban;
                break;
            case "x":
                Solve();
                input += "*";
                break;
            case "^":
                Solve();
                input += "^";
                break;
            case "=":
                Solve();
                jawaban = input;
                break;
            case "c":
                String newText = input.substring(0, input.length() - 1);
                input = newText;
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                }
                input += data;
        }
        screen.setText(input);

    }


    private void Solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double kali = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = kali + "";
            } catch (Exception e) {
                //Error
            }

        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double bagi = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = bagi + "";
            } catch (Exception e) {
                //Error
            }

        } else if (input.split("\\^").length == 2) {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow + "";
            } catch (Exception e) {
                //Error
            }

        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double tambah = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = tambah + "";
            } catch (Exception e) {
                //Error
            }

        } else if (input.split("-").length > 1) { // untuk substarck yang memiliki dua split char di case yaitu -4-6
            String number[] = input.split("-");
            /*Untuk substract negative seperti -8-5*/
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub = 0;
                if (number.length == 2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if (number.length == 3) {
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                input = sub + "";
            } catch (Exception e) {
                //Error
            }
        }
        //untuk menghapus digit terakhir .0 dari hasil integer seperti: 9 sebagai gantinya 9.0
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        screen.setText(input);
    }

}