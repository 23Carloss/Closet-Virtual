package gonzalez.carlos.myapplication.data

import gonzalez.carlos.myapplication.R

data class UserProfile(
    val name: String,
    val email: String,
    val phone: String,
    val pfp: Int = R.drawable.profilepfp,
    val isBiometricsEnabled: Boolean = true
)

val sampleUserProfile = UserProfile(
    name = "Luis Pérez",
    email = "luis.perez08@gmail.com",
    phone = "+52 6442819732",
    pfp = R.drawable.profilepfp,
    isBiometricsEnabled = true
)