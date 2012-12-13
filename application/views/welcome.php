<!DOCTYPE html>
<html lang="en">

<?php $this->load->view('common/header'); ?>

<body>
    
  <?php $this->load->view('common/navbar-fixed-top'); ?>

  <div class="container-fluid">

    <div class="row-fluid">

      <?php $this->load->view('common/sidebar-nav'); ?>

      <div class="span9" id="content"> <?php /* the actual content */ ?>

        <div class="hero-unit">
          <h1>Hello, CRM!</h1>
          <p>This is the landing page for the first checkpoint of the CRM Framework project.</p>          
        </div>

<?php if (!empty($tickets)) { ?>
        <div class="row well">
          <table class="table table-condensed table-striped" id="ticketsListing">
            <caption>Top 5 unresolved tickets.</caption>            
            <thead>              
              <tr>
                <th>Agent</th>
                <th>Customer</th>
                <th>Date</th>
                <th>Subject</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($tickets as $t) { ?>
              <tr>
                <td><?=$t->agent_id;?></td>
                <td><?=$t->customer_id;?></td>
                <td><?=$t->submit_datetime;?></td>
                <td><?=$t->subject;?></td>
                <td><?=$t->status;?><?=!empty($t->resolved)?'/OK':'';?></td>
                <td><?=anchor('ticketing/ticket/'.$t->id, 'Details');?></td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div><!--/row-->
<?php } ?>

<?php if (!empty($agents)) {?>
        <div class="row well">
          <table class="table table-condensed table-striped" id="agentsActivity">
            <caption>Top 5 agents</caption>
            <thead>              
              <tr>
                <th>Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Details</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($agents as $a) {?>
              <tr>
                <td><?=$a->name;?></td>
                <td><?=$a->username;?></td>
                <td><?=$a->email;?></td>
                <td><?=anchor('ticketing/agent/'.$a->agent_id, 'Detail');?></td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div>
<?php } ?>

<?php if (!empty($invoices)) {?>
        <div class="row well">
          <table class="table table-condensed table-striped" id="invoicesActivity">
            <caption>Top 5 due invoices</caption>
            <thead>              
              <tr>
                <th>Customer</th>
                <th>Total</th>
                <th>Due Date</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($invoices as $i) {?>
              <tr>
                <td><?=$i->customer_id; ?></td>
                <td><?=$i->total; ?></td>
                <td><?=$i->due_date;?></td>
                <td><?=anchor('invoicing/invoice/'.$i->id, 'Detail');?></td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div>
<?php } ?>

<?php if (!empty($customers)) {?>
        <div class="row well">
          <table class="table table-condensed table-striped" id="customersActitivy">
            <caption>Last 5 registered customers</caption>
            <thead>              
              <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($customers as $c) {?>
              <tr>
                <td><?=$c->username;?></td>
                <td><?=$c->email;?></td>
                <td><?php print_r($this->role->find($c->role_id, 1)[0]);?></td>
                <td><?=anchor('invoicing/customer/'.$c->id, 'Detail');?></td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div>
<?php } ?>

<?php if (!empty($servers)) {?>
        <div class="row well">
          <table class="table table-condensed table-striped" id="serversActivity">
            <caption>Servers Monitoring</caption>
            <thead>              
              <tr>
                <th>Server</th>
                <th>IP Address</th>
                <th>Load</th>
                <th>Disk</th>
                <th>Memory</th>
                <th>Net</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($servers as $s) {?>
              <tr>
                <td><?=$s->server_name;?></td>
                <td><?=$s->ip_address;?></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <?php } ?>
            </tbody>
          </table>
        </div>
<?php } ?>


      </div><!--/span-->

    </div><!--/row-->

    <?php $this->load->view('common/footer'); ?>

  </div><!--/.fluid-container-->

<?php $this->load->view('common/script'); ?>

</body>

</html>
