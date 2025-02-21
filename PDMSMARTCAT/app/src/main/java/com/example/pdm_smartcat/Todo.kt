package com.example.calculadora
import java.time.Instant
import java.util.Date


data class Todo(
    var id: Int,
    var title : String,
    var createdAt : Date
)



fun getFakeTodo() : List<Todo>{
    return listOf<Todo>(
        Todo(1,  "first_todo",Date.from(Instant.now())),
        Todo(2,  "two_todo",Date.from(Instant.now())),
        Todo(3,  "three_todo",Date.from(Instant.now())),
        Todo(4,  "four_todo",Date.from(Instant.now()))


    );
}