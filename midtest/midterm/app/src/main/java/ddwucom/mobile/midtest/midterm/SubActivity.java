/*
    과제명: 모바일소프트웨어 중간평가 과제
    분반: 01분반
    학번: 20180981, 성명: 안태연
    제출일: 2020년 5월 26일
 */

package ddwucom.mobile.midtest.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class SubActivity extends MainActivity {

    final static String TAG = "SubActivity";

    Button btn_power;
    Button btn_sroot;
    Button btn_sin;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.g_gen:
                select = R.id.g_gen;
                intent_gen = new Intent(this, MainActivity.class);
                startActivity(intent_gen);
                finish();
                break;
            case R.id.g_eng:
//                intent_eng = new Intent(this, SubActivity.class);
//                intent_eng.putExtra("nums", nums);
//                intent_eng.putExtra("ops", ops);
//                startActivity(intent_eng);
//                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_power = findViewById(R.id.btn_power);
        btn_sroot = findViewById(R.id.btn_sroot);
        btn_sin = findViewById(R.id.btn_sin);

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

        btn_power.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                strNum = "";
                ops[cnt] = R.id.btn_power;
                textView.setText("");
                textView.setHint("power");
                cnt++;
            }
        });
        btn_sroot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                ops[cnt] = R.id.btn_sroot;
                textView.setText("");
                textView.setHint("root");
            }
        });
        btn_sin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nums[cnt] = Integer.parseInt(strNum);
                ops[cnt] = R.id.btn_sin;
                textView.setText("");
                textView.setHint("sin");
            }
        });
    }

    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            nums[cnt] = Integer.parseInt(strNum);

            for(int i = 0; i < ops.length; i++) {

                if(ops[0] == 0 && ops[0] != R.id.btn_sroot && ops[0] != R.id.btn_sin){
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
                        if(i == 0)
                            result = (double)nums[i] / (double)nums[i+1];
                        else
                            result /= nums[i+1];
                        break;
                    case R.id.btn_power:
                        if(i == 0)
                            result = Math.pow(nums[i], nums[i + 1]);
                        else
                            result = Math.pow(result, nums[i+1]);
                        break;
                    case R.id.btn_sroot:
                        if(i == 0)
                            result = Math.sqrt(nums[i]);
                    break;
                    case R.id.btn_sin:
                        result = Math.sin(Math.toRadians(nums[i]));
                        break;
                }

            }

            textView.setText(Double.toString(result));

        }
    };

}