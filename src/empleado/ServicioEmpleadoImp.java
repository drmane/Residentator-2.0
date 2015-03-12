package empleado;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import tarea.Tarea;

import departamento.Departamento;

public class ServicioEmpleadoImp implements ServicioEmpleado {

	protected EntityManager entityManager;

	public ServicioEmpleadoImp() {
		// crea una fábrica de EntityManagers
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("todos");

		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public int crearEmpleado(Empleado empleado) {

		entityManager.getTransaction().begin(); // empieza la transaccion

		// id = 0 para nuevo empleado

		int id = 0; // id del empleado

		// comprueba que el departamento existe y esta activado

		TypedQuery query_2 = entityManager.createQuery(
				"SELECT d FROM Departamento d", Departamento.class); // ejecuta
																		// la
																		// consulta
		List<Departamento> departamentos = query_2.getResultList(); // obtiene
																	// la lista
																	// de
																	// departamentos

		Iterator<Departamento> it = departamentos.iterator();
		Departamento d;
		d = it.next();
		boolean terminado = false;

		while (it.hasNext() && !terminado) {

			// mira si el nombre esta en algún departamento

			if (d.getNombre().equals(empleado.getDepartamento().getNombre())) {
				terminado = true;
				// existe y no está activo
				if (!d.isActivo())
					id = -1;
			} else {
				// mira el siguiente elemento
				d = it.next();
			}

		}

		// comprueba que no hay empleados con el mismo dni

		TypedQuery query = entityManager.createQuery(
				"SELECT e FROM Empleado e", Empleado.class); // ejecuta la
																// consulta
		List<Empleado> empleados = query.getResultList(); // obtiene la lista de
															// departamentos

		for (Empleado e : empleados) {
			if (empleado.getDni().equals(e.getDni())) {
				if (e.isActivo()) {
					id = -3;
				} else {
					// si existe pero no esta activo se da de alta ese con los
					// nuevos datos
					id = e.getId();
					e.setActivo(true);
					e.setDni(empleado.getDni());
					e.setNombre_apellidos(empleado.getNombre_apellidos());
					e.setSalario(empleado.getSalario());

					e.setDepartamento(entityManager.find(Departamento.class,
							d.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT));
					entityManager.persist(e);
				}
			}

		}

		if (id >= 0) {// si el id es mayor o igual a 0 lo guarda

			// si id = 0 quiere decir que se crea uina nueva, no se reactiva
			if (id == 0) {
				empleado.setDepartamento(entityManager.find(Departamento.class,
						d.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT));

				entityManager.persist(empleado); // lo guarda en la BD
				entityManager.getTransaction().commit(); // realiza los cambios
				id = empleado.getId();
			}
			// Si se va a dar de alta , en vez de crear, no hace falta coger el
			// id
			else {

				entityManager.getTransaction().commit(); // realiza los cambios
			}

		} else {
			entityManager.getTransaction().rollback(); // no realiza cambios
		}

		return id;
	}

	@Override
	public boolean bajaEmpleado(int id) {
		entityManager.getTransaction().begin(); // empieza la transaccion
		Empleado empleado = entityManager.find(Empleado.class, id,
				LockModeType.OPTIMISTIC);
		boolean correcto = false;

		if (empleado != null) {
			// solo se borran los empleados que no tengan tareas
			if (empleado.getLista_tareas().isEmpty()) {
				empleado.setActivo(false); // baja logica

				// se elimina el empleado de ese departamento
				empleado.getDepartamento().getLista_empleados()
						.remove(empleado);

				entityManager.persist(empleado);
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
	public Empleado buscarEmpleado(int id) {
		entityManager.getTransaction().begin(); // empieza la transaccion
		Empleado e = entityManager.find(Empleado.class, id,
				LockModeType.OPTIMISTIC);

		if (e != null) {
			// si no esta activo el empleado no se muestra
			if (!e.isActivo()) {
				e = null;
			}

		}
		return e;

	}

	@Override
	public Collection<Empleado> buscarTodosEmpleados() {
		entityManager.getTransaction().begin();

		List<Empleado> lista_empleados;

		TypedQuery query = entityManager.createQuery(

		// obtiene la lista de empleado
				"SELECT e FROM Empleado e  WHERE e.activo = 1", Empleado.class);

		lista_empleados = query.getResultList();

		entityManager.getTransaction().commit();

		return lista_empleados;
	}

	@Override
	public int asignarTarea(Tarea tarea) {

		int id = 0;

		entityManager.getTransaction().begin();

		Empleado empleadoAasignar;

		// Busca empleado en BD
		int id_empleado = tarea.getLista_empleados().get(0).getId();

		empleadoAasignar = entityManager.find(Empleado.class, id_empleado,
				LockModeType.OPTIMISTIC);
		// se comprueba que existe el empleado con ese id

		// Busca Tarea en BD

		Tarea tareaAasignar = entityManager.find(Tarea.class, tarea.getId(),
				LockModeType.OPTIMISTIC);

		// no existe o no activo
		if (empleadoAasignar == null) {
			id = -1;
		} else if (!empleadoAasignar.isActivo()) {
			id = -1;
		} else {
			// comprueba que la tarea no está asginada al empleado
			for (Tarea t : empleadoAasignar.getLista_tareas()) {
				if (empleadoAasignar != null) {
					if (t.getId() == tareaAasignar.getId()) {
						id = -3;
					}

				}
			}
		}

		// no existe o no activo
		if (tareaAasignar == null) {
			id = -2;
		} else if (!tareaAasignar.isActivo()) {
			id = -2;
		} else {
			// comprueba que el empleado no está asignado a la tarea
			for (Empleado e : tareaAasignar.getLista_empleados()) {
				if (empleadoAasignar != null) {
					if (e.getId() == empleadoAasignar.getId()) {
						id = -4;
					}
				}
			}
		}

		// Los asigna a cada entidad

		if (id >= 0) { // sino hay error
			empleadoAasignar.getLista_tareas().add(tareaAasignar);
			tareaAasignar.getLista_empleados().add(empleadoAasignar);

			entityManager.persist(empleadoAasignar);
			entityManager.persist(tareaAasignar);

			entityManager.getTransaction().commit();

			id = tareaAasignar.getId();
		} else {
			entityManager.getTransaction().rollback();
		}

		return id;
	}

}
