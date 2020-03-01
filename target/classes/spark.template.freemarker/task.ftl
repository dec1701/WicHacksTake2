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
    border-top-right-radius: 300px;
    border-bottom-right-radius: 300px;
    opacity: .65;
    margin: 20px;
    padding: 20px;
    margin-left: 0;

    .options{
        display: grid
    }
}

button{
    background-color: black;
    opacity: .65;
    border: none
}


h5{
    margin-top: 10px;
    font-family: 'Libre Franklin';
    font-size: 150%;
    text-align: left;
    color: white;
    opacity: 1;
}


h2{
    font-family: 'Libre Franklin';
    font-size: 250%;
    text-align: left;
    color: whitesmoke;
    width: 50px;
}
p{
    font-family: 'Libre Franklin';
    color: white;
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


<if tasks??>
    <#list tasks as task>
        <div class = "taskboxes">
            <form action="./Tasks?taskId=${task.getId()}" method="post">
                <button type="submit" formmethod="post"><h5>${task.getData()}</h5></button>
            </form>

            <div class = "options">
                <#if inputId??>
                    <#if task.getId() == inputId>
                        <form action="./Edit?taskId=${task.getId()}" method="post">
                            <button type="submit" formmethod="post"><p>Edit</p></button>
                        </form>

                        <form action="./Complete?taskId=${task.getId()}" method="post">
                            <button type="submit" formmethod="post"><p>Complete</p></button>
                        </form>
                    </#if>
                </#if>
            </div>
        </div>
  </#list>
</if>


</body>

