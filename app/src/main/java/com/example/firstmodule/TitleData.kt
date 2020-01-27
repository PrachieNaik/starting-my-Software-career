package com.example.firstmodule


class TitleData(var number:String) : DisplayList {
    override fun getType(): ItemType {

        return ItemType.TITLE
    }
}