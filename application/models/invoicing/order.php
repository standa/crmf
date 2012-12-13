<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Order extends MY_Model {

	protected $_table 			= "orders"; //Default lowercase plural modelname
	protected $primary_key 	= "id"; //Default id
	protected $validate 		= array(); //Set Codeigniter validation rules {

	var $id;
	var $invoice_id;
	var $product_name;
	var $description;
	var $quantity;
	var $unit_price;
	var $vat_rate;
	var $currency;
	var $subtotal;
	var $valid_from;
	var $valid_until;
	var $reminder_days;

  function __construct()
  {
      parent::__construct();
  }
}
