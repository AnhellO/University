<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Socios.aspx.cs" Inherits="Socios" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <link rel="stylesheet" type="text/css" href="styles/clientes.css" />
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Socios</div>
            <section>
                <p> <h2>ORACLE</h2>
                    <img src=" images/oracle.png"/>
                    <br /><br />
                        Oracle Corporation es una de las mayores compañías de software del mundo. Sus productos van desde bases de datos (Oracle) 
                        hasta sistemas de gestión. Cuenta además, con herramientas propias de desarrollo para realizar potentes aplicaciones, como 
                        Oracle Designer, Oracle JDeveloper y Oracle Developer Suite. Su actual consejero delegado es Larry Ellison.
                    </p>

                <p> <h2>CISCO Systems</h2>
                    <img src=" images/Cisco.gif"/>
                    <br /><br />
                        Cisco Systems es una empresa global con sede en San José, (California, Estados Unidos), principalmente dedicada a la 
                        fabricación, venta, mantenimiento y consultoría de equipos de telecomunicaciones tales como:
                    <ul type="circle">
                        <li>Dispositivos de conexión para redes informáticas: routers (enrutadores, encaminadores o ruteadores), switches (conmutadores) y 
                            Hubs (concentradores)</li>
                        <li>Dispositivos de seguridad como Cortafuegos y Concentradores para VPN</li>
                        <li>Productos de telefonía IP como teléfonos y el CallManager (una PBX IP)</li>
                        <li>Software de gestión de red como CiscoWorks</li>
                        <li>Equipos para redes de área de almacenamiento</li>
                    </ul>
                </p>
            </section>
    </body>
</asp:Content>

