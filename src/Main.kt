data class Task(val name: String,var iscomplited:Boolean=false )

fun main() {

    val tasklist= mutableListOf<Task>()
    while (true){
        println("choose an option")
        println("1. add task")
        println("2.mark task as completed")
        println("3.view tasks")
        println("4. exit")
        val userInput= readlnOrNull()?.toIntOrNull()
       when(userInput){
           1->{
               println("enter task name")
               val taskname= readlnOrNull()
               if (!taskname.isNullOrEmpty()){
                   val newtask=Task(taskname)
                   tasklist.add(newtask)
                   println("$taskname task added")
               }else{
                   println("invalid task name!!! pleas try again")
               }

           }
           2->{
               if (tasklist.isNotEmpty()){
                   println("select the index of the task to mark as completed")
                   val index = readlnOrNull()?.toIntOrNull()
                   if (index!=null && index in tasklist.indices){
                       val task=tasklist[index]
                       task.iscomplited=true
                     println("task '${task.name}' mark as completed ")
                   }else{
                       println("invalid index try again!!!!! ")
                   }
               }
               else{
                   println("no tasks available to mark as complete ")
               }

           }
           3->{if(tasklist.isNotEmpty()){
               println("Tasks: ")
               for ((index,task)in tasklist.withIndex()){
            println("${index+1}.${task.name}-${if (task.iscomplited)"completed" else "incompleted"}")

               }
           }else{
                println("no task available")
           }

           }
           4->{
               println("exiting the program!!!!!")
             return
           }
           else->{
             println("invalid choice please enter number 1 to 4")
           }
       }
    }
}