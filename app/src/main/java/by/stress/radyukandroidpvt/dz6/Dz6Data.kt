package by.stress.radyukandroidpvt.dz6

import android.webkit.URLUtil
import java.util.*
import kotlin.collections.ArrayList

/**
 * Helper class for providing sample content
 */
object Dz6Data { // https://antonioleiva.com/objects-kotlin/ // object Singleton // You don’t need more.

    // sample данные
    private var table = arrayOf(
        arrayOf(1, "Арктическая лиса Arctic fox", "https://cdn.pixabay.com/photo/2016/10/21/14/46/norway-1758183_960_720.jpg"),
        arrayOf(2, "Африканский лев African lion", "https://cdn.pixabay.com/photo/2016/01/02/16/53/lion-1118467_960_720.jpg"),
        arrayOf(3, "Баран Mutton", "https://cdn.pixabay.com/photo/2017/12/17/15/58/mammal-3024471_960_720.jpg"),
        arrayOf(4, "Волк Wolf", "https://cdn.pixabay.com/photo/2012/10/25/23/52/wolf-62898_960_720.jpg"),
        arrayOf(5, "Голубь Dove", "https://cdn.pixabay.com/photo/2017/07/18/18/24/dove-2516641_960_720.jpg"),
        arrayOf(6, "Ёжик Hedgehog", "https://cdn.pixabay.com/photo/2016/02/22/10/06/hedgehog-1215140_960_720.jpg"),
        arrayOf(7, "Жёлтый попугай Ara", "https://cdn.pixabay.com/photo/2018/08/12/16/59/ara-3601194_960_720.jpg"),
        arrayOf(8, "Жираф Giraffe", "https://cdn.pixabay.com/photo/2017/04/11/21/34/giraffe-2222908_960_720.jpg"),
        arrayOf(9, "Конь Horse", "https://cdn.pixabay.com/photo/2018/11/11/17/10/black-horse-3809167_960_720.jpg"),
        arrayOf(10, "Котёнок Kitten", "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_960_720.jpg"),
        arrayOf(11, "Котёнок в лесу Kitten in the forest", "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_960_720.jpg"),
        arrayOf(12, "Кролик Rabbit", "https://cdn.pixabay.com/photo/2016/12/04/21/58/rabbit-1882699_960_720.jpg"),
        arrayOf(13, "Лань Deer", "https://cdn.pixabay.com/photo/2015/10/12/15/46/fallow-deer-984573_960_720.jpg"),
        arrayOf(14, "Лебедь Swan", "https://cdn.pixabay.com/photo/2017/02/18/13/55/swan-2077219_960_720.jpg"),
        arrayOf(15, "Лев Lion", "https://cdn.pixabay.com/photo/2018/05/03/22/34/lion-3372720_960_720.jpg"),
        arrayOf(16, "Лиса Fox", "https://cdn.pixabay.com/photo/2015/04/10/01/41/fox-715588_960_720.jpg"),
        arrayOf(17, "Лось Moose", "https://cdn.pixabay.com/photo/2012/12/17/03/59/moose-70254_960_720.jpg"),
        arrayOf(18, "Лягушка Frog", "https://cdn.pixabay.com/photo/2019/06/24/20/02/frog-4296784_960_720.jpg"),
        arrayOf(19, "Оленёнок Fawn", "https://cdn.pixabay.com/photo/2016/05/02/13/17/wildlife-1367217_960_720.jpg"),
        arrayOf(20, "Орлан-белохвост Eagle", "https://cdn.pixabay.com/photo/2017/06/09/09/39/adler-2386314_960_720.jpg"),
        arrayOf(21, "Плавающий тигр Swimming tiger", "https://cdn.pixabay.com/photo/2017/07/24/19/57/tiger-2535888_960_720.jpg"),
        arrayOf(22, "Попугай Parrot", "https://cdn.pixabay.com/photo/2017/09/16/19/33/parrot-2756488_960_720.jpg"),
        arrayOf(23, "Слон Elephant", "https://cdn.pixabay.com/photo/2017/10/20/10/58/elephant-2870777_960_720.jpg"),
        arrayOf(24, "Собака Dog", "https://cdn.pixabay.com/photo/2018/03/31/06/31/dog-3277416_960_720.jpg"),
        arrayOf(25, "Сова 1 Owl 1", "https://cdn.pixabay.com/photo/2018/09/02/15/34/burrowing-3649048_960_720.jpg"),
        arrayOf(26, "Сова 2 Owl 2", "https://cdn.pixabay.com/photo/2018/10/08/14/46/bird-3732867_960_720.jpg"),
        arrayOf(27, "Тигр Tiger", "https://cdn.pixabay.com/photo/2016/11/29/10/07/animal-1868911_960_720.jpg"),
        arrayOf(28, "Черепаха Turtle", "https://cdn.pixabay.com/photo/2017/05/31/18/38/sea-2361247_960_720.jpg")
    )

    // An array of sample items.
    var ITEMS: ArrayList<StudentItem> = ArrayList()

    // A map of sample items, by ID.
    var ITEM_MAP: HashMap<String, StudentItem> = HashMap()

    // длина исходного массива
    private val COUNT = table.size

    // создаём исходные массивы
    init {
        for (i in 0 until COUNT) {
            addItem(createStudentItemDefault(i))
        }
    }
    private fun addItem(item: StudentItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }
    private fun createStudentItemDefault(i: Int): StudentItem {
        return StudentItem(
            UUID.randomUUID().toString(),
            table[i][2].toString(),
            table[i][1].toString(),
            table[i][0].toString().toInt()
        )
    }

    // добавление нового элемента
    fun createItem(newStudent: StudentItem): Boolean {

        val createStudent = StudentItem(
            UUID.randomUUID().toString(),
            newStudent.imageUrl,
            newStudent.name,
            newStudent.age
        )

        addItem(createStudent)

        return true
    }

    // удаление элемента
    fun deleteItem(id: String) {

        // удаляем элемент из ArrayList ITEMS
        val indexInArrayList = ITEMS.indexOf(ITEM_MAP[id])
        ITEMS.removeAt(indexInArrayList)

        // удаляем элемент из HashMap ITEM_MAP
        ITEM_MAP.remove(id)
    }

    // обновление элемента
    fun updateItem(changedItem: StudentItem): Boolean {

        // ищем индекс в ArrayList
        val indexInArrayList = getIndexInArrayListByStudentId(changedItem.id)

        // если не нашли (защита от ошибок) - возвращаем false
        if (indexInArrayList == -1) {
            return false
        }

        // заменяем элемент на изменённый в ArrayList ITEMS
        ITEMS[indexInArrayList] = changedItem

        // заменяем элемент на изменённый в HashMap ITEM_MAP
        ITEM_MAP[changedItem.id] = changedItem

        // сообщаем об успехе
        return true
    }

    // получаем индекс элемента в ArrayList по StudentId
    private fun getIndexInArrayListByStudentId(id: String): Int {
        for ((i, item) in ITEMS.withIndex()) {
            if (item.id == id) {
                return i
            }
        }
        return -1
    }

    // проверка правильности ввода данных // возраст должен быть ненулевым до этой проверки
    fun checkStudentFields(st: StudentItem): String {
        var msg = ""
        if (st.name.isEmpty()) msg += "Необходимо указать имя студента. "
        if (st.imageUrl.isEmpty()) msg += "Необходимо ввести ссылку на фотографию студента. "
        if (!URLUtil.isValidUrl(st.imageUrl)) msg += "Пожалуйста, исправьте ошибки в ссылке на фотографию студента. "
        return msg
    }
}