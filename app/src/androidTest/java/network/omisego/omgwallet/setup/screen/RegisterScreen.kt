package network.omisego.omgwallet.setup.screen

import com.agoda.kakao.edit.KTextInputLayout
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import network.omisego.omgwallet.R
import network.omisego.omgwallet.setup.custom.KScrollView

/*
 * OmiseGO
 *
 * Created by Phuchit Sirimongkolsathien on 5/10/2018 AD.
 * Copyright © 2017-2018 OmiseGO. All rights reserved.
 */
class RegisterScreen : Screen<RegisterScreen>() {
    val scrollView: KScrollView = KScrollView {
        withId(R.id.scrollView)
    }
    val tilFullname: KTextInputLayout = KTextInputLayout {
        withId(R.id.tilFullname)
    }
    val tilEmail: KTextInputLayout = KTextInputLayout {
        withId(R.id.tilEmail)
    }
    val tilPassword: KTextInputLayout = KTextInputLayout {
        withId(R.id.tilPassword)
    }
    val tilRetypePassword: KTextInputLayout = KTextInputLayout {
        withId(R.id.tilRetypePassword)
    }
    val btnSignUp: KButton = KButton {
        withId(R.id.btnSignUp)
    }
}
