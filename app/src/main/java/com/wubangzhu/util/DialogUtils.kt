package com.wubangzhu.util

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.wubangzhu.R

public class DialogUtils {
    companion object {
        //用companion object包裹方法，实现java中static的效果
        public fun showCustomInputDialog(context: Context) {
            MaterialDialog(this).show {

                input()
                positiveButton(R.string.submit)
            }


        }
    }
}