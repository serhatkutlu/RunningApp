package com.androiddevs.runningappyt.DB

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverters
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class Converter {
    @TypeConverters
    fun toBitmap(bytes:ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }
    @TypeConverters
    fun fromBitmap(bitm:Bitmap):ByteArray{
        val outputStream=ByteArrayOutputStream()
        bitm.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return outputStream.toByteArray()
    }
}