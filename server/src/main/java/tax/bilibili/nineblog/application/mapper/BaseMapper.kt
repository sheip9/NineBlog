package tax.bilibili.nineblog.application.mapper

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapping

interface BaseMapper<D, E, V> {
    @InheritInverseConfiguration
    fun dtoToEntity(dto: D): E

    @InheritInverseConfiguration
    fun entityToVo(entity: E): V
}