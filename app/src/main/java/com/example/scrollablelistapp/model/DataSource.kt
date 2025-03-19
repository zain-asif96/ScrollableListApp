package com.example.scrollablelistapp.model
import com.example.scrollablelistapp.R


class DataSource() {
    fun loadDataSources(): List<FamousLandMark> {
        return listOf<FamousLandMark>(
            FamousLandMark(R.string.title1, R.string.description1, R.drawable.eiffeltower),
            FamousLandMark(R.string.title2, R.string.description2, R.drawable.great_wall_of_china),
            FamousLandMark(R.string.title3, R.string.description3, R.drawable.pyramids),
            FamousLandMark(R.string.title4, R.string.description4, R.drawable.statueofliberty),
            FamousLandMark(R.string.title5, R.string.description5, R.drawable.machupichchu),
            FamousLandMark(R.string.title6, R.string.description6, R.drawable.tajmahal),
            FamousLandMark(R.string.title7, R.string.description7, R.drawable.colosseum),
            FamousLandMark(R.string.title8, R.string.description8, R.drawable.christheredeemer),
            FamousLandMark(R.string.title9, R.string.description9, R.drawable.bigben),
            FamousLandMark(R.string.title10, R.string.description10, R.drawable.sydneyoperahouse)
        )
    }
}