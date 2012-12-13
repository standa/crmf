<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Customer extends MY_Model {

	protected $_table 			= "customers"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $username;
	var $password;
	var $email;
	var $role_id;

  function __construct()
  {
      parent::__construct();
  }

  function last5() {
  	$q = $this->order_by('id DESC')->get($this->_table, 5);
  	return $q->result();
  }
}
