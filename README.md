# Orcamento-BackEnd
**v1.1.0**

MUDANÇAS
- **/users**
  - POST **/login** - Retorna um token e cria um cookie;

**v1.0.0**

NOVO
- **/modelo**
    - GET **/all** - Retorna todos os modelos de vidros;
    - GET **/{id}** - Retorna um modelo especifico;
    - POST **/add** - Retorna o modelo adicionado;
    - PUT **/edit/{id}** - Retorna o modelo editado se existente;
    - DEL **/del/{id}** - Retorna sucesso se a remoção der certo;
 
- **/users**
  - POST **/register** - Retorna o usuario registrado;
  - POST **/login** - Retorna sucesso e cria um cookie;
  - GET **/logout** - Retorna sucesso e deleta o cookie;
  - GET **/me** - Retorna usuario atual;