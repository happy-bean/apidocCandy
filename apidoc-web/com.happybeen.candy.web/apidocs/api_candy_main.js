require.config({
    paths: {
        "jquery": "./vendor/jquery.min",
        "handlebars": "./vendor/handlebars.min",
        "api_candy": "api_candy",
        "api_candy_connection": "./util/mysql/connection",
        "api_candy_sql": "./util/mysql/common_sql",
    }
})
require(
    [
        "jquery",
        "handlebars",
        "api_candy",
        "api_candy_connection",
        "api_candy_sql",
    ], function ($, _, api_candy, mysql_connection, api_candy_sql) {
        $(function () {

            //load side data
            function api_side_data() {
                var sql = api_candy_sql.api_candy_sql.select_all_api;
                var params = [];
                var action_data = excute_select_sql(sql, params)
            }

            function excute_select_sql(sql, sql_params) {
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

            var template_side_nav = Handlebars.compile($('#template-sidenav').html());
        })
    })