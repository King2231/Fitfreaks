package com.example.king.fitfreakss;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SigninActivity extends AppCompatActivity {
    Button btnlogin2,btnsignup2;
    ImageView img_logo2;
    EditText txtmail,txtpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        btnlogin2=(Button)findViewById(R.id.btn_login);
        btnsignup2=(Button)findViewById(R.id.btn_signup);
        img_logo2=(ImageView)findViewById(R.id.img_logo);
        txtmail=(EditText)findViewById(R.id.txtMail);
        txtpwd=(EditText)findViewById(R.id.txtpass);
        btnsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair[] pairs=new Pair[3];
                pairs[0]=new Pair<View,String>(img_logo2,"abc");
                pairs[1]=new Pair<View,String>(btnlogin2,"xyz");
                pairs[2]=new Pair<View,String>(btnsignup2,"pqr");
//                pairs[3]=new Pair<View,String>(txtmail,"txtTrans1");


                Intent intent=new Intent(SigninActivity.this,LoginActivity.class);
                ActivityOptions opts=ActivityOptions.makeSceneTransitionAnimation(SigninActivity.this, pairs);
                startActivity(intent,opts.toBundle());
            }
        });
    }
}

