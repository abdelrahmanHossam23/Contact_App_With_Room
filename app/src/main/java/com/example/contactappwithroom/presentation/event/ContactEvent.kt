package com.example.contactappwithroom.presentation.event

import com.example.contactappwithroom.data.room.Contact
import com.example.contactappwithroom.util.SortType

sealed interface ContactEvent {
    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val lastName: String): ContactEvent
    data class SetPhoneNumber(val phoneNumber: String): ContactEvent
    data class SortContacts(val sortType: SortType): ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
    object SaveContact: ContactEvent
}