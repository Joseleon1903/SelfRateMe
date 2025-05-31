package self.rate.me.compose.application.note.data

data class Note(val id : Int,
                val title: String,
                val type: String,
                val content: String,
                val creationDate :String,
                val eventDate :String?,
                val billsDate :String?,
                val billsAmount: Double?
)