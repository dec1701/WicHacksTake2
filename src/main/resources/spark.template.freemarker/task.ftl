<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Libre+Franklin:400&display=swap" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Poiret+One&display=swap" rel="stylesheet">

<link rel="stylesheet" href="taskcss.css">

<title>${title}</title>

    <style>
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
  font-size: 25px;
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
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>


</head>
<body>


    <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">Home</a>
  <a href="#">Tasks</a>
  <a href="#">Stats</a>
  <a href="#">Settings</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "200px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>


 <div class = "title">
     <h2>TASKS</h2>
    </div>

 <div class = "taskboxes">
     <h5>Get Groceries</h5>
    </div>

 <div class = "taskboxes">
     <h5>Do Laundry</h5>
    </div>

</body>
</html>