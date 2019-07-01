package ru.skillbranch.devintensive.models

import android.provider.Contacts
import ru.skillbranch.devintensive.utils.Utils
import java.time.LocalDate
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = null,
    val isOnline: Boolean = false

) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)

    constructor(id: String) : this(id, null, null)

    fun printMe() = println("""
            id: $id     
            firstName: $firstName    
            lastName: $lastName
            avatar: $avatar   
            rating: $rating   
            respact: $respect  
            lastVisit: $lastVisit    
            isOnline: $isOnline 
            
        """.trimIndent())

    companion object Factory {
        private var lastId: Int = -1

        fun makeUser (fullName: String?) : User{
            lastId++
            val (firstName,lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName , lastName = lastName)
        }
    }
    class Builder {
        private lateinit var id: String
        private var firstName: String? = null
        private var lastName: String? = null
        private var avatar: String? = null
        private var rating: Int = 0
        private var respect: Int = 0
        private var lastVisit: Date? = null
        private var isOnline: Boolean = false


        fun id(id: String)= apply{this.id = id}
        fun firstName(firstName: String?)= apply{this.firstName = firstName}
        fun lastName(lastName: String?)= apply{this.lastName = lastName}
        fun avatar(avatar: String?)= apply{this.avatar = avatar}
        fun rating(rating: Int)=apply{this.rating = rating}
        fun respect(respect: Int)= apply{this. respect = respect}
        fun lastVisit(lastVisit: Date?)= apply{this.lastVisit = lastVisit}
        fun isOnline(isOnline: Boolean )= apply{this.isOnline = isOnline}
        fun build()= User( id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }
}
