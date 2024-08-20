package com.example.lab6bai31;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            showDatePickerDialog(year, month, dayOfMonth);
        });
    }

    private void showDatePickerDialog(int year, int month, int dayOfMonth) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, day) -> {
            // Hiển thị ngày đã chọn
            String dateStr = day + "/" + (selectedMonth + 1) + "/" + selectedYear;
            Toast.makeText(MainActivity.this, "Ngày đã chọn: " + dateStr, Toast.LENGTH_SHORT).show();

            // Cập nhật CalendarView với ngày đã chọn
            calendar.set(selectedYear, selectedMonth, day);
            long timeInMillis = calendar.getTimeInMillis();
            calendarView.setDate(timeInMillis, true, true);
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
