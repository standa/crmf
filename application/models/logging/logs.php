<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Logs extends CI_Model {

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
