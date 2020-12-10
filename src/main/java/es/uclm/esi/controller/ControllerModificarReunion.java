package es.uclm.esi.controller;

import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryReuniones;
import es.uclm.esi.repository.UserRepository;
import es.uclm.esi.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerModificarReunion {
	@Autowired
	RepositoryReuniones rReuniones;
	@Autowired
	UserRepository usuarios;
	@Autowired
	JwtUtils jwt;
	
	@Value("${siget.app.jwtSecret}")
	private String jwtSecret;
	@PostMapping(value = "/convocar")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> convocarReunion(@RequestBody Map<String, Object> entrada,
			@RequestHeader("Authorization") String token) {
		JSONObject reu = new JSONObject(entrada);
	
			// me saco del mongo el objeto
		//Optional<Reunion> optReunion = rReuniones.findById(id);
		
		// lo seteo y lo vuelvo a meter(se actualiza)
		//Optional<Reunion> optReunion = rReuniones.findById(id);
		
		//	rReuniones.save(reunion);
			return new ResponseEntity<>(HttpStatus.OK);
		
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	

}
