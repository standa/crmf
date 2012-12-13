<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Role extends MY_Model {

	protected $_table 			= "roles"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $role_name;
	var $description;

  function __construct()
  {
      parent::__construct();
  }
}
