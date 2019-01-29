require.config({
    paths: {
        "jquery": "./vendor/jquery.min",
        "handlebars": "./vendor/handlebars.min",
        "api_candy": "api_candy"
    }
})
require(
    [
        "jquery",
        "handlebars",
        "api_candy", "vendor/handlebars.min"
    ], function ($, handlebars, api_candy) {
        var handleHelper = handlebars.registerHelper("addOne", function (index) {
            //返回+1之后的结果
            return index + 1;
        });

        // template

        var template_side_nav = handlebars.compile($('#template-sidenav').html());
        var template_project = handlebars.compile($('#template-project').html());
        var template_header = handlebars.compile($('#template-header').html());
        var template_footer = handlebars.compile($('#template-footer').html());
        var template_generator = handlebars.compile($('#template-generator').html());
        //var template_sections = handlebars.compile($('#template-sections').html());


        loadHtml();

        //load html
        function loadHtml() {
            ajaxPost("/actions", {}, template_side_nav, "#sidenav");

            $('#project').append(template_project(api_candy));
            $('#header').append(template_header(api_candy));
            $('#footer').append(template_footer(api_candy));
            $('#generator').append(template_generator(api_candy));
        }

        function ajaxPost(url, data, template, id) {
            $.ajax({
                url: url,
                data: data,
                dataType: "json",
                type: "POST",
                success: function (result) {
                    console.log("----info----result：" + JSON.stringify(result));
                    $(id).append(template(result));
                },
                error: function (result) {
                    console.log("----error---error：" + result)
                }
            });
        }
    });