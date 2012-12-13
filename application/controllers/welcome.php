<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Welcome extends CI_Controller {

	var $tpl_vars;

	/**
	 * Index Page for this controller.
	 *
	 */
	public function index()
	{		
		$this->tpl_vars['title'] = 'Dashboard';

		// get 5 oldest tickets that are have not been closed
		$this->tpl_vars['tickets'] = $this->ticket->top5();

		// get agents activity - how many tickets they have pending / closed

		// get 5 last due invoices

		// get 5 last created customers
		$this->tpl_vars['customers'] = $this->customer->last5();

		// get status of all servers

		$this->load->view('welcome', $this->tpl_vars);
	}
}

