/*
    과제명: 모바일소프트웨어 중간평가 과제
    분반: 01분반
    학번: 20180981, 성명: 안태연
    제출일: 2020년 5월 26일
 */
package ddwucom.mobile.midtest.midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    String strNum = "";
    int[] nums = new int[10];
    int[] ops = new int[9];
    int cnt = 0;
    double result;

    TextView textView;

    Button btn_add;
    Button btn_sub;
    Button btn_mul;
    Button btn_div;
    Button btn_clear;
    Button btn_equal;

    Intent intent_gen;
    Intent intent_eng;

    static int select = R.id.g_gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_clear = findViewById(R.id.btn_clear);
        btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(myClickListener);
        textView = findViewById(R.id.editText);

        btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                strNum = "";
                ops[cnt] = R.id.btn_add;
                textView.setText("");
                textView.setHint("+");
                cnt++;
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                strNum = "";
                ops[cnt] = R.id.btn_sub;
                textView.setText("");
                textView.setHint("-");
                cnt++;
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                strNum = "";
                ops[cnt] = R.id.btn_mul;
                textView.setText("");
                textView.setHint("*");
                cnt++;
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                strNum = "";
                ops[cnt] = R.id.btn_div;
                textView.setText("");
                textView.setHint("/");
                cnt++;
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums = new int [10];
                ops = new int [9];
                strNum = "";
                cnt = 0;
                textView.setText("");
                textView.setHint("");
            }
        });
    }


    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            nums[cnt] = Integer.parseInt(strNum);

            for(int i = 0; i < ops.length; i++) {

                if(ops[0] == 0){
                    Toast.makeText(getApplicationContext(), "연산 순서 오류입니다.", Toast.LENGTH_SHORT).show();
                    nums = new int [10];
                    ops = new int [9];
                    strNum = "";
                    cnt = 0;
                    textView.setText("");
                    textView.setHint("");
                    return;
                }

                switch (ops[i]) {
                    case R.id.btn_add:
                        if(i == 0)
                            result = nums[i] + nums[i+1];
                        else
                            result += nums[i+1];
                        break;
                    case R.id.btn_sub:
                        if(i == 0)
                            result = nums[i] - nums[i+1];
                        else
                            result -= nums[i+1];
                        break;
                    case R.id.btn_mul:
                        if(i == 0)
                            result = nums[i] * nums[i+1];
                        else
                            result *= nums[i+1];
                        break;
                    case R.id.btn_div:
                        if(nums[i+1] == 0) {
                            Toast.makeText(getApplicationContext(), "연산 오류입니다.\n0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                            nums = new int [10];
                            ops = new int [9];
                            strNum = "";
                            cnt = 0;
                            textView.setText("");
                            textView.setHint("");
                            return;
                        }
                        if(i == 0){
                            result = (double)nums[i] / (double)nums[i+1];
                        }
                        else
                            result /= nums[i+1];
                        break;
                }
            }

            textView.setText(Double.toString(result));

        }
    };

    public void onClick_num(View v){
        switch(v.getId()){
            case R.id.btn0: strNum += "0";  break;
            case R.id.btn1: strNum += "1"; break;
            case R.id.btn2: strNum += "2";  break;
            case R.id.btn3: strNum += "3";  break;
            case R.id.btn4: strNum += "4";  break;
            case R.id.btn5: strNum += "5";  break;
            case R.id.btn6: strNum += "6";  break;
            case R.id.btn7: strNum += "7";  break;
            case R.id.btn8: strNum += "8";  break;
            case R.id.btn9: strNum += "9";  break;
        }
        textView.setText(strNum);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(select).setChecked(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.g_gen:
                select = R.id.g_gen;
//                intent_gen = new Intent(this, MainActivity.class);
//                startActivity(intent_gen);
                break;
            case R.id.g_eng:
                select = R.id.g_eng;
                intent_eng = new Intent(this, SubActivity.class);
                startActivity(intent_eng);
                finish();
                break;
        }
        return true;
    }

}
