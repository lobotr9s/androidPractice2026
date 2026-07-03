package ru.itis.summer.practice26.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import coil3.compose.AsyncImage
import ru.itis.summer.practice26.R
import ru.itis.summer.practice26.model.UserDataModel
import ru.itis.summer.practice26.utils.DefaultPaddings

@Composable
fun UserProfileContent(
    userDataModel: UserDataModel
) {
    val horizontalPadding = DefaultPaddings.horizontal
    val verticalPadding = DefaultPaddings.vertical

    Column(modifier = Modifier.padding(top = verticalPadding)) {
        AsyncImage(
            model = userDataModel.imageUrl,
            contentDescription = stringResource(R.string.user_profile_content_desc),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
        )

        Spacer(modifier = Modifier.height(horizontalPadding))

        val text = userDataModel.description ?: stringResource(R.string.user_profile_no_desc)

        Text(
            text = text,
            fontSize = TextUnit(18f, TextUnitType.Sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
        )
    }
}