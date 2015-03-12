package query;

public class FactoryQueryImp extends FactoryQuery{

	@Override
	public Query generateQueryMostrarHabitaciones() {
		return new QueryMostrarHabitaciones();
	}

	@Override
	public Query generateQueryMostrarResidentes() {
		return new QueryMostrarResidentes();
	}

	@Override
	public Query generateQueryMostrarResidentesSuperanFacturas() {
		return new QueryMostrarResidentesSuperanFacturas();
	}

	@Override
	public Query generateQueryMostrarFacturas() {
		return new QueryMostrarFacturas();
	}

	@Override
	public Query generateQueryAsignarFacturas() {
		return new QueryAsignarFactura();
	}
}
