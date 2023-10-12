import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.random.Random

class Bukin(override var dimensions: Int) : Problem() {
    override val name = "Bukin"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        dimensions = 2
        lowerBound = MutableList(dimensions) { -3.0 }
        upperBound = MutableList(dimensions) { 3.0 }
        lowerBound[0] = -15.0
        upperBound[0] = -5.0
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        val x1 = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        val x2 = MutableList(dimensions) { random.nextDouble(lowerBound[1], upperBound[1]) }
        val ret = mutableListOf(x1[0], x1[1], x2[0], x2[1])
        var resoult = 100 * sqrt(abs(x2[0] - 0.01 * pow(x1[0], 2.0))) + 0.01 * abs(x1[0] * 10)
        return ret to resoult
    }
}
