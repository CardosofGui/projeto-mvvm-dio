package com.everis.listadecontatos.feature.listacontatos.viewmodel

import androidx.lifecycle.ViewModel
import com.everis.listadecontatos.application.ContatoApplication
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO
import com.everis.listadecontatos.feature.listacontatos.repository.ListaDeContatosRepository
import java.lang.Exception

class ListaDeContatosViewModel(
    var repository: ListaDeContatosRepository? = null
) {

    fun getListaDeContatos(
        busca: String,
        onSucesso: (List<ContatosVO>) -> Unit,
        onError: (Exception) -> Unit
    ){
        Thread(Runnable {

            repository?.requestListaDeContatos(
                busca,
                onSucesso = { list ->
                    onSucesso(list)
                },
                onError = { ex ->
                    onError(ex)
                }
            )

        }).start()
    }
}