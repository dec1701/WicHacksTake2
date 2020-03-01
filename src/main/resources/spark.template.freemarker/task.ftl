<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Libre+Franklin:400&display=swap" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Poiret+One&display=swap" rel="stylesheet">

<link rel="stylesheet" href="taskcss.css">

<title>Task Manager</title>

    <style>


    body{
        background: rgb(82,72,156);
        background: linear-gradient(0deg, rgba(102,51,153,1) 0%, rgba(102,102,153) 49%, rgba(153,153,255,1) 100%);
        background-repeat:no-repeat;
        background-attachment: fixed;
    }

    .title{
    }

    .taskboxes{
        text-align: center;
        /* background-color: #cc99cc; */
        background-color: midnightblue;
        height: 50px;
        border-top-right-radius: 300px;
        border-bottom-right-radius: 300px;
        opacity: .65;
        margin: 20px;
        padding: 20px;
        margin-left: 0;

    }

    h5{
        margin-top: 10px;
        font-family: 'Libre Franklin';
        font-size: 28px;
        text-align: left;
        color: white;
    }
    h2{
        font-family: 'Poiret One';
        height: 50px;
        width: 500px;
        font-size: 40px;
        text-align: center;
        color: black;


    }

    a{
        font-family: 'Poiret One';
    }


        body{
    background: rgb(82,72,156);
    background: linear-gradient(0deg, rgba(82, 52, 140,1) 0%, rgba(118, 118, 255,1) 100%);
    background-repeat:no-repeat;
    background-attachment: fixed;

}

.title{
    margin-bottom: 60px;
}

.add{
    float: right;
}


.taskboxes{
    text-align: center;
    /* background-color: #cc99cc; */
    background-color: black;
    height: 50px;
    border-top-right-radius: 300px;
    border-bottom-right-radius: 300px;
    opacity: .65;
    margin: 20px;
    padding: 20px;
    margin-left: 0;
}

h5{
    margin-top: 10px;
    font-family: 'Libre Franklin';
    font-size: 28px;
    text-align: left;
    color: white;
    opacity: 1;
}
h2{
    font-family: 'Libre Franklin';
    font-size: 40px;
    text-align: left;
    color: whitesmoke;
    width: 50px;
}

a{
    font-family: 'Poiret One';
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

<div class = "add">
     <h2>+</h2>
    </div>

 <div class = "title">
     <h2>Tasks</h2>
    </div>


 <div class = "taskboxes">
     <h5>Get Groceries</h5>
    </div>

 <div class = "taskboxes">
     <h5>Do Laundry</h5>
    </div>

</body>

