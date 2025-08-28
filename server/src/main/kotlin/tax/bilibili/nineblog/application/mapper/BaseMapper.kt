package tax.bilibili.nineblog.application.mapper

import org.mapstruct.*

interface BaseMapper<D, E, V> {
    @InheritInverseConfiguration
    fun dtoToEntity(dto: D): E

    @InheritInverseConfiguration
    fun entityToVo(entity: E): V

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun merge(@MappingTarget target: E, source: E): E

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun mergeFromDto(@MappingTarget target: E, source: D): E
}