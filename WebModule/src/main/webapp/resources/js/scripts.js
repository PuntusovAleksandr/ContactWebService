$(document).ready(function(){

    $("#bottom-panel").click(function(){
       alert("hello!");
    });


     $("#getAllHobbies").click(function(){
         $("#t_hobby").find("tr:gt(0)").remove();
         $.get("/getHobbies", {}, function (data){
            $.each(data, function(index, value) {
                $("#t_hobby > tbody:last").append("<tr><td>"+index+"</td><td>"+
                value.title+"</td><td>"+ value.description +"</td></tr>");
            });
        });
     });


    $("#getAllPlace").click(function(){
        $("#t_place").find("tr:gt(0)").remove();
        $.get("/getPlace", {}, function (data){
            $.each(data, function(index, value) {
                $("#t_place > tbody:last").append("<tr><td>"+index+"</td><td>"+
                value.title+"</td><td>"+ value.description +"</td><td>" +
                value.latitude+"</td><td>"+value.longitude+"</td></tr>");
            });
        });
    });













});
