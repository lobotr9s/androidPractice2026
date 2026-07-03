package ru.itis.summer.practice26.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import ru.itis.summer.practice26.R
import ru.itis.summer.practice26.model.UserDataModel
import ru.itis.summer.practice26.model.UserProfileScreen
import ru.itis.summer.practice26.utils.DefaultPaddings

@Composable
fun UsersLazyColumnSample(
    usersData: List<UserDataModel>,
    navController: NavController,
) {
    LazyColumn(modifier = Modifier.padding(vertical = DefaultPaddings.vertical)) {
        items(
            count = usersData.size,
            key = { position -> usersData[position].id }
        ) { position ->
            val userData = usersData[position]

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable {
                        navController.navigate(
                            route = UserProfileScreen(userDataModel = userData)
                        )
                    }
            ) {
                AsyncImage(
                    model = userData.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = userData.userName,
                        fontSize = TextUnit(24f, TextUnitType.Sp),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    userData.lastSeen?.let { lastSeenTime ->
                        val lastSeenText = stringResource(R.string.users_list_last_seen_pattern, lastSeenTime)
                        Text(text = lastSeenText)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}