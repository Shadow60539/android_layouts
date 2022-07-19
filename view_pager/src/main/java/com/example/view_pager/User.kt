package com.example.view_pager

data class User (val name: String, val image: Int) {

    companion object {
        fun getUsers(): List<User> {
            val users = listOf<User>(
                User("User 1", R.drawable.user1),
                User("User 2", R.drawable.user2),
                User("User 3", R.drawable.user3),
                User("User 4", R.drawable.user4),
                User("User 5", R.drawable.user5),
                User("User 6", R.drawable.user6),
                User("User 7", R.drawable.user7),
                User("User 8", R.drawable.user8),
            )

            return users
        }
    }
}