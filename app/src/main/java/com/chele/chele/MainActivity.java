package com.chele.chele;

/*
This app will show chemical element
from alphabets that are typed in text Box.

"Nepali"
will show
Neon(Ne  10)
Protactinium(Pa  91)
Lithium(Li  3)

If letter is not found in Chemical Elements list,
then alphabet will be shown as it is.

 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public static String gStr;
    public static String[] ans1 = new String[10000];
    public static TextView tv;
    public EditText mEdit;
    public EditText mEditResult;
    public String gOriStr;
    public static Integer index1;
    public static Integer index2;
    public static String separator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        tv = (TextView)findViewById(R.id.tv);

        mEdit   = (EditText)findViewById(R.id.mEdit);
        mEdit.setText("Nepali");
        mEditResult   = (EditText)findViewById(R.id.mEditResult);

        Button button = (Button) findViewById(R.id.button01);
        button.setOnClickListener(view -> {

            gStr = "";
            separator=",";
            gOriStr=mEdit.getText().toString();
            toUpperCaseALL();
            func();
            myTextView.setText(gStr);
        });


    }

    public void func(){
        tv.setText("Please Wait...");

        String oriStr=mEdit.getText().toString().toUpperCase();
        String tmp="";
        Integer i;
        Integer j;
        Integer len1=0;
        Integer k=0;
        String tmp2="";



        for(i=oriStr.length();i>=1;i--){
            if(oriStr.length()>2){
                len1=3;
            }
            else if(oriStr.length()>1){
                len1=2;
            }else if(oriStr.length()>0){
                len1=1;
            }else if(oriStr.length()==0){
                break;
            }
            for(j=len1;j>=1;j--){
                tmp=oriStr.substring(0,j).toUpperCase();

                index1=Global.eleArrayUpperList.indexOf(tmp);

                if(index1!=-1){
                    if(tmp.length()==2){
                        tmp2=oriStr.substring(1,2).toUpperCase();
                        index2=Global.eleArrayUpperList.indexOf(tmp2);
                        if(index2!=-1){
                            //Log.e("tmp2","<>"+tmp2);
                            //Log.e("tmp2",Global.fneleArray[index2] + "(" + Global.eleArray[index2] + "  " + Global.eleArrayNum[index2] + ")");
                        }

                    }
                    oriStr = oriStr.replaceFirst(tmp,"");
                    ans1[k]=Global.fneleArray[index1] + "(" + Global.eleArray[index1] + "  " + Global.eleArrayNum[index1] + ")";
                    k=k+1;
                    break;
                }
                else{
                    if(tmp.length()==1){

                        oriStr = oriStr.replaceFirst(tmp,"");
                        ans1[k]=tmp.toString();
                        k=k+1;
                        break;
                    }
                }

            }
        }
        tmp="";
        for(i = 0;i<k;i++){
            tmp = tmp + ans1[i] + separator;
        }

        if(tmp.substring(tmp.length())==separator){
            tmp = tmp.substring(0, tmp.length()-1);
        }else{
            tmp = tmp.substring(0, tmp.length()-1);
        }
        mEditResult.setText(gOriStr + "\r\n" + tmp);
        tv.setText("Result:" + gOriStr + "\r\n" + tmp);
    }


    public void toUpperCaseALL(){
        for(int i=0;i<Global.eleArray.length;i++){
            Global.eleArrayUpperList.add(Global.eleArray[i].toUpperCase());
        }
    }

}

