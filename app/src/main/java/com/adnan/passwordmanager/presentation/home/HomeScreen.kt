package com.adnan.passwordmanager.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adnan.passwordmanager.R
import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.presentation.add.AddPasswordSheet
import com.adnan.passwordmanager.presentation.add.AddPasswordViewModel
import com.adnan.passwordmanager.presentation.components.DefaultDragHandle
import com.adnan.passwordmanager.presentation.components.EmptyState
import com.adnan.passwordmanager.presentation.components.PasswordItemCard
import com.adnan.passwordmanager.presentation.details.PasswordDetailsSheet
import com.adnan.passwordmanager.presentation.details.PasswordDetailsViewModel
import com.adnan.passwordmanager.presentation.theme.BackgroundColor
import com.adnan.passwordmanager.presentation.theme.BlueColor
import com.adnan.passwordmanager.presentation.theme.ButtonBackgroundColor
import com.adnan.passwordmanager.presentation.theme.DividerColor
import com.adnan.passwordmanager.presentation.theme.SFProFonts
import com.adnan.passwordmanager.presentation.theme.SheetBackgroundColor
import com.adnan.passwordmanager.presentation.theme.TitleTextColor
import com.adnan.passwordmanager.presentation.theme.WhiteColor

/**
 * Created by Adnan.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    addPasswordViewModel: AddPasswordViewModel,
    passwordViewModel: PasswordDetailsViewModel
) {
    val addSheetState = rememberModalBottomSheetState()
    val detailsSheetState = rememberModalBottomSheetState()
    var showAddSheet by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<PasswordItem?>(null) }
    val passwords = homeViewModel.passwords.collectAsState()
    Scaffold(
        containerColor = BackgroundColor,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = BlueColor, onClick = {
                    addPasswordViewModel.clear()
                    showAddSheet = true
                }, shape = RoundedCornerShape(15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    modifier = Modifier.size(38.dp),
                    contentDescription = null,
                    tint = WhiteColor
                )
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            Text(
                text = stringResource(R.string.label_password_manager),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = SFProFonts,
                fontWeight = FontWeight.Bold,
                color = TitleTextColor
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = DividerColor
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                when {
                    homeViewModel.isLoading.value -> {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(color = BlueColor)
                            Text(
                                text = stringResource(R.string.label_loading),
                                fontFamily = SFProFonts,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = ButtonBackgroundColor,
                                modifier = Modifier.padding(top = 10.dp)
                            )
                        }
                    }

                    passwords.value.isEmpty() -> {
                        EmptyState(modifier = Modifier.align(Alignment.Center))
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(bottom = 50.dp)
                        ) {
                            items(passwords.value) { item ->
                                PasswordItemCard(
                                    modifier = Modifier.padding(vertical = 6.dp),
                                    title = item.accountName,
                                    onClick = { selectedItem = item }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    if (showAddSheet) {
        ModalBottomSheet(
            sheetState = addSheetState,
            onDismissRequest = { showAddSheet = false },
            containerColor = SheetBackgroundColor,
            dragHandle = { DefaultDragHandle() }
        ) {
            AddPasswordSheet(
                vm = addPasswordViewModel,
                onClose = { showAddSheet = false }
            )
        }
    }
    selectedItem?.let { item ->
        ModalBottomSheet(
            sheetState = detailsSheetState,
            onDismissRequest = { selectedItem = null },
            containerColor = SheetBackgroundColor,
            dragHandle = { DefaultDragHandle() }
        ) {
            PasswordDetailsSheet(
                item = item,
                onEdit = {
                    addPasswordViewModel.loadForEdit(item)
                    selectedItem = null
                    showAddSheet = true
                },
                onDelete = {
                    passwordViewModel.delete(item) {
                        selectedItem = null
                        addPasswordViewModel.clear()
                    }
                },
                passwordDetailsViewModel = passwordViewModel
            )
        }
    }
}