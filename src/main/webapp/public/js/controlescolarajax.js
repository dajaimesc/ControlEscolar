/* 
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */

/***
*
* Funciones para el sistema de Control Escolar
*
*/

$(document).ready(function() {
  init();
  profesores();
  login();
});

/***
* Variables globales
*/
var activeTab;

/***
* init
*/
function init(){
  $('article').hide();

  $('ul.ultabs li a').click(function() {
    activeTab = $(this).attr('href');     /* ¿Qué opción clicó? */
    $('article').hide();                  /*  oculto todos */
    $(activeTab).show();                  /*  muestro el tab asociado */
  });
}

/***
* login
*/
function login(){

  $('#formLogin').submit(function(event) {
    event.preventDefault();             /* evita que se repinte la página*/
    var usuario = $('#loginUsuario').val();
    var contrasena = $('#loginContrasena').val();

    // Checar que sea un id válido
    if (usuario.length > 0 && contrasena.length > 0) {
      validarLogin(usuario, contrasena);
    } else {
      $('#loginUsuario').val('');
      $('#loginContrasena').val('');
    }
  });
}

/***
* Asociar comportamientos a la opción de profesores
*/
function profesores(){

  $('#formConsultaProfesor').submit(function(event) {
    event.preventDefault();
    var id = $('#buscaProfesor').val();

    // Checar que sea un id válido
    if ($.isNumeric(id)) {
        consultarProfesor(id);
    } else {
        $('#buscaProfesor').val('');
    }

  });

}

/***
* consultar profesor por id
*/
function consultarProfesor(id){
  $.ajax({
      // Programa que me atenderá en el servidor
      url: "/mvc/controladores/indexmvc.php",

      // Si la petición tuvo éxito
      success: function(data, textStatus, jqXHR){
                $('#divprofesoresdatos').html(data);
              },
      // Puedo enviar datos
      data: {
        // controlador debe ser siempre el primer dato que envíe
        // de otro modo no funciona bien router.php
        controlador: 'profesores',
        id: id
      },
      // Qué espero de regreso del servidor
      dataType: 'html',
      // Si ocurre un error técnico
      error: function(jqHR, status, error){
        // alert("Error");
      },
      // Ejecutar esto no importando si la petición falló o tuvo éxito
      complete: function(){
        // alert("Consulta finalizada");
      }
    });
}

/***
* validarLogin
*/
function validarLogin(usuario, contrasena){

  $.ajax({
      // Programa que me atenderá en el servidor
      url: "/mvc/controladores/indexmvc.php",

      // Si la petición tuvo éxito
      success: function(data, textStatus, jqXHR){
                $('#nombreUsuario').text(data);
              },
      data: {
        // controlador debe ser siempre el primer dato que envíe
        // de otro modo no funciona bien router.php
        controlador: 'login',
        usuario: usuario,
        contrasena: contrasena
      },
      // Qué espero de regreso del servidor
      dataType: 'text',
      // Si ocurre un error técnico
      error: function(jqHR, status, error){
        //alert("error técnico");
      },
      // Ejecutar esto no importando si la petición falló o tuvo éxito
      complete: function(){
        // alert("concluida");
      }

    });
}

