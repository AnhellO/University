<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Principal.aspx.cs" Inherits="Principal" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <!DOCTYPE HTML>
    <head>
        <link rel="stylesheet" type="text/css" href="styles/principal.css" />
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <title>Página Principal</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Página Principal</div>
        <section>
            <article>
                <!-- Start Animation Code from html5maker.com -->
                    <iframe height="215" width="700" src="https://cdn.html5maker.com/43e5bcc7c927a10a51ea098e660e2f82b60159419609.html" frameborder="0" scrolling="no" allowTransparency="true"></iframe>
                <!-- End Animation Code -->
            </article>
            
        </section>
        <section>
            <img id="img1" style="float: left;" hspace="15" src="images/IMG_content.png" />
            <h3>¿Cual es el objetivo principal de PARNET?</h3>
            <p>Nuestra empresa tiene como objetivo suministrar soluciones integrales en telecomunicaciones (voz y datos), electricas que 
                resulevan las necesidades empresariales con productos, aplicaciones, servicios y tecnologia de punta, la cual simplifique el trabajo al usuario
                final obteniendo una comunicacion eficiente, de alta confiablidad, incrementando los indices de productividad y competitividad
                de su empresa y del personal de la misma.</p>
            <p>Las fibras opticas y los sistemas de comunicaciones , comstituyen el desarrollo tecnologico mas importante de los ultimos años.</p>
            
        </section>
        <section>
            <img id="img2" style="float:left;" hspace="15" src="images/IMGcontent2_03.png" />
            <h3>¿Hay buena energia dentro de su empresa?</h3>
            <p>Normalmente, las personas y los encargados de la informatica en las empresas ven en los virus a los principales enemigos a 
                combatir en aras de no perder informacion del negocio. No obstante, segun la empresa de seguridad energetica APC, el 60 por
                ciento de los daños de los equipos y la desaparicion de datos en los computadores es ocasionada por problemas asociados a la
                enrgia electrica.
            </p>
            <p>Picos, sobrevoltajes, trasientes, interrupciones, apagones y distorciones, entre otros, son algunos de los males mas comunes
                que sufre la energis electrica y que pueden mandar a la basura las inversiones que usted o su empresa han hecho en computadores,
                televisores planos,teatros caseros, etc.
            </p>
        </section>
        <section>
            <h3>Con el afan de brindarle soluciones integrales, PARNET Ingeniería le ofrece desarrollo de software tales como:</h3>
            <p>
                <ul>
                    <li>Aplicaciones a la medida</li>
                    <li>Aplicaciones web</li>
                    <li>Aplicaciones Cliente-Servidor</li>
                    <li>Desarrollo de Aplicaiones Multimedia</li>
                    <li>Software de nómina para el control total de sus empleados</li>
                    <li>Aplicaciones moviles para celulares y PDA's</li>
                    <li>Bases de datos</li>
                </ul>
            </p>
        </section>
    </body>
</asp:Content>

