package com.kevin.mellow.data.source;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 *     该类中提供相关需要方法，将网络请求，传递参数独立起来<br/>
 *     这样在Presenter类中可以直接调用该方法，而不用再写网络请求传递参数了<br/>
 *     如果有相关界面调用同一方法，可以复用
 * </div>
 */


public class RemoteLoanDataSource implements LoanDataSource {
    private static RemoteLoanDataSource INSTANCE;

    private RemoteLoanDataSource() {

    }

    public static RemoteLoanDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (RemoteLoanDataSource.class) {
                INSTANCE = new RemoteLoanDataSource();
            }
        }
        return INSTANCE;
    }

    @Override
    public void login(String username, String password) {
        //这里面进行联网请求
        //传递相关参数
    }
}
