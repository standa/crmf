<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Invoice extends MY_Model {

	protected $_table 			= "invoices"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $total;
	var $booking_amount;
	var $issue_date;
	var $due_date;
	var $customer_id;
	var $billing_contact;
	var $delivery_contact;
	var $note;
	var $invoice_pdf;

  function __construct()
  {
      parent::__construct();
  }
}
