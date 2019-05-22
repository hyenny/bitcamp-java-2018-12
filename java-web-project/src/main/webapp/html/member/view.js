
var param = location.href.split('?')[1];
var url;
var imgBox = $('#imgBox');

if (param) {
	url = '../../app/json/member/update';
	document.querySelector('h1').innerHTML = "회원 조회";
	loadData(param.split('=')[1]);
	var el = document.querySelectorAll('.bit-new-item');
	for (e of el) {
		e.style.display = 'none';
	}
} else {
	url = '../../app/json/member/add';
	document.querySelector('h1').innerHTML = "새 회원"
		var el = document.querySelectorAll('.bit-view-item');
	for (e of el) {
		e.style.display = 'none';
	}
}



$('#photo').fileupload({
	url: url,        // 서버에 요청할 URL
	dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
	add: function (e, data) {
		console.log('add()...');
		console.log('fileuploadURL: ' + url);

		$('#add-btn').on('click', function() {
			// data 객체의 formData 프로퍼티에 일반 파라미터 값을 설정한다.
			data.formData = {
					name: $('#name').val(),
					email: $('#email').val(),
					password: $('#password').val(),
					tel: $('#tel').val()
			};
			console.log('add : ' + data.formData);
			console.log(url);
			data.submit();	
		});

		$('#update-btn').on('click', function() { 
			// data 객체의 formData 프로퍼티에 일반 파라미터 값을 설정한다.
			data.formData = {
					no: $('#no').val(),
					name: $('#name').val(),
					email: $('#email').val(),
					password: $('#password').val(),
					tel: $('#tel').val()
			};
			console.log('update : ' + data.formData);
			console.log(url);
			data.submit();	
		});

	}, 
	done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
		console.log('done()...');
		console.log(data.result);

		if (data.result.status == 'success') {
			location.href = "index.html"
		} 
	}
}); 

$('#delete-btn').click((e) => {
	e.preventDefault();
	var no = $('#no').val();
	$.getJSON('../../app/json/member/delete?no=' + no,
			function(data) {

		if (data.status == 'success') {
			location.href = "index.html"
		} else {
			alert('삭제 실패입니다!\n' + data.message)
		}
	});
});





function loadData(no) {
	console.log(no);
	$.getJSON('../../app/json/member/detail?no=' + no,
			function(data) {

		console.log(data);

		$('#no').val(data.no);
		$('#name').val(data.name);
		$('#email').val(data.email);
		$('#password').val(data.password);
		// $('#photoFile').val(photoFile);
		$('#tel').val(data.tel);
		$('#registeredDate').val(data.registeredDate);

		$('<img>')
		.attr('src', '/java-web-project/upload/member/' + data.photo)
		.appendTo(imgBox);

	});
}








