package com.spring.course.persitence.mapper;

import com.spring.course.domain.Category;
import com.spring.course.persitence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") //Le decimos al mapeador que vamos a modelar un componente de spring
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "CategoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //Indica que la conversion a realizar es la inversa a la anterior.
    @Mapping(target = "productos", ignore = true) //porque no quise mapear la lista de productos
    Categoria toCategoria(Category category);
}
