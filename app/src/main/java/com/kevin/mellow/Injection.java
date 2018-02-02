package com.kevin.mellow;

import com.kevin.mellow.data.LoanRepository;
import com.kevin.mellow.data.source.RemoteLoanDataSource;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 *     该类用于提供网络方法
 * </div>
 */


public class Injection {
    //
    public static LoanRepository provideLoanRepository() {
        return LoanRepository.getInstance(RemoteLoanDataSource.getInstance());
    }
}
