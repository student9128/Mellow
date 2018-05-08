package com.kevin.mellow.dialog;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/8.
 * <h3>
 * Describe:
 * <h3/>
 */
public class DialogManager {
    public static BaseDialog createProgressDialog(String title) {
        return CommonLoadingDialog.newInstance(title);
    }
}
