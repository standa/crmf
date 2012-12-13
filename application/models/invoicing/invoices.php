<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Invoices extends CI_Model {

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
