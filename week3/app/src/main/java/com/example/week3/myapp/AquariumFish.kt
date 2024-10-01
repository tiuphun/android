package com.example.week3.myapp

//abstract class AquariumFish : FishAction {
//    abstract val color: String
//    override fun eat() = println("yum")
//}
//interface FishAction  {
//    fun eat()
//}
//
//class Shark: AquariumFish(), FishAction {
//    override val color = "grey"
//    override fun eat() {
//        println("hunt and eat fish")
//    }
//}
//
//class Plecostomus: AquariumFish(), FishAction {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by GoldColor {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
    }


class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}