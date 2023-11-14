let loginObject = {
    // init() 함수선언
    init: function () {
        let _this = this;

        $("#btn-login").on("click", () => {
            _this.login();
        });
    },
    login: function () {
        alert("로그인 요청!!!");

        let user = {
            userId: $("#userId").val(),
            userPw: $("#userPw").val()
        }
        console.log(user);
        $.ajax({
           type:"post",
           url:"/login/login",
           data:JSON.stringify(user),
           contentType: "application/json; charset=utf-8"
        }).done(function(response){
            // location = "/";

            let status = response["status"]; // 응답 상태코드
            if(status == 200){
                let message = response["data"];
                console.log(response);
                alert(message);
                location = "/";
            }else{
                let warn = "";
                let errors = response["data"]; // 리턴된 Map 데이터
                 warn = warn + errors + "\n";
                console.log(response);
                alert(warn);
            }
        }).fail(function(error){
            alert("에러 발생 : " + error);
        });
    },
}

loginObject.init();