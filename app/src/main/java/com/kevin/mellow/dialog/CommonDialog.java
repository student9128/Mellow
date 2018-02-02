package com.kevin.mellow.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/26.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class CommonDialog extends BaseDialog {
    public static CommonDialog newInstance(String title, String message, DialogContract.DialogBtnClickListener listener) {
        return newInstance(title, message, listener, null, null);
    }

    public static CommonDialog newInstance(String title, String message, DialogContract.DialogBtnClickListener listener,
                                           String negativeBtn, String positiveBtn) {
        CommonDialog dialog = new CommonDialog();
        dialog.btnClickListener = listener;
        Bundle bundle = new Bundle();
        bundle.putString(DIALOG_TITLE, title);
        bundle.putString(DIALOG_MESSAGE, message);
        bundle.putString(DIALOG_NEGATIVE_BUTTON, negativeBtn);
        bundle.putString(DIALOG_POSITIVE_BUTTON, positiveBtn);
        dialog.setArguments(bundle);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String title = bundle.getString(DIALOG_TITLE);
        String message = bundle.getString(DIALOG_MESSAGE);
        String negativeBtn = bundle.getString(DIALOG_NEGATIVE_BUTTON);
        String positiveBtn = bundle.getString(DIALOG_POSITIVE_BUTTON);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton(negativeBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (btnClickListener != null) {
                            btnClickListener.onClickNegativeButton(dialog, null);
                        }
                    }
                })
                .setPositiveButton(positiveBtn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (btnClickListener != null) {
                            btnClickListener.onClickPositiveButton(dialog, null);
                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }
}
