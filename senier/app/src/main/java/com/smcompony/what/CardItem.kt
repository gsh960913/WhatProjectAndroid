package com.smcompony.what

class CardItem(var title: String?, var contents: String?, var image: Int) {
    override fun toString(): String {
        return "CardItem{" +
                "title='" + title + '\''.toString() +
                ", contents='" + contents + '\''.toString() +
                ", image=" + image +
                '}'.toString()
    }

}
