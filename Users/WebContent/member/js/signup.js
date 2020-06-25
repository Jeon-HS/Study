
// 스크립트 링크가 body 위에 있다면 window의 load 이벤트 안에 작성
window.addEventListener('load', function(event){
	// id를 가지고 필요한 객체들을 찾아오기
	var registerform = document.getElementById("signupform");
	var msg = document.getElementById("msg");
	var email = document.getElementById("user_email");
	var emailmsg = document.getElementById("emailmsg");
	
	var password = document.getElementById("user_password");
	var password1 = document.getElementById("password1");
	var passwordmsg = document.getElementById("passwordmsg");

	var registerbtn = document.getElementById("signupbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	// mainbtn을 클릭하면 메인 화면으로 이동
	mainbtn.addEventListener("click", function(event){
		location.href = "../";
	});
	
	// loginbtn을 클릭하면 login 으로 이동하도록 작성
	loginbtn.addEventListener("click", function(event){
		location.href = "login";
	});
	
	// email 중복검사 통과 여부를 저장할 변수
	var emailcheck = false;
	
	// email을 작성하고 포커스가 떠나면 중복검사를 수행
	email.addEventListener("focusout", function(event){
		if(email.value.trim().length == 0){
			emailmsg.innerHTML = "이메일을 입력하고 넘어가세요!!";
			emailmsg.style.color = 'red';
			// 검사하지 않도록 리턴
			return;
		}
		// ajax 요청 객체를 생성
		var request = new XMLHttpRequest();
		// 요청 생성
		request.open('get', 
			'emailcheck' + '?' + 'email=' + email.value, true);
		// 요청을 전송
		request.send('');
		// 결과를 받기 위한 부분 생성
		request.addEventListener('load', function(event){
			// 결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				emailmsg.innerHTML = "사용 가능한 이메일";
				emailmsg.style.color = "blue";
				// email 중복 검사를 통과했다고 표시
				emailcheck = true;
			}else{
				emailmsg.innerHTML = "사용 중 인 이메일";
				emailmsg.style.color = "red";
				// email 중복 검사를 통과 못했다고 표시
				emailcheck = false;
			}
		})
	});
});	
