var param = location.href.split('?')[1];
var contents;
var no;

if (param) {
	$('h1').html('게시물 조회');
	loadData(param.split('=')[1]);
	var el = $('.bit-new-item');
	for (e of el) {
		e.style.display = 'none';
	}
} else {
	$('h1').html('새 글');
	var el = $('.bit-view-item');
	for (e of el) {
		e.style.display = 'none';
	}
}


var editor = CKEDITOR.replace('contents', {
	width : '90%',
	height : 300
});


$('#add-btn').click((e) => {
	e.preventDefault();
	var url = '../../app/json/board/add';
	saveData(url);
});

$('#update-btn').click((e) => {
	e.preventDefault();
	no = $('#no').val();
	var url = '../../app/json/board/update';	
	saveData(url);
});

$('#delete-btn').click((e) => {
	e.preventDefault();
	var no = $('#no').val();
	$.getJSON('../../app/json/board/delete?no=' + no,
			function(data) {

		if (data.status == 'success') {
			location.href = "index.html"
		} else {
			alert('삭제 실패입니다!\n' + data.message)
		}

	});
});



function saveData(url) {
	var qs;
	var title = $('#title').val();

	for (instance in CKEDITOR.instances) {
		CKEDITOR.instances[instance].updateElement();
		contents = CKEDITOR.instances[instance].getData();
	}

	if (url.endsWith('add'))  {
		qs = 'title=' + encodeURIComponent(title) + '&contents=' + encodeURIComponent(contents);
		console.log('add: ' + url, qs)
	} else { // update
		qs = 'title=' + encodeURIComponent(title) + '&contents=' + encodeURIComponent(contents) + '&no=' + no;
		console.log('update: ' + url, qs)
	}

	$.ajax({
		type: 'POST',
		url: url,
		data: qs,
		dataType: 'json',
		success: function(data) {
			console.log(data);
			console.log('성공!');
			if (data.status == 'success') {
				location.href = "index.html"
			} else {
				alert('전송 실패입니다!\n' + data.message)
			}
		}
	});  
	return false; 

}

function loadData(no) {
	$.getJSON('../../app/json/board/detail?no=' + no,
			function(data) {

		console.log(data);

		$('#no').val(data.no);
		$('#title').val(data.title);
		$('#contents').val(data.contents);
		$('#createdDate').val(data.createdDate);
		$('#viewCount').val(data.viewCount);

	});

	//$( '#contents' ).attr( 'readonly', 'true' );


}







