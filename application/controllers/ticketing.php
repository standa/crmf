<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Ticketing extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 */
	public function index()
	{	
		
		$this->load->view('ticketing/show', 
			array('title' => 'Tickets listing'));

	}
}
