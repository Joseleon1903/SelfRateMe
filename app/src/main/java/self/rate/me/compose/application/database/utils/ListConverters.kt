package self.rate.me.compose.application.database.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListConverters {


    @TypeConverter
    fun fromList(list: MutableList<String?>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(value: String?): MutableList<String?> {
        val listType: Type? = object : TypeToken<MutableList<String?>?>() {}.getType()
        return Gson().fromJson(value, listType)
    }


}