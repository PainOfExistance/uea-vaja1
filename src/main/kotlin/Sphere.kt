import kotlin.random.Random

import Problem
class Sphere(override val dimensions: Int) : Problem() {
    override val name = "Sphere"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        lowerBound = MutableList(dimensions) { -100.0 }
        upperBound = MutableList(dimensions) { 100.0 }
        for (i in 0 until dimensions) {
            if (i % 2 == 1) {
                lowerBound[i] = -10.0
                upperBound[i] = 10.0
            }
        }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        val candidate = MutableList(dimensions) { 0.0 }
        for (i in 0 until candidate.size - 1) {
            candidate[i] = random.nextDouble(lowerBound[i], upperBound[i])
        }
        return candidate to candidate.sumOf { it * it }
    }
}
