function formCheck(formId) {
    var form = document.getElementById(formId);
    for (var i = 0; i < form.length; i++) {
        if (form[i].type === "button") continue;
        console.log(form[i].value);
        if (form[i].value == null || form[i].value == "") {
            alert("请填写完整！");
            return false;
        }
    }
    return true;
}
