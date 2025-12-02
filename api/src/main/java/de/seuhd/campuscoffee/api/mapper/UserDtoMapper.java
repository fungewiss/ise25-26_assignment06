package de.seuhd.campuscoffee.api.mapper;

import de.seuhd.campuscoffee.api.dtos.UserDto;
import de.seuhd.campuscoffee.domain.model.User;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@ConditionalOnMissingBean // prevent IntelliJ warning about duplicate beans
@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    //TODO: Implement user DTO mapper

    UserDto fromDomain(User source);
    User toDomain(UserDto source);
}