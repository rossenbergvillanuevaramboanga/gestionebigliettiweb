package it.prova.gestionebigliettiweb.service;

import java.util.List;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoService {

	// questo mi serve per injection
	public void setBigliettoDao(BigliettoDAO bigliettoDAO);

	public List<Biglietto> listAll() throws Exception;

	public Biglietto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Biglietto input) throws Exception;

	public void inserisciNuovo(Biglietto input) throws Exception;

	public void rimuovi(Long id) throws Exception;

	public List<Biglietto> findByExample(Biglietto input) throws Exception;
}
