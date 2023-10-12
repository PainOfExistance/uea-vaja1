import kotlin.random.Random

abstract class Problem {
    abstract val name: String
    abstract val lowerBound: MutableList<Double>
    abstract val upperBound: MutableList<Double>
    abstract val dimensions: Int
    abstract fun fitness(random: Random): Pair<MutableList<Double>, Double>

    fun randomSearch(problem: Problem, maxFes: Int): Pair<MutableList<Double>, Double> {
        val random = Random.Default
        var (bestCandidate, bestValue) = problem.fitness(random)
        repeat(maxFes - 1) {
            val (candidate, value) = problem.fitness(random)
            if (value < bestValue) {
                bestValue = value
                bestCandidate = candidate
                println("x$bestCandidate = $bestValue")
            }
        }
        return bestCandidate to bestValue
    }
}
