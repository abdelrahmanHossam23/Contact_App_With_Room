package com.example.contactappwithroom.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactappwithroom.presentation.screens.AddContact
import com.example.contactappwithroom.presentation.screens.ContactScreen
import com.example.contactappwithroom.presentation.viewModel.ContactViewModel


@Composable
fun AppNavHost(viewModel: ContactViewModel) {

    val state by viewModel.state.collectAsState()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.ContactsScreen.route
    ) {
        composable(route = Screens.ContactsScreen.route) {
            ContactScreen(state, onEvent = viewModel::onEvent,  onAddContactClick = { navController.navigate(Screens.AddContactScreen.route)  })
        }


        composable(route = Screens.AddContactScreen.route) {
            AddContact(
                onEvent = viewModel::onEvent, onSaveContactClick = { navController.navigate(Screens.ContactsScreen.route)  }, state =state
            )
        }


    }
}
