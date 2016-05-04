/**
 * Created by Henrikh Kantuni on 4/5/16.
 */

app.controller('SurveyBuilderCtrl', ['$scope', '$http', '$compile', '$routeParams', '$timeout', 'RestURL',
  function ($scope, $http, $compile, $routeParams, $timeout, RestURL) {
    var self = $scope;

    /* config */
    var NOW_EDITING = false;

    /* keep survey id */
    self.survey_id = $routeParams['id'];

    self.init = function () {
      /* get survey info by self.survey_id */
      self.getSurveyByID();

      /* get question types */
      self.getQuestionTypes();
    };

    self.addQuestion = function () {
      var $editForm = $('.edit');

      /* validation */
      if (NOW_EDITING || ($editForm.length && !$editForm.hasClass('hidden'))) {
        /* if editing another question */
        alert('You are currently editing a question. Please complete it before proceeding.');
      } else if (!self.new_question_type) {
        /* if not valid show alert */
        alert('Please choose question type');
      } else {
        /* hide add question modal */
        $('#add_question_modal').modal('hide');

        var new_question = {};

        switch (self.new_question_type['id']) {
          /* Single Textbox */
          case 1:
            /* set values */
            new_question['id'] = 0;
            new_question['type_name'] = self.new_question_type.name;
            new_question['type_id'] = self.new_question_type.id;
            new_question['title'] = '';

            break;
          /* Multiple Choice (Only One Answer) */
          case 2:
            /* set values */
            new_question['id'] = 0;
            new_question['type_name'] = self.new_question_type.name;
            new_question['type_id'] = self.new_question_type.id;
            new_question['title'] = '';
            new_question['answers'] = [
              {
                'id': 0,
                'name': 'Answer'
              },
              {
                'id': 0,
                'name': 'Answer'
              }
            ];

            break;
          /* Take Photo */
          case 3:
            /* set values */
            new_question['id'] = 0;
            new_question['type_name'] = self.new_question_type.name;
            new_question['type_id'] = self.new_question_type.id;
            new_question['title'] = '';

            break;
          /* Add Picture */
          case 4:
            /* set values */
            new_question['id'] = 0;
            new_question['type_name'] = self.new_question_type.name;
            new_question['type_id'] = self.new_question_type.id;
            new_question['title'] = '';
            new_question['items'] = [
              {
                'id': 0,
                'src': ''
              }
            ];

            break;
          /* Range Slider */
          case 5:
            /* set values */
            new_question['id'] = 0;
            new_question['type_name'] = self.new_question_type.name;
            new_question['type_id'] = self.new_question_type.id;
            new_question['title'] = '';
            new_question['range_slider'] = {
              'id': 0,
              'value': null,
              'options': {
                'ceil': null,
                'floor': null
              }
            };
            break;
        }

        /* push new question to the existing questions array */
        self.questions.push(new_question);

        NOW_EDITING = true;
      }
    };

    self.saveQuestion = function (question_id) {
      var valid = false, type;

      var question;

      for (var i = 0; i < self.questions.length; i++) {
        if (self.questions[i].id === question_id) {
          question = self.questions[i];
        }
      }

      /* title validation */
      if (question['title']) {
        valid = true;
      }

      /* URL validation */
      var validUrl = true;
      if (question['items']) {
        for (var j = 0; j < question['items'].length; j++) {
          if (!question['items'][j]['src']) {
            validUrl = false;
          }
        }
      }

      /* if new question */
      if (self.new_question_type) {
        type = self.new_question_type['id'];
        /* reset new_question_type */
        self.new_question_type = undefined;
      } else {
        /* for existing questions */
        type = question['type_id'];
      }

      /* DOM for the given question */
      var $question = $('#question_' + question_id);

      if (valid && validUrl) {
        switch (type) {
          case 1:
            /* TODO: http request goes here */
            /* save question data */

            /* hide all except Single Textbox */
            // $question.find('.preview .radio_buttons').addClass('hidden');

            break;
          case 2:
            /* TODO: http request goes here */
            /* save question data */

            /* hide all except Multiple Choice Answers */
            // $question.find('.preview .single_textbox').addClass('hidden');

            break;
          case 3:
            /* TODO: http request goes here */
            /* save question data */

            /* hide all except Take Photo */
            // $question.find('.preview .take_photo').addClass('hidden');

            break;
          case 4:
            /* TODO: http request goes here */
            /* save question data */

            /* hide all except Upload Photo */
            // $question.find('.preview .take_photo').addClass('hidden');

            break;
          case 5:
            /* TODO: http request goes here */
            /* save question data */
            /* TODO: asign floor and ceil from screen */
            question['range_slider']['value'] = (question['range_slider']['options']['floor'] + question['range_slider']['options']['ceil']) / 2;
            $timeout(function () {
              self.$broadcast('rzSliderForceRender');
            }, 0);

          /* hide all except Upload Photo */
          // $question.find('.preview .take_photo').addClass('hidden');
        }

        /* hide edit question form */
        $question.find('.edit').addClass('hidden');

        /* show preview */
        $question.find('.preview').removeClass('hidden');

        /* show action buttons (edit, delete) */
        $question.find('.actions').removeClass('hidden');

        /* update survey */
        self.updateSurvey();

      } else if (valid && !validUrl) {
        /* if image is not selected */
        alert('Please select an image.');
      } else {
        /* if not valid show alert */
        alert('Please enter a title');
      }

      /* reset new question type */
      self.new_question_type = undefined;

      NOW_EDITING = false;
    };

    self.editQuestion = function (question_id) {
      if (NOW_EDITING) {
        /* if editing another question */
        alert('You are currently editing a question. Please complete it before proceeding.');
      } else {
        NOW_EDITING = true;

        /* DOM for the given question */
        var $question = $('#question_' + question_id);

        /* show edit question form */
        $question.find('.edit').removeClass('hidden');

        /* hide preview */
        $question.find('.preview').addClass('hidden');

        /* hide action buttons (edit, delete) */
        $question.find('.actions').addClass('hidden');
      }
    };

    self.deleteQuestion = function (question_id) {
      /* TODO: http request goes here */
      /* delete question with the given id */
      $http.delete(RestURL.baseURL + 'Question/delete_Question/' + question_id)
        .success(function (response) {
          console.log('after delete', response);
          self.getSurveyByID();
        })
        .error(function (err) {
          console.error(err);
        });
    };

    /* === Multiple Choice (Only One Answer) ==== */

    self.addRadioAnswer = function (question_id) {
      /* TODO: http request goes here */
      /* get id for new answer */

      for (var i = 0; i < self.questions.length; i++) {
        if (question_id === self.questions[i]['id']) {
          var new_answer = {
            'id': 0,
            'name': 'Answer'
          };
          self.questions[i]['answers'].push(new_answer);
        }
      }
    };

    self.removeRadioAnswer = function (question_id, answer_id) {
      /* TODO: http request goes here */
      /* get id for new answer */
      $http.delete(RestURL.baseURL + '/Option/delete_Option/' + answer_id)
        .success(function (res) {
          for (var i = 0; i < self.questions.length; i++) {
            if (question_id === self.questions[i]['id']) {
              for (var j = 0; j < self.questions[i]['answers'].length; j++) {
                if (answer_id === self.questions[i]['answers'][j]['id']) {
                  self.questions[i]['answers'].splice(j, 1);
                }
              }
            }
          }
        })
        .error(function (err) {
          console.error(err);
        });
    };

    /* === Add Picture ==== */

    self.uploadFile = function (input, images) {
      var form_data = new FormData();

      console.log('yaaaay', images);
      form_data.append('uploadfile', images[0]);

      $http.post(RestURL.baseURL + 'Servey_result_Default_Activity/uploadFile', form_data, {
          transformRequest: angular.identity,
          headers: {
            'Content-Type': undefined
          }
        })
        .success(function (res) {
          var question_id = $(input).parents("li[id^='question_']").attr('id').replace('question_', '');
          var item_id = $(input).parents("li[id^='items_']").attr('id').replace('items_0_', '');

          for (var i = 0; i < self.questions.length; i++) {
            if (question_id == self.questions[i]['id']) {
              for (var j = 0; j < self.questions[i]['items'].length; j++) {
                if (item_id == j) {
                  self.questions[i]['items'][j]['src'] = res.src;
                }
              }
            }
          }
        })
        .error(function (err) {
          console.error(err);
        })
    };

    self.addPictureItem = function (question_id) {
      /* TODO: http request goes here */
      /* get id for new answer */

      for (var i = 0; i < self.questions.length; i++) {
        if (question_id === self.questions[i]['id']) {
          var new_item = {
            'id': 0,
            'src': ''
          };
          self.questions[i]['items'].push(new_item);
        }
      }
    };

    self.removePictureItem = function (question_id, item_id) {
      /* TODO: http request goes here */
      /* get id for new answer */
      $http.delete(RestURL.baseURL + '/Option/delete_Option/' + item_id)
        .success(function (res) {
          for (var i = 0; i < self.questions.length; i++) {
            if (question_id === self.questions[i]['id']) {
              if (self.questions[i]['items'].length === 1) {
                alert('Not allowed.');
              } else {
                for (var j = 0; j < self.questions[i]['items'].length; j++) {
                  if (item_id === self.questions[i]['items'][j]['id']) {
                    self.questions[i]['items'].splice(j, 1);
                  }
                }
              }
            }
          }
        })
        .error(function (err) {
          console.error(err);
        });
    };

    /* get survey info by self.survey_id */
    self.getSurveyByID = function () {
      $http.get(RestURL.baseURL + 'Survey_Default_Activity/get_survey_by_id_new/' + self.survey_id)
        .success(function (response) {
          self.survey = response;
          console.log(response);

          /* existing questions */
          self.questions = (self.survey['questions']) ? self.survey['questions'] : [];
        })
        .error(function (err) {
          console.error(err);
        });
    };

    /* update survey */
    self.updateSurvey = function () {
      console.log('updating survey', self.survey);
      /* TODO: http request goes here */
      $http.put(RestURL.baseURL + 'Survey_Default_Activity/update_survey_new', self.survey)
        .success(function (response) {
          console.log('after update', response);
          self.getSurveyByID();
        })
        .error(function (err) {
          console.error(err);
        });
    };

    /* get question types */
    self.getQuestionTypes = function () {
      $http.get(RestURL.baseURL + 'Question/get_all_question_types')
        .success(function (response) {
          self.question_types = response;
          console.log(response);
        })
        .error(function (err) {
          console.error(err);
        });
    };

    self.init();
  }
]);


app.directive('control', function () {
  return function (scope, element, attrs) {
    if (scope.$last) {
      setTimeout(function () {
        var $question = $(element[0]);
        var question_id = Number($question.attr('id').replace('question_', ''));

        if (!question_id) {
          /* hide edit question form */
          $question.find('.edit').removeClass('hidden');

          /* show preview */
          $question.find('.preview').addClass('hidden');

          /* show action buttons (edit, delete) */
          $question.find('.actions').addClass('hidden');
        }
      }, 0);
    }
  };
});