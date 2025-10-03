package com.conamobile.wincoweb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.conamobile.wincoweb.components.DefaultBlue
import com.conamobile.wincoweb.components.HoverableText
import com.conamobile.wincoweb.tools.PlatformType
import com.conamobile.wincoweb.tools.getPlatformType
import com.conamobile.wincoweb.tools.isPortrait
import com.conamobile.wincoweb.types.LanguageType
import org.jetbrains.compose.resources.painterResource
import wincoweb.composeapp.generated.resources.Res
import wincoweb.composeapp.generated.resources.cover_image
import wincoweb.composeapp.generated.resources.ic_globe
import wincoweb.composeapp.generated.resources.winco_logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var selectedLanguage by remember { mutableStateOf(LanguageType.EN) }
    val uriHandler = LocalUriHandler.current

    MaterialTheme {
        if (isPortrait()) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color(0xFFF8F9FD),
                topBar = {
                    TopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.White,
                            scrolledContainerColor = Color(0xFFF8F9FD)
                        ),
                        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                        title = {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    modifier = Modifier.padding(4.dp).size(55.dp),
                                    painter = painterResource(Res.drawable.winco_logo),
                                    contentDescription = "Winco Logo"
                                )
                                Spacer(Modifier.weight(1f))
                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    HoverableText(
                                        modifier = Modifier.padding(4.dp),
                                        text = "Why Winco?",
                                        fontSize = 16.sp,
                                        color = Color(0xFF717179),
                                        hoverColor = DefaultBlue
                                    )
                                    HoverableText(
                                        modifier = Modifier.padding(4.dp),
                                        text = "Prices",
                                        fontSize = 16.sp,
                                        color = Color(0xFF717179),
                                        hoverColor = DefaultBlue
                                    )
                                    HoverableText(
                                        modifier = Modifier.padding(4.dp),
                                        text = "Company",
                                        fontSize = 16.sp,
                                        color = Color(0xFF717179),
                                        hoverColor = DefaultBlue
                                    )
                                    HoverableText(
                                        modifier = Modifier.padding(4.dp),
                                        text = "Contact Us",
                                        fontSize = 16.sp,
                                        color = Color(0xFF717179),
                                        hoverColor = DefaultBlue
                                    )
                                }
                                Spacer(Modifier.weight(1f))
                                Box(
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .dropShadow(
                                            shape = RoundedCornerShape(13.5.dp),
                                            shadow = Shadow(
                                                radius = 4.dp,
                                                spread = 1.4.dp,
                                                color = Color.LightGray.copy(.6f),
                                            )
                                        )
                                        .clip(RoundedCornerShape(13.dp))
                                        .background(Color.White),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        modifier = Modifier.padding(6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(Res.drawable.ic_globe),
                                            contentDescription = null,
                                            tint = DefaultBlue
                                        )
                                        Spacer(Modifier.width(6.dp))
                                        Text(
                                            modifier = Modifier,
                                            text = selectedLanguage.name,
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                Spacer(Modifier.width(4.dp))
                                Box(
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .clip(RoundedCornerShape(13.dp))
                                        .background(Color(0xFFF2F3F5))
                                        .clickable {
                                            when (getPlatformType()) {
                                                PlatformType.ANDROID -> {
                                                    uriHandler.openUri("https://play.google.com/store/apps/details?id=com.conamobile.romchi2&hl=en")
                                                }

                                                PlatformType.IOS -> {
                                                    uriHandler.openUri("https://apps.apple.com/uz/app/romchi/id6742743588")
                                                }

                                                else -> {
                                                    uriHandler.openUri("https://t.me/romchi_rasmiy")
                                                }
                                            }
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        modifier = Modifier.padding(6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            modifier = Modifier.padding(horizontal = 2.dp),
                                            text = "Download App",
                                            fontSize = 14.sp,
                                            color = DefaultBlue,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                Spacer(Modifier.width(4.dp))
                            }
                        }
                    )
                },
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .safeContentPadding()
                        .fillMaxSize()
                ) {
                    item {
                        Spacer(Modifier.height(50.dp))
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Winco - Best Solution for your business",
                                fontSize = 30.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    item {
                        Spacer(Modifier.height(20.dp))
                    }
                    item {
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(Res.drawable.cover_image),
                            contentDescription = null,
                        )
                    }
                    item {
                        Spacer(Modifier.height(20.dp))
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Soon more information will be here...",
                                fontSize = 20.sp,
                                color = Color.Black,
                            )
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(Modifier.height(20.dp))
                }
                item {
                    Image(
                        modifier = Modifier.padding(4.dp).size(70.dp),
                        painter = painterResource(Res.drawable.winco_logo),
                        contentDescription = "Winco Logo"
                    )
                }
                item {
                    Spacer(Modifier.height(20.dp))
                }
                item {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(Res.drawable.cover_image),
                        contentDescription = null,
                    )
                }
                item {
                    Spacer(Modifier.height(20.dp))
                }
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Winco - Best Solution for your business",
                            fontSize = 30.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                item {
                    Spacer(Modifier.height(10.dp))
                }
                item {
                    Box(
                        modifier = Modifier
                            .padding(6.dp)
                            .clip(RoundedCornerShape(13.dp))
                            .background(Color(0xFFF2F3F5))
                            .clickable {
                                when (getPlatformType()) {
                                    PlatformType.ANDROID -> {
                                        uriHandler.openUri("https://play.google.com/store/apps/details?id=com.conamobile.romchi2&hl=en")
                                    }

                                    PlatformType.IOS -> {
                                        uriHandler.openUri("https://apps.apple.com/uz/app/romchi/id6742743588")
                                    }

                                    else -> {
                                        uriHandler.openUri("https://t.me/romchi_rasmiy")
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 6.dp),
                                text = "Download App",
                                fontSize = 14.sp,
                                color = DefaultBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                item {
                    Spacer(Modifier.height(20.dp))
                }
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Soon more information will be here...",
                            fontSize = 20.sp,
                            color = Color.Black,
                        )
                    }
                }
            }
        }
    }

}