const soap = require('soap');
const express = require('express');
const fs = require('fs');
const app = express();

// Define the service implementation
const service = {
  HelloService: {
    HelloPortType: {
      sayHello: function(args, callback) {
        console.log("Received request for:", args.firstName);
        const response = {
          greeting: `Hello, ${args.firstName}! Welcome to SOAP Web Service.`
        };
        return response;
      }
    }
  }
};

// Read WSDL file
const wsdl = fs.readFileSync('HelloService.wsdl', 'utf8');

// Attach SOAP service first
soap.listen(app, '/HelloService', service, wsdl);

// Create SOAP server
const server = app.listen(8080, function() {
  const host = 'localhost';
  const port = 8080;
  
  console.log(`Server running at http://${host}:${port}/`);
  console.log(`WSDL available at http://${host}:${port}/HelloService?wsdl`);
});