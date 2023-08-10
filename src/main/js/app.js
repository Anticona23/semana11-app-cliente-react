const React = require('react');
const ReactDOM = require('react-dom'); 

const client = require('./client'); 

class App extends React.Component { 

	constructor(props) {
		super(props);
		this.state = {instrumentos: [], musicos: []}; //solo se añade
	}

	componentDidMount() { 
		client({method: 'GET', path: '/api/instrumentos'}).done(response => {
			this.setState({instrumentos: response.entity._embedded.instrumentos});
		});

		
		client({method: 'GET', path: '/api/musicos'}).done(response => {
			this.setState({musicos: response.entity._embedded.musicos});
		});
	}

	render() { 
		return (
			<>
				<h2>Lista de Instrumentons</h2>
				<InstrumentoList instrumentos={this.state.instrumentos}/>
				<hr></hr>
				<h2>Lista de Musicos</h2>
				<MusicoList musicos={this.state.musicos}/>
			</>
		)
	}
}

//Listando Instrumento
class InstrumentoList extends React.Component{
	render() {
		const instrumentos = this.props.instrumentos.map(instrumento =>
			<Instrumento key={instrumento._links.self.href} instrumento={instrumento}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Nombre</th>
						<th>Categoria</th>
						<th>Descripcion</th>
					</tr>
					{instrumentos}
				</tbody>
			</table>
		)
	}
}

//Listando Musico
class MusicoList extends React.Component{
	render() {
		const musicos = this.props.musicos.map(musico =>
			<Musico key={musico._links.self.href} musico={musico}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Nombre</th>
					</tr>
					{musicos}
				</tbody>
			</table>
		)
	}
}

//Mostrando Instrumento
class Instrumento extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.instrumento.nombre}</td>
				<td>{this.props.instrumento.categoria}</td>
				<td>{this.props.instrumento.descripcion}</td>
			</tr>
		)
	}
}

//Mostrando Musico
class Musico extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.musico.nombre}</td>
			</tr>
		)
	}
}

ReactDOM.render(<App />, document.getElementById('react'))
