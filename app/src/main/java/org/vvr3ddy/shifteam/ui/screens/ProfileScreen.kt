package org.vvr3ddy.shifteam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileScreen private constructor() {

    companion object {
        val instance: ProfileScreen by lazy {
            ProfileScreen()
        }
    }

    @Composable
    fun ShowProfilePage(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.then(Modifier.fillMaxSize()),
            verticalArrangement = Arrangement.Top
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .defaultMinSize(minHeight = 200.dp)
                    .fillMaxHeight(0.25f)
                    .padding(16.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    Image(
                        imageVector = Icons.TwoTone.AccountCircle,
                        contentDescription = "Profile Image",
                        modifier = Modifier.size(96.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Text(
                            text = "Person Name",
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "Person Role",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            )
                            Text(
                                text = "Site Location ID",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.error
                                )
                            )
                        }
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Reports To: ")
                                }
                                append("Manager Name")
                            }
                        )
                    }
                }
            }
            Card(
                modifier = Modifier.fillMaxWidth()
                    // Compose seems to calculate the Max height
                    // as available max height - occupied height
                    // Hence, select 25% of the full height and not 25% of remaining height
                    .fillMaxHeight(0.25f/0.75f)
                    .padding(16.dp)
            ){

            }
        }
    }
}