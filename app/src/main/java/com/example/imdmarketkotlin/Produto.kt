import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

//Classe produto serializada para conseguir transferir por intent
@Serializable
data class Produto(
    var codigoProduto: String,
    var nomeProduto: String,
    var descProduto: String,
    var estoque: Int
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

    //Getters
    fun getCodigo() : String {
        return this.codigoProduto
    }

    fun getNome() : String{
        return this.nomeProduto
    }


    //Setters
    fun setNome(nomeProduto: String){
        this.nomeProduto = nomeProduto
    }

    fun setDesc(descProduto: String){
        this.descProduto = descProduto
    }

    /*fun setEstoque(estoque: Int){
        this.estoque = estoque
    }*/

}
