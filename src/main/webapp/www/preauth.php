<?php

// http://wiki.zimbra.com/wiki/Preauth

/**
* Globals. Can be stored in external config.inc.php or retreived from a DB.
*/
$PREAUTH_KEY="ed992df86bd8b8f74ec386e3cf2a08f8cc99fa46e6de28f719a6e59c8d2518d3";
$WEB_MAIL_PREAUTH_URL="http://mx1.novymail.cz/service/preauth";

/**
* User's email address and domain. In this example obtained from a GET query parameter. 
* i.e. preauthExample.php?email=user@domain.com&domain=domain.com
* You could also parse the email instead of passing domain as a separate parameter
*/
// $user = $_GET["user"];
// $domain=$_GET["domain"];

$user = 'test';
$domain = 'novymail.cz';
	
$email = "{$user}@{$domain}";

if(empty($PREAUTH_KEY)) {
    die('0');
    // die("Need preauth key for domain ".$domain);
}

$redirectURL = '';
if (!empty($_REQUEST['t'])) {
	switch ($_REQUEST['t']) {
		case 'h':
		case 'm':
			$redirectURL = '&redirectURL=/zimbra/'.$_REQUEST['t'].'/';
	}
	
}

/**
* Create preauth token and preauth URL
*/

$timestamp 		= time()*1000;

$preauthToken	= hash_hmac("sha1",$email."|name|0|".$timestamp,$PREAUTH_KEY);

$preauthURL 	= $WEB_MAIL_PREAUTH_URL."?account=".$email.
	"&by=name&timestamp=".$timestamp.
	"&expires=0&preauth=".$preauthToken.$redirectURL;

/**
 * Redirect to Zimbra preauth URL
 */
header("Location: $preauthURL");
