package com.kevin.mellow.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.mellow.R;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/17.
 * <h3>
 * Describe:
 * <h3/>
 */
public class FingerprintDialog extends BaseDialog {


    public static FingerprintDialog newInstance() {
        FingerprintDialog dialog = new FingerprintDialog();
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_fingerprint, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.onAuthCancel();
                }
                if (isAdded()) {
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }

    private OnAuthCancelListener listener;

    public interface OnAuthCancelListener {
        void onAuthCancel();
    }

    public void setOnAuthCancelListener(OnAuthCancelListener l) {
        listener = l;
    }
}
