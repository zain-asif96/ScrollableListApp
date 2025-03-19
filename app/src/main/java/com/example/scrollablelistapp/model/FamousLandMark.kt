package com.example.scrollablelistapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FamousLandMark(
    @StringRes val titleID: Int,
    @StringRes val descriptionID: Int,
    @DrawableRes val imageID: Int,
)