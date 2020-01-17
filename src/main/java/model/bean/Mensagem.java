/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author nando
 */
public class Mensagem {
    public static String error(){
        String mensagem;
        mensagem = ""
                + "<!DOCTYPE html>"
                + "<html lang='pt-br'>"
                + "<head>"
                + "<title>Sucesso</title>"
                + "<script src='resource/assets/jquery/jquery-3.4.1.js'></script>"
                + "<script src='resource/assets/js/sweetalert.js'></script>"
                + "<script>"
                + "     $(document).ready(function(){"
                + "     const Toast = Swal.mixin({"
                + "         timer: 2000,"
                + "         timerProgressBar: true,"
                + "         onClose: (toast) => {"
                + "             window.location.href = '/crud-gestores/resource/view/gestor/novo.jsp'"
                + "         }"
                + "     });"
                + "     Toast.fire({"
                + "         icon: 'error',"
                + "         title: 'Erro!',"
                + "         text: 'Ação não realizada'"
                + "     })"
                + "     })"
                + "</script>"
                + "</head>"
                + "<body>"
                + "</body>"
                + "</html>";
        return mensagem;
    }
    
    public static String success(){
        String mensagem;
        mensagem = ""
                + "<!DOCTYPE html>"
                + "<html lang='pt-br'>"
                + "<head>"
                + "<title>Sucesso</title>"
                + "<script src='resource/assets/jquery/jquery-3.4.1.js'></script>"
                + "<script src='resource/assets/js/sweetalert.js'></script>"
                + "<script>"
                + "     $(document).ready(function(){"
                + "     const Toast = Swal.mixin({"
                + "         timer: 2000,"
                + "         timerProgressBar: true,"
                + "         onClose: (toast) => {"
                + "             window.location.href = '/crud-gestores/resource/view/gestor/listar.jsp'"
                + "         }"
                + "     });"
                + "     Toast.fire({"
                + "         icon: 'success',"
                + "         title: 'Sucesso!',"
                + "         text: 'Ação realizada com sucesso'"
                + "     })"
                + "     })"
                + "</script>"
                + "</head>"
                + "<body>"
                + "</body>"
                + "</html>";
        return mensagem;
    }
}
