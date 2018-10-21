package rajatarora.com.startwithmvvm.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable


data class Avatar(
        val response: List<Response>,
        val code: Int) : Parcelable {

    @Entity(tableName = "avatars_local")
    data class Response(
            @PrimaryKey
            val id: Int,
            @ColumnInfo(name = "name")
            val name: String,
            @ColumnInfo(name = "avatar_url")
            val avtar_url: String) : Parcelable {

        constructor(source: Parcel) : this(
                source.readInt(),
                source.readString(),
                source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeInt(id)
            writeString(name)
            writeString(avtar_url)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Response> = object : Parcelable.Creator<Response> {
                override fun createFromParcel(source: Parcel): Response = Response(source)
                override fun newArray(size: Int): Array<Response?> = arrayOfNulls(size)
            }
        }
    }


    constructor(source: Parcel) : this(
            ArrayList<Response>().apply { source.readList(this, Response::class.java.classLoader) },
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(response)
        writeInt(code)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Avatar> = object : Parcelable.Creator<Avatar> {
            override fun createFromParcel(source: Parcel): Avatar = Avatar(source)
            override fun newArray(size: Int): Array<Avatar?> = arrayOfNulls(size)
        }
    }
}