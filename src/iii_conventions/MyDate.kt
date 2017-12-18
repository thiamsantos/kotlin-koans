package iii_conventions

import java.util.*

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year !== other.year -> year - other.year
        month !== other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun rangeTo(end: MyDate): DateRange {
        return DateRange(this, end)
    }

    fun nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

    fun addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
        val c = Calendar.getInstance()
        c.set(year, month, dayOfMonth)
        when (timeInterval) {
            TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
            TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
            TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
        }
        return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
    }
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(date: MyDate): Boolean {
        if (start <= date && date <= endInclusive) {
            return true
        }
        return false
    }

    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean {
        return current <= dateRange.endInclusive
    }
}
