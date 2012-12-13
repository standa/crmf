<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Agents extends CI_Model {

	var $id;
	var $username;
	var $password;
	var $name;
	var $email;
	var $phone;
	var $sms_notification;

  function __construct()
  {
      parent::__construct();
  }
}
