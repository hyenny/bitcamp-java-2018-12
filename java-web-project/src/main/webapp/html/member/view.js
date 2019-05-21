
var param = location.href.split('?')[1];
if (param) {
	document.querySelector('h1').innerHTML = "회원 조회";
	loadData(param.split('=')[1]);
	var el = document.querySelectorAll('.bit-new-item');
	for (e of el) {
		e.style.display = 'none';
	}
} else {
	document.querySelector('h1').innerHTML = "새 회원"
		var el = document.querySelectorAll('.bit-view-item');
	for (e of el) {
		e.style.display = 'none';
	}
}

var imgBox = $('#imgBox');


//$('#photoFile').fileupload({
//dataType: 'json', /* "서버가 보낸 데이터가 JSON 문자열이다. 자바스크립트 객체로 바꿔라." 라는 의미*/
//done: function (e, data) { 
//console.log('done()...');
//console.log(data.result);

//$('<img>')
//.attr('src', '../../upload/member/' + data.result.name)
//.appendTo(imgBox);
//$('<img>')
//.attr('src', '../../upload/member/' + data.result.name + '_50x50.jpg')
//.appendTo(imgBox);
//}
//});


//document.querySelector('#add-btn').onclick = () => {
//var xhr = new XMLHttpRequest()
//xhr.onreadystatechange = function() {
//if (xhr.readyState != 4 || xhr.status != 200)
//return;

//var data = JSON.parse(xhr.responseText);

//if (data.status == 'success') {
//location.href = "index.html"

//} else {
//alert('등록 실패입니다!\n' + data.message)
//}
//};
//xhr.open('POST', '../../app/json/member/add', true)
//xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

//var title = document.querySelector('#title').value;
//var contents = document.querySelector('#contents').value;
//var startDate = document.querySelector('#startDate').value;
//var endDate = document.querySelector('#endDate').value;
//var totalHours = document.querySelector('#totalHours').value;
//var dayHours = document.querySelector('#dayHours').value;



//xhr.send(qs);

//};

//document.querySelector('#delete-btn').onclick = () => {
//var xhr = new XMLHttpRequest()
//xhr.onreadystatechange = function() {
//if (xhr.readyState != 4 || xhr.status != 200)
//return;

//var data = JSON.parse(xhr.responseText);

//if (data.status == 'success') {
//location.href = "index.html"

//} else {
//alert('삭제 실패입니다!\n' + data.message)
//}
//};
//var no = document.querySelector('#no').value;
//xhr.open('GET', '../../app/json/member/delete?no=' + no, true)
//xhr.send();
//};

//document.querySelector('#update-btn').onclick = () => {
//var xhr = new XMLHttpRequest()
//xhr.onreadystatechange = function() {
//if (xhr.readyState != 4 || xhr.status != 200)
//return;

//var data = JSON.parse(xhr.responseText);

//if (data.status == 'success') {
//location.href = "index.html"

//} else {
//alert('변경 실패입니다!\n' + data.message)
//}
//};
//xhr.open('POST', '../../app/json/member/update', true)
//xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

//var no = document.querySelector('#no').value;
//var contents = document.querySelector('#contents').value;
//var title = document.querySelector('#title').value;
//var startDate = document.querySelector('#startDate').value;
//var endDate = document.querySelector('#endDate').value;
//var totalHours = document.querySelector('#totalHours').value;
//var dayHours = document.querySelector('#dayHours').value;

//var qs = 'title=' + encodeURIComponent(title) +
//'&contents=' + encodeURIComponent(contents) +
//'&startDate=' + startDate +
//'&endDate=' + endDate +
//'&totalHours=' + totalHours +
//'&dayHours=' + dayHours +
//'&no=' + no;

//xhr.send(qs);

//};

//$('#add-btn').click((e) => {
//	var name = $('#name').val(),
//	email = $('#email').val(),
//	password = $('#password').val(),
//	photoFile = $('#photoFile').val(),
//	tel = $('#tel').val();
//
//	var qs = 'name=' + encodeURIComponent(name) +
//	'&email=' + email +
//	'&password=' + encodeURIComponent(password) +
//	'&photoFile=' + photoFile +
//	'&tel=' + tel;
//
//
//	//var qs = $( "form" ).serialize();
//
//	console.log(qs);
//
//});





function loadData(no) {
	console.log(no);
	$.getJSON('../../app/json/member/detail?no=' + no,
			function(data) {

		console.log(data);

		var photoFile = data.photo;

		$('#no').val(data.no);
		$('#name').val(data.name);
		$('#email').val(data.email);
		$('#password').val(data.password);
		//$('#photoFile').val(photoFile);
		$('#tel').val(data.tel);
		$('#registeredDate').val(data.registeredDate);

		$('<img>')
		.attr('src', '/java-web-project/upload/member/' + data.photo)
		.appendTo(imgBox);

	});
}








