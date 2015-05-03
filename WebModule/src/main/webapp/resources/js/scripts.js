$(document).ready(function(){

    $("#bottom-panel").click(function(){
       alert("hello!");
    });

    $("#addContact").click(function(){
        var firstName = $("#add_firstName").val();
        var lastName = $("#add_lastName").val();
        var birthDay = $("#add_birthDay").val();
        if(firstName== "" || firstName ==undefined){
            alert("First Name is not valid");
        }else{
            alert("in");
            $.get("/addContact", {
                firstName: firstName,
                lastName: lastName,
                birthDay: birthDay
            },
                function(date){
                    alert(""+date);
                });
        }
     });

    $("#addHobby").click(function(){
        var title = $("#add_titleHobby").val();
        var description = $("#add_descriptionHobby").val();
        if(title== "" || title ==undefined){
            alert("Title is not valid");
        }else{
            alert("in");
            $.get("/addHobby", {
                    title: title,
                    description: description
            },
                function(date){
                    alert(""+date);
                });
        }
     });

    $("#addPlace").click(function(){
        var title = $("#add_titlePlace").val();
        var description = $("#add_descriptionPlace").val();
        var longitude = $("#add_longitude").val();
        var latitude = $("#add_latitude").val();
        if(title== "" || title ==undefined){
            alert("Title is not valid");
        }else{
            alert("in");
            $.get("/addPlace", {
                    title: title,
                    description: description,
                    longitude: longitude,
                    latitude: latitude
            },
                function(date){
                    alert(""+date);
                });
        }
     });

    $("#deleteContact").click(function() {
       var contact = $("#deleteCont").val();
        if(contact=="" || contact== undefined){
            alert("Contact not enter!")
        }else{
            alert("in");
            $.get("/deleteContact", {
                contact: contact
            },
                function(date){
                    alert(""+ date);
                });
        }
    });

    $("#delHobby").click(function() {
       var hobby = $("#deleteHobby").val();
        if(hobby=="" || hobby== undefined){
            alert("Hobby not enter!")
        }else{
            alert("in");
            $.get("/deleteHobby", {
                hobby: hobby
            },
                function(date){
                    alert(""+ date);
                });
        }
    });

    $("#delPlace").click(function() {
       var place = $("#deletePlace").val();
        if(place=="" || place== undefined){
            alert("Place not enter!")
        }else{
            alert("in");
            $.get("/deletePlace", {
                place: place
            },
                function(date){
                    alert(""+ date);
                });
        }
    });

    $("#getAllContacts").click(function(){
         $("#t_contact").find("tr:gt(0)").remove();
         $.get("/getAllContacts", {}, function (data){
            $.each(data, function(index, value) {
                $("#t_contact > tbody:last").append("<tr><td>"+index+"</td><td>"+
                value.firstName+"</td><td>"+ value.lastName+"</td><td>"+ value.birthDate +"</td></tr>");
            });
        });
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

    $("#addMessage").click(function(){
        var contactFrom = $("#contactFrom").val();
        var contactTo = $("#contactTo").val();
        var newMessage = $("#newMessage").val();
        if(contactFrom=="" || contactFrom == undefined ||
            contactTo=="" || contactTo == undefined ||
                newMessage=="" || newMessage == undefined){
            alert("Enter all data");
        }else {
            alert("in");
            $.get("/addMessage", {
                    contactFrom: contactFrom,
                    contactTo: contactTo,
                    newMessage: newMessage
                },
                function (data) {
                    alert("" + data);
                });
        }
    });

    $("#getAllMessage").click(function(){
        var contact = $("#allMes");
            if(contact =="" || contact == undefined){
                alert("Enter contact");
            }else {
                alert("in");
                $.get("/getAllMessage", {
                        contact: contact
                    },
                    function (data) {
                        alert("" + data);
                    });
            }
    });













});
