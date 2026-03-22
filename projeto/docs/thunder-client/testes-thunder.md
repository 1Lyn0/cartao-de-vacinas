# 🧪 Documentação de Testes da API — Thunder Client

Este documento registra todos os testes realizados manualmente nos endpoints da API utilizando o Thunder Client.

---

# 🟥 Imunizações (`/imunizacao`)

**Inserir imunização**  
POST  
http://localhost:8080/imunizacao/inserir  
Body:
{
  "fabricante": "Pfizer",
  "lote": "ABC123",
  "local_aplicacao": "UBS Central",
  "profissional_aplicador": "Maria",
  "data_aplicacao": "2024-01-10"
}

**Alterar imunização**  
PUT  
http://localhost:8080/imunizacao/alterar/1

**Excluir imunização**  
DELETE  
http://localhost:8080/imunizacao/excluir/1

**Excluir todas de um paciente**  
DELETE  
http://localhost:8080/imunizacao/excluir/paciente/1

**Consultar por paciente**  
GET  
http://localhost:8080/imunizacao/consultar/paciente/1

**Consultar por período**  
GET  
http://localhost:8080/imunizacao/consultar/paciente/1/aplicacao/2024-01-01/2024-12-31

---

# 🟦 Vacinas (`/vacinas`)

**Listar todas as vacinas**  
GET  
http://localhost:8080/vacinas/consultar

**Consultar por faixa etária**  
GET  
http://localhost:8080/vacinas/consultar/faixa_etaria/ADULTO

**Consultar vacinas acima de X meses**  
GET  
http://localhost:8080/vacinas/consultar/idade_maior/12

---

# 🟧 Pacientes (`/paciente`)

**Excluir paciente e todo o histórico**  
DELETE  
http://localhost:8080/paciente/excluir/1

---

# 🟪 Estatísticas (`/estatisticas`)

**Total de imunizações**  
GET  
http://localhost:8080/estatisticas/imunizacoes/paciente/1

**Imunizações atrasadas**  
GET  
http://localhost:8080/estatisticas/imunizacoes_atrasadas/paciente/1

**Próximas imunizações**  
GET  
http://localhost:8080/estatisticas/proximas_imunizacoes/paciente/1

**Vacinas acima de idade**  
GET  
http://localhost:8080/estatisticas/imunizacoes/idade_maior/12

---

# ✔ Testes concluídos
Todos os endpoints acima foram validados manualmente no Thunder Client, garantindo que os métodos HTTP, rotas e respostas funcionam como esperado.