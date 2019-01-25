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
        $(function () {

            //load side data
            function api_side_data() {

            }

            var template_side_nav = handlebars.compile($('#template-sidenav').html());
        })
    })