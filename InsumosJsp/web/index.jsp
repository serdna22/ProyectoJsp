<%-- 
    Document   : index
    Created on : 12/04/2022, 3:43:56 p. m.
    Author     : serdn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body ">
                    <form action="Login" class="form-sign" method="POST">
                        <div class="form-group  text-center">
                            <h3>Login</h3>
                            <img src="img/logo.png" alt="70" width="170"/>
                            <label>Bienvenidos al Sistema</label>
                        </div>  
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div> 
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
                    </form>
                </div>
            </div>   
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>