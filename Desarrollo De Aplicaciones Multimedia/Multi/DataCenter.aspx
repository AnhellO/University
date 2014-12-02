<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="DataCenter.aspx.cs" Inherits="DataCenter" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <head>
        <link rel="stylesheet" type="text/css" href="styles/datacenter.css" />
        <title>Data Center</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Data Center</div>
        <section>
            <div id="datahead">
                <img src="images/Header-data-center.png" />
            </div>
            <p>
                El Centro de Datos el cerebro de una empresa y el lugar donde se ejecutan los procesos más críticos. Sistemas informáticos 
                a gran escala han estado alrededor por un tiempo, y muchas personas ya están familiarizados con el centro de datos a 
                largo plazo.
            </p>
        </section>
        <section>
            <div id="data">
                <img src="images/data-center.png" />
            </div>
            <p>
                Los centros de datos son comúnmente administrados por grandes empresas o agencias gubernamentales. Sin embargo, también 
                se utilizan cada vez más para proporcionar un rápido crecimiento servicio solución en la nube para aplicaciones privadas 
                y de negocios.
            </p>
            <p>
                Las características básicas son las mismas, independientemente del tamaño de los datos, ya que el éxito de toda empresa 
                depende invariablemente de las operaciones de software suaves - y los que tienen que salvaguardar.
            </p>
        </section>
    </body>
</asp:Content>
