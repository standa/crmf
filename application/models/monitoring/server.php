<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Server extends MY_Model {

	protected $_table 			= "servers"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $server_name;
	var $description;
	var $ip_address;
	var $agent_id;
	var $status;

  function __construct()
  {
      parent::__construct();
  }
}
