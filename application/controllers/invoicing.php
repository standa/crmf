<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Invoicing extends CI_Controller {

	var $tpl_vars;

	/**
	 * Index Page for this controller.
	 *
	 */
	public function index()
	{	
		$this->tpl_vars['title'] 			= 'Invoices listing';
		
		$this->load->view('invoicing/show', $this->tpl_vars);

	}
}
