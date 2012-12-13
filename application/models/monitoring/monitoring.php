<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Monitoring extends MY_Model {

	protected $_table 			= "monitoring"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

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
