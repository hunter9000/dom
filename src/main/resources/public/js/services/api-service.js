
dominionApp.factory('APIService', function($window, $location, $http, $log) {

    var getHeaders = function() {
        return { headers: {'x-access-token': $window.localStorage['jwtToken']} };
    };
    var getStandardFailureCallback = function(response) {
        return function(response) {
            $log.error(response);
            $location.path('/error');
        };
    };

    var getSuccessCallbackWrapper = function(callback, method, uri, data) {
        return function(response) {
            $log.debug('Response from '+method+': ' + uri);
            if (data) {
                $log.debug('With data: ');
                $log.debug(data);
            }
            $log.debug(response);
            callback(response);
        };
    };

    var get = function(uri, params, successCallback) {
        $log.debug('GET: ' + uri);
        var config = getHeaders();
        if (params) {
            config['params'] = params;
        }
        $http.get(uri, config)
        .then(getSuccessCallbackWrapper(successCallback, 'GET', uri), getStandardFailureCallback());
    };
    var post = function(uri, data, successCallback, failureCallback) {
        $log.debug('POST: ' + uri + ' DATA:');
        $log.debug(data);
        if (!failureCallback) {
            failureCallback = getStandardFailureCallback();
        }
        return $http.post(uri, data, getHeaders())
        .then(getSuccessCallbackWrapper(successCallback, 'POST', uri, data), failureCallback);
    };
    var put = function(uri, data, successCallback) {
        $log.debug('PUT: ' + uri + ' DATA:');
        $log.debug(data);
        return $http.put(uri, data, getHeaders())
        .then(getSuccessCallbackWrapper(successCallback, 'PUT', uri, data), getStandardFailureCallback());
    };
    var patch = function(uri, data, successCallback) {
        $log.debug('PATCH: ' + uri + ' DATA:');
        $log.debug(data);
        return $http.patch(uri, data, getHeaders())
        .then(getSuccessCallbackWrapper(successCallback, 'PATCH', uri, data), getStandardFailureCallback());
    };
    var deleteCall = function(uri, successCallback) {
        $log.debug('DELETE: ' + uri);
        return $http.delete(uri, getHeaders())
        .then(getSuccessCallbackWrapper(successCallback, 'DELETE', uri), getStandardFailureCallback());
    };

    return {
        // API CALLS
        authenticate: function(data, successCallback) {
            post('/api/authenticate/', data, successCallback);
        },
        getUser: function(userId, successCallback) {
            get('/api/users/'+userId+'/', null, successCallback);
        },
        getUsers: function(successCallback) {
            get('/api/users/', null, successCallback);
        },
        updateUser: function(userId, data, successCallback) {
            put('/api/users/'+userId+'/', data, successCallback);
        },
        createUser: function(data, successCallback) {
            post('/api/user/', data, successCallback);
        },
        getProfile: function(successCallback) {
            get('/api/profile/', null, successCallback);
        },
        editProfile: function(data, successCallback) {
            put('/api/profile/', data, successCallback);
        },
        getAllRoles: function(successCallback) {
            get('/api/roles/', null, successCallback);
        },

		getExpansions: function(successCallback) {
		    get('/api/expansions/', null, successCallback);
		},
        /** expansionsParams is the params object that contains 'expansions': [] */
		getCardsFromExpansions: function(expansionsParams, successCallback) {
		    get('/api/cards/', expansionsParams, successCallback);
		},

		getAllPlayers: function(successCallback) {
		    get('/api/players/', null, successCallback);
		},

        getGames: function(successCallback) {
            get('/api/game/', null, successCallback);
        },
        getGame: function(gameId, successCallback) {
            get('/api/game/'+gameId+'/', null, successCallback);
        },
		createGame: function(gameInfo, successCallback) {
		    post('/api/game/', gameInfo, successCallback);
		},
    };
});