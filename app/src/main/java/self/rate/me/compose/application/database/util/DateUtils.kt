package self.rate.me.compose.application.database.util

import android.os.Build
import androidx.annotation.RequiresApi
import self.rate.me.compose.application.utils.Constantes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
class DateUtils {

    companion object {

        fun daysBetween(startDateStr: String, endDateStr: String): Long {
            println("startDateStr: $startDateStr")
            println("startDateStr: $endDateStr")
            val formatter = DateTimeFormatter.ofPattern(Constantes.FOMATO_FECHA)
            val startDate = LocalDate.parse(startDateStr, formatter)
            val endDate = LocalDate.parse(endDateStr, formatter)
            return ChronoUnit.DAYS.between(startDate, endDate)
        }

        fun getCurrentDate(): String {
            val formatter = DateTimeFormatter.ofPattern(Constantes.FOMATO_FECHA)
            return LocalDate.now().format(formatter).toString()
        }
    }
}