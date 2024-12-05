import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class Produto(
    val codigoProduto: String,
    val nomeProduto: String,
    val descProduto: String,
    val estoque: Int
) : Parcelable{
    // Constructor for reading from Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",  // codigoProduto
        parcel.readString() ?: "",  // nomeProduto
        parcel.readString() ?: "",  // descProduto
        parcel.readInt()            // estoque
    )

    // Writing to Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codigoProduto)
        parcel.writeString(nomeProduto)
        parcel.writeString(descProduto)
        parcel.writeInt(estoque)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Produto> {
        override fun createFromParcel(parcel: Parcel): Produto {
            return Produto(parcel)
        }

        override fun newArray(size: Int): Array<Produto?> {
            return arrayOfNulls(size)
        }
    }
}
