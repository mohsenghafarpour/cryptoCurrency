package ir.digipay.cryptocurrency.data.pojo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "currency")
@Parcelize
data class CurrencyModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "symbol")
    val symbol: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "marketCap")
    val marketCap: Double,
    @ColumnInfo(name = "icon")
    val icon: String?,
    @ColumnInfo(name = "percentChange")
    val percentChange: Double,
    @ColumnInfo(name = "sortOrder")
    val sortOrder: Int
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        return other is CurrencyModel &&
                other.sortOrder == this.sortOrder &&
                other.id == this.id

    }

    fun equalsContent(other: Any?): Boolean {
        return other == this &&
                other is CurrencyModel &&
                other.name == this.name &&
                other.symbol == this.symbol &&
                other.icon == this.icon &&
                other.price == this.price &&
                other.marketCap == this.marketCap &&
                other.percentChange == this.percentChange

    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
