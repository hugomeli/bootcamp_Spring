Link Tracker é um sistema para rastrear e mascarar URLs no objetivo de poder
obter quantas vezes cada um dos links foi chamado, além de adicionar regras de
negócio para o funcionamento do redirecionamento.

Desenvolva uma aplicação usando Spring Boot com Maven que suporte os seguintes
casos de uso:

1. Crie um link: Endpoint POST para criar um link a partir de um URL válido e
   deve retornar um JSON com o linkId para usar no redirecionamento.
   
2. Redirecionamento: Dado um link (ej: http://localhost:8080/link/{linkId} ) faça
   um redirecionamento para o url mascarado. Contanto que o link seja válido.
   Caso o link seja inválido, retorna 404. (INVESTIGAR REDIRECT)
   
3. Estatísticas por link: Endpoint GET que fornece um link (exemplo:
   http://localhost:8080/metrics/{linkID} ) retorna a estatística do número de
   vezes que foi redirecionado.
   
4. Invalidar link: Endpoint POST para invalidar um link (exemplo:
   http://localhost:8080/invalidate/{linkID} )
   
5. Ao criar os links você deve ser capaz de adicionar uma senha que será um
   parâmetro de consulta ao chamar o redirecionamento.

Dica: Repositório a ser usado para armazenar informações, pode ser um
HashMap<Integer, LinkDTO> ou List<LinkDTO>