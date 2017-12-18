package iv_properties

import iii_conventions.MyDate
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate?> {
    var timeInMillis: Long? = null

    operator override fun getValue(thisRef: R, property: KProperty<*>): MyDate? = timeInMillis?.toDate()
    operator override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate?) {
        timeInMillis = value?.toMillis()
    }
}

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth, 0, 0, 0)
    c.set(Calendar.MILLISECOND, 0)
    return c.timeInMillis
}

fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}
