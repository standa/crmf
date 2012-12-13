<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Role extends DataMapper {

	var $has_many = array('customer');

}
