<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Corriente.aspx.cs" Inherits="Corriente" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <head>
        <link rel="stylesheet" type="text/css" href="styles/corriente.css" />
        <title>Corriente</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Corriente Regulada</div>
        <section>
            <p>
                La irregularidad en el flujo eléctrico es algo que vivimos constantemente, siendo una de las causes principales 
                de que muchos de nuestros aparatos eléctricos sufran fallas. Lo más preparados han sabido comprar sistemas de protección 
                eléctrica, pero curiosamente las fallas en los equipos por flujo eléctricos irregulares siguen sucediendo ¿Por qué?
            </p>
            <p>Una de las cuestiones que debemos tener claro para proteger nuestros aparatos eléctricos, es contra qué los estamos 
                protegiendo, ya que existen dos sistemas de protección principales: Los sistemas de alimentación ininterrumpida  
                (UPS por sus siglas en inglés) y los supresores de pico.</p>
        </section>
        <section>
            <div id="ups">
                <img src="images/ups.png" />
            </div>
            <p>
                Un UPS se hace necesario en aquellos dispositivos que necesitan un debido proceso de apagado como por ejemplo sistemas 
                de aires acondicionados, computadoras y neveras, y es que gracias a ese pequeño tiempo extra de energía que nos ofrece 
                un UPS podemos tomar las medidas necesarias para desactivar los aparatos sin que éstos sufran fallas en sus sistemas internos.
            </p>
            <div id="pico">
                <img src="images/supresor-de-picos.png" />
            </div>
            <p>
                Un supresor de picos tiene la función de eliminar los llamados transitorios de tensión (picos de voltaje) que debido a su 
                corta duración no son detectados fácilmente por otros equipos de calidad de energía. Los picos son generados por muchos 
                equipos o materiales en una instalación eléctrica y la aparición constante de ellos puede causar daños a corto mediano y 
                largo plazo en un equipo sensible como los equipos de TI.
            </p>
        </section>
    </body>
</asp:Content>

