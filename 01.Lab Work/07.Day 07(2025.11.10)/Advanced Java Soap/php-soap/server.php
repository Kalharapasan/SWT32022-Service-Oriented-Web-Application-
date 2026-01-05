<?php
$server = new SoapServer(null, ['uri' => "http://localhost/soap"]);
$server->addFunction('getUsers');

function getUsers() {
    $pdo = new PDO("mysql:host=localhost;dbname=soap_db", "root", "");
    $stmt = $pdo->query("SELECT name, email FROM users");
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

$server->handle();
?>
