package com.conamobile.wincoweb.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.conamobile.wincoweb.tools.PlatformType
import com.conamobile.wincoweb.tools.getPlatformType

@Composable
fun ColumnRow(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    if (getPlatformType() == PlatformType.ANDROID || getPlatformType() == PlatformType.IOS) {
        Column(
            modifier = modifier,
            content = { content() },
            horizontalAlignment = Alignment.CenterHorizontally
        )
    } else {
        Row(
            modifier = modifier,
            content = { content() },
            verticalAlignment = Alignment.CenterVertically
        )
    }
}