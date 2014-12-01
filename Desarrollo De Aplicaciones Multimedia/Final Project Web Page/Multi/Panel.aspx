﻿<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Panel.aspx.cs" Inherits="Panel" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <link rel="stylesheet" type="text/css" href="styles/panel.css" />
    <head>
<meta charset="utf-8" />
<title>Paper Stack</title>
</head>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <body>
        <div id="marcador">Control Panel</div>
            <div class="container">
	            <section id="content">
		            <form action="">
			            <h1>Login Form</h1>
			            <div>
				            <input type="text" placeholder="Username" required="" id="username" />
			            </div>
			            <div>
				            <input type="password" placeholder="Password" required="" id="password" />
			            </div>
			            <div>
				            <input type="submit" value="Log in" />
				            <a href="#">Lost your password?</a>
				            <a href="#">Register</a>
			            </div>
		            </form><!-- form -->
		            <div class="button">
			            <a href="#">Download source file</a>
		            </div><!-- button -->
	            </section><!-- content -->
            </div><!-- container -->
        </body>
</asp:Content>

