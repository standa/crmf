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

	public function invoice_pdf($invoice_id) {

		$i = new Invoice();
		$i->select('invoice_pdf')->get_by_id($invoice_id);

		$this->load->helper('download');
		force_download('invoice_'.$invoice_id.'.pdf', $i->invoice_pdf);
	}
}
