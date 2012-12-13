<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Agent extends MY_Model {

	protected $_table 			= "agents"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

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
