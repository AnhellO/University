<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Quienes.aspx.cs" Inherits="Quienes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <!DOCTYPE HTML>
    <head>
        <link rel="stylesheet" type="text/css" href="styles/quienes.css" />
        <title>Quienes Somos</title>
    </head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">¿Quienes Somos?</div>
        <section>
            <h2>Sobre Nosotros...</h2>
           <video class="center" width="500" height="500" controls>
               <source src="videos/video_1.mp4" type="video/mp4"/>
                  Your browser does not support the video tag.
                </video>
            <p>Somos una empresa Mexicana, nacida en noviembre de 2004 en Saltillo, Coah., como producto de las necesidades de tecnologia en la region.</p>
            <p>Tenemos una amplia experiencia en el mercado, ofreciendo servicios a mas de 30 empresas de Coahuila, Zacatecas y Nuevo León, de igual manera en Estados Unidos.</p>
            <p>El desarrollo logrado y la diversidad de productos ofrecidos, convierten a PARNET en una de las empresas proveedoras de tecnología y comunicaciones
                 de mayor importancia de la región y del país.</p>
        </section>
        <section>
            <h3>Misión</h3>
            <p>Nuestra misión es ser conocidos y reconocidos por nuestro liderazgo a través de nuestra pasión por los altos estándares, 
                nuestro respeto por la diversidad y nuestro compromiso para crear oportunidades excepcionales para el crecimiento personal, 
                para que nuestros asociados puedan alcanzar su más alto potencial tanto en su carrera como en lo personal.</p>
        </section>
        <section>
            <h3>Vision</h3>
            <p>
                Nuestra visión representa nuestra mayor aspiración. Es nuestro propósito y nuestra razón de existir como empresa y 
                se refleja en la historia que escribimos en todo el mundo.</p>
        </section>
    </body>
</asp:Content>
