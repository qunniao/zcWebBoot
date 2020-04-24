
//读取cookies
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    console.log("getCookie ca:"+ca);
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) {

            console.log("存在cookie:"+cname);
            if("zcWebBoot_login_phone"==cname){
                $("#username").val(c.substring(name.length,c.length));
            }else if("zcWebBoot_login_pwd"==cname){
                $("#password").val(c.substring(name.length,c.length));
            }

            //return c.substring(name.length,c.length);
        }
    }
    return "";
}


getCookie("zcWebBoot_login_phone");
getCookie("zcWebBoot_login_pwd");

function checkForm() {
    var username = $("#username").val();
    var password = $("#password").val();
    var online = $("#online").val();
    if(username=="")return false;
    if(password=="")return false;
    console.log("online:"+online);
    $.ajax({
        url : serverHost()+"/admin/login",
        type : "post",
        dataType : "json",
        data:{username: username,password:password,online:online},
        success : function(data){
            console.log(data);
            if (data && data.success) {
                console.log("index.js返回成功");
                window.location.href = serverHost()+'/home';
            } else {
                console.log("index.js返回失败");
            }
        }
    });

    return false;
}


function submitAjax3(){
    var username = $("#username").val();
    var password = $("#password").val();
    if(username=="")return false;
    if(password=="")return false;
    console.log("username:"+username+"   password:"+password);
    $.post(serverHost()+"/user/login", { username: username,password:password }, function (text, status) {
        console.log("返回结果")
        location.href=serverHost()+"/home";
    });
}

function submitAjax2(){
    var username = $("#username").val();
    var password = $("#password").val();
    if(username=="")return false;
    if(password=="")return false;
    console.log("username:"+username+"   password:"+password);
    $.ajax({
        url: serverHost()+"/login",
        type: "POST",
        dataType: "json",
        data: {
            "username":username,
            "password": password
        },
        async: false,
        success: function(data) {
            console.log("登录结果："+data.code+"  msg:"+data.msg);
        },
        error: function() {
            alert("添加失败");
        }
    });
}