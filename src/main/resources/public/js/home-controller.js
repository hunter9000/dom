
dominionApp.controller('homeController', function(APIService, $scope){
    $scope.expansionsMap = [];
    $scope.selectedExpansions = [];

    $scope.cardsMap = null;        // []

    $scope.players = [];
    $scope.selectedPlayers = [];

    APIService.getExpansions(function(response) {
        $scope.expansionsMap = response.data;
    });

    APIService.getAllPlayers(function(response) {
        $scope.players = response.data;
    });

    $scope.showPlayerSelection = function() {

    };

    $scope.selectCards = function() {
        console.log($scope.selectedExpansions);

        APIService.getCardsFromExpansions({'expansions': $scope.selectedExpansions}, function(response) {
            $scope.cardsMap = response.data;
        });
    };

});