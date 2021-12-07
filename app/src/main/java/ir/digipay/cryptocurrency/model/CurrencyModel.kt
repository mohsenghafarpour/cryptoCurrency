package ir.digipay.cryptocurrency.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyModel(
    val id: Long,
    val name: String,
    val symbol: String,
    val price: Double,
    val marketCap: Double,
    val icon: String?,
    val percentChange: Double,
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
