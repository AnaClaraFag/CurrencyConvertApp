package com.example.currencyconvert.ui.allcurrencies

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconvert.core.utils.convertDoubleToMonetaryFormat
import com.example.currencyconvert.databinding.CurrencyListItemBinding
import okhttp3.internal.notifyAll

class CurrencyValueListAdapter(
    var hashMapOfSymbolAndValue: HashMap<String, Any>
) : RecyclerView.Adapter<CurrencyValueListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyValueListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrencyValueListViewHolder(
            CurrencyListItemBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return hashMapOfSymbolAndValue.size
    }

    private fun convertAnyInMonetaryFormat(item: Any) =
        item.toString().toDouble().convertDoubleToMonetaryFormat()

    override fun onBindViewHolder(holder: CurrencyValueListViewHolder, position: Int) {
        try {
            val keys: List<String> = hashMapOfSymbolAndValue.keys.toList()
            val key = keys[position]
            //holder.symbol = key
            val value = convertAnyInMonetaryFormat(hashMapOfSymbolAndValue[key] ?: 0)
            //holder.currencyValue = value
            holder.bind(key, value)

        } catch (e: Exception) {
            Log.e("LIST", "$e")
        }

    }

}


class CurrencyValueListViewHolder(
    val binding: CurrencyListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

 fun bind(coin: String, value: String){
     binding.currencyValue.text = coin
     binding.currencyName.text = value
 }
       /* var currencyValue =
        var symbol = */


}