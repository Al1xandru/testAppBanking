package org.web.bankingapp.converter;

import org.web.bankingapp.dto.UserResponseDto;
import org.web.bankingapp.entity.User;

public interface Converter <Entity, RequestDto, ResponseDto>{
    ResponseDto toDto(Entity entity);
    Entity toEntity(RequestDto requestDto);
    UserResponseDto toDto(User user, String roleAuthority);
}
