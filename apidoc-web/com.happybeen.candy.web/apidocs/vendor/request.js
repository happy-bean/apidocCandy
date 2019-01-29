document.write("<script language=javascript src='./vendor/handlebars.min.js'></script>");

function actionByAttr(id) {
    actionById($(id).attr("id"))
}

function actionById(id) {
    var template_sections = Handlebars.compile($('#template-sections').html());
    $('#action').empty();
    ajaxPost("/action_by_id", {"id": id}, template_sections, "#action");
}

function headerByActionId() {
    var template_header = Handlebars.compile($('#template-header').html());
    $('#header').empty();
    ajaxPost("/headers_by_action_id", {"id": id}, template_header, "#header");
}

function paramsByActionId() {
    
}

function resultByActionId() {
    
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