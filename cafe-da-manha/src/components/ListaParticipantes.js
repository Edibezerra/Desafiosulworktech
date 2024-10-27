import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './ListaParticipantes.css'; // Importa o arquivo CSS

const ListaParticipantes = () => {
    const [colaboradores, setColaboradores] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const fetchColaboradores = async () => {
        try {
            const response = await axios.get('http://localhost:8080/colaboradores');
            setColaboradores(response.data);
        } catch (err) {
            setError('Erro ao buscar colaboradores. Tente novamente mais tarde.');
            console.error(err);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchColaboradores();
    }, []);

    if (loading) {
        return <div>Carregando...</div>; // Mensagem de loading
    }

    if (error) {
        return <div>{error}</div>; // Mensagem de erro
    }

    return (
        <div>
            <h2>Lista de Participantes</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Opção de Café</th>
                        <th>Data do Café</th>
                    </tr>
                </thead>
                <tbody>
                    {colaboradores.length > 0 ? (
                        colaboradores.map((colaborador) => (
                            <tr key={colaborador.id}>
                                <td>{colaborador.nome}</td>
                                <td>{colaborador.cpf}</td>
                                <td>{colaborador.opcaoCafe}</td>
                                <td>{colaborador.dataCafe}</td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="4">Nenhum participante encontrado.</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
};

export default ListaParticipantes;
