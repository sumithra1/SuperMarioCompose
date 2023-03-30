package com.example.supermariocompose.ui

import com.example.domain.entity.Amiibo

data class HomeState(
    var isLoading:Boolean=false,
    var data:List<Amiibo>?=null,
    var error:String=""
)