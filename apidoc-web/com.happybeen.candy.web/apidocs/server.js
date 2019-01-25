var http = require('http');
var fs = require('fs');
var url = require('url');
var querystring = require('querystring');

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

    console.log('Request for ' + request_path + ' received,method:' + request_method);
    if ('GET' == request_method) {
        doGet(request, response);
    } else if ('POST' == request_method) {
        doPost(request, response);
    } else {
        response.writeHead(404, {'Content-Type': 'text/html'});
        response.end();
    }
}).listen(server_port);

printBanner();

function postRouteAndResult(path_name, post, request, response) {
    post = querystring.parse(post);
    if (path_name == '/actions') {
        actions(response);
    } else if (path_name == '/action_by_id') {
        actionById(response, post['id']);
    } else if (path_name == '/params_by_action_id') {
        paramsByActionId(response, post['id'])
    } else {
        response.writeHead(404, {'Content-Type': 'text/html'});
        response.end();
    }
}

function doGet(request, response) {
    var path_name = '/index.html'

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
    var path_name = url.parse(request.url).pathname.trim();

    // 通过req的data事件监听函数，每当接受到请求体的数据，就累加到post变量中
    request.on('data', function (chunk) {
        post += chunk;
    });
    // 在end事件触发后，通过querystring.parse将post解析为真正的POST请求格式，然后向客户端返回。
    request.on('end', function () {
        postRouteAndResult(path_name, post, request, response);
        // response.write(data.toString())
        // response.end();
    });
}

function printBanner() {
    fs.readFile('./banner/banner.txt', 'utf8', function (err, data, fields) {
        console.log(data);
    });
    console.log('Api Candy Web server running at http://127.0.0.1:' + server_port + '/');
}

//mysql
var mysql = require('mysql');

//sql
var select_all_action = 'SELECT * FROM apicandy_action';
var select_action_by_id = 'SELECT * FROM apicandy_action WHERE id = ?';
var select_param_by_action_id = 'SELECT * FROM apicandy_param WHERE action_id = ?';
var select_header_by_action_id = 'SELECT * FROM apicandy_header WHERE action_id = ?';
var select_result_by_action_id = 'SELECT * FROM apicandy_result WHERE action_id = ?';

function excuteSelectSql(sql, sql_params, response) {
    console.log('--------------------------SELECT----------------------------');

    var sql_result = undefined;

    var connection = mysql.createConnection(mysql_config);
    connection.connect();
    connection.query(sql, sql_params, function (err, results, fields) {
        if (err) {
            console.log('[SELECT ERROR] - ', err.message);
            return;
        }
        console.log('RESULT:', results);
        var data = new Array();
        for (var i = 0; i < results.length; i++) {
            data.push(results[i])
        }
        response.write(JSON.stringify(data))
        response.end();
    });
    console.log('-----------------------------------------------------------------\n\n');
    connection.end();
    return sql_result
}

function actions(response) {
    console.log("actions==>>>");
    var sql_params = [];
    excuteSelectSql(select_all_action, sql_params, response);
}

function actionById(response, id) {
    console.log("actionById==>>> id:" + id);
    var sql_params = [id];
    excuteSelectSql(select_action_by_id, sql_params, response);
}

function paramsByActionId(response, id) {
    console.log("paramsByActionId==>>> id:" + id);
    var sql_params = [id];
    excuteSelectSql(select_param_by_action_id, sql_params, response);
}

function headersByActionId(response, id) {
    console.log("headersByActionId==>>> id:" + id);
    var sql_params = [id];
    excuteSelectSql(select_header_by_action_id, sql_params, response);
}

function resultsByActionId(response, id) {
    console.log("resultsByActionId==>>> id:" + id);
    var sql_params = [id];
    excuteSelectSql(select_result_by_action_id, sql_params, response);
}