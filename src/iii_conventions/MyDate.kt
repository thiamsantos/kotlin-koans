package iii_conventions

import java.util.*

data class TimeIntervalTimes(val timeInterval: TimeInterval, val amount: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(amount: Int): TimeIntervalTimes = TimeIntervalTimes(this, amount)
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

    fun nextDay() = addTimeIntervals(TimeInterval.DAY)

    operator fun plus(timeInterval: TimeInterval): MyDate {
        return addTimeIntervals(timeInterval)
    }

    operator fun plus(times: TimeIntervalTimes): MyDate {
        return addTimeIntervals(times.timeInterval, times.amount)
    }

    fun addTimeIntervals(timeInterval: TimeInterval, number: Int = 1): MyDate {
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
