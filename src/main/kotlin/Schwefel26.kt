import kotlin.math.*
import kotlin.random.Random

class Schwefel26(override val dimensions: Int) : Problem() {
    override val name = "Schwefel26"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        lowerBound = MutableList(dimensions) { -100.0 }
        upperBound = MutableList(dimensions) { 100.0 }
        for (i in 0 until dimensions) {
                lowerBound[i] = -500.0
                upperBound[i] = 500.0
        }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        return candidate to -candidate.sumOf { it * sin(sqrt(abs(it))) }
    }
}

