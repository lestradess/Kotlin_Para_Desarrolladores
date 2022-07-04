package com.lestrades.kotlin_para_desarrolladores

import android.view.ViewGroup
import kotlinx.coroutines.Dispatchers
import kotlin.random.Random
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun test() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    //Otra forma de hacerlo
    val suma = { x: Int, y: Int -> x + y }
    //operaciones con la función operación
    val res = operacion(5, 8) { x, y ->
        x - y
    }//Salida ==> -3

}

//Esta función deja hacer cualquier operación con dos enteros
fun operacion(x: Int, y: Int, op: (Int, Int) -> Int) = op(x, y)

//Usar una función como una lambda
fun sum(x: Int, y: Int): Int = x + y
val res = operacion(5, 8, ::sum) //Salida ==> 13



fun <T> T.apply(body: T.() -> Unit): T {
    this.body()
    return this
}

fun <T, U> T.run(body: T.() -> U): U {
    return this.body()
}

fun <T, U> T.let(body: (T) -> U): U {
    return body(this)
}

fun <T, U> witch(receiver: T, body: T.() -> U): U {
    return receiver.body()
}
fun <T> T.also(body: (T)-> Unit): T{
    body(this)
    return this
}

data class Fotos (val title: String, val url:String, val type :Type){
    enum class Type {PHOTO,VIDEO}
}
//Forma larga
fun incluirFoto():List<Fotos> = listOf(
    Fotos("Title 1", "https://placekitten.com/200/200?image=1", Fotos.Type.PHOTO),
    Fotos("Title 2", "https://placekitten.com/200/200?image=2", Fotos.Type.VIDEO),
    Fotos("Title 3", "https://placekitten.com/200/200?image=3", Fotos.Type.PHOTO),
    Fotos("Title 4", "https://placekitten.com/200/200?image=4", Fotos.Type.PHOTO),
    Fotos("Title 5", "https://placekitten.com/200/200?image=5", Fotos.Type.VIDEO),
    Fotos("Title 6", "https://placekitten.com/200/200?image=6", Fotos.Type.PHOTO),
    Fotos("Title 7", "https://placekitten.com/200/200?image=7", Fotos.Type.PHOTO),
    Fotos("Title 8", "https://placekitten.com/200/200?image=8", Fotos.Type.PHOTO),
    Fotos("Title 9", "https://placekitten.com/200/200?image=9", Fotos.Type.VIDEO),
    Fotos("Title 10", "https://placekitten.com/200/200?image=10", Fotos.Type.PHOTO),
)
//Forma abreviada
fun incluirFoto2(): List<Fotos> = (1..10).map {
    Fotos("Title $it","https://placekitten.com/200/200?image=$it",
        if (Random.nextBoolean()) Fotos.Type.VIDEO else Fotos.Type.PHOTO)
}
fun prueba(){
    //until es una funcion infix, es usada para elegir un rango 
    // desde el número que se pone anterior a until hasta uno menos del número posterior.
    for (i in 0 until 10)   {
        
    }
    //to es una funcion infix
    val map = mapOf("a" to 1, "b" to 2)
}
//Se crean como una función de extensión pero anteponiendo la palabra infix,de la siguiente manera:
infix fun Int.until2(to: Int): IntRange {
    if (to <= Int.MIN_VALUE) return IntRange.EMPTY  
    return this .. (to - 1).toInt()
}
//Poner nombre a una funcion de una clase
fun test(viewGroup: ViewGroup){
    viewGroup.tamanio
}
val ViewGroup.tamanio: Int get() = childCount
// Corrutinas
fun corrutina(viewGroup: ViewGroup){

    GlobalScope.launch (Dispatchers.Main){

    }
}