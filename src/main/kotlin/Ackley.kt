import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sqrt
import kotlin.random.Random

class Ackley(override val dimensions: Int) : Problem() {
    override val name = "Ackley"
    override val lowerBound: MutableList<Double>
    override val upperBound: MutableList<Double>

    init {
        lowerBound = MutableList(dimensions) { -100.0 }
        upperBound = MutableList(dimensions) { 100.0 }
        for (i in 0 until dimensions) {
            lowerBound[i] = -32.768
            upperBound[i] = 32.768
        }
    }

    override fun fitness(random: Random): Pair<MutableList<Double>, Double> {

        val candidate = MutableList(dimensions) { random.nextDouble(lowerBound[0], upperBound[0]) }
        val term1 = -20 * exp(
                -0.2 * sqrt((1.0 / dimensions) * candidate.sumOf { it * it })
        )
        val term2 = exp(
                (1.0 / dimensions) * candidate.sumOf { cos(2 * PI * it) }
        )
        val fin = term1 - term2 + 20 + exp(1.0)
        return candidate to fin
    }
}
