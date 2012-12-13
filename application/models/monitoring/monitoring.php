<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Monitoring extends DataMapper {

	var $table 		= 'monitoring';

	var $has_one 	= array('server');

	

}
