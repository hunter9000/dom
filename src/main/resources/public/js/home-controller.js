
dominionApp.controller('homeController', function(APIService, $scope, $uibModal){
    $scope.games = null;

//    $scope.expansionsMap = [];
//    $scope.selectedExpansions = [];
//
//    $scope.cardsMap = null;        // []
//
//    $scope.players = [];
//    $scope.selectedPlayers = [];

//    APIService.getExpansions(function(response) {
//        $scope.expansionsMap = response.data;
//    });

//    APIService.getAllPlayers(function(response) {
//        $scope.players = response.data;
//    });

//    $scope.showPlayerSelection = function() {
//
//    };

//    $scope.selectCards = function() {
//        console.log($scope.selectedExpansions);
//
////        APIService.getCardsFromExpansions({'expansions': $scope.selectedExpansions}, function(response) {
////            $scope.cardsMap = response.data;
////        });
//    };

    APIService.getGames(function(response) {
        $scope.games = response.data;
    });

        // opens a modal dialog to confirm deleting the character
        $scope.startNewGame = function () {
            var modalInstance = $uibModal.open({
                animation: false,
                templateUrl: 'myModalContent.html',
                controller: 'NewGameController',
                size: 'lg',
                resolve: {
//                        sheet: function () {
//                            return sheet;    // pass the character to delete
//                        }
                }
            });

            modalInstance.result.then(function (gameInfo) {
//                    $scope.deleteSheet(sheet.id);
                // create game
                APIService.createGame(gameInfo, function() {

                });
            }, function () {
                 $log.debug('Modal dismissed at: ' + new Date());
            });
        };

});


    // controller for the modal window
    dominionApp.controller('NewGameController', function (APIService, $scope, $log, $uibModalInstance) {
//        $scope.sheet = sheet;
        $scope.gameInfo = {
            'selectedPlayers': [],
            'selectedExpansions': [],
            'selectedCards': [],
        };

        $scope.players = [];
        $scope.expansionsMap = [];
//        $scope.selectedExpansions = [];
        $scope.cardsMap = null;        // []
//        $scope.selectedPlayers = [];

        $scope.state = 'players';

        // load all players
        APIService.getAllPlayers(function(response) {
            $scope.players = response.data;
        });

        $scope.next = function () {
            if ($scope.showPlayers()) {
                // get expansions and go to expansions step
                APIService.getExpansions(function(response) {
                    $scope.expansionsMap = response.data;
                    $scope.state = 'expansions';
                });
            }
            else if ($scope.showExpansions()) {
                APIService.getCardsFromExpansions({'expansions': $scope.gameInfo.selectedExpansions}, function(response) {
                    $scope.cardsMap = response.data;
                    $scope.state = 'cards';
                });
            }
            else {
               $uibModalInstance.close($scope.gameInfo);
//                return 'Select Kingdom Cards';
            }

//            $uibModalInstance.close($scope.gameInfo);
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };

        $scope.modalHeader = function() {
            if ($scope.showPlayers()) {
                return 'Select Players';
            }
            else if ($scope.showExpansions()) {
                return 'Select Expansions';
            }
            else {
                return 'Select Kingdom Cards';
            }
        }

        $scope.nextButtonLabel = function() {
            if ($scope.showPlayers() || $scope.showExpansions()) {
                return 'Next';
            }
            else {
                return 'Create Game';
            }
        }

        $scope.showPlayers = function() {
            return $scope.state == 'players';
        }

        $scope.showExpansions = function() {
            return $scope.state == 'expansions';
        }

        $scope.showCards = function() {
            return $scope.state == 'cards';
        }
    });