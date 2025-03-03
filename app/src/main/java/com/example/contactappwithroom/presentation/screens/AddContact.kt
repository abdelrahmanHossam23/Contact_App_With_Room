package com.example.contactappwithroom.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.contactappwithroom.presentation.event.ContactEvent
import com.example.contactappwithroom.presentation.state.ContactState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContact(
    onEvent: (ContactEvent) -> Unit,
    onSaveContactClick: () -> Unit,
    state: ContactState
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    val Context = LocalContext.current

    LaunchedEffect(state.firstName, state.lastName, state.phoneNumber) {
        if (state.firstName.isNotBlank() && state.lastName.isNotBlank() && state.phoneNumber.isNotBlank()) {
            onEvent(ContactEvent.SaveContact)
            Toast.makeText(Context, "Contact added successfully", Toast.LENGTH_SHORT).show()
            onSaveContactClick()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Contact",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiary
                ),
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = "First Name",
                icon = Icons.Default.Person,
                showError = showError && firstName.isBlank()
            )
            CustomTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = "Last Name",
                icon = Icons.Default.Person,
                showError = showError && lastName.isBlank()
            )
            CustomTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Phone Number",
                icon = Icons.Default.Phone,
                keyboardType = KeyboardType.Phone,
                showError = showError && phoneNumber.isBlank()
            )

            if (showError && (firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank())) {
                Text(
                    text = "Please fill all fields",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Button(
                onClick = {
                    if (firstName.isNotBlank() && lastName.isNotBlank() && phoneNumber.isNotBlank()) {
                        onEvent(ContactEvent.SetFirstName(firstName))
                        onEvent(ContactEvent.SetLastName(lastName))
                        onEvent(ContactEvent.SetPhoneNumber(phoneNumber))
//                        onEvent(ContactEvent.SaveContact)
//                        onSaveContactClick()
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Text("Save Contact")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    showError: Boolean = false,
    iconColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.secondary
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null, tint = iconColor) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = showError,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewAddContact() {
    val navController = rememberNavController()
    AddContact(
        onEvent = {},
        onSaveContactClick = {},
        state = ContactState()
    )
}