<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Ticket extends DataMapper {

	var $has_one = array(
		'agent' => array(),
		'customer' => array(),
		'ticket' => array('other_field' => 'parent_ticket')
	);


}
