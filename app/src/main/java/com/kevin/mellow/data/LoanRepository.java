package com.kevin.mellow.data;

import com.kevin.mellow.data.source.RemoteLoanDataSource;
import com.kevin.mellow.data.source.LoanDataSource;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class LoanRepository implements LoanDataSource {
  private static LoanRepository INSTANCE;
    private RemoteLoanDataSource remoteLoanDataSource;

    public LoanRepository(RemoteLoanDataSource remoteLoanDataSource) {
        this.remoteLoanDataSource = remoteLoanDataSource;
    }

    public static LoanRepository getInstance(RemoteLoanDataSource remoteLoanDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new LoanRepository(remoteLoanDataSource);
        }
        return INSTANCE;
    }
    @Override
    public void login(String username, String password) {

    }
}
