<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="<?=site_url('/')?>">CRM Framework</a>
      <div class="nav-collapse collapse">
        <p class="navbar-text pull-right">
          <!-- Logged in as <a href="#" class="navbar-link">Username</a> -->
        </p>
        <ul class="nav">
          <li<?= $this->uri->segment(1) == '' ? ' class="active"':'';?>><a href="<?=site_url('/')?>">Dashboard</a></li>
          <li<?= $this->uri->segment(1) == 'ticketing' ? ' class="active"':'';?>><a href="<?=site_url('ticketing');?>">Ticketing</a></li>
          <li<?= $this->uri->segment(1) == 'invoicing' ? ' class="active"':'';?>><a href="<?=site_url('invoicing');?>">Invoicing</a></li>
          <li<?= $this->uri->segment(1) == 'monitoring' ? ' class="active"':'';?>><a href="<?=site_url('monitoring');?>">Monitoring</a></li>
          <li<?= $this->uri->segment(1) == 'logging' ? ' class="active"':'';?>><a href="<?=site_url('logging');?>">Logging</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</div>
