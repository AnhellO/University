<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Fibra.aspx.cs" Inherits="Fibra" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <head>
        <link rel="stylesheet" type="text/css" href="styles/fibra.css" />
        <title>Fibra Optica</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Fibra Optica</div>
        <section>
            <div id="fibrahead">
                <img src="images/fibra-optica.png" />
            </div>
            <p>
                Las fibras ópticas se pueden utilizar con LAN, así como para transmisión de largo alcance, aunque derivar en ella es más 
                complicado que conectarse a una Ethernet. La interfaz en cada computadora pasa la corriente de pulsos de luz hacia el 
                siguiente enlace y también sirve como unión T para que la computadora pueda enviar y recibir mensajes.
            </p>
        </section>
        <section>
            <div id="data">
                <img src="images/tec_fibraoptica.png" />
            </div>
            <p>
                Como especialistas en el campo de la fibra óptica, ponemos a su disposición nuestra amplia experiencia con el fin de que 
                usted obtenga los beneficios con soluciones integrales totalmente probadas para seleccionar los mejores productos del mercado.
            </p>
            <p>
                Al conocer las necesidades de nuestros clientes, hacemos que sus sistemas de telecomunicación sean capaces de cumplir 
                totalmente con los aspectos más innovadores y lograr que su impacto sea capaz de evolucionar mantener positivamente la 
                operación de su empresa.
            </p>
        </section>
    </body>
</asp:Content>
