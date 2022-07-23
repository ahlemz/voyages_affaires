package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Invitation;

public interface InvitationRespository extends CrudRepository<Invitation, Long> {

}
