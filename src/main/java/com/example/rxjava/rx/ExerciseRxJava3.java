package com.example.rxjava.rx;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ExerciseRxJava3 {



  public static void main(String[] args) {
    doSomeWork();
  }

  private static void doSomeWork() {
    Flowable<Integer> observable = Flowable.just(1,2,3,4);
    observable.reduce(50,(t1,t2) -> t1 + t2).subscribe(getObserver());
  }

  private static  SingleObserver<Integer> getObserver() {
    return new SingleObserver<Integer>(){

      @Override
      public void onSubscribe(Disposable disposable) {
      System.out.println("onSubscribe");
      }

      @Override
      public void onSuccess(Integer integer) {
        System.out.println("onSuccess : value : " +integer);
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println("onSuccess : value : " +throwable.getMessage());
      }
    };

  }
}
