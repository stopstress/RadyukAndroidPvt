package by.stress.radyukandroidpvt.dz6

// item representing a piece of content
data class StudentItem(
    val id: String,
    val imageUrl: String,
    val name: String,
    val age: Int = 0  // защита от обрушения при непрвильно введённом возрасте
) { override fun toString(): String = "$name (возраст: $age, ID: $id)" }
