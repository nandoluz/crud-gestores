<%-- 
    Document   : menu
    Created on : 14/01/2020, 22:45:40
    Author     : nando
--%>
<!-- inicio do menu -->
    <nav class="navbar navbar-expand-md navbar-dark bg-primary fixed-top">
        <a class="navbar-brand" href="/crud-gestores">GESTORES</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/crud-gestores">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="/crud-gestores" id="gestoresDrop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestor</a>
                    <div class="dropdown-menu" aria-labelledby="gestoresDrop">
                        <a class="dropdown-item" href="novo.jsp">Novo</a>
                        <a class="dropdown-item" href="listar.jsp">Listar</a>
                    </div>
                </li>
            </ul>
            <form action="/crud-gestores/resource/view/gestor/busca.jsp" class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Pesquisa gestor" name="por" aria-label="pesquisar gestor">
                <input type="hidden" name="action" value="pesquisar">
                <button class="btn btn-dark my-2 my-sm-0" type="submit">Pesquisar</button>
            </form>
        </div>
    </nav>
    <!-- fim do menu -->
    
    <div class="espaco-menu"></div>