package com.kevin.mellow.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import com.kevin.mellow.dialog.DialogContract.DialogBtnClickListener;
import com.kevin.mellow.dialog.DialogContract.DialogDismissListener;
/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/26.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class BaseDialog extends DialogFragment {
    public static final String DIALOG_TITLE = "com.kevin.mellow.DIALOG_TITLE";
    public static final String DIALOG_MESSAGE = "com.kevin.mellow.DIALOG_MESSAGE";
    public static final String DIALOG_NEGATIVE_BUTTON = "com.kevin.mellow.DIALOG_NEGATIVE_BUTTON";
    public static final String DIALOG_POSITIVE_BUTTON = "com.kevin.mellow.DIALOG_POSITIVE_BUTTON";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);//转屏时候，fragment不会重建
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
      //https://issuetracker.google.com/issues/36929400
        Dialog dialog = getDialog();
        if ((dialog != null) && getRetainInstance()) {
            dialog.setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    protected DialogBtnClickListener btnClickListener;
    protected DialogDismissListener dialogDismissListener;

    public void setOnDialogBtnClickListener(DialogBtnClickListener listener) {
        btnClickListener = listener;
    }

    public void setOnDialogDismissListener(DialogDismissListener listener) {
        dialogDismissListener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (dialogDismissListener != null) {
            dialogDismissListener.onDialogDismiss(dialog);
        }
    }
}
