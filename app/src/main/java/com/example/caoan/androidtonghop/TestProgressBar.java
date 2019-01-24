package com.example.caoan.androidtonghop;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TestProgressBar extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private ProgressBar progressBar;
    private Button bt1,bt2;
    private TextView tv;
    int i1,i2 =0;
    static int number = 100;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_bar);
        bt1 = findViewById(R.id.btstartprocess);
        bt2 = findViewById(R.id.btstartcustomprocess);
        progressBar = findViewById(R.id.progress);
        tv = findViewById(R.id.tv);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(TestProgressBar.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                progressDialog.show();
                Runnable runnable = new Mythread();
                new Thread(runnable).start();
            }
        });
        synchronized (progressBar){
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setMax(100);
                    progressBar.setProgress(0);
                    progressBar.setIndeterminate(false);

                    new ProgressAsyncTask().execute();
//                Thread thread = new Thread(){
//                    @Override
//                    public void run() {
//                        while (i1<100){
//                            try {
//                                i1++;
//                                progressBar.setProgress(i1);
//                                Thread.sleep(100);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        //progressBar.setVisibility(View.INVISIBLE);
//                    }
//                };
//                thread.start();
                    //Runnable runnable = new Mythread1();
                    //new Thread(runnable).start();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            while (i1<100){
//                                try {
//                                    i1++;
//                                    progressBar.setProgress(i1);
//                                    Thread.sleep(100);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                setText(tv,i1+"%");
//                            }
//                        }
//                    }).start();
                }
            });
        }
    }
    class Mythread implements Runnable{
        @Override
        public void run() {
            while (i2<100){
                try {
                    i2++;
                    progressDialog.setProgress(i2);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            progressDialog.dismiss();
        }
    }
    class Mythread1 implements Runnable{
        @Override
        public void run() {
            while (i1<100){
                try {
                    i1++;
                    progressBar.setProgress(i1);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setText(tv,i1+"%");
            }
//
//            int delay = 1000;
//            int period = 1000;
//            timer = new Timer();
//            timer.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//                    setText(tv, String.valueOf(setInterval()));
//                    progressBar.setProgress(100-setInterval());
//                }
//            },delay,period);
//
         }
    }
//    private static final int setInterval(){
//        if(number == 0){
//            return number;
//        }else {
//            return number --;
//        }
//    }
    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private class ProgressAsyncTask extends AsyncTask<Void, Integer, String>{

        //AsyncTask<> và Handle là các đối tượng dùng để giao tiếp giữa worker thread(luồng xử lý công việc)
        // và UI thread( cũng có thể là main thread(luồng xử lý giao diện))
        //Nó cho phép bạn thực hiện công việc ở background và sau đó cập nhật giao diện ở UI Thread.
        // AsyncTask chính là sự tổ hợp của một Thread và một Handler
        // Dùng AsyncTask tối ưu hơn Handle vì nó ít code hơn
        @Override
        protected String doInBackground(Void... voids) {
            for( int i =0;i<=100;i++){
                publishProgress(i);//gởi lại i cho main thread (UI thread)
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Loading completed";// gởi "Loading completed" khi đã hoàn thành
        }

        @Override
        protected void onProgressUpdate(final Integer... values) {
            //super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);// update UI (progressbar) trong main thread
            // , tham số values chính là tham số trong hàm publicProgress, có thể đưa vào nhiều giá trị
            setText(tv, String.valueOf(values[0])+"%");//tương tự, cái này dùng đc
//            tv.post(new Runnable() {
//                @Override
//                public void run() {
//                    tv.setText(values[0]);
//                }
//            });

        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            //Trả về kết quả cuối cùng cho main thread, tham số s chính là kết quả trả về của hàm doInBackground()
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            bt2.setEnabled(false);
        }
    }
    public void count(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=100;i++){
                    Message message = new Message();
                    message.what = 1;
                    message.arg1 = i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    public void listenHandler(){
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        progressBar.setProgress(msg.arg1);
                        setText(tv,msg.arg1+"%");
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Loading completed",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
    }

}
