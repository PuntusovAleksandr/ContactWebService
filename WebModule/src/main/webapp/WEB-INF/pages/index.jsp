<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--<![endif]-->
<head>
  <meta charset="utf-8" />
  <title>Contact Web Service</title>
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="shortcut icon" href="favicon.png" />
  <link rel="stylesheet" href="resources/libs/bootstrap/bootstrap-grid-3.3.1.min.css" />
  <link rel="stylesheet" href="resources/libs/bootstrap/bootstrap.css" />
  <link rel="stylesheet" href="resources/libs/bootstrap/bootstrap-responsive.css">
  <link rel="stylesheet" href="resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="resources/libs/fancybox/jquery.fancybox.css" />
  <link rel="stylesheet" href="resources/libs/owl-carousel/owl.carousel.css" />
  <link rel="stylesheet" href="resources/libs/countdown/jquery.countdown.css" />
  <link rel="stylesheet" href="resources/css/fonts.css" />
  <link rel="stylesheet" href="resources/css/main.css" />
  <link rel="stylesheet" href="resources/css/media.css" />

  <script type="text/javascript" src="resources/libs/jquery/jquery-2.1.1.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.js"></script>
  <script type="text/javascript" src="resources/js/scripts.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap-datepicker.js"></script>




</head>


<body>

<%--<script>$(document).ready(function(){alert("hello!")})</script>--%>

