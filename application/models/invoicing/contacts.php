<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Contacts extends CI_Model {

	var $id;
	var $name;
	var $surname;
	var $street;
	var $number;
	var $zip;
	var $district;
	var $city;
	var $region;
	var $country;
	var $company_id;
	var $vat_no;
	var $company;
	var $bank_account;
	var $bank;
	var $iban;
	var $swift_bic;
	var $phone;
	var $email;
	var $primary_contact;
	var $customer_id;

  function __construct()
  {
      parent::__construct();
  }
  
}
