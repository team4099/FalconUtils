package org.team4099.lib.math

import edu.wpi.first.math.MathUtil
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value

fun <K : UnitKey> clamp(value: Value<K>, lowerBound: Value<K>, upperBound: Value<K>): Value<K> {
  return Value(MathUtil.clamp(value.value, lowerBound.value, upperBound.value))
}

fun <K : UnitKey> abs(n: Value<K>): Value<K> {
  return Value(kotlin.math.abs(n.value))
}

fun <K : UnitKey> hypot(x: Value<K>, y: Value<K>): Value<K> {
  return Value(kotlin.math.hypot(x.value, y.value))
}
