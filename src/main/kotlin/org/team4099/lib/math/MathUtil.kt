package org.team4099.lib.math

import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value
import org.team4099.lib.units.base.Time
import org.team4099.lib.units.base.inSeconds
import org.team4099.lib.units.base.seconds
import org.team4099.lib.units.max
import org.team4099.lib.units.min

fun <K : UnitKey> clamp(value: Value<K>, lowerBound: Value<K>, upperBound: Value<K>): Value<K> {
  return max(lowerBound, min(value, upperBound))
}

fun <K : UnitKey> abs(n: Value<K>): Value<K> {
  return Value(kotlin.math.abs(n.value))
}

fun <K : UnitKey> hypot(x: Value<K>, y: Value<K>): Value<K> {
  return Value(kotlin.math.hypot(x.value, y.value))
}

fun <K : UnitKey> lerp(a: Value<K>, b: Value<K>, t: Time): Value<K> {
  return a + (b - a) * t.inSeconds
}

fun <K : UnitKey> inverseLerp(a: Value<K>, b: Value<K>, q: Value<K>): Time {
  if (a.epsilonEquals(b)) {
    return 0.seconds
  }
  return ((q.value - a.value) / (b.value - a.value)).seconds
}
