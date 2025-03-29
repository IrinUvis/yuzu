package uvis.irin.core.common

fun <T> MutableCollection<T>.toggleElement(element: T) {
    if (element in this) remove(element) else add(element)
}
