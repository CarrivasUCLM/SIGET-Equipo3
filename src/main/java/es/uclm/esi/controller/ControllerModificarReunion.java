package es.uclm.esi.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.json.JSONArray;
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

import es.uclm.esi.model.Asistente;
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
	@PostMapping(value = "/modificar")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> convocarReunion(@RequestBody Map<String, Object> entrada,
			@RequestHeader("Authorization") String token) {
		
		
		JSONObject modificar= new JSONObject();
		modificar.put("id", "11122");
		modificar.put("organizador","pepe");
		modificar.put("titurlo", "reunion modificada");
		//modificar.put("dia", 14);
		//modificar.put("mes", 12);
		//modificar.put("ano", 2020);
		modificar.put("descripcion", "modificada");
		
		
		
		JSONObject reu = new JSONObject(entrada);
		Optional<Reunion> optReunion = rReuniones.findById(modificar.getString("id"));
		
		//optReunion.set;
			// me saco del mongo el objeto
		//Optional<Reunion> optReunion = rReuniones.findById(id);
		/*String[] parts = reu.getString("fecha").split("-");
		ano = Integer.parseInt(parts[0]);
		mes = Integer.parseInt(parts[1]);
		dia = Integer.parseInt(parts[2]);
		
		*JSONArray asistentes = (JSONArray) reu.get("asistentes");
		ArrayList<Asistente> asistentesR = new ArrayList<>();
		boolean existe = false;
		for (int i = 0; i < asistentes.length(); i++) {
			String nombre = (String) asistentes.get(i);
			String estado = "pendiente";
			if(nombre.equals(nombreOrganizador)) {
				existe = true;
			}
			asistentesR.add(new Asistente(nombre,estado));
		}
		if(!existe) {
			asistentesR.add(new Asistente(nombreOrganizador,"aceptada"));
		}
		reunion.setAsistentes(asistentesR);
		*/
		// lo seteo y lo vuelvo a meter(se actualiza)
		//Optional<Reunion> optReunion = rReuniones.findById(id);
		
		//	rReuniones.save(reunion);
			return new ResponseEntity<>(HttpStatus.OK);
		
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	

}
