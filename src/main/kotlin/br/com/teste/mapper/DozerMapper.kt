package br.com.teste.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

class DozerMapper {
    private val dozer: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun <O, D> parseObject(origin: O, destination: Class<D>): D {
        return dozer.map(origin, destination)
    }

    fun <O, D> parseListObject(origin: List<O>, destination: Class<D>): ArrayList<D> {
        var convertedList: ArrayList<D> = ArrayList()

        for (o in origin) {
            convertedList.add(dozer.map(o, destination))
        }

        return convertedList
    }
}