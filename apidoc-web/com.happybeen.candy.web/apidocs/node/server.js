var http = require('http');
var fs = require('fs');
var url = require('url');

http.createServer(function (request, response) {
    var pathname = url.parse(request.url).pathname;

    console.log("Request for " + pathname + " received.");
    fs.readFile(pathname.substr(1), function (err, data) {
        if (err) {
            console.log(err);
            // HTTP 状态码: 404 : NOT FOUND
            // Content Type: text/plain
            response.writeHead(404, {'Content-Type': 'text/html'});
        } else {
            // HTTP 状态码: 200 : OK
            // Content Type: text/plain
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.write(data.toString());
        }
        //  发送响应数据
        response.end();
    });
}).listen(8090);
var http = require('http');

// 终端打印如下信息
console.log('Api Candy Server running at http://127.0.0.1:8888/');
