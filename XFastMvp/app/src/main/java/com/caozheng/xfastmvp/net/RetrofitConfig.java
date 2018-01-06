package com.caozheng.xfastmvp.net;

import com.caozheng.xfastmvp.log.FLog;
import com.caozheng.xfastmvp.net.converter.GsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * @author caozheng
 * @date 2018/1/6
 * <p>
 * describe:
 */

public class RetrofitConfig {

    public Retrofit init(){
        //这个是处理网络请求的log信息的,可以实现Interceptor接口来自定义.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                FLog.d("RxJava", message);
            }
        });

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
