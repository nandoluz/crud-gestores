<%-- 
    Document   : 404
    Created on : 14/01/2020, 14:26:31
    Author     : nando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <script src="/resource/assets/jquery/jquery-3.4.1.js"></script>
        <script src="/resource/assets/jquery/popper.min.js"></script>
        <script src="/resource/assets/bootstrap/js/bootstrap.js"></script>
        <link href="/resource/assets/bootstrap/css/bootstrap.css" rel="stylesheet">        
        <link href="/resource/assets/css/custom.css" rel="stylesheet">        
        <link rel="icon" href="/favicon.png">
        <title>404</title>
        <style >
            .pag404 {
              font-size: 15em;
              color: tomato;
            }
        </style>
    </head>
    <body class="text-center">
        <div class="container d-flex h-100 align-items-center">
            <div class="w-100">
                <h1 class="pag404">404</h1>
                <p class="lead">Não conseguimos encontrar sua pagina =(<br>Clique no botão abaixo para voltar ao inicio.</p>
                <a href="/" class="btn btn-primary">Vamos voltar</a>            
            </div>
        </div>
    </body>
</html>
