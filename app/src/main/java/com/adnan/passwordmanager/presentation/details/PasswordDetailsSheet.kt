package com.adnan.passwordmanager.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adnan.passwordmanager.R
import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.presentation.theme.BlueColor
import com.adnan.passwordmanager.presentation.theme.ButtonBackgroundColor
import com.adnan.passwordmanager.presentation.theme.DeleteButtonColor
import com.adnan.passwordmanager.presentation.theme.HintTextFieldColor
import com.adnan.passwordmanager.presentation.theme.SFProFonts

/**
 * Created by Adnan.
 */
@Composable
fun PasswordDetailsSheet(
    item: PasswordItem,
    onDelete: () -> Unit,
    onEdit: () -> Unit,
    passwordDetailsViewModel: PasswordDetailsViewModel
) {
    var showPassword by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.label_account_details),
            fontSize = 18.sp,
            fontFamily = SFProFonts,
            fontWeight = FontWeight.Bold,
            color = BlueColor,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            stringResource(R.string.label_account_type),
            fontSize = 12.sp,
            fontFamily = SFProFonts,
            fontWeight = FontWeight.Medium,
            color = HintTextFieldColor,
            modifier = Modifier.padding(top = 25.dp),
            lineHeight = 1.sp
        )
        Text(
            item.accountName,
            fontFamily = SFProFonts,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.sp
        )
        Text(
            stringResource(R.string.label_user_name_or_email),
            fontSize = 12.sp,
            fontFamily = SFProFonts,
            fontWeight = FontWeight.Medium,
            color = HintTextFieldColor,
            lineHeight = 1.sp,
            modifier = Modifier.padding(top = 25.dp),
        )
        Text(
            item.username,
            fontFamily = SFProFonts,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.sp
        )
        Text(
            stringResource(R.string.label_password),
            fontSize = 12.sp,
            fontFamily = SFProFonts,
            fontWeight = FontWeight.Medium,
            color = HintTextFieldColor,
            lineHeight = 1.sp,
            modifier = Modifier.padding(top = 25.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (showPassword) item.password else stringResource(R.string.masked_password),
                fontFamily = SFProFonts,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 1.sp
            )
            IconButton(
                onClick = { showPassword = !showPassword },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    painter = painterResource(
                        if (showPassword) R.drawable.ic_eye_open else R.drawable.ic_eye_close
                    ),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onEdit,
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonBackgroundColor)
            ) {
                Text(
                    stringResource(R.string.label_edit),
                    fontFamily = SFProFonts,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = { passwordDetailsViewModel.delete(item,onDelete) },
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DeleteButtonColor)
            ) {
                Text(
                    stringResource(R.string.label_delete),
                    fontFamily = SFProFonts,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
