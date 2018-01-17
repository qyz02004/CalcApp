package jp.techacademy.fukushi.kouchi.calcapp;


import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("VALUE1");
        String value2 = intent.getStringExtra("VALUE2");
        String calc = intent.getStringExtra("CALC");

        TextView textView = (TextView) findViewById(R.id.textView);

        BigDecimal big1 = new BigDecimal(value1);
        BigDecimal big2 = new BigDecimal(value2);

        String strResult = "";
        BigDecimal BigResult;

        switch ( calc ) {
            case "＋":
                BigResult = big1.add(big2);
                strResult = BigResult.toString();
                break;

            case "－":
                BigResult = big1.subtract(big2);
                strResult = BigResult.toString();
                break;

            case "×":
                BigResult = big1.multiply(big2);
                strResult = BigResult.toString();
                break;

            case "÷":
                // ゼロ除算を防ぐ
                if ( big2.compareTo(BigDecimal.ZERO) != 0) {
                    BigResult = big1.divide(big2,9, BigDecimal.ROUND_HALF_UP);
                    strResult = BigResult.toString();
                }
                else {
                    strResult = "ゼロで割ることはできません";
                }
                break;

            default:
                strResult = "エラーが発生しました";
                break;

        }
        // 結果表示
        textView.setText(strResult);
    }
}
