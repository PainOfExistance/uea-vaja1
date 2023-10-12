import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

class Rosenbrock(override val dimensions: Int) : Problem() {
    override val name = "Rosenbrock"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        lowerBound = MutableList(dimensions) { -100.0 }
        upperBound = MutableList(dimensions) { 100.0 }
        for (i in 0 until dimensions) {
            lowerBound[i] = -5.0
            upperBound[i] = 10.0
        }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        var resoult = 0.0;
        for (i in 0..candidate.count() - 2) {
            resoult += 100 * pow((candidate[i + 1] - pow(candidate[i], 2.0)), 2.0) + pow((candidate[i] - 1), 2.0)
        }
        return candidate to resoult
    }
}

