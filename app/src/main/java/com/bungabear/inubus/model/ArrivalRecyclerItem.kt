package com.bungabear.inubus.model

/**
 * Created by Minjae Son on 2018-08-07.
 */

// Column Header, Section Header, ArrivalItem을 함께 담는 객체
class ArrivalRecyclerItem(
        val itemType : ItemType = ItemType.ArrivalInfo,
        val sectionHeader : ArrivalInfoModel.BusType? = null,
        val arrivalInfo: ArrivalInfoModel.BusArrivalInfo? = null
){
    constructor() : this(ItemType.Header)
    constructor(sectionHeader : ArrivalInfoModel.BusType) : this(ItemType.SectionHeader, sectionHeader)
    constructor(arrivalInfo: ArrivalInfoModel.BusArrivalInfo) : this(ItemType.ArrivalInfo, arrivalInfo = arrivalInfo)

    // RecyclerView's Multiple Type Enum
    enum class ItemType{
        Header,SectionHeader, ArrivalInfo;
        companion object {
            fun findByOridinal(value: Int): ItemType = ItemType.values().find { it.ordinal == value } ?: Header
        }
    }

    fun equals(other: ArrivalRecyclerItem): Boolean {
        return when(this.itemType){
            ItemType.Header -> other.itemType == ItemType.Header
            ItemType.SectionHeader -> this.sectionHeader == other.sectionHeader
            ItemType.ArrivalInfo -> if(other.arrivalInfo == null) false else this.arrivalInfo!!.no == other.arrivalInfo.no
        }
    }
}