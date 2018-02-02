package com.kevin.mellow.dialog;

import android.content.DialogInterface;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/26.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public interface DialogContract {
    public interface DialogBtnClickListener {
        public void onClickNegativeButton(DialogInterface dialog, Object data);

        public void onClickPositiveButton(DialogInterface dialog, Object data);

        public void onClickConfirmButton(DialogInterface dialog, Object data);

    }

    public interface DialogItemSelectedListener {
        public void onSelectedItem(DialogInterface dialog, Object data, int position);

    }

    public interface DialogDismissListener {
        public void onDialogDismiss(DialogInterface dialog);
    }

    /**
     * Show an alert dialog. the dialog contain a title, content and a 'OK' button.
     *
     * @param titleResId   The title string resource id, e.g:R.string.title
     * @param contentResId The dialog content string resource id.
     */
    public void showAlertDialog(int titleResId, int contentResId);

    public void showAlertDialog(int titleResId, int contentResId,
                                Object... component);

    public void showAlertDialog(String title, String content);

    public void showAlertDialog(String title, String content,
                                DialogBtnClickListener listener);

    public void showAlertDialog(int titleResId, int contentResId,
                                DialogBtnClickListener listener);


    public void showNormalDialog(String title, String content,
                                 int negativeBtn, int positiveBtn, DialogBtnClickListener listener);

    public void showNormalDialog(int titleResId, int contentResId,
                                 DialogBtnClickListener listener);

    public void showNormalDialog(int titleResId, int contentResId, int negativeBtn, int positiveBtn,
                                 DialogBtnClickListener listener);
    /**
     * Dismiss the showing dialog.
     */
    public void dismissDialog();
}
