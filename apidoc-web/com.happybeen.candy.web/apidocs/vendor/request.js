document.write("<script language=javascript src='./vendor/handlebars.min.js'></script>");

window.onload = function () {
    var helper = Handlebars.registerHelper("compare", function (v1, v2, options) {
        if (v1 == v2) {
            return options.fn(this);
        } else {
            return options.inverse(this);
        }
    });
}

function actionById(e) {
    $('#loader').show();

    var id = $(e).attr('id');
    var template_sections = Handlebars.compile($('#template-sections').html());
    $('#action').empty();
    ajaxPost("/action_by_id", {"id": id}, template_sections, "#action");

    headerByActionId(id);
    paramsByActionId(id);
    resultByActionId(id);

    title(e);
}

function headerByActionId(id) {
    var template_header = Handlebars.compile($('#template-header').html());
    $('#header').empty();
    ajaxPost("/headers_by_action_id", {"id": id}, template_header, "#header");
}

function paramsByActionId(id) {
    var template_header = Handlebars.compile($('#template-param').html());
    $('#param').empty();
    ajaxPost("/params_by_action_id", {"id": id}, template_header, "#param");
}

function resultByActionId(id) {
    var template_result = Handlebars.compile($('#template-result').html());
    $('#result').empty();
    ajaxPost("/results_by_id", {"id": id}, template_result, "#result");
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

function openParam(e) {
    var id = $(e).attr('actionid')
    $('.' + id).show();
    $(e).text("Close");
    $(e).attr("onclick", "closeParam(this)");
}

function closeParam(e) {
    var id = $(e).attr('actionid')
    $('.' + id).hide();
    $(e).text("Open");
    $(e).attr("onclick", "openParam(this)");
}

function title(e) {
    var name = $(e).attr("name");
    $("title").html(name);

    $('#loader').hide();
}