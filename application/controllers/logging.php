<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Logging extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 */
	public function index()
	{	
		
		$this->load->view('logging/show', array('title' => 'Logs listing'));

	}
}
