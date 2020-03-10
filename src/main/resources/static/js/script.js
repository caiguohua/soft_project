// 模拟后台接口
function getData(params) {
	var data = [
		{id: '套餐A：究极套餐很帅', name: '套餐A：究极套餐很帅AAAAAAAAAAAAAAAAA', age: 10},
		{id: '套餐A：究极套餐很帅', name: '当', age: 23},
		{id: '套餐A：究极套餐很帅', name: '节点', age: 12},
		{id: '套餐A：究极套餐很帅', name: '科二', age: 23},
		{id: '套餐A：究极套餐很帅', name: '开心', age: 44},
		{id: '套餐A：究极套餐很帅', name: '为', age: 12},
		{id: '套餐A：究极套餐很帅', name: '看我', age: 22},
		{id: '套餐A：究极套餐很帅', name: '看', age: 43},
		{id: '套餐A：究极套餐很帅', name: '考虑', age: 15},
		{id: '套餐A：究极套餐很帅', name: '为额', age: 18},
		{id: '套餐A：究极套餐很帅', name: '熊', age: 32},
		{id: '套餐A：究极套餐很帅', name: '下', age: 51},
		{id: '套餐A：究极套餐很帅', name: '前往', age: 23},
		{id: '套餐A：究极套餐很帅', name: '我去', age: 28},
		{id: '套餐A：究极套餐很帅', name: '问', age: 36},
		{id: '套餐A：究极套餐很帅', name: '跳', age: 46},
		{id: '套餐A：究极套餐很帅', name: '欧文', age: 31}
	]

	var start = (params.current - 1) * params.size;
	var end = params.current *params.size;
	
	return {
		total: data.length,
		list: data.splice( (params.current - 1) * params.size, params.size )
	}
}

// 设置tbody的html
function setTbody (arr) {
	var html = '';
	for (var i = 0; i < arr.length; i++) {
		var item = arr[i];
		html += '<tr><td>' + item.id + '</td><td>' + item.name + '</td><td>' + item.age + '</td></tr>';
	}
	$('.tbody').html(html);
}



// 初始化分页
$('.box2').MyPaging({
	size: 3,
	total: 0,
	current: 1,
	prevHtml: '上一页',
	nextHtml: '下一页',
	layout: 'total, totalPage, prev, pager, next, jumper',
	jump: function () {
		var _this = this;

		// 模拟ajax获取数据
		setTimeout(function () {
			var res = getData({
				size: _this.size,
				current: _this.current
			})

			setTbody(res.list);

			// 必须调用
			_this.setTotal(res.total);
		}, 100);
	}
});