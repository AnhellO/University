<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Circuito.aspx.cs" Inherits="Circuito" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <head>
        <link rel="stylesheet" type="text/css" href="styles/circuito.css" />
        <title>Circuito Cerrado TV</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Circuito Cerrado TV</div>
        <section>
            <div id="cam1">
                <img src="images/Camaras%20CCTV.png" />
            </div>
            <p>
                PARNET Ingeniería, S.A. de C.V. le ofrece Soluciones Integrales en CCTV, usted podrá encontrar en nosotros un proveedor 
                confiable ya que trabajamos con las mejores marcas del mercado a un precio inigualable. Entre nuestros productos usted 
                podrá encontrar Cámaras de todo Tipo, Monitores, Gabinetes, Servidores, Multiplexores, Grabadoras Digitales de Video.
            </p>
        </section>
        <section>
            <div id="cam2">
                <img src="images/camaras%20de%20seguridad%20cctv.png" />
            </div>
            <p>
                En la moderna arquitectura de control de los edificios actuales, la incorporación del circuito cerrado de televisión (CCTV) 
                es indispensable. Los proyectos incluyen cámaras de funcionamiento nocturno y diurno, internas, externas y de iluminación y 
                captación infrarroja para zonas de seguridad crítica, en color y en blanco y negro.
            </p>
        </section>
    </body>
</asp:Content>

