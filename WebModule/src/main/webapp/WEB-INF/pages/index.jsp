<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<!--<![endif]-->
<head>
  <meta charset="utf-8" />
  <title>Contact Web Service</title>
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="shortcut icon" href="favicon.png" />
  <link rel="stylesheet" href="resources/libs/bootstrap/bootstrap-grid-3.3.1.min.css" />
  <link rel="stylesheet" href="resources/libs/bootstrap/bootstrap.min.css" />
  <link rel="stylesheet" href="resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="resources/libs/fancybox/jquery.fancybox.css" />
  <link rel="stylesheet" href="resources/libs/owl-carousel/owl.carousel.css" />
  <link rel="stylesheet" href="resources/libs/countdown/jquery.countdown.css" />
  <link rel="stylesheet" href="resources/css/fonts.css" />
  <link rel="stylesheet" href="resources/css/main.css" />
  <link rel="stylesheet" href="resources/css/media.css" />
</head>
<body>

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
            <a href="http://skillsup.ua/" class="skillsup">
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
                  <a href="#" tabindex="-1">Create contact</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">Delete contact</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">All contacts</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="hobby">
              Hobby
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#" tabindex="-1">Add hobby</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">Delete hobby</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">All hobbyes</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="place">
              Place
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#" tabindex="-1">Add place</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">Delete place</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">All places</a>
                </li>
              </ul>
            </li>
            <li class="button_check" id="message">
              Message
              <p></p>
              <ul class="dropdown-menu"  >
                <li class="select">
                  <a href="#" tabindex="-1">Create message</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">Delete message</a>
                </li>
                <li class="select">
                  <a href="#" tabindex="-1">All messages</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>

  </div>

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
<script src="resources/js/bootstrap.min.js"></script>
<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
<!-- Google Analytics counter --><!-- /Google Analytics counter -->
</body>
</html>
