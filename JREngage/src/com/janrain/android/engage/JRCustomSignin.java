/*
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Copyright (c) 2012, Janrain, Inc.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification,
 *  are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation and/or
 *    other materials provided with the distribution.
 *  * Neither the name of the Janrain, Inc. nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 */

package com.janrain.android.engage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.janrain.android.engage.ui.JRProviderListFragment;

public abstract class JRCustomSignin {
    /* package */ View mView;
    /* package */ JRProviderListFragment mProviderListFragment;
    private Context mContext;
    
    private JRCustomSignin(){}
    
    public JRCustomSignin(Context context, JRProviderListFragment fragment) {
        mContext = context;
        mProviderListFragment = fragment;
    }
    
    public View doOnCreateView(Context context,
                               LayoutInflater inflater,
                               ViewGroup container,
                               Bundle savedInstanceState) {
        mView = onCreateView(context, inflater, container, savedInstanceState);
        return mView;
    }
    
    /**
     * This method should have no side effects as it may be called more than once per activity.
     * @param context The Context
     * @param inflater A LayoutInflater which can be used to inflate your layout file
     * @param container The ViewGroup to which your view will be attached
     * @param savedInstanceState Any state saved
     * @return Your custom sign-in view
     */
    public View onCreateView(Context context,
                             LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return null; 
    }

    public Activity getActivity() {
        return mProviderListFragment.getActivity();
    }

    public Resources getResources() {
        return mContext.getResources();
    }

    public String getString(int id) {
        return getResources().getString(id);
    }
    
    public String getString(int id, Object... formatArgs) {
        return getResources().getString(id, formatArgs);
    }
    
    public View getView() {
        return mView;
    }

    public void onResume() {}

    public void onPause() {}

    public void onSaveInstanceState(Bundle outState) {}

    public void onDestroy() {}

    public void finishJrSignin() {
        mProviderListFragment.finishJrSignin();
    }

    public void showProgressIndicator() {
        mProviderListFragment.showProgressDialogForCustomSignin();
    }

    public void dismissProgressIndicator() {
        mProviderListFragment.dismissProgressDialogForCustomSignin();
    }
}