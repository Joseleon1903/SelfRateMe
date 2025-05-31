package self.rate.me.compose.application.note.mapper

import self.rate.me.compose.application.note.data.Note

class NoteFactory {

    companion object {

        fun toCreateNote(title: String,
                          type: String,
                          content: String,
                          creationDate :String): Note{
            return Note(
                id = 0,
                title = title,
                type = type,
                content = content,
                creationDate =creationDate,
                eventDate = null,
                billsDate = null,
                billsAmount = null
            )
        }

        fun toCreateEvent(title: String,
                         type: String,
                         content: String,
                         creationDate :String,
                         eventDate: String): Note{
            return Note(
                id = 0,
                title = title,
                type = type,
                content = content,
                creationDate =creationDate,
                eventDate = eventDate,
                billsDate = null,
                billsAmount = null
            )
        }

        fun toCreateBills(title: String,
                          type: String,
                          content: String,
                          creationDate :String,
                          billsDate: String,
                          billsAmount: Double): Note{
            return Note(
                id = 0,
                title = title,
                type = type,
                content = content,
                creationDate =creationDate,
                eventDate = null,
                billsDate = billsDate,
                billsAmount = billsAmount
            )
        }

    }
}