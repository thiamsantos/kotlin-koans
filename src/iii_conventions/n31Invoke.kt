package iii_conventions

class Invokable {
    private var counter: Int = 0

    operator fun invoke(): Invokable {
        counter++
        return this
    }

    fun getNumberOfInvocations(): Int {
        return counter
    }
}

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
