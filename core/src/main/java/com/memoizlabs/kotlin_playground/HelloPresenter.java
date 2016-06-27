package com.memoizlabs.kotlin_playground;

import com.mvcoding.mvp.Presenter;

import rx.Observable;
import rx.functions.Action1;

public class HelloPresenter extends Presenter<HelloPresenter.View> {

        @Override
        protected void onViewAttached(final View view) {
                unsubscribeOnDetach(view.showHellos().subscribe(new Action1<Void>() {
                        @Override
                        public void call(Void aVoid) {
                                view.sayHello();
                        }
                }));
        }

        public interface View extends Presenter.View {
                Observable<Void> showHellos();
                void sayHello();
        }
}
