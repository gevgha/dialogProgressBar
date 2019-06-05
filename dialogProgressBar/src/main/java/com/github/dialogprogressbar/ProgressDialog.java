package com.github.dialogprogressbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

public class ProgressDialog {

    private static AlertDialog progressDialog;

    public static void show(Context context) {
        try {
            progressDialog.dismiss();
        } catch (Exception e) {
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        progressDialog = builder.create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.progress_view, null);
        progressDialog.setView(inflate);
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void showWithTimer(Context context, int seconds) {
        show(context);
        new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                dismiss();
            }
        }.start();
    }

    public static void dismiss() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
