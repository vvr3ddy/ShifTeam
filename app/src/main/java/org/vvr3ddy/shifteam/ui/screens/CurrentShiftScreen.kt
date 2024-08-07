package org.vvr3ddy.shifteam.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

class CurrentShiftScreen private constructor() {
    companion object {
        val instance: CurrentShiftScreen by lazy {
            CurrentShiftScreen()
        }
    }

    @Composable
    fun ShowCurrentShift(modifier: Modifier = Modifier) {
        val taskScrollState = rememberScrollState()

        var isTaskCompleted  by remember { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.then(Modifier.fillMaxSize())
        ) {
            OutlinedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ){
                    Text(
                        text = "Today's Shift".toUpperCase(Locale.current),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        ),
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize(),
                        ){
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Text(
                                text = "Shift Progress".toUpperCase(Locale.current),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth()
                            )
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Text(
                                buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    ){
                                        append("Shift Duration: ",)
                                    }
                                    append("HH hours MM minutes")
                                },
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.error
                                        )
                                    ){
                                        append("Remaining: ")
                                    }
                                    append("HH hours MM minutes")
                                }
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            LinearProgressIndicator(
                                modifier = Modifier.fillMaxWidth(),
                                progress = { 0.75f },
                                color = MaterialTheme.colorScheme.onSecondary,
                                trackColor = MaterialTheme.colorScheme.secondary,
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = "00:00 AM",
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.error,
                                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                                    )
                                )
                                Text(
                                    text = "11:59 PM",
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                                    )
                                )
                            }
                        }
                    }
                    HorizontalDivider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp))
                    Text(
                        text = "Tasks to be completed".toUpperCase(Locale.current),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        )
                    )
                    HorizontalDivider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp))
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                            .scrollable(
                                state = taskScrollState,
                                enabled = true,
                                orientation = Orientation.Vertical
                            ),
                        colors = CardDefaults.outlinedCardColors(
                            containerColor = Color.Transparent,

                        )
                    ){
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            // TODO: Fix placeholder and add tasks based on API calls
                            items(10, key = { it }) {
                                TextButton(
                                    onClick = {
                                        isTaskCompleted = !isTaskCompleted
                                    },
                                    modifier = Modifier.padding(16.dp).fillMaxWidth()
                                ){
                                    Text(
                                        text = "Task $it",
                                        style = TextStyle(
                                            color = MaterialTheme.colorScheme.primary,
                                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                            textDecoration = if (isTaskCompleted) TextDecoration.LineThrough else TextDecoration.None
                                        ),
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                if(it < 9){
                                    HorizontalDivider(
                                        modifier = Modifier.padding(vertical = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        ElevatedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(0.40f)
                                .fillMaxHeight(0.5f),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = Color(0xFF119822),
                                contentColor = Color(0xFFEBF2FA)
                            )
                        ){
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Icon(
                                    imageVector = Icons.TwoTone.CheckCircle,
                                    contentDescription = "End Shift Button",
                                    modifier = Modifier
                                        .padding(end = 4.dp)
                                        .size(MaterialTheme.typography.bodyLarge.fontSize.value.dp)
                                )
                                Text(
                                    text = "End Shift",
                                    style = TextStyle(
                                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        ElevatedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(0.667f)
                                .fillMaxHeight(0.5f),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = MaterialTheme.colorScheme.error,
                                contentColor = MaterialTheme.colorScheme.onError
                            )
                        ){
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Icon(
                                    imageVector = Icons.TwoTone.CheckCircle,
                                    contentDescription = "Report SOS Button",
                                    modifier = Modifier
                                        .padding(end = 4.dp)
                                        .size(MaterialTheme.typography.bodyLarge.fontSize.value.dp)
                                )
                                Text(
                                    text = "Report SOS",
                                    style = TextStyle(
                                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}