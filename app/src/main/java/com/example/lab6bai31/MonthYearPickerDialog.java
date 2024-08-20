package com.example.lab6bai31;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MonthYearPickerDialog extends DialogFragment {
    private final DatePickerDialog.OnDateSetListener listener;
    private final int year;
    private final int month;

    public MonthYearPickerDialog(DatePickerDialog.OnDateSetListener listener, int year, int month) {
        this.listener = listener;
        this.year = year;
        this.month = month;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final NumberPicker monthPicker = new NumberPicker(getActivity());
        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(month + 1);

        final NumberPicker yearPicker = new NumberPicker(getActivity());
        yearPicker.setMinValue(1900);
        yearPicker.setMaxValue(2100);
        yearPicker.setValue(year);

        // Set up the layout for the dialog
        // ...

        return new Dialog(getActivity());
    }
}
