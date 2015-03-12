package departamento;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Implementacion de las operaciones sobre los departamentos
 * 
 * @author Daniel
 * 
 */
public class ServicioDepartamentoImp implements ServicioDepartamento {

	protected EntityManager entityManager;

	public ServicioDepartamentoImp() {
		// crea una fábrica de EntityManagers
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("todos");

		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public int crearDepartamento(Departamento departamento) {

		entityManager.getTransaction().begin(); // empieza la transaccion

		// id = 0 para nueva tarea

		int id = 0; // id del departamento

		TypedQuery query = entityManager.createQuery(
				"SELECT d FROM Departamento d", Departamento.class); // ejecuta
																		// la
																		// consulta
		List<Departamento> departamentos = query.getResultList(); // obtiene la
																	// lista de
																	// departamentos

		for (Departamento d : departamentos) {
			if (d.getNombre().equals(departamento.getNombre())) { // mira si el
																	// nombre
																	// esta en
																	// algún
																	// departamento

				if (d.isActivo()) {
					id = -1;
				} else {
					// si existe pero no esta activo se da de alta ese con los nuevos datos
					id = d.getId();
					d.setActivo(true);
					d.setNombre(departamento.getNombre());
					entityManager.persist(d);
				}
			}
		}

		if (id >= 0) { // si el id es mayor o igual a 0 lo guarda

			//si id = 0 quiere decir que se crea uina nueva, no se reactiva
			if (id == 0) {

				entityManager.persist(departamento);
				entityManager.getTransaction().commit(); // realiza los cambios
				id = departamento.getId();
				
			} else {
				entityManager.getTransaction().commit(); // realiza los cambios
			}

		} else {
			entityManager.getTransaction().rollback(); // no realiza cambios
		}

		return id;
	}

	@Override
	public boolean bajaDepartamento(int id) {
		entityManager.getTransaction().begin(); // empieza la transaccion

		Departamento departamento = entityManager.find(Departamento.class, id,LockModeType.OPTIMISTIC);

		boolean correcto = false;

		if ((departamento != null) && (departamento.isActivo())) {

			// se comprueba si no tiene nigun empleado el departamento
			if (departamento.getLista_empleados().isEmpty()) {

				// si esta activo lo pone a false
				departamento.setActivo(false);
				entityManager.persist(departamento);
				correcto = true;

				entityManager.getTransaction().commit(); // realiza los cambios
			}
		} else {
			correcto = false;
			entityManager.getTransaction().rollback(); // no realiza cambios
		}

		return correcto;
	}

	@Override
	public Departamento buscarDepartamento(int id) {
		entityManager.getTransaction().begin(); // empieza la transaccion

		Departamento departamento = entityManager.find(Departamento.class, id,LockModeType.OPTIMISTIC);

		entityManager.getTransaction().commit(); // realiza los cambios

		Departamento departamentoAux = null;

		if ((departamento != null) && (departamento.isActivo())) {
			departamentoAux = departamento;
		}

		/*
		 * Otra manera? TypedQuery query = entityManager.createQuery(
		 * "SELECT d FROM Departamento d JOIN Empleado e", Departamento.class);
		 * // obtiene la lista // de empleado
		 * 
		 * List<Departamento> lista_departamentos = query.getResultList();
		 * 
		 * Departamento departamento = lista_departamentos.get(0);
		 * 
		 * if(!departamento.isActivo()){ //sino está activo se devuelve null
		 * departamento = null; }
		 */

		return departamentoAux;
	}

	@Override
	public Collection<Departamento> buscarTodosDepartamentos() {
		entityManager.getTransaction().begin(); // empieza la transaccion

		List<Departamento> lista_departamentos;

		TypedQuery query = entityManager.createQuery(
				"SELECT d FROM Departamento d WHERE d.activo = 1",
				Departamento.class); // obtiene los departamentos activos
		lista_departamentos = query.getResultList();

		entityManager.getTransaction().commit();

		return lista_departamentos;
	}

}
