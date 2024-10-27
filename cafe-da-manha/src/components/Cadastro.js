import React, { useState } from 'react';
import axios from 'axios';
import './Cadastro.css'; 


const Cadastro = () => {
    const [nome, setNome] = useState('');
    const [cpf, setCpf] = useState('');
    const [opcaoCafe, setOpcaoCafe] = useState('');
    const [dataCafe, setDataCafe] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/colaboradores', {
                nome,
                cpf,
                opcaoCafe,
                dataCafe,
            });
            alert('Colaborador cadastrado com sucesso!');
            // Resetar os campos
            setNome('');
            setCpf('');
            setOpcaoCafe('');
            setDataCafe('');
        } catch (error) {
            alert('Erro ao cadastrar colaborador: ' + error.response.data.message);
        }
    };

    return (
        <div>           
            <h2>Cadastrar Colaborador</h2>
            <form onSubmit={handleSubmit}>
                
                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
                <input
                   type="text"
                   placeholder="CPF (somente números)"
                   value={cpf}
                   onChange={(e) => {
                       // Remove qualquer caractere que não seja dígito
                       const onlyNumbers = e.target.value.replace(/\D/g, '');
                       // Limita a entrada a 11 dígitos
                       if (onlyNumbers.length <= 11) {
                           setCpf(onlyNumbers);
                       }
                   }}
                   maxLength="11"
                   required
                />
                <input
                
                    type="text"
                    placeholder="Opção de Café"
                    value={opcaoCafe}
                    onChange={(e) => setOpcaoCafe(e.target.value)}
                    required
                />
                <input
                    type="date"
                    value={dataCafe}
                    onChange={(e) => setDataCafe(e.target.value)}
                    min={new Date(new Date().setDate(new Date().getDate() + 1)).toISOString().split("T")[0]} // Define a data mínima como o dia seguinte
                    required
                />
                <button type="submit">Cadastrar</button>
            </form>
        </div>
        
    );
    
};
export default Cadastro;