package co.listdetail.model

import co.listdetail.R

data class Contact(
    var firstName: String,
    val lastName: String,
    var descriptionItem: String,
    var email: String){
    var imageUrl = R.drawable.ferry_land
}

