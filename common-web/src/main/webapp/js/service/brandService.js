app.service('brandService',
		function($http) {

			this.findAll = function() {
				return $http.get('../brand/findAll.do');
			}

			this.findPage = function(page, rows) {
				return $http.get('../brand/findPage.do?page=' + page + '&rows='
						+ rows);
			}

			this.findOne = function(id) {
				return $http.get('../brand/findOne.do?id=' + id);
			}

			// 增加
			this.add = function(entity) {
				return $http.post('../brand/add.do', entity);
			}
			// 修改
			this.update = function(entity) {
				return $http.post('../brand/update.do', entity);
			}

			// 增加
			this.add = function(entity) {
				return $http.post('../brand/add.do', entity);
			}
			// 修改
			this.update = function(entity) {
				return $http.post('../brand/update.do', entity);
			}
			// 删除
			this.dele = function(ids) {
				return $http.get('../brand/delete.do?ids=' + ids);
			}
			// 搜索
			this.search = function(page, rows, searchEntity) {
				return $http.post('../brand/search.do?page=' + page + "&rows="
						+ rows, searchEntity);
			}
			// 下拉列表数据
			this.selectOptionList = function() {
				return $http.get('../brand/selectOptionList.do');
			}

		});
