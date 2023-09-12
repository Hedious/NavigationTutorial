package com.example.navigationtutorial

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
        fun passId(id: Int) = "detail_screen/$id"

        //fun passNameAndId(id: Int, name: String) = "detail_screen/$id/$name"
        fun passNameAndId(id: Int, name: String): String {
            return "detail_screen/$id/$name"
        }
    }

    object NewDetail :
        Screen(route = "detail_screen?id={$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}") {
        fun passNameAndId(id: Int = 1, name: String = "Albert"): String {
            return "detail_screen?id=$id&name=$name"
        }
    }
}
