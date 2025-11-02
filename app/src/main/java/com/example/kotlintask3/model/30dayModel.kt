package com.example.kotlintask3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ThirteenDayData(
    @StringRes val day :Int,
    @StringRes val title :Int,
    @DrawableRes val imageRecourse :Int,
    @StringRes val body :Int

)
