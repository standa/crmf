<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Servers extends CI_Model {

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
