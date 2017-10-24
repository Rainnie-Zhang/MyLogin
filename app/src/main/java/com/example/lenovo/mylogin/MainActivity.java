package com.example.lenovo.mylogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        et_username=(EditText)findViewById(R.id.et_username);
        et_password=(EditText)findViewById(R.id.et_passward);
        check=(CheckBox)findViewById(R.id.check);
        Map<String,String> maps=UserInfoUtils.readInfo();
        if(maps!=null){
            String name=maps.get("name");
            String pwd=maps.get("pwd");

            et_username.setText(name);
            et_password.setText(pwd);
        }
    }
    public void login(View v){
        String name=et_username.getText().toString().trim();
        String pwd=et_password.getText().toString().trim();
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
            Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        }else {
            System.out.println("连接服务器  进行登录 等我们讲到 第四天 网络 编程 在说");
            if(check.isChecked()){
                boolean result = UserInfoUtils.saveInfo(name, pwd);
                if (result) {
                    Toast.makeText(MainActivity.this, "保存成功",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(MainActivity.this, "请勾选cb", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
