<!DOCTYPE html>
<html>
<head>   
    <link href="https://fonts.googleapis.com/css?family=Poiret+One&display=swap" rel="stylesheet">
<title>Home</title>
    <style>
        body{
            background: rgb(82,72,156);
    background: linear-gradient(0deg, rgba(82, 52, 140,1) 0%, rgba(118, 118, 255,1) 100%);
    background-repeat:no-repeat;
    background-attachment: fixed;
            text-align: center;
        }
        .bk{
            
            opacity: 1;
        }
        
        .sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: white;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 170%;
  color: midnightblue;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #cc99cc;
}

  .sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 270%;
  margin-left: 50px;
}



@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
        
        a{
    font-family: 'Poiret One';
}
</style>
    
    
</head>
<body>
    
    
    <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">Home</a>
  <a href="#">Tasks</a>
</div>
    
<span style="float: left;
    clear:both;font-size:300%;cursor:pointer" onclick="openNav()">&#9776; </span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "275px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
        
   
<body>
<div class="bk">
 <img src="homescreen2.png" alt = "home">
</div> 
    
</body>
