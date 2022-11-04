package it.prova.gestionebigliettiweb.service;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;

public class BigliettoServiceImpl implements BigliettoService {
	
	private BigliettoDAO bigliettoDAO;

	@Override
	public void setBigliettoDao(BigliettoDAO bigliettoDao) {
		// TODO Auto-generated method stub
		this.bigliettoDAO = bigliettoDao;

	}

}
