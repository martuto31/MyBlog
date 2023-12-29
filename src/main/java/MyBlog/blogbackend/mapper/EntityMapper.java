package MyBlog.blogbackend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EntityMapper<Entity, DTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DTO convertToDto(Entity entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public Entity convertToEntity(DTO dto, Class<Entity> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

}
