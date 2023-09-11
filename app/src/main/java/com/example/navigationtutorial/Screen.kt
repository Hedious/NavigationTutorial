package com.example.navigationtutorial

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "id"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
        fun passId(id: Int) = "detail_screen/$id"

        fun passNameAndId(id: Int, name: String) = "detail_screen/$id/$name"
    }
}
