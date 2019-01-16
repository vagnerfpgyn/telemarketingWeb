package com.example.tmkweb.api.event.listenter;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tmkweb.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
			HttpServletResponse response = recursoCriadoEvent.getResponse();
			long codigo = recursoCriadoEvent.getCodigo();
			
			adicionarHeaderLocation(response, codigo);
			
	}

	private void adicionarHeaderLocation(HttpServletResponse response, long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				 .buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
	}

}
