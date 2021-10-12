<!DOCTYPE html>
    <head>
     <html>
        <title>Lab 5</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <header style="background-color: rgb(239, 245, 191);font-size: 25pt;position: relative;top: 20px;text-align: center;height: 200px;">
        <?php
            include("Header.php"); //including header
        ?>
    </header>
    <body >
    <ul class="nav nav-pills nav-justified"  style="width: fit-content;height: min-content;position: relative;bottom: 30px;left: 70%;">
        <li class="nav-item">
            <a class="nav-link active" href="http://www.soominl.sgedu.site/Lab5/index.php">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="http://www.soominl.sgedu.site/Lab2/index.html">Lab2</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="http://www.soominl.sgedu.site/Lab3/index.html">Lab3</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="http://www.soominl.sgedu.site/Lab4/index.html">Lab4</a>
        </li>
    </ul>
    <div class="container-xl p-3 my-3 bg-dark text-white">
    <h3>
    <?php
        include("Menu.php");
    ?>
    </h3>
    </div>
    </body>
    <footer class="footer" style=" bottom: 0px;background-color: rgb(107, 107, 107); text-align: center; color: white;height: 100px;">
        <?php
         include("Footer.php");
        ?>
    </footer>  
</html>

