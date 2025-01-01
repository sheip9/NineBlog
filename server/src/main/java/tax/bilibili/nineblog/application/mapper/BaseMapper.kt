package tax.bilibili.nineblog.application.mapper

import org.mapstruct.InheritInverseConfiguration

interface BaseMapper<D, E, V> {
    @InheritInverseConfiguration
    fun dtoToEntity(dto: D): E

    @InheritInverseConfiguration
    fun entityToVo(entity: E): V
}