package com.example.contactappwithroom.presentation.state

import com.example.contactappwithroom.data.room.Contact
import com.example.contactappwithroom.util.SortType

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME
)
