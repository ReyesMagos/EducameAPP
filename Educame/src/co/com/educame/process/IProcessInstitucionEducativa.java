package co.com.educame.process;

import java.util.List;

import co.com.educame.modelo.entidades.InstitucionEducacionSuperior;

public interface IProcessInstitucionEducativa {

	public InstitucionEducacionSuperior saveInstitucionEducacionSuperior(
			InstitucionEducacionSuperior institucionEducacionSuperior);
	
	public List<InstitucionEducacionSuperior>findAllInstitucionEducacionSuperior();
}
