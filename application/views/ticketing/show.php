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
            <li class="nav-header">Ticketing menu</li>
          </ul>
        </div><!--/.well -->
      </div><!--/span-->


      <div class="span9" id="content"> <?php /* the actual content */ ?>

        <div class="hero-unit">
          <h1>Hello, CRM!</h1>
          <p>This is the landing page for the first checkpoint of the CRM Framework project.</p>
          <p><a class="btn btn-primary btn-large">Learn more &raquo;</a></p>
        </div>
        <div class="row-fluid">
          <div class="span4">
            <h2>Invoicing</h2>
            <p>Invoicing module allows for registration of new customers to the system. Invoice monitoring, reporting, and controlling.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
          </div><!--/span-->
          <div class="span4">
            <h2>Logging</h2>
            <p>Logging module is responsible for recording of all important events in the system so that the valid proof in case of trouble escalation occurs.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
          </div><!--/span-->
          <div class="span4">
            <h2>Monitoring</h2>
            <p>Monitoring module is designed to process automating performance statistics sent to the system by connected services.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
          </div><!--/span-->
        </div><!--/row-->
        <div class="row-fluid">
          <div class="span4">
            <h2>Ticketing</h2>
            <p>Ticketing module facilitates the requests submitted by users / customers of the system.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
          </div><!--/span-->
        </div><!--/row-->

      </div><!--/span-->

    </div><!--/row-->

    <?php $this->load->view('common/footer'); ?>

  </div><!--/.fluid-container-->

<?php $this->load->view('common/script'); ?>

</body>

</html>
