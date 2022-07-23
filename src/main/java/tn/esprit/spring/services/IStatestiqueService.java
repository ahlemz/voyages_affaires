package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Statestique;

public interface IStatestiqueService { 
	 
	List<Statestique> retrieveAllStatestique(); 
	Statestique addStatestique(Statestique st);


} 
