package com.example.rxjava.rx;

import io.reactivex.Observable;

public class ExerciseRxJava4 {

  /**
   * Metodo princilapa. Agrupar las palabras en grupos con el mismo numero de caracteres
   */
  public static void main(String[] args) {
    String[] words = {"One", "Open", "close", "new", "next", "start", "end", "bye", "brain",
        "mouse"};

    Observable.fromArray(words).groupBy(x -> {
      if (x != null && x.length() >= 4)
        return 1;
       else
        return 0;
    }).subscribe(y -> {
      System.out.println("Mi grupo es :" + y.getKey());
      y.toList().subscribe(l -> {
        System.out.println("Grupo : " + y.getKey() + " Elemento : " + l);
      });
    });


  }
}
