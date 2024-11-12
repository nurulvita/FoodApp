package com.example.foodapp.data

import com.example.foodapp.R

object DataSource {
    val foodList = listOf(
        Food("1", "Pizza", "Adonan yang renyah dan keemasan, dipenuhi dengan keju mozzarella yang meleleh, saus tomat pedas, dan berbagai topping gurih seperti pepperoni, zaitun, jamur, dan paprika. Perpaduan rasa yang sempurna di setiap gigitan.", R.drawable.pizza, FoodCategory.MainCourse, 50000),
        Food("2", "Burger", "Patty daging sapi yang juicy dan dipanggang sempurna, disajikan di antara roti yang empuk dan dipanggang, dengan tambahan selada segar, tomat matang, bacon renyah, dan keju meleleh. Disajikan dengan kentang goreng yang renyah sebagai pelengkap makanan yang nyaman.", R.drawable.burger, FoodCategory.MainCourse, 40000),
        Food("3", "Pasta", "Pasta Italia yang lezat, dilapisi dengan saus tomat yang kaya dan asam, terbuat dari tomat matang, bawang putih, dan sedikit basil. Dihiasi dengan keju Parmesan parut segar, hidangan ini merupakan kombinasi rasa dan tekstur yang memuaskan.", R.drawable.pasta, FoodCategory.MainCourse, 45000),
        Food("4", "Sushi", "Rol sushi yang segar dan lembut, diisi dengan potongan ikan mentah premium, seperti salmon dan tuna, dipadukan dengan sayuran renyah seperti mentimun dan alpukat. Disajikan dengan kecap asin, wasabi, dan jahe acar untuk pengalaman Jepang yang otentik.", R.drawable.sushi, FoodCategory.Appetizers, 60000),
        Food("5", "Salad", "Campuran segar dari daun hijau seperti bayam, selada, dan arugula, dipadukan dengan sayuran berwarna-warni seperti wortel, mentimun, dan tomat ceri. Disiram dengan saus vinaigrette ringan untuk rasa yang segar dan menyehatkan.", R.drawable.salad, FoodCategory.Appetizers, 30000),
        Food("6", "Es Krim", "Es krim yang halus dan krimi, terbuat dari bahan-bahan terbaik. Pilih dari rasa klasik seperti vanila dan coklat, atau nikmati rasa buah segar seperti stroberi dan mangga. Hidangan penutup yang menyegarkan di hari panas.", R.drawable.ice_cream, FoodCategory.Desserts, 25000),
        Food("7", "Steak", "Steak yang dipanggang sempurna dengan kulit yang garing dan bagian tengah yang lembut dan juicy. Dibumbui dengan campuran rempah dan herba, disajikan dengan sayuran panggang dan kentang tumbuk, menjadikannya hidangan yang berat dan memuaskan.", R.drawable.steak, FoodCategory.MainCourse, 120000),
        Food("8", "Sandwich", "Sandwich yang lezat terbuat dari roti yang baru dipanggang, diisi dengan lapisan ham, keju leleh, selada renyah, dan tomat juicy. Sempurna untuk makan siang cepat dan mengenyangkan, disajikan dengan acar renyah.", R.drawable.sandwich, FoodCategory.MainCourse, 35000),
        Food("9", "Kentang Goreng", "Kentang goreng yang keemasan dan renyah, terbuat dari kentang yang baru dipotong, digoreng dengan sempurna dengan lapisan garam ringan di luar. Cocok sebagai lauk atau camilan, sempurna untuk dicelupkan ke dalam saus sambal, mayones, atau saus favorit lainnya.", R.drawable.fries, FoodCategory.Appetizers, 20000),
        Food("10", "Sup", "Sup hangat dan memuaskan yang terbuat dari campuran sayuran, rempah-rempah, dan bumbu. Baik itu sup tomat klasik, kaldu ayam yang kaya, atau sup kentang leek yang krimi, hidangan ini adalah makanan kenyamanan terbaik, cocok untuk dinikmati di hari yang dingin.", R.drawable.soup, FoodCategory.MainCourse, 35000)
    )
}
