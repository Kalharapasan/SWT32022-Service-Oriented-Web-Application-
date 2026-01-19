const soap = require('soap');
const url = 'http://localhost:8080/HelloService?wsdl';

// Create client and call service
soap.createClient(url, function(err, client) {
  if (err) {
    console.error("Error creating client:", err);
    return;
  }
  
  console.log("Client created successfully!");
  console.log("Available methods:", Object.keys(client));
  
  // Call sayHello operation
  client.sayHello({ firstName: 'Alice' }, function(err, result) {
    if (err) {
      console.error("Error calling service:", err);
      return;
    }
    
    console.log("Full result object:", JSON.stringify(result, null, 2));
    console.log("Response:", result.greeting || result);
  });
});