<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Tickets extends CI_Model {

	var $id;
	var $agent_id;
	var $customer_id;
	var $submit_datetime;
	var $parent_ticket;
	var $subject;
	var $message;
	var $attachment;
	var $url;
	var $status;
	var $resolved;	

  function __construct()
  {
      parent::__construct();
  }
}
