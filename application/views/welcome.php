<!DOCTYPE html>
<html lang="en">

<?php $this->load->view('common/header'); ?>

<body>
    
  <?php $this->load->view('common/navbar-fixed-top'); ?>

  <div class="container-fluid">

    <div class="row-fluid">

      <div class="span3">
        <div class="well sidebar-nav">
          <ul class="nav nav-list">
            <li class="nav-header">Test Suite</li>
            <li><a href="<?=site_url('logging');?>">Logging</a></li>
            <li><a href="<?=site_url('invoicing');?>">Invoicing</a></li>
            <li><a href="<?=site_url('monitoring');?>">Monitoring</a></li>
            <li><a href="<?=site_url('ticketing');?>">Ticketing</a></li>
          </ul>

          <ol class="nav nav-list">
            <li class="nav-header">Installation &amp; Start-Up</li>
            <li><a href="<?=site_url('welcome/backup');?>">Backup DB To Server</a></li>
            <li><a href="<?=site_url('welcome/download');?>">Download DB</a></li>
            <li><a href="<?=site_url('welcome/restore');?>">Restore DB From Server</a></li>
          </ol>
        </div><!--/.well -->
      </div><!--/span-->

      <div class="span9" id="content"> <?php /* the actual content */ ?>

        <div class="hero-unit">
          <h1>Hello, CRM!</h1>
          <p>This is the landing page for the the CRM Framework project.</p>          
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
                <td><?=anchor('ticketing/agent/'.$t->agent->id, $t->agent->username);?></td>
                <td><?=anchor('invoicing/customer/'.$t->customer->id, $t->customer->username);?></td>
                <td><?=$t->submit_datetime;?></td>
                <td><?=$t->subject;?></td>
                <td><?=$t->status;?></td>
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
                <th>Tickets Resolved/Total</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($agents as $a) {?>
              <tr>
                <td><?=$a->name;?></td>
                <td><?=$a->username;?></td>
                <td><?=$a->email;?></td>
                <td><?=
                  $a->ticket->where('resolved', 1)->count().'/'.
                  $a->ticket->count();
                  ?></td>
                <td><?=anchor('ticketing/agent/'.$a->id, 'Detail');?></td>
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
                <th colspan="2">Action</th>
              </tr>
            </thead>
            <tbody>
              <?php foreach ($invoices as $i) {?>
              <tr>
                <td><?=anchor('invoicing/customer/'.$i->customer->id, $i->customer->username);?></td>
                <td><?=$i->total; ?></td>
                <td><?=$i->due_date;?></td>
                <td><?=anchor('invoicing/invoice/'.$i->id, 'Detail');?></td>
                <td><?=anchor('invoicing/invoice_pdf/'.$i->id, 'PDF Invoice');?></td>
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
                <td><?=anchor('invoicing/role/'.$c->role->id, $c->role->role_name);?></td>
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
                <th>Status</th>
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
                <td><?=$s->status;?></td>
                <td><?=$s->monitoring->loadavg;?></td>
                <td><?=$s->monitoring->df;?></td>
                <td><?=$s->monitoring->free;?></td>
                <td><?=$s->monitoring->netstat;?></td>
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
