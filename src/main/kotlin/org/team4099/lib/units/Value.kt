package org.team4099.lib.units

import java.util.function.Supplier
import kotlin.math.absoluteValue
import kotlin.math.sign

@JvmInline
value class Value<T : UnitKey>(val value: Double) : Comparable<Value<T>> {
  inline val absoluteValue: Value<T>
    get() = Value(value.absoluteValue)

  inline val sign: Double
    get() = sign(value)

  inline val inverse: Value<Inverse<T>>
    get() = Value(1 / value)

  inline val squared: Value<Squared<T>>
    get() = Value(value * value)

  inline val cubed: Value<Cubed<T>>
    get() = Value(value * value * value)

  inline val asSupplier: Supplier<Value<T>>
    get() = Supplier { Value(value) }

  inline operator fun plus(o: Value<T>): Value<T> = Value(value + o.value)
  inline operator fun minus(o: Value<T>): Value<T> = Value(value - o.value)

  inline operator fun times(k: Double): Value<T> = Value(value * k)
  inline operator fun times(k: Number): Value<T> = this * k.toDouble()
  inline operator fun <K : UnitKey> times(o: Value<Fraction<K, T>>): Value<K> =
    Value(value * o.value)

  @Suppress("INAPPLICABLE_JVM_NAME")
  @JvmName("times1")
  inline operator fun <K : UnitKey> times(o: Value<K>): Value<Product<T, K>> =
    Value(value * o.value)

  inline operator fun unaryMinus(): Value<T> = Value(-value)

  inline operator fun div(k: Double): Value<T> = Value(value / k)
  inline operator fun div(k: Number): Value<T> = this / k.toDouble()
  inline operator fun div(o: Value<T>): Double = value / o.value
  inline operator fun <K : UnitKey> div(o: Value<K>): Value<Fraction<T, K>> = Value(value / o.value)

  override inline operator fun compareTo(other: Value<T>): Int = value.compareTo(other.value)
}

infix fun <T : UnitKey> ClosedRange<Value<T>>.step(step: Value<T>): Iterable<Value<T>> {
  require(start.value.isFinite())
  require(endInclusive.value.isFinite())
  require(step.value > 0.0) { "Step must be positive, was: $step." }
  val sequence =
    generateSequence(start) { previous ->
      if (previous.value == Double.POSITIVE_INFINITY) return@generateSequence null
      val next = previous + step
      if (next > endInclusive) null else next
    }
  return sequence.asIterable()
}
