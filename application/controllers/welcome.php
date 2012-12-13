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
		$t = new Ticket();
		$t->where('resolved', false)->order_by('id')->get_iterated(5);
		$this->tpl_vars['tickets'] = $t;

		// get agents activity - how many tickets they have pending / closed
		$a = new Agent();
		$a->get_iterated();
		$this->tpl_vars['agents'] = $a;

		// get 5 last due invoices
		$i = new Invoice();
		$i->select('id, total, booking_amount, due_date')->where('due_date < ', 'now()')->get_iterated(5);
		$i->customer->get();
		$this->tpl_vars['invoices'] = $i;

		// get 5 last created customers
		$c = new Customer();
		$c->order_by('id DESC')->get_iterated(5);	
		$c->role->get();
		$this->tpl_vars['customers'] = $c;

		// get status of all servers
		$s = new Server();
		$s->get_iterated();
		$s->agent->get();
		$s->monitoring->order_by('id DESC')->get(1);
		$this->tpl_vars['servers'] = $s;

		$this->load->view('welcome', $this->tpl_vars);

	}

	public function backup() {
		// Load the DB utility class
		$this->load->dbutil();

		// Backup your entire database and assign it to a variable
		$backup =& $this->dbutil->backup(); 

		// Load the file helper and write the file to your server
		$this->load->helper('file');
		write_file('/path/to/mybackup.gz', $backup); 

		// Load the download helper and send the file to your desktop
		$this->load->helper('download');
		force_download('mybackup.gz', $backup);		
	}

	public function download() {
		// Load the DB utility class
		$this->load->dbutil();

		// Backup your entire database and assign it to a variable
		$backup =& $this->dbutil->backup(); 

		// Load the download helper and send the file to your desktop
		$this->load->helper('download');
		force_download('crmf_'.date('dmY_Gi').'.gz', $backup);
	}

	public function restore() {

	}
}

