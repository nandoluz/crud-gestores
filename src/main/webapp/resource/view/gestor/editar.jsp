<%-- 
    Document   : editar
    Created on : 16/01/2020, 11:50:50
    Author     : nando
--%>
<%@page import="model.bean.Gestor"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.dao.GestorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestores | Editar</title>        
        <script src="../../assets/jquery/jquery-3.4.1.js"></script>
        <script src="../../assets/jquery/popper.min.js"></script>
        <script src="../../assets/bootstrap/js/bootstrap.js"></script>
        <link href="../../assets/bootstrap/css/bootstrap.css" rel="stylesheet">        
        <link href="../../assets/css/custom.css" rel="stylesheet">        
        <link rel="icon" href="favicon.ico">
    </head>
    <body>        
        <%@include file="../menu.jsp" %>
        <div class="container">
            <h2>Cadastro de Gestor</h2>
            <hr>
            <div class="container col-8">
                
                <form action="/crud-gestores/gestorServlet.do" method="post">
                    <%  
                        GestorDAO dao = new GestorDAO();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Gestor gestor = dao.readOne(Integer.parseInt(request.getParameter("id")));
                    %>
                    <div class="form-group">
                        <label for="inputNome">Nome<span class="obrigatorio">*</span></label>
                        <input name="nome" value="<%=gestor.getNome()%>" type="text" class="form-control" id="inputNome" aria-describedby="nomeHelp" placeholder="Nome completo" required autofocus>
                        <small id="nomeHelp" class="form-text text-muted">Informe o nome completo do novo gestor.</small>
                    </div>
                    <div class="form-group">
                        <label for="inputMatricula">Matricula<span class="obrigatorio">*</span></label>
                        <input name="matricula" value="<%=gestor.getMatricula()%>" type="text" class="form-control" id="inputMatricula" aria-describedby="matriculaHelp" placeholder="XXX.XXX" required>
                        <small id="matriculaHelp" class="form-text text-muted">Este campo aceita letras e números.</small>
                    </div>
                    <div class="form-group">
                        <label for="inputData">Data de Nascimento<span class="obrigatorio">*</span></label>
                        <input name="data_nascimento" value="<%=sdf.format(gestor.getData_nascimento())%>" type="text" class="form-control" id="inputData" aria-describedby="dataHelp" placeholder="00/00/0000" required>
                        <small id="dataHelp" class="form-text text-muted">Se preferir pode usar o caledario ao lado.</small>
                    </div>
                    <div class="form-group">
                        <label for="inputSetor">Setor<span class="obrigatorio">*</span></label>
                        <select class="form-control" id="inputSetor" name="setor" required>
                            <option disabled value="" selected>selecione um setor</option>
                            <option value="Administrativo" <%if(gestor.getSetor().equals("Administrativo")){out.println("selected");}%> >Administrativo</option>
                            <option value="Tecnologia"<%if(gestor.getSetor().equals("Tecnologia")){out.println("selected");}%> >Tecnologia</option>
                            <option value="Recursos humanos" <%if(gestor.getSetor().equals("Recursos humanos")){out.println("selected");}%> >Recursos humanos</option>
                            <option value="Help desk" <%if(gestor.getSetor().equals("Help desk")){out.println("selected");}%> >Help desk</option>                          
                        </select>
                        <small id="setorHelp" class="form-text text-muted">Selecione o setor que será responsável</small>
                    </div>
                    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                    <input type="hidden" value="editar" name="action">
                    <br>
                    <div class="col-12 d-flex justify-content-center">
                        <button type="submit" class="btn btn-success btn-lg m-3 justify-content-center">Atualizar</button>
                        <a href="/crud-gestores/resource/view/gestor/listar.jsp" class="btn btn-danger btn-lg m-3">&nbsp;Cancelar&nbsp;</a>
                    </div>
                </form>
            </div>
        </div>
                    
        <script src='../../assets/js/jquery.mask.min.js'></script>
        <script>
            $(document).ready(function(){
                $("#inputData").mask("00/00/0000");
                $("#inputMatricula").mask("AAA.AAA");
            });
        </script>
    </body>
</html>
