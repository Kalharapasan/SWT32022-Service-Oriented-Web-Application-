# server.py
from spyne import Application, rpc, ServiceBase, Unicode
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from wsgiref.simple_server import make_server

class HelloService(ServiceBase):
    @rpc(Unicode, _returns=Unicode)
    def sayHello(ctx, firstName):
        return f"Hello, {firstName} from Python SOAP Service!"

application = Application([HelloService],
    tns='http://example.com/wsdl/HelloService',
    in_protocol=Soap11(validator='lxml'),
    out_protocol=Soap11()
)

if __name__ == '__main__':
    wsgi_app = WsgiApplication(application)
    server = make_server('localhost', 8080, wsgi_app)
    print("Listening on http://localhost:8080")
    server.serve_forever()