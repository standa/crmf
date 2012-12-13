<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Customers extends CI_Model {

	var $id;
	var $username;
	var $password;
	var $email;
	var $role_id;

  function __construct()
  {
      parent::__construct();
  }
}
