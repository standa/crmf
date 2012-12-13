<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Invoice extends DataMapper {

	var $has_many = array(
		'order'
	);

	var $has_one = array(
		'customer'
	);


}
