package com.memoizlabs.kotlin_playground;

import com.memoizrlabs.ShankModule;
import com.memoizrlabs.functions.Func0;

import static com.memoizrlabs.Shank.registerFactory;

public class HelloModule implements ShankModule {

    @Override
    public void registerFactories() {
        registerFactory(HelloPresenter.class, new Func0<HelloPresenter>() {
            @Override
            public HelloPresenter call() {
                return new HelloPresenter();
            }
        });
    }
}
