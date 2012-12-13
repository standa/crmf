<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Agent extends DataMapper {

	var $has_one = array();

	var $has_many = array(
		'ticket',
		'server'
	);


}
