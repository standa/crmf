<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Customer extends DataMapper {

	var $has_many = array('invoice', 'ticket', 'contact');
	var $has_one = array(
		'role'
	);

}
