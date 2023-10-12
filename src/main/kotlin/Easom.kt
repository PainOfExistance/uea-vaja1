import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.pow
import kotlin.random.Random

class Easom(override var dimensions: Int) : Problem() {
    override val name = "Easom"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        dimensions = 2
        lowerBound = MutableList(dimensions) { -100.0 }
        upperBound = MutableList(dimensions) { 100.0 }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {
        dimensions = 2
        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        var result = -cos(candidate[0]) * cos(candidate[1]) * exp(
                -(candidate[0] - Math.PI).pow(2.0) - (candidate[1] - Math.PI).pow(2.0)
        )
        return candidate to result
    }
}