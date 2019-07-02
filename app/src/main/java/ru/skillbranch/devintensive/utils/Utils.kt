package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName: String?) : Pair <String?,String?> {

        return when (fullName) {
            "", " " -> {
                val firstName = null
                val lastName = null
                firstName to lastName
            }
            else -> {
                val cleanValue: String? = fullName?.trim()
                val pars: List<String>? = cleanValue?.split(" ")
                val clearPars: List<String>? =  pars?.filter { s -> s != "" }
                val firstName = clearPars?.getOrNull(0)
                val lastName = clearPars?.getOrNull(1)
                firstName  to  lastName
            }
        }
    }

    fun transliteration(payloat: String, divider:String = " "): String? {
        var cleanValue: String = payloat.trim()

        val translitExemplL: Map<String,String> = mapOf(
            "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d",
            "е" to "e", "ё" to "e", "ж" to "zh", "з" to "z", "и" to "i",
            "й" to "i", "к" to "k", "л" to "l", "м" to "m", "н" to "n",
            "о" to "o", "п" to "p", "р" to "r", "с" to "s", "т" to "t",
            "у" to "u", "ф" to "f", "х" to "h", "ц" to "c", "ч" to "ch",
            "ш" to "sh", "щ" to "sh'", "ъ" to "", "ы" to "i", "ь" to "",
            "э" to "e", "ю" to "yu", "я" to "ya")

        val translitExemplU: Map<String,String> = mapOf(
            "А" to "A", "Б" to "B", "В" to "V", "Г" to "G", "Д" to "D",
            "Е" to "E", "Ё" to "E", "Ж" to "Zh", "З" to "Z", "И" to "I",
            "Й" to "I", "К" to "K", "Л" to "L", "М" to "M", "Н" to "N",
            "О" to "O", "П" to "P", "Р" to "R", "С" to "S", "Т" to "T",
            "У" to "U", "Ф" to "F", "Х" to "H", "Ц" to "C", "Ч" to "Ch",
            "Ш" to "Sh", "Щ" to "Sh'","Ы" to "I","Э" to "E", "Ю" to "Yu", "Я" to "Ya")




        for (r in translitExemplL){
                cleanValue = cleanValue.replace(r.key, r.value)
            }

        for (r in translitExemplU){
            cleanValue = cleanValue.replace(r.key, r.value)
        }

         var content: List<String>? = cleanValue.split(" ")
         val clearPars: List<String>? =  content?.filter { s -> s != "" }


        return  clearPars?.get(0) + if (clearPars?.size == 2) divider + clearPars?.get(1) else ""
    }

    fun toInitials(firstName: String? = null, lastName: String?=null): String? {
        val firstNameInitiale: Char? = firstName?.getOrNull(0)?.toUpperCase()
        val lastNameInitiale: Char? = lastName?.getOrNull(0)?.toUpperCase()

       return when (firstNameInitiale to lastNameInitiale) {
           null to null, ' ' to null, null to ' '  -> null
           firstNameInitiale to null, firstNameInitiale to ' ' -> firstNameInitiale.toString()
           null to lastName, ' ' to lastName -> lastNameInitiale.toString()
           lastNameInitiale to null, lastNameInitiale to ' ' -> lastNameInitiale.toString()
           else -> firstNameInitiale.toString() + lastNameInitiale.toString()
        }
    }
}