<?php
      $str1 = "Hellow World!! ";
      $str2 = "This is the first time I am using PHP!!";
      echo($str1.$str2."<br><hr>");
      //today date and time
      echo("Today is ".date("Y/m/d")."<br>");
      echo("The current time is ".date("h:i:sa")."<br>");
      
      //tomorrow and next monday
      $tmr = strtotime("tomorrow");
      $next = strtotime("next Monday");
      echo("Tomorrow is ".date("Y-m-d", $tmr)."<br>");
      echo("Next Monday is ".date("Y-m-d", $next)."<br>");
    ?>
