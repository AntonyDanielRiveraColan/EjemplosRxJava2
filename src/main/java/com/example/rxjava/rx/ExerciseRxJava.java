package com.example.rxjava.rx;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class ExerciseRxJava {

  /** Metodo principal llama a los otros metodos.*/
  public static void main(String[] args) {
    myObserverSingle();
    myObserverCompletable();
    myObserverMaybe();
  }

  private static Single<Integer> myObserverSingle() {
    Single<Integer> myObservable = Single.create(x -> {
      for (Integer i = 0; i < 20; i++) {
        x.onSuccess(10);
      }
    });
    return myObservable;
  }

  private static Completable myObserverCompletable() {
    Completable myObserverCompletable = Completable.create(x -> {
      for (Integer i = 0; i < 20; i++) {
        x.onComplete();
      }
    });
    return myObserverCompletable;
  }

  private static Maybe<Integer> myObserverMaybe() {
    Maybe myObserverMaybe = Maybe.create(x -> {
      for (Integer i = 0; i < 20; i++) {
        x.onSuccess(i);
      }
    });
    return myObserverMaybe;
  }

}
