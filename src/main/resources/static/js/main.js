var nominal     = $(".nominal");
var currYen     = $(".currentYen");
var value =       $(".value");

var htmlString = 'Текущий курс:'+ '<br>';
$(document).ready(function() {
$.get('/getLast', function (data) {
  nominal.append(data.nominal);
  value.append(data.value);
    htmlString += 'Nominal ='+nominal.prop("outerHTML") + 'Value ='+value.prop("outerHTML");
    currYen.html(htmlString);
})});

function buy() {
    $.get('/getLast', function (data) {

    });
}
function sell() {
    $.get('/getLast', function (data) {

    });
}