/**
 *
 * @author Schubert Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p>
 *
 * code was generated by the Schubert System </br>
 * Schubert system Copyright - NewPortBay LLC copy_right_range</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

app.controller("Option_Default_Activity", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http', 'OptionId', 'RestURL',
				    function( $scope, $rootScope, $location, $window, $q, $http, OptionId, RestURL) {

		$scope.Option = {
		id: '',
		question_id : '', 
		answer : '', 
		answer_image : '', 
		answer_type : ''
		};



        $scope.create = function () {

		  //this is where the start code goes


		  //this is where the validate code goes


		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.post(RestURL.baseURL+'Option/create_Option/', $scope.Option).success(function(response) {
		  	 alert('Operation createOption successful');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes


		  //this is where the transition code goes

		  //this is where the end code goes 
		  return deferred.promise; 


        };

        $scope.delete = function () {

		  //this is where the start code goes

		  //this is where the validate code goes

		  //this is where the confirm code goes

		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.delete(RestURL.baseURL+'Option/delete_Option/{Option_id}/'+$scope.Option.id).success(function(response) {
		  	 alert('Operation deleteOption successful');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes

		  //this is where the transition code goes

		  //this is where the end code goes 
		  return deferred.promise; 


        };

        $scope.search_for_update = function (id) {

		  //this is where the start code goes

		  //this is where the validate code goes

		  //this is where the confirm code goes

		  //this is where the post code goes
		  $http.get(RestURL.baseURL+'Option/search_for_update_Option/{Option_id}/' + id).success(function(response) {
		  	 console.log('Operation search_for_update Option successful');
		  $scope.Option.id = response.id;
		  $scope.Option.question_id = response.question_id;
		  $scope.Option.answer = response.answer;
		  $scope.Option.answer_image = response.answer_image;
		  $scope.Option.answer_type = response.answer_type;
		  OptionId.setId(undefined)
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes

		  //this is where the transition code goes

		  //this is where the end code goes

        };

        $scope.update = function () {

		  //this is where the start code goes

		  //this is where the validate code goes

		//  this is where the confirm code goes

		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.put(RestURL.baseURL+'Option/update_Option', $scope.Option).success(function(response) {
		  	 alert('Operation updateOption successful');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes

		  //this is where the transition code goes

		  //this is where the end code goes 
		  return deferred.promise; 


        };

        $scope.search = function () {

		  //this is where the start code goes
		  	$scope.Option.question_id = $scope.Option.question_id? $scope.Option.question_id:"%%";
		  	$scope.Option.answer = $scope.Option.answer? $scope.Option.answer:"%%";
		  	$scope.Option.answer_image = $scope.Option.answer_image? $scope.Option.answer_image:"%%";
		  	$scope.Option.answer_type = $scope.Option.answer_type? $scope.Option.answer_type:"%%";


		  //this is where the validate code goes

		  //this is where the confirm code goes

		  var deferred = $q.defer();
		  $http.get(RestURL.baseURL+'Option/search_Option?question_id='+$scope.Option.question_id+'&answer='+$scope.Option.answer+'&answer_image='+$scope.Option.answer_image+'&answer_type='+$scope.Option.answer_type+ '&slider_value='+$scope.Option.slider_value + '&min='+$scope.Option.min + '&max='+$scope.Option.max).success(function(response) {
		  console.log(response);
		  var search_result = [];
		  response.forEach(function(entry) {
		  var row = {'question_id':entry.question_id,'answer':entry.answer,'answer_image':entry.answer_image,'answer_type':entry.answer_type,'slider_value':entry.slider_value,'min':entry.min,'max':entry.max};
		  search_result.push(row);
		  });
		  handle_search_result(search_result);
		  }).error(function(err) {
		  alert('You got' + err + 'error');
		  deferred.reject(err);
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes

		  //this is where the transition code goes

		  //this is where the end code goes 
		  return deferred.promise; 


        };




		/*var id = OptionId.getId();
		if (id) {
		console.log(id);
		$scope.search_for_update(id);
		} else {
		$('#myModal').modal('toggle');
		$('#myModal').modal('show');
		$scope.searchForOption = function () {
		if ($scope.idForOption) {
		$('#myModal').modal('hide');
		id = $scope.idForOption;
		console.log(id);
		$scope.search_for_update(id);
		}	else {
		alert('You should enter ID');
		}
		};
		}*/

		$scope.$on('$viewContentLoaded', function(event) {
			var biggestHeight = 0;
			var height = 0;
			$(".screen").find('*').each(function(){
				height = $(this).position().top + $(this).height() + 100;
				if (height > biggestHeight ) {
					biggestHeight = height;
				}
			});
			$(".screen").height(biggestHeight);
		});

}]);


