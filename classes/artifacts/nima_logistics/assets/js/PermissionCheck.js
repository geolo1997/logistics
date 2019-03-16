function permissionCheck() {
    console.log(document.getElementById("stateTag").innerText);
    if (document.getElementById("stateTag").innerText == null || document.getElementById("stateTag").innerText == "" || document.getElementById("stateTag").innerText == "\n") {
        console.log("未登录");
        document.getElementById("login_or_register").style.display = "block";
        document.getElementById("profileLi").style.display = "none";
        // document.getElementById("sidebar").style.display = "none";
    } else {
        console.log("已登录");
        document.getElementById("login_or_register").style.display = "none";
        document.getElementById("profileLi").style.display = "block";
        if (document.getElementById("identity").innerText == "DRIVER" || document.getElementById("identity").innerText == "DRIVER\n") {
            var x = document.getElementsByClassName("shippers");
            for (var i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
        } else if (document.getElementById("identity").innerText == "SHIPPER" || document.getElementById("identity").innerText == "SHIPPER\n") {
            var x = document.getElementsByClassName("drivers");
            for (var i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
        }
    }
}