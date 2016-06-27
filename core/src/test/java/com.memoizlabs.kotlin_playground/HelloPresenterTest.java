package com.memoizlabs.kotlin_playground;

import com.mvcoding.mvp.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.subjects.PublishSubject;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloPresenterTest {
    Presenter<HelloPresenter.View> presenter = new HelloPresenter();
    HelloPresenter.View view = Mockito.mock(HelloPresenter.View.class);
    PublishSubject<Void> hellos = PublishSubject.create();

    @Before
    public void setup() {
        when(view.showHellos()).thenReturn(hellos);
    }

    @Test
    public void saysHello() {
        presenter.attach(view);

        hellos.onNext(null);

        verify(view).sayHello();
    }
}
