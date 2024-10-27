import React from 'react';
import Cadastro from './components/Cadastro';
import ListaParticipantes from './components/ListaParticipantes';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';

const App = () => {
    return (
        <div> 
            <h2>Gerenciador de Café da Manhã dos Colaboradores</h2>.                 
            <FontAwesomeIcon icon={faCoffee} size="3x" />
            <Cadastro />
            <ListaParticipantes />
        </div>
    );
};

export default App;