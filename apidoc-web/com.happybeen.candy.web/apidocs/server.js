var http = require('http');
var fs = require('fs');
var url = require('url');

var apicandy = "index.html"

//服务信息
var port = 8090

http.createServer(function (request, response) {
    var request_path = url.parse(request.url).pathname;
    var request_method = request.method

    console.log("Request for " + request_path + " received,,method:" + request_method);
    if ("GET" == request_method) {
        doGet(request, response);
    } else if ("POST" == request_method) {
        doPost(request, response);
    } else {
        response.writeHead(404, {'Content-Type': 'text/html'});
        response.end();
    }
}).listen(port);

printBanner();

function doGet(request, response) {
    var path_name = url.parse(request.url).pathname;
    fs.readFile(path_name.substr(1), function (err, data) {
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
}

function doPost(request, response) {
    // 定义了一个post变量，用于暂存请求体的信息
    var post = '';

    // 通过req的data事件监听函数，每当接受到请求体的数据，就累加到post变量中
    request.on('data', function (chunk) {
        post += chunk;
    });

    // 在end事件触发后，通过querystring.parse将post解析为真正的POST请求格式，然后向客户端返回。
    request.on('end', function () {
        post = querystring.parse(post);
        response.end(util.inspect(post));
    });
}

function printBanner(){
    console.log("    _     ___   ___    ___     _     _  _   ___   __   __")
    console.log("   /_\\   | _ \\ |_ _|  / __|   /_\\   | \\| | |   \\  \\ \\ / /");
    console.log("  / _ \\  |  _/  | |  | (__   / _ \\  | .` | | |) |  \\ V /");
    console.log(" /_/ \\_\\ |_|   |___|  \\___| /_/ \\_\\ |_|\\_| |___/    |_|  ");
    console.log("                                                  v:1.0.0")
    console.log('Api Candy Web server running at http://127.0.0.1:' + port + '/');
}

//mysql
var mysql = require('mysql');
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'test'
});

//sql
var select_all_api = "SELECT * FROM apicandy_action";
var select_param_by_action_id = "SELECT * FROM apicandy_param WHERE action_id = ?";
var select_header_by_action_id = "SELECT * FROM apicandy_header WHERE action_id = ?";
var select_result_by_action_id = "SELECT * FROM apicandy_result WHERE action_id = ?";

function excuteSelectSql(sql, sql_params) {
    connection.connect();
    var sql_result;
    connection.query(sql, sql_params, function (err, result) {
        if (err) {
            console.log('[SELECT ERROR] - ', err.message);
            return;
        }
        sql_result = result;
        console.log('--------------------------SELECT----------------------------');
        console.log('RESULT:', result);
        console.log('-----------------------------------------------------------------\n\n');
    });
    connection.end();
    return sql_result
}


