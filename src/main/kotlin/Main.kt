import kotlin.random.Random

import Sphere
import Ackley
import Schwefel26
import Rosenbrock
import Bukin
import CarromTable
import Easom
import Trid

fun main(args: Array<String>) {
    val problemName = args[0]
    val dimensions = args[1].toInt()
    val maxFes = args[2].toInt()

    val problem = when (problemName) {
        "Sphere" -> Sphere(dimensions)
        "Ackley" -> Ackley(dimensions)
        "Schwefel26" -> Schwefel26(dimensions)
        "Rosenbrock" -> Rosenbrock(dimensions)
        "Bukin" -> Bukin(dimensions)
        "CarromTable" -> CarromTable(dimensions)
        "Easom" -> Easom(dimensions)
        "Trid" -> Trid(dimensions)
        else -> throw IllegalArgumentException("Invalid problem number")
    }

    val (bestCandidate, bestValue) = problem.randomSearch(problem, maxFes)
    println("Best solution: $bestCandidate = $bestValue")
}
