package network.omisego.omgwallet.screen.auth.balance

/*
 * OmiseGO
 *
 * Created by Phuchit Sirimongkolsathien on 22/9/2018 AD.
 * Copyright © 2017-2018 OmiseGO. All rights reserved.
 */

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.omisego.omisego.model.Balance
import co.omisego.omisego.model.WalletList
import network.omisego.omgwallet.base.StateViewHolderBinding
import network.omisego.omgwallet.databinding.ViewholderBalanceBinding
import network.omisego.omgwallet.extension.formatAmount
import network.omisego.omgwallet.extension.scaleAmount
import network.omisego.omgwallet.model.APIResult
import network.omisego.omgwallet.repository.LocalRepository
import network.omisego.omgwallet.repository.contract.BalanceDataRepository
import network.omisego.omgwallet.util.Event

class BalanceViewModel(
    private val localRepository: LocalRepository,
    private val remoteRepository: BalanceDataRepository
) : ViewModel(), StateViewHolderBinding<Balance, ViewholderBalanceBinding> {

    val liveBalanceClickEvent: MutableLiveData<Event<Balance>> by lazy { MutableLiveData<Event<Balance>>() }
    val liveResult: MutableLiveData<Event<APIResult>> by lazy { MutableLiveData<Event<APIResult>>() }

    override fun resolvePayloadBundle(bundle: Bundle): Balance? {
        return bundle.getParcelable("balance")
    }

    override fun bind(binding: ViewholderBalanceBinding, data: Balance) {
        binding.balance = data
        binding.viewModel = this
        binding.tvAmount.text = data.scaleAmount(2).formatAmount()
    }

    fun clear() = localRepository.deleteSession()

    fun isPrimaryToken(balance: Balance): Boolean {
        return balance.token.id == localRepository.loadTokenPrimary()
    }

    fun handleClickBalance(balance: Balance) {
        liveBalanceClickEvent.value = Event(balance)
    }

    fun loadLocalWallet() {
        localRepository.loadWallet(liveResult)
    }

    fun loadWallet() {
        remoteRepository.loadWallet(liveResult)
    }

    fun updateWallet(walletList: WalletList) {
        localRepository.saveWallets(walletList)
    }
}