<div class="container-fluid">

  <div class="row-fluid" id="header">
    <div class="span12" id="span12_font">Привет на моей страничке</div>
  </div>
  <div class="progress progress-striped active">
    <div class="bar" style="width: 100%;"></div>
  </div>

  <div class="sider_container">
    <div class="next_button"><i class="fa fa-angle-right"></i></div>
    <div class="pref_button"><i class="fa fa-angle-left"></i></div>
    <div class="carousel">
      <div class="slide_iten">

					<span class="style_model">
						<a href="#contact" class="button_slide"> <img class="slide_img" src="resources/img/contact.jpg" alt/><dev class="button_img">Contact</dev></a>
					</span>

      </div>
      <div class="slide_iten">

					<span class="style_model">
						<a  href="#hobby" class="button_slide"> <img class="slide_img" src="resources/img/hobby.jpg" alt/><dev class="button_img">Hobby</dev></a>
					</span>

      </div>
      <div class="slide_iten">

					<span class="style_model">
						<a href="#place"  class="button_slide"><img class="slide_img" src="resources/img/place.jpg" alt/><dev class="button_img"> Place</dev></a>
					</span>

      </div>
      <div class="slide_iten">

					<span class="style_model">
						<a  href="#message" class="button_slide"><img class="slide_img" src="resources/img/message.jpg" alt/> <dev class="button_img">Message</dev></a>
					</span>

      </div>
    </div>
  </div>

  <div class="row-fluid" id="container">
    <div class="span12">
      <div class="span9" id="container_left_span6">
        <div class="image_botton">
          <div class="image">
            <a href="http://skillsup.ua/" target="_blank" class="skillsup">
              <img src="resources/img/21.JPG" align="center" class="img-polaroid">
            </a>
          </div>
        </div>
      </div>

      <div class="span3" id="container_right_span6">
        <div class="row">
          <ul class="button_checking">
            <li class="button_check" id="contact">
              Contact
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#create_contact" tabindex="-1" data-toggle="modal">Create contact</a>
                </li>
                <li class="select">
                  <a href="#delete_contact" tabindex="-1" data-toggle="modal">Delete contact</a>
                </li>
                <li class="select">
                  <a href="#get_all_contacts" id="getAllContacts" target="_blank" tabindex="-1" data-toggle="modal">All contacts</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="hobby">
              Hobby
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#add_hobby" target="_blank" tabindex="-1" data-toggle="modal">Add hobby</a>
                </li>
                <li class="select">
                  <a href="#ddelete_hobby" target="_blank" tabindex="-1" data-toggle="modal">Delete hobby</a>
                </li>
                <li class="select">
                  <a href="#get_all_hobbies" id="getAllHobbies" onclick="allHobbies()" target="_blank" tabindex="-1" data-toggle="modal">All hobbies</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="place">
              Place
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#add_place" target="_blank" tabindex="-1" data-toggle="modal">Add place</a>
                </li>
                <li class="select">
                  <a href="#delete_place" target="_blank" tabindex="-1" data-toggle="modal">Delete place</a>
                </li>
                <li class="select">
                  <a href="#get_all__place" id="getAllPlace" target="_blank" tabindex="-1" data-toggle="modal">All places</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="message">
              Message
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#add_message" target="_blank" tabindex="-1" data-toggle="modal">Create message</a>
                </li>
                <li class="select">
                  <a href="#get_all_message" target="_blank" tabindex="-1" data-toggle="modal">All messages</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <%-- ========================================= --%>
  <div class="modal  fade" id="create_contact" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Create new contact</h3>
    </div>
    <div class="modal_body">
      <input id="add_firstName" class="modal_body_input" type="text" name="name" placeholder="Name..." required />
      <input id="add_lastName" class="modal_body_input" type="text" name="last_name" placeholder="Last name..." required />
      <input id="add_birthDay" class="modal_body_input" type="text" name="birth_day" placeholder="Birth  yyyy-mm-dd" required >
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button id="addContact" data-dismiss="modal"  class="btn btn-primary">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="delete_contact" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Delete contact</h3>
    </div>
    <div class="modal_body">
      <input class="modal_body_input" type="text" name="delete_contact_from_list"  placeholder="Name contact..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button  id="deleteContact" class="btn btn-primary">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="get_all_contacts" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>All contacts</h3>
    </div>
    <div class="modal_body">
      <table id="t_contact" class="table my_table table-condensed table-hover table-striped table-bordered table-bordered">
        <thead>
        <tr>
          <th>№ id</th>
          <th>Name</th>
          <th>Last name</th>
          <th>Date</th>
        </tr>
        </thead>
        <tbody>


        </tbody>
      </table>
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Ok</button>
    </div>
  </div>
  <%--++++++++++++++++++++++++++++++++++--%>
  <div class="modal  fade" id="add_hobby" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Add hobby</h3>
    </div>
    <div class="modal_body">
      <input id="add_titleHobby" class="modal_body_input" type="text" name="title_hobby" placeholder="Title..." required />
      <input id="add_descriptionHobby" class="modal_body_input" type="text" name="description_hobby" placeholder="Description..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button id="addHobby"  class="btn btn-primary" data-dismiss="modal">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="ddelete_hobby" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Delete hobby</h3>
    </div>
    <div class="modal_body">
      <input class="modal_body_input" type="text" name="delete_hobby_from_list" placeholder="Name hobby..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button class="btn btn-primary">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="get_all_hobbies" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>All hobbies</h3>
    </div>
    <div class="modal_body">
      <table id="t_hobby" class="table my_table table-condensed table-hover table-striped table-bordered table-bordered">
        <thead>
        <tr>
          <th>№ id</th>
          <th>Title</th>
          <th>Description</th>
        </tr>
        </thead>
        <tbody>


        </tbody>
      </table>
      <%--<button class="button" id="bottom-panel" onclick="allHobbies()"> Проверка JQuery </button>--%>
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Ok</button>
    </div>
  </div>
  <%--++++++++++++++++++++++++++++++++++--%>
  <div class="modal  fade" id="add_place" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Create new place</h3>
    </div>
    <div class="modal_body">
      <input id="add_titlePlace" class="modal_body_input" type="text" name="place" placeholder="Title..." required />
      <input id="add_descriptionPlace" class="modal_body_input" type="text" name="description_place" placeholder="Description..." required />
      <input id="add_longitude" class="modal_body_input" type="text"  name="longitude_place" placeholder="Longitude..." required />
      <input id="add_latitude" class="modal_body_input" type="text" name="latitude_place" placeholder="Latitude..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button id="addPlace" class="btn btn-primary" data-dismiss="modal" >Save</button>
    </div>
  </div>

  <div class="modal  fade" id="delete_place" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Delete place</h3>
    </div>
    <div class="modal_body">
      <input class="modal_body_input" type="text" name="delete_place_from_list" placeholder="Place title..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button class="btn btn-primary">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="get_all__place" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>All places</h3>
    </div>
    <div class="modal_body">
      <table id="t_place" class="table my_table table-condensed table-hover table-striped table-bordered table-bordered">
        <thead>
        <tr>
          <th>№ id</th>
          <th>Title</th>
          <th>Description</th>
          <th>Latitude</th>
          <th>Longitude</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
      </table>
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Ok</button>
    </div>
  </div>
  <%--++++++++++++++++++++++++++++++++++--%>
  <div class="modal  fade" id="add_message" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>Add new message</h3>
    </div>
    <div class="modal_body">
      <input class="modal_body_input" type="text" name="contact_from" placeholder="Contact from..." required />
      <input class="modal_body_input" type="text" name="contact_to" placeholder="Contact to..." required />
      <input class="modal_body_input" type="text" name="message" placeholder="Message..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Cancel</button>
      <button class="btn btn-primary">Save</button>
    </div>
  </div>

  <div class="modal  fade" id="get_all_message" tabindex="-1" role="dialog">
    <div class="modal-header">
      <button class="close" type="button" data-dismiss="modal">x</button>
      <h3>All messages</h3>
    </div>
    <div class="modal_body">
      <input class="modal_body_input" type="text" name="message_contact" placeholder="Name contact..." required />
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Ok</button>
    </div>
  </div>
  <%--++++++++++++++++++++++++++++++++++--%>


  <div class="row-fluid" id="footer">
    <div class="span12" id="span12_footer">
      <row class="font_footer">
        <div class="autor_name">AleksandrP	 aleksandr_mdc@mail.ru </div>
      </row>
    </div>
  </div>

</div>



<!--[if lt IE 9]>
<script src="resources/libs/html5shiv/es5-shim.min.js"></script>
<script src="resources/libs/html5shiv/html5shiv.min.js"></script>
<script src="resources/libs/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="resources/libs/respond/respond.min.js"></script>
<![endif]-->
<script src="resources/libs/jquery/jquery-1.11.1.min.js"></script>
<script src="resources/libs/jquery-mousewheel/jquery.mousewheel.min.js"></script>
<script src="resources/libs/fancybox/jquery.fancybox.pack.js"></script>
<script src="resources/libs/waypoints/waypoints-1.6.2.min.js"></script>
<script src="resources/libs/scrollto/jquery.scrollTo.min.js"></script>
<script src="resources/libs/owl-carousel/owl.carousel.min.js"></script>
<script src="resources/libs/countdown/jquery.plugin.js"></script>
<script src="resources/libs/countdown/jquery.countdown.min.js"></script>
<script src="resources/libs/countdown/jquery.countdown-ru.js"></script>
<script src="resources/libs/landing-nav/navigation.js"></script>
<script src="resources/js/common.js"></script>


<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
<!-- Google Analytics counter --><!-- /Google Analytics counter -->
</body>
</html>
