import java.lang.Math.pow
import kotlin.random.Random
import Problem

class Trid(override val dimensions: Int) : Problem() {
    override val name = "Trid"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        lowerBound = MutableList(dimensions) { dimensions * dimensions * -1.0 }
        upperBound = MutableList(dimensions) { dimensions * dimensions * 1.0 }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        var result = candidate.sumOf { pow(it - 1, 2.0) };
        var res = 0.0;
        for (i in 1..candidate.count() - 1) {
            res += candidate[i] * candidate[i - 1]
        }
        return candidate to (result - res)
    }
}