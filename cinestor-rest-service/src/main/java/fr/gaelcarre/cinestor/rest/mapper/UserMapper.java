package fr.gaelcarre.cinestor.rest.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import fr.gaelcarre.cinestor.model.Message;
import fr.gaelcarre.cinestor.rest.dto.DTOMessage;

@Mapper
public abstract class UserMapper {

	public abstract fr.gaelcarre.cinestor.rest.dto.DTOUser userEntityToDto(fr.gaelcarre.cinestor.model.User entity);

	public abstract fr.gaelcarre.cinestor.model.User userDtoToEntity(fr.gaelcarre.cinestor.rest.dto.DTOUser dto);

	public abstract Set<DTOMessage> mapMessageEntitiesToDto(Set<Message> entities);

	public abstract Set<Message> mapMmessageDTOToEntities(Set<DTOMessage> dtos);

	public abstract DTOMessage messageEntityToDto(Message entity);

	public abstract Message messageDtoToEntity(DTOMessage dto);

}
