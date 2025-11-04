package com.adnan.passwordmanager.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adnan.passwordmanager.R
import com.adnan.passwordmanager.presentation.theme.HintTextFieldColor
import com.adnan.passwordmanager.presentation.theme.SFProFonts
import com.adnan.passwordmanager.presentation.theme.TitleTextColor

/**
 * Created by Adnan.
 */
@Composable
fun EmptyState(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Color.Gray.copy(alpha = 0.5f),
                modifier = Modifier.size(72.dp)
            )
            Text(
                text = stringResource(R.string.label_no_password_yet),
                fontFamily = SFProFonts,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = TitleTextColor.copy(alpha = 0.85f),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = stringResource(R.string.label_tap_button_to_add_password),
                fontFamily = SFProFonts,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = HintTextFieldColor,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}