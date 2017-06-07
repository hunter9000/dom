
dominionApp.controller('homeController', function(APIService, $scope){
    $scope.expansions = [];
    $scope.selectedExpansions = [];

    $scope.cards = [];

    APIService.getExpansions(function(response) {
        $scope.expansions = response.data;
    });

    $scope.selectCards = function() {
        console.log($scope.selectedExpansions);

        APIService.getCardsFromExpansions({'expansions': $scope.selectedExpansions}, function(response) {
            $scope.cards = response.data;
        });
    }

});