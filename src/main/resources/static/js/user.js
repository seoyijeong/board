let userObject = {
    // init() 함수선언
    init: function () {
        let _this = this;

        $("#btn-save").on("click", () => {
            _this.insertUser();
        });
    },
    insertUser: function () {
        alert("회원 가입 요청!!!");

        let user = {
            userId: $("#userId").val(),
            userName: $("#userName").val(),
            userPw: $("#userPw").val(),
            userEmail: $("#userEmail").val(),
            userGender: $("#userGender").val(),
            userTel: $("#userTel").val()
        }

        $.ajax({
           type:"post",
           url:"/login/register",
           data:JSON.stringify(user),
           contentType: "application/json; charset=utf-8"
        }).done(function(response){
           console.log(response);
            // location = "/";

            // validation 후
            let status = response["status"]; // 응답 상태코드
            if(status == 200){
                let message = response["data"];
                alert(message);
                location = "/";
            }else{
            let warn = "";
            let errors = response["data"]; // 리턴된 Map 데이터
            if(errors.userId != null) warn = warn + errors.userId + "\n";
            if(errors.userName != null) warn = warn + errors.userName + "\n";
            if(errors.userPw != null) warn = warn + errors.userPw + "\n";
            if(errors.userEmail != null) warn = warn + errors.userEmail + "\n";
            else warn = warn + errors + "\n";
            alert(warn);
            }
        }).fail(function(error){
            error = "이름 중복"
            alert("에러 발생 : " + error);
        });
    },
}

// userObject의 init함수 호출하기
userObject.init();