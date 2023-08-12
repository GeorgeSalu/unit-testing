package br.com.barriga.service.external;

import br.com.barriga.domain.Conta;

public interface ContaEvent {

	public enum EventType { CREATED, UPDATED, DELETED };
	
	void dispatch(Conta conta, EventType type);
	
}
