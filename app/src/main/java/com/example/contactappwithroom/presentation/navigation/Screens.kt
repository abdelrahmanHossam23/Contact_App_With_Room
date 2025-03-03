package com.example.contactappwithroom.presentation.navigation


sealed class Screens (val route: String){
    data object AddContactScreen: Screens("add_contact_screen")
    data object ContactsScreen: Screens("contacts_screen")
}