<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Log extends MY_Model {

	protected $_table 			= "logs"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $code;
	var $message;
	var $action;
	var $object_type;
	var $object_id;
	var $log_time;	

  function __construct()
  {
      parent::__construct();
  }
  
}
