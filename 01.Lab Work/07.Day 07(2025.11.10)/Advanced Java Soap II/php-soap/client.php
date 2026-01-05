<?php
$client = new SoapClient(null, [
    'location' => "http://localhost:8080/ws/users",
    'uri' => "http://soap.example.com/",
    'trace' => 1
]);

// Get all users
$users = $client->__soapCall("getAllUsers", []);
print_r($users);

// Create new user
$newUser = ['name'=>'Charlie','email'=>'charlie@example.com','age'=>28];
$client->__soapCall("createUser", [$newUser]);
echo "User created!\n";
?>
