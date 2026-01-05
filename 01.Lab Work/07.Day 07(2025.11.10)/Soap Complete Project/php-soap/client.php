<?php
$client = new SoapClient(null, [
    'location' => "http://localhost:8081/server.php",
    'uri' => "http://localhost/soap",
    'trace' => 1
]);

$users = $client->__soapCall("getUsers", []);
print_r($users);
?>
