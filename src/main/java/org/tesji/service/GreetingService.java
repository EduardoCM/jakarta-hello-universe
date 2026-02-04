package org.tesji.service;

import java.util.List;

import org.tesji.dao.GreetingDAO;
import org.tesji.dto.Greeting;

public class GreetingService {

	private GreetingDAO dao = new GreetingDAO();

	public void saveGreeting(String name, String email) throws Exception {
		dao.insert(name, email);
	}

	public List<Greeting> getGreetings() throws Exception {
		return dao.findAll();
	}

	public void delete(int id) throws Exception {
		dao.deleteById(id);
	}

	public void update(int id, String name) throws Exception {
		dao.updateName(id, name);
	}
	
	public Greeting getById(int id) throws Exception {
	    return dao.findById(id);
	}
}