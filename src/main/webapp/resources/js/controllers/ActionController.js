'use strict';

/**
 * ActionController
 * @constructor
 */
var ActionController = function($scope, $http) {
    $scope.ac = {};
    $scope.editMode = false;

    $scope.fetchActionList = function() {
        $http.get('actions/actionlist.json').success(function(rsList){
            $scope.actions = rsList;
        });
    };

    $scope.addNewAction = function(rs) {

        $scope.resetError();

        $http.post('actions/add', rs).success(function() {
            $scope.fetchActionList();
            $scope.ac.name = '';
            $scope.ac.asignee = '';
            $scope.ac.createDate = '';
            $scope.ac.dueDate = '';
        }).error(function() {
            $scope.setError('Could not add a new action');
        });
    };

    $scope.updateAction = function(rs) {
        $scope.resetError();

        $http.put('actions/update', rs).success(function() {
            $scope.fetchActionList();
            $scope.ac.name = '';
            $scope.ac.asignee = '';
            $scope.ac.createdDate = '';
            $scope.ac.dueDate = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the action');
        });
    };

    $scope.editAction = function(ac) {
        $scope.resetError();
        $scope.ac = ac;
        $scope.editMode = true;
    };

    $scope.removeAction = function(id) {
        $scope.resetError();

        $http.delete('actions/remove/' + id).success(function() {
            $scope.fetchActionList();
        }).error(function() {
            $scope.setError('Could not remove action');
        });
        
        $scope.rs = '';
    };

    $scope.removeAllActions = function() {
        $scope.resetError();

        $http.delete('actions/removeAll').success(function() {
            $scope.fetchActionList();
        }).error(function() {
            $scope.setError('Could not remove all actions');
        });

    };

    $scope.resetActionForm = function() {
        $scope.resetError();
        $scope.ac = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchActionList();

    $scope.predicate = 'id';
};