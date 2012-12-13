<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Roles extends CI_Model {

	var $id;
	var $role_name;
	var $description;

  function __construct()
  {
      parent::__construct();
  }
}
