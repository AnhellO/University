<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Contacto.aspx.cs" Inherits="Contacto" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
<head>
        <meta charset="utf-8" />                      
        <meta name="author" content="Manuel Baronetti" />                  
        <title>Demo formulario de contacto</title>
        <!-- importamos hoja de estilos -->
        <link rel="stylesheet" type="text/css" href="styles/contacto.css" media="screen">
        <!-- importamos fuente -->
        <link href='http://fonts.googleapis.com/css?family=Alegreya+Sans+SC:300,400,300italic' rel='stylesheet' type='text/css'>
    </head>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<body>
    <div id="marcador">Contacto</div>
    <section>
        <br /><br />
        <p class="des">Para cualquier duda, aclaración, queja o sugerencia, escribenos a través del siguiente formulario!
        Todas tus dudas y preguntas serán atendidas a la brevedad posible. Por ello, cuenta con la calidad y el servicio que solamente
        PARNET S.A. de C.V. te ofrece! Estamos para tí!</p>
        <br /><br />
    </section>
        <div id="contactform">
            <!-- bloque confirmacion de envio oculto  -->
            <div id="c_information" class="hide">
                <p></p>
            </div>
            <!-- fin bloque confirmacion de envio -->
             
            <!-- inicio formulario -->
            <form id="c_form" name="contact">
                <div>
                  <label>
                    <p>Nombre</p>
                    <input name="nombre" id="c_name" type="text" class="c_input" placeholder="nombre..."/>
                  </label>
                  <br/>
                  <label>
                    <p>Email:</p>
                    <input name="email"  id="c_mail" type="text" class="c_input" placeholder="email..."/>
                  </label>
                </div>
                <label>
                  <p>Mensaje:</p>
                  <textarea name="mensaje"  id="c_msg" placeholder="mensaje..."></textarea>
                </label>
                <!-- boton enviar  -->
                <div id="c_btns">
                    <input name="send" onclick="cargaSendMail()" type="button" value="Enviar" class="btn-b" id="c_enviar"></input>
                </div>
            </form>
            <!-- fin formulario -->
      </div>
    </body>
</asp:Content>

