package com.example.contactappwithroom.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY firstName ASC")
    fun getContactsByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY lastName ASC")
    fun getContactsByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY phoneNumber ASC")
    fun getContactsByPhoneNumber(): Flow<List<Contact>>
}