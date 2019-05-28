package com.example.rxjava.rx;

import io.reactivex.Observable;


public class ExerciseRxJava2 {

  public static void main(String[] args) {
    // ejemplo1();
    // ejemplo2();
    loadNumbers().map(x ->"[" + String.valueOf(x)+"] ").subscribe(System.out::print);

  }

  /**
   * Ejercicio 1. Utilizando from y map, convertir los numeros de String con el formato , ej : [1]
   */
  private static void ejemplo1() {

    Integer[] numbers = {5, 8, 65, 8, 2, 1, 7, 9, 6, 4};
    Observable.fromArray(numbers)
        .filter(number -> ((number % 2) == 0))
        // .count()
        //.take(2)
        .distinct()
        .map(number -> "[" + number + "]")
        .subscribe(System.out::print);

  }

  /**
   * Ejercicio 2. Utilizando from,flatMap y map, convertir los numeros de String con el formato , ej
   * : [1]
   */
  private static void ejemplo2() {

    Integer[][] matrix = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0},
        {10, -8, 17, -6, -5, 34, -3, -2, 21, 0}};

    Observable.fromArray(matrix).flatMap(line -> Observable.fromArray(line))
        .map(elemnt -> "["+String.valueOf(elemnt)+"] ")
        .subscribe(System.out::print);

  }

  /**
   * Ejercicio 3. Utilizando Observable.create terminar la funcion loadNumber para emita los numeros
   * del 1 al , luego subimos al observable que devolvera loadNumbers e imprimir  los numeros. E
   * imprimir un mensaje de fin despues de imprimir todos los numeros
   */

  private static Observable<Integer> loadNumbers() {

    return Observable.create(x -> {
      for (int i = 1; i <= 10; i++) {
        x.onNext(i);
      }
      x.onComplete();
    });
  }


}
