# <h1> Aplicativo Android para auxiliar no controle de produção<h1>

#### Durante o desenvolvimento atualizarei o diário;

### Lista TO DO;
- [x] inicialização do projeto e pacotes do AndroidStudio;
- [x] organização da estrutura do projeto;
- [x] definição do layout Main;
- [x] ajuste no fluxo inicial do aplicativo;
- [x] integração com o BD;
- [x] fluxo do cadastro;
- [ ] opções de ações nas listas;
- [ ] função de calculo, adição e edição de produção diario;
- [ ] inserção de gastos;
- [ ] função de calculo, rendimento/retorno(mensal);

#
#

# Diário



### Dia 1 

Criei o projeto no AS, editei algumas coisas no mainActivity e fiquei com dor de cabeça por causa
do git, o camando `git push - u origin <branch>` nao me permitia trocar pra outra branch remota além
da master, depois de pesquisar um bom tempo achei uma solução no
stackoverflow usando `git push origin HEAD:<branch>`.

### Dia 2

Depois de organizar a pastas e dividir as classes nelas, criei e configurei os botoes FAB das listas
de funcionários e também dos Modelos, também organizei o layout das views dessas activitys, ainda
falta o BD para preencher elas e depois começar a fazer as opções de delete e edit, eu poderia
fazer um DAO, mas nesse caso seria como ficar indo e voltando, depois eu faço uns 2 modelos
estáticos pra teste.

### Dia 3

Comecei a criação do BD usando o SQLite nativo e um método de entidades e repositório, fiz os métodos
inserir, editar, excluir e buscar todos. Foi um pouco demorado por que eu não sabia como fazer essas
partes, já estou ficando habituado a ler a sugestão de código para ver quais são os parâmetros para
preencher os métodos. Ainda não compreendo muito bem ContentValue, quero dizer eu sei que ele
armazena valores, mas seu uso ainda não é algo intuitivo para mim, talvez seja também por causa dos
métodos do SQLiteDatabase que tem muita novidade para mim. Foi legal usar o StringBuilder ao invés
de concatenar Strings, isso eu não aprendi na faculdade.

### Dia 4

Finalizei a integração com o banco de dados por hora, organizei o layout das caixas de texto nas 
activitys de cadastro de funcionario e modelo. Foi bem tranquilo o dia de hoje também por que as 
aulas da faculdade voltaram essa semana.

### Dia 5

Adicionei os botões de salvar e cancelar aos cadastros e fiz uma validação de campos, refatorei
algumas IDs e o nome de algumas activitys, agora o próximo passo é fazer o botão salvar enviar os dados 
para o BD e depois retornar eles para exibir na tela de listas. Por enquanto está sendo bem tranquilo, 
segui alguns tutorias para fazer algumas partes que não sabia. Existem muitas bibliotecas no Java, não
tem como já sair fazendo, é preciso conhecer algumas técnicas e ferramentas, coisa que só se aprende com
experiência mesmo.
