var http = require('http');
var fs = require('fs');
var url = require('url');

// 服务信息
var server_port = '8090';

var mysql_config = {
    host: 'localhost',
    port: '3306',
    user: 'root',
    password: '123456',
    database: 'test'
}


http.createServer(function (request, response) {
    var request_path = url.parse(request.url).pathname;
    var request_method = request.method

    console.log("Request for " + request_path + " received,method:" + request_method);
    if ("GET" == request_method) {
        doGet(request, response);
    } else if ("POST" == request_method) {
        doPost(request, response);
    } else {
        response.writeHead(404, {'Content-Type': 'text/html'});
        response.end();
    }
}).listen(server_port);

printBanner();

function postRouteAndResult(path_name) {
    var data = "";
    if (path_name == "/action") {
        data = action();
    } else {
        data = action();
    }
    return data;
}

function doGet(request, response) {
    var path_name = "/index.html"

    fs.readFile(path_name.substr(1), function (err, data) {
        if (err) {
            console.log(err);
            // HTTP 状态码: 404 : NOT FOUND
            // Content Type: text/plain
            response.writeHead(404, {'Content-Type': 'text/html'});
        } else {
            // HTTP 状态码: 200 : OK
            // Content Type: text/plain
            response.write(data);
        }
        // 发送响应数据
        response.end();
    });
}

function doPost(request, response) {
    // 定义了一个post变量，用于暂存请求体的信息
    var post = '';
    var path_name = url.parse(request.url).pathname;

    // 通过req的data事件监听函数，每当接受到请求体的数据，就累加到post变量中
    request.on('data', function (chunk) {
        post += chunk;
    });

    // 在end事件触发后，通过querystring.parse将post解析为真正的POST请求格式，然后向客户端返回。
    request.on('end', function () {
        var data = postRouteAndResult(path_name);
        response.write(data.toString())
        response.end();
    });
}

function printBanner() {
    fs.readFile('./banner/banner.txt', 'utf8', function (err, data) {
        console.log(data);
    });
    console.log('Api Candy Web server running at http://127.0.0.1:' + server_port + '/');
}

//mysql
var mysql = require('mysql');
var connection = mysql.createConnection(mysql_config);

//sql
var select_all_api = "SELECT * FROM apicandy_action";
var select_param_by_action_id = "SELECT * FROM apicandy_param WHERE action_id = ?";
var select_header_by_action_id = "SELECT * FROM apicandy_header WHERE action_id = ?";
var select_result_by_action_id = "SELECT * FROM apicandy_result WHERE action_id = ?";

function excuteSelectSql(sql, sql_params) {
    connection.connect();
    var sql_result = null;
    console.log('--------------------------SELECT----------------------------');
    connection.query(sql, sql_params, function (err, result) {
        if (err) {
            console.log('[SELECT ERROR] - ', err.message);
            return;
        }
        sql_result = result;
        console.log('RESULT:', result);
    });
    connection.end();
    console.log('-----------------------------------------------------------------\n\n');
    return sql_result
}

function action() {
    var sql_params = [];
    var result = excuteSelectSql(select_all_api, sql_params);
    if (result == null) {
        result = "";
    }
}

