package com.kevin.mellow.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.kevin.mellow.R;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/8.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CommonLoadingDialog extends BaseDialog {
    private boolean isCancelable;

    public static CommonLoadingDialog newInstance(String title) {
        return newInstance(title, true);
    }

    public static CommonLoadingDialog newInstance(String title, boolean isCancelable) {
        CommonLoadingDialog dialog = new CommonLoadingDialog();
        dialog.isCancelable = isCancelable;
        Bundle bundle = new Bundle();
        bundle.putString(DIALOG_TITLE, title);
        dialog.setArguments(bundle);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_loading, container, false);
        //        //添加这两行代码去除系统自带的边框
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        String title = getArguments().getString(DIALOG_TITLE);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        } else {

        }

        return view;
    }
}
