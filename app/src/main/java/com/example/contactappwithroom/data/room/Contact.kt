package com.example.contactappwithroom.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")  // Make sure the name is consistent
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)
