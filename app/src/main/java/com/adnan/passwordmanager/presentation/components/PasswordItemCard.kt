package com.adnan.passwordmanager.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adnan.passwordmanager.R
import com.adnan.passwordmanager.presentation.theme.DividerColor
import com.adnan.passwordmanager.presentation.theme.MarkedPasswordColor
import com.adnan.passwordmanager.presentation.theme.SFProFonts
import com.adnan.passwordmanager.presentation.theme.WhiteColor

/**
 * Created by Adnan.
 */
@Composable
fun PasswordItemCard(
    modifier: Modifier,
    title: String,
    onClick: () -> Unit
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .clickable(
                    onClick = onClick,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ), shape = RoundedCornerShape(40.dp),
            colors = CardDefaults.cardColors(
                containerColor = WhiteColor
            ), border = BorderStroke(width = 1.dp, color = DividerColor)
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontFamily = SFProFonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                    )
                    Box(modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 8.dp)) {
                        Text(
                            text = stringResource(R.string.masked_password),
                            fontFamily = SFProFonts,
                            fontWeight = FontWeight.Medium,
                            color = MarkedPasswordColor,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 12.dp)
                        )
                    }
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                )
            }
        }
    }
}