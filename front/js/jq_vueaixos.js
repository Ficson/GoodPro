jQuery.extend({

	initService: function(url, param) {

		let service = axios.create({
			timeout: 50 * 1000, // 请求超时时间
			
		});

		service.interceptors.request.use(
			config => {
				
				if (!(config.url.lastIndexOf('/api.php') > -1) ) {
					config.headers.token = sessionStorage.getItem('token')
				}
				return config;
			},
			error => {
				console.log('err' + error); // for debug
				return Promise.reject(err);
			});
		service.interceptors.response.use(
			response => {
				var res = response.data;
				
				return response;
			},
			error => {
				alert("连接错误")
				console.log('err' + error+"----"); // for debug
				return Promise.reject(error);
			}
		)

		return service;
	}

});