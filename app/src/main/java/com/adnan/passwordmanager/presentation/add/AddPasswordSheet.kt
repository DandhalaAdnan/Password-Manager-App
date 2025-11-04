package com.adnan.passwordmanager.presentation.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adnan.passwordmanager.R
import com.adnan.passwordmanager.presentation.components.SmallTextField
import com.adnan.passwordmanager.presentation.theme.ButtonBackgroundColor
import com.adnan.passwordmanager.presentation.theme.SFProFonts

/**
 * Created by Adnan.
 */
@Composable
fun AddPasswordSheet(
    vm: AddPasswordViewModel,
    onClose: () -> Unit
) {
    val isEdit = vm.editingId != null
    Column(Modifier.padding(horizontal = 30.dp)) {
        SmallTextField(
            modifier = Modifier.padding(top = 30.dp),
            value = vm.account,
            onValueChange = {
                vm.account = it
                vm.accountError = null
            },
            placeholder = stringResource(R.string.label_account_name),
            error = vm.accountError
        )
        SmallTextField(
            value = vm.username,
            onValueChange = {
                vm.username = it
                vm.usernameError = null
            },
            placeholder = stringResource(R.string.label_user_name_or_email),
            modifier = Modifier.padding(top = 20.dp),
            error = vm.usernameError
        )
        SmallTextField(
            value = vm.password,
            onValueChange = {
                vm.password = it
                vm.passwordError = null
            },
            placeholder = stringResource(R.string.label_password),
            modifier = Modifier.padding(top = 20.dp),
            error = vm.passwordError
        )
        Button(
            onClick = { vm.save(onClose) },
            modifier = Modifier
                .padding(top = 20.dp, bottom = 15.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonBackgroundColor)
        ) {
            Text(
                text = if (isEdit)
                    stringResource(R.string.label_update_account)
                else
                    stringResource(R.string.label_add_new_account),
                fontSize = 16.sp,
                fontFamily = SFProFonts,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}