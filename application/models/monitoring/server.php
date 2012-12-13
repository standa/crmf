<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Server extends DataMapper {

	var $has_one = array('agent');
	var $has_many = array('monitoring');

}
