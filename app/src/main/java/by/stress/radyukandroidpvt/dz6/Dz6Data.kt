package by.stress.radyukandroidpvt.dz6

import java.util.HashMap

/**
 * Helper class for providing sample content
 */
object Dz6Data {

    private var table= arrayOf(
        arrayOf(1, "Арктическая лиса", "https://cdn.pixabay.com/photo/2016/10/21/14/46/norway-1758183_960_720.jpg"),
        arrayOf(2, "Африканский лев", "https://cdn.pixabay.com/photo/2016/01/02/16/53/lion-1118467_960_720.jpg"),
        arrayOf(3, "Баран", "https://cdn.pixabay.com/photo/2017/12/17/15/58/mammal-3024471_960_720.jpg"),
        arrayOf(4, "Волк", "https://cdn.pixabay.com/photo/2012/10/25/23/52/wolf-62898_960_720.jpg"),
        arrayOf(5, "Голубь", "https://cdn.pixabay.com/photo/2017/07/18/18/24/dove-2516641_960_720.jpg"),
        arrayOf(6, "Ёжик", "https://cdn.pixabay.com/photo/2016/02/22/10/06/hedgehog-1215140_960_720.jpg"),
        arrayOf(7, "Жёлтый попугай", "https://cdn.pixabay.com/photo/2018/08/12/16/59/ara-3601194_960_720.jpg"),
        arrayOf(8, "Жираф", "https://cdn.pixabay.com/photo/2017/04/11/21/34/giraffe-2222908_960_720.jpg"),
        arrayOf(9, "Конь", "https://cdn.pixabay.com/photo/2018/11/11/17/10/black-horse-3809167_960_720.jpg"),
        arrayOf(10, "Котёнок", "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_960_720.jpg"),
        arrayOf(11, "Котёнок в лесу", "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_960_720.jpg"),
        arrayOf(12, "Кролик", "https://cdn.pixabay.com/photo/2016/12/04/21/58/rabbit-1882699_960_720.jpg"),
        arrayOf(13, "Лань", "https://cdn.pixabay.com/photo/2015/10/12/15/46/fallow-deer-984573_960_720.jpg"),
        arrayOf(14, "Лебедь", "https://cdn.pixabay.com/photo/2017/02/18/13/55/swan-2077219_960_720.jpg"),
        arrayOf(15, "Лев", "https://cdn.pixabay.com/photo/2018/05/03/22/34/lion-3372720_960_720.jpg"),
        arrayOf(16, "Лиса", "https://cdn.pixabay.com/photo/2015/04/10/01/41/fox-715588_960_720.jpg"),
        arrayOf(17, "Лось", "https://cdn.pixabay.com/photo/2012/12/17/03/59/moose-70254_960_720.jpg"),
        arrayOf(18, "Лягушка", "https://cdn.pixabay.com/photo/2019/06/24/20/02/frog-4296784_960_720.jpg"),
        arrayOf(19, "Оленёнок", "https://cdn.pixabay.com/photo/2016/05/02/13/17/wildlife-1367217_960_720.jpg"),
        arrayOf(20, "Орлан-белохвост", "https://cdn.pixabay.com/photo/2017/06/09/09/39/adler-2386314_960_720.jpg"),
        arrayOf(21, "Плавающий тигр", "https://cdn.pixabay.com/photo/2017/07/24/19/57/tiger-2535888_960_720.jpg"),
        arrayOf(22, "Попугай", "https://cdn.pixabay.com/photo/2017/09/16/19/33/parrot-2756488_960_720.jpg"),
        arrayOf(23, "Слон", "https://cdn.pixabay.com/photo/2017/10/20/10/58/elephant-2870777_960_720.jpg"),
        arrayOf(24, "Собака", "https://cdn.pixabay.com/photo/2018/03/31/06/31/dog-3277416_960_720.jpg"),
        arrayOf(25, "Сова", "https://cdn.pixabay.com/photo/2018/09/02/15/34/burrowing-3649048_960_720.jpg"),
        arrayOf(26, "Сова", "https://cdn.pixabay.com/photo/2018/10/08/14/46/bird-3732867_960_720.jpg"),
        arrayOf(27, "Тигр", "https://cdn.pixabay.com/photo/2016/11/29/10/07/animal-1868911_960_720.jpg"),
        arrayOf(28, "Черепаха", "https://cdn.pixabay.com/photo/2017/05/31/18/38/sea-2361247_960_720.jpg")
    )

    // An array of sample items.
    private val ITEMS: MutableList<StudentItem> = ArrayList()

    // A map of sample items, by ID.
    val ITEM_MAP: MutableMap<Long, StudentItem> = HashMap()

    // длина исходного массива
    private val COUNT = table.size

    // Add sample items
    init {
        for (i in 1..COUNT) {
            addItem(createStudentItem(i))
        }
    }

    private fun addItem(item: StudentItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createStudentItem(i: Int): StudentItem {
        return StudentItem(
            System.currentTimeMillis(),
            table[i][2].toString(),
            table[i][1].toString(),
            table[i][0].toString().toInt()
        )
    }

    // item representing a piece of content
    data class StudentItem(
        val id: Long,
        val imageUrl: String,
        val name: String,
        val age: Int
    ) { override fun toString(): String = "$name (возраст: $age, ID: $id)"}
}