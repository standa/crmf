<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Monitoring extends CI_Model {

	var $id;
	var $server_id;
	var $update_time;
	var $loadavg;
	var $top;
	var $netstat;
	var $df;
	var $free;

  function __construct()
  {
      parent::__construct();
  }
}
