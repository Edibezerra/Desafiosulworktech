# Sistema de Organização de Café da Manhã

Esta aplicação web tem como objetivo organizar cafés da manhã colaborativos, onde cada participante registra o que pretende trazer, evitando conflitos e garantindo diversidade de itens. Feita em **Java (REST)** para o backend, permite registro seguro e verificação dos itens.

## Funcionalidades
- **Registro de Participantes**: Cada colaborador pode registrar o nome, CPF e o que pretende trazer para o café da manhã.
- **Controle de Itens**: A aplicação garante que um item não seja trazido duas vezes no mesmo dia, promovendo diversidade.
- **Validação de Data**: Apenas datas futuras podem ser selecionadas, e o sistema confirma no dia se o colaborador trouxe o item.
- **Sistema de Validação e Mensagens**: Verificação de dados obrigatórios, como CPF único e com 11 dígitos, e exclusividade de itens para cada data específica.

## Tecnologias Utilizadas
- **Backend**: Java (REST API)
- **Banco de Dados**: SQL (usando NativeQuery para inserção, consulta, atualização e exclusão)
- **Frontend**: Tecnologia à escolha (React, Angular, ou similar)
- **IDE Recomendadas**: Eclipse, STS ou Visual Studio Code

## Requisitos
- **Não permitir CPF duplicado**: Cada colaborador deve ter um CPF único e válido (11 dígitos).
- **Exclusividade de itens por data**: Um item não pode ser duplicado no mesmo dia, mesmo por colaboradores diferentes.
- **Validação de datas**: Apenas datas futuras são permitidas para o evento.


