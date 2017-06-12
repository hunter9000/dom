
dominionApp.controller('gameController', function(APIService, $scope, $requestParams){
    $scope.game = null;

    APIService.getGame($requestParams.gameId, function(response) {
        $scope.game = response.data;
    });

});