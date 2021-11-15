package co.edu.udea.compumovil.listdetail.model

import co.edu.udea.compumovil.listdetail.R

data class Contact(
    var firstName: String,
    val lastName: String,
    var email: String){
    var imageUrl = R.drawable.ferry_land
}

