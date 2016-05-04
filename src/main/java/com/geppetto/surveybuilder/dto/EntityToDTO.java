package com.geppetto.surveybuilder.dto;

import java.util.ArrayList;
import java.util.List;

import com.geppetto.surveybuilder.domain.core.Option;
import com.geppetto.surveybuilder.domain.core.Question;
import com.geppetto.surveybuilder.domain.core.Survey;

public class EntityToDTO {

	public static List<SurveyDTO> convertSurvey(List<Survey> surveyList) {
		List<SurveyDTO> surveyDTOList = null;

		if (surveyList != null) {
			surveyDTOList = new ArrayList<SurveyDTO>();
			for (Survey surveyEntity : surveyList) {
				surveyDTOList.add(convertSurvey(surveyEntity));
			}
		}
		return surveyDTOList;
	}

	public static SurveyDTO convertSurvey(Survey surveyEntity) {

		if (surveyEntity == null) {
			return null;
		}
		SurveyDTO surveyDTO = new SurveyDTO();

		surveyDTO.setId(surveyEntity.getId());
		surveyDTO.setClient_id(surveyEntity.getClient_Id());
		surveyDTO.setProduct_id(surveyEntity.getProduct_Id());
		surveyDTO.setCountry_id(surveyEntity.getCountry_Id());
		surveyDTO.setClient_name(surveyEntity.getClient_name());
		surveyDTO.setCountry_name(surveyEntity.getCountry_name());
		surveyDTO.setProduct_name(surveyEntity.getProduct_name());
		surveyDTO.setSurvey_description(surveyEntity.getSurvey_description());
		surveyDTO.setSurvey_name(surveyEntity.getSurvey_name());
		surveyDTO.setSurvey_notes(surveyEntity.getSurvey_notes());

		List<Question> questionEntityList = surveyEntity.getQuestion();
		if (questionEntityList == null) {
			return surveyDTO;
		}
		if (questionEntityList != null) {
			List<QuestionDTO> questionsDtoList = new ArrayList<QuestionDTO>();

			for (Question questionEntity : questionEntityList) {
				questionsDtoList.add(convertQuestion(questionEntity));

			}
			surveyDTO.setQuestions(questionsDtoList);
		}
		return surveyDTO;
	}

	public static QuestionDTO convertQuestion(Question questionEntity) {
		QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setId(questionEntity.getId());
		questionDTO.setType_id(questionEntity.getType_id());
		questionDTO.setType_name(questionEntity.getDisplay_type());
		questionDTO.setTitle(questionEntity.getThe_question());

		List<AnswerDTO> answerDTOList = new ArrayList<AnswerDTO>();

		List<ItemsDTO> itemsDTOList = new ArrayList<ItemsDTO>();

		RangeSliderDTO rangeSliderDTO = new RangeSliderDTO();

		List<Option> optionsEntityList = questionEntity.getOptions();

		if (optionsEntityList != null) {

			for (Option optionEntity : optionsEntityList) {

				if (optionEntity != null) {

					if (QuestionTypesEnum.MULTIPLE_CHOICE.getvalue() == questionEntity
							.getType_id()) {

						answerDTOList.add(convertAnswer(optionEntity));

					} else if (QuestionTypesEnum.ADD_PICTURE.getvalue() == questionEntity
							.getType_id()) {

						itemsDTOList.add(convertItems(optionEntity));

					} else if (QuestionTypesEnum.RANGE_SLIDER.getvalue() == questionEntity
							.getType_id()) {

						rangeSliderDTO = convertRangeSlider(optionEntity);
					}
				}
			}
		}

		questionDTO.setAnswers(answerDTOList);
		questionDTO.setItems(itemsDTOList);
		questionDTO.setRange_slider(rangeSliderDTO);

		return questionDTO;
	}

	public static AnswerDTO convertAnswer(Option optionEntity) {
		AnswerDTO answerDTO = new AnswerDTO();

		answerDTO.setId(optionEntity.getId());
		answerDTO.setName(optionEntity.getAnswer());

		return answerDTO;
	}

	public static ItemsDTO convertItems(Option optionEntity) {
		ItemsDTO itemsDTO = new ItemsDTO();

		itemsDTO.setId(optionEntity.getId());
		itemsDTO.setSrc(optionEntity.getAnswer());

		return itemsDTO;
	}

	public static RangeSliderDTO convertRangeSlider(Option optionEntity) {
		RangeSliderDTO rangeSliderDTO = new RangeSliderDTO();

		rangeSliderDTO.setId(optionEntity.getId());
		rangeSliderDTO.setValue((optionEntity.getSlider_value() == null ? 0
				: optionEntity.getSlider_value()));

		RangeSliderOptionsDTO rangeSliderOptionsDTO = new RangeSliderOptionsDTO();

		rangeSliderOptionsDTO.setCeil((optionEntity.getSlider_max() == null ? 0
				: optionEntity.getSlider_max()));
		rangeSliderOptionsDTO
				.setFloor((optionEntity.getSlider_min() == null ? 0
						: optionEntity.getSlider_min()));

		rangeSliderDTO.setOptions(rangeSliderOptionsDTO);

		return rangeSliderDTO;
	}
}
