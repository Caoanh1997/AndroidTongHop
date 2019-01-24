package com.example.caoan.androidtonghop;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime extends AppCompatActivity {

    private Button bt1, bt2;
    private TextView tv2, tv4;
    private Calendar calendar;
    private int h,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        tv2 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv4);

        Date date = new Date();
        calendar = Calendar.getInstance();

        //String strDateFormat = "dd/MM/yyyy";
        //String strDateFormat24 = "HH:mm:ss ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm ");
        h = calendar.get(Calendar.HOUR_OF_DAY);
        m = calendar.get(Calendar.MINUTE);

        tv2.setText(simpleDateFormat.format(calendar.getTime()));
        tv4.setText(dateFormat.format(calendar.getTime()));
        //System.out.println("Ngay hom nay la "+simpleDateFormat.format(date));

        //System.out.println("Gio hien tai la "+dateFormat.format(date));
    }

    public void setDate(View view) {
//        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
//                tv2.setText((dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
//                //Lưu vết lại biến ngày hoàn thành
//                //calendar.set(year, monthOfYear, dayOfMonth);
//                //dateFinish=cal.getTime();
//            }
//        };
//        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
//        //sẽ giống với trên TextView khi mở nó lên
//        String s = tv2.getText() + "";
//        String strArrtmp[] = s.split("/");
//        int ngay = Integer.parseInt(strArrtmp[0]);
//        int thang = Integer.parseInt(strArrtmp[1]) - 1;
//        int nam = Integer.parseInt(strArrtmp[2]);
//        DatePickerDialog pic = new DatePickerDialog(DateTime.this, callback, nam, thang, ngay);
//        pic.setTitle("Chọn ngày hoàn thành");
//        pic.show();
        String s = tv2.getText()+"";
        String strArrtmp[] = s.split("/");
        int day = Integer.parseInt(strArrtmp[0]);
        int month = Integer.parseInt(strArrtmp[1])-1;
        int year = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog datePickerDialog = new DatePickerDialog(DateTime.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                tv2.setText(d+"/"+(m+1)+"/"+y);
            }
        },year,month,day);
        datePickerDialog.setTitle("Chon ngay");
        datePickerDialog.show();

    }

    public void setTime(View view) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(DateTime.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                tv4.setText(hour+":"+minute);
            }
        },h,m,true);
        timePickerDialog.setTitle("Chon gio");
        timePickerDialog.show();

//        Calendar calendar = Calendar.getInstance();
//        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                Log.e(TAG, "onTimeSet: " + hour + ", " + minute);
//            }
//        }, hour, minute, true);
//
//        timePickerDialog.show();
    }
}
