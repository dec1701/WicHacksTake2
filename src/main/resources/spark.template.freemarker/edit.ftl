<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Libre+Franklin:400&display=swap" rel="stylesheet">

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

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  border: none;
    border-bottom: 2px white;
}

</style>

</head>

<body>


<form method="post">
        <input type="text" id="newData" name="newData">

        <script>
                function getInputValue(){
                    // Selecting the input element and get its value
                    var inputVal = document.getElementById("newData").value;

                    // Displaying the value
                    alert(inputVal);
                }
        </script>

        <input type="submit" onclick="form.action='/SubmitEdit?data="document.getElementById("newData").value;"';">
</form>

</body>

</html>