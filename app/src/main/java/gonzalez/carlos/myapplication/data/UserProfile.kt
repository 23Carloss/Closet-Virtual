package gonzalez.carlos.myapplication.data

data class UserProfile(
    val name: String,
    val email: String,
    val phone: String,
    val pfp: String? = null,
    val isBiometricsEnabled: Boolean = true
)

val sampleUserProfile = UserProfile(
    name = "Luis Pérez",
    email = "luis.perez08@gmail.com",
    phone = "+52 6442819732",
    isBiometricsEnabled = true
)