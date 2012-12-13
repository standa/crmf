<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Ticket extends MY_Model {

	protected $_table 			= "tickets"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

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


  function top5() {

  	
  	$q = $this->where('resolved', false)
  		->order_by('submit_datetime')->get($this->_table, 5);

  	return $q->result();
  }

}
