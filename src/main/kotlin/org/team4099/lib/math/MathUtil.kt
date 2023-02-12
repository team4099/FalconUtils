package org.team4099.lib.math

import edu.wpi.first.math.MathUtil
import org.team4099.lib.units.UnitKey
import org.team4099.lib.units.Value

fun <K : UnitKey> clamp(value: Value<K>, lowerBound: Value<K>, upperBound: Value<K>): Value<K> {
  return Value(MathUtil.clamp(value.value, lowerBound.value, upperBound.value))
}
