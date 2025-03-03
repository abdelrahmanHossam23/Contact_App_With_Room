package com.example.contactappwithroom.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contactappwithroom.presentation.event.ContactEvent
import com.example.contactappwithroom.presentation.state.ContactState
import com.example.contactappwithroom.util.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(state: ContactState,
                  onEvent: (ContactEvent) -> Unit,
                  onAddContactClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                text = "Contacts",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
                    ) },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.tertiary
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onAddContactClick()
            },
                containerColor = MaterialTheme.colorScheme.tertiary) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add contact",
                    tint = MaterialTheme.colorScheme.background


                )
            }
        },
    ){ padding ->

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column {
                    Text(text = "Sort Type:",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SortType.values().forEach { sortType ->
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        onEvent(ContactEvent.SortContacts(sortType))
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = state.sortType == sortType,
                                    onClick = {
                                        onEvent(ContactEvent.SortContacts(sortType))
                                    }
                                )
                                Text(text = sortType.name,
                                    color = MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }
                }

            }
            items(state.contacts) { contact ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "${contact.firstName} ${contact.lastName}",
                                fontSize = 20.sp
                            )
                            Text(text = contact.phoneNumber, fontSize = 12.sp)
                        }
                        IconButton(onClick = {
                            onEvent(ContactEvent.DeleteContact(contact))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete contact"
                            )
                        }
                    }
                }

            }
        }
    }
}