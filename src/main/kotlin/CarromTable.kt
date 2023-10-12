import java.lang.Math.cos
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

class CarromTable(override var dimensions: Int) : Problem() {
    override val name = "CarromTable"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        dimensions = 2
        lowerBound = MutableList(dimensions) { -10.0 }
        upperBound = MutableList(dimensions) { 10.0 }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {

        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        val firstTerm = -(1 / 30.0) * exp(
                2 * abs(1.0 - (sqrt(candidate[0] * candidate[0] + candidate[1] * candidate[1]) / Math.PI))
        )
        val secondTerm = cos(candidate[0]).pow(2.0) * cos(candidate[1]).pow(2.0)
        val result = firstTerm * secondTerm
        
        return candidate to result
    }

}
