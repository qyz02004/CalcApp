package jp.techacademy.fukushi.kouchi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.editText1);
        // 入力を数字、小数点に制限、先頭だけマイナスを許可
        mEditText1.setInputType( InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL
                | InputType.TYPE_NUMBER_FLAG_SIGNED);

        mEditText2 = (EditText)findViewById(R.id.editText2);
        // 入力を数字、小数点に制限、先頭だけマイナスを許可
        mEditText2.setInputType( InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL
                | InputType.TYPE_NUMBER_FLAG_SIGNED);

        // ボタンにリスナーを設定
        setButton( R.id.plusButton, onClick_Button );
        setButton( R.id.minusButton, onClick_Button );
        setButton( R.id.multiButton, onClick_Button );
        setButton( R.id.divButton, onClick_Button );
    }

    // ボタンにリスナーを設定
    private void setButton( int id, View.OnClickListener onClickListener ){
        Button button = (Button)findViewById(id);
        button.setOnClickListener(onClickListener);
    }

    // ボタンをクリックした時の処理
    private View.OnClickListener onClick_Button = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String str1 = mEditText1.getText().toString();
            String str2 = mEditText2.getText().toString();

            // 入力文字がカラでなければ実行
            if ( !str1.isEmpty() && !str2.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                intent.putExtra("VALUE1", str1);

                intent.putExtra("VALUE2", str2);

                // 押下されたボタンを取得
                Button button = (Button) v;
                // ボタンの表示テキストを設定
                intent.putExtra("CALC", button.getText());

                startActivity(intent);
            }
        }
    };
}
