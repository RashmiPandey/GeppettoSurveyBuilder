package com.geppetto.surveybuilder.dto;

import java.util.ArrayList;
import java.util.List;

import com.geppetto.surveybuilder.domain.core.Option;
import com.geppetto.surveybuilder.domain.core.Question;
import com.geppetto.surveybuilder.domain.core.Survey;

public class DtoToEntity {

	public static Survey convertSurvey(SurveyDTO surveyDTO) throws Exception {

		if (surveyDTO == null) {
			return null;
		}
		Survey surveyEntity = new Survey();

		// set survey details
		surveyEntity.setId((surveyDTO.getId() == null ? 0 : surveyDTO.getId()));
		surveyEntity.setClient_Id((surveyDTO.getClient_id() == null ? 0
				: surveyDTO.getClient_id()));
		surveyEntity.setProduct_Id((surveyDTO.getProduct_id() == null ? 0
				: surveyDTO.getProduct_id()));
		surveyEntity.setCountry_Id((surveyDTO.getCountry_id() == null ? 0
				: surveyDTO.getCountry_id()));
		surveyEntity.setClient_name(surveyDTO.getClient_name());
		surveyEntity.setCountry_name(surveyDTO.getCountry_name());
		surveyEntity.setProduct_name(surveyDTO.getProduct_name());
		surveyEntity.setSurvey_description(surveyDTO.getSurvey_description());
		surveyEntity.setSurvey_name(surveyDTO.getSurvey_name());
		surveyEntity.setSurvey_notes(surveyDTO.getSurvey_notes());

		// set survey questions
		List<QuestionDTO> questionsDTOList = surveyDTO.getQuestions();
		if (questionsDTOList == null) {
			return surveyEntity;
		}
		List<Question> questionsEntityList = new ArrayList<Question>();
		for (QuestionDTO questionDTO : questionsDTOList) {
			questionsEntityList.add(convertQuestion(questionDTO));

		}
		surveyEntity.setQuestion(questionsEntityList);

		return surveyEntity;
	}

	public static Question convertQuestion(QuestionDTO questionDTO) {
		// set question details
		Question questionEntity = new Question();
		questionEntity.setId((questionDTO.getId() == null ? 0 : questionDTO
				.getId()));
		questionEntity.setType_id((questionDTO.getType_id() == null ? 0
				: questionDTO.getType_id()));
		questionEntity.setDisplay_type(questionDTO.getType_name());
		questionEntity.setThe_question(questionDTO.getTitle());

		ArrayList<Option> optionEntityList = new ArrayList<Option>();

		// convert answer to options
		List<AnswerDTO> answerDTOList = questionDTO.getAnswers();
		if (answerDTOList != null) {
			for (AnswerDTO answerDTO : answerDTOList) {
				if (answerDTO != null) {
					optionEntityList.add(convertAnswerDTO(answerDTO,
							questionDTO.getType_name()));
				}
			}
		}

		// convert image option
		List<ItemsDTO> itemsDTOList = questionDTO.getItems();
		if (itemsDTOList != null) {
			for (ItemsDTO itemsDTO : itemsDTOList) {
				if (itemsDTO != null) {
					optionEntityList.add(convertItemsDTO(itemsDTO,
							questionDTO.getType_name()));
				}
			}
		}

		// convert slider
		RangeSliderDTO rangeSliderDTO = questionDTO.getRange_slider();

		if (rangeSliderDTO != null && rangeSliderDTO.getId()!=null) {
			optionEntityList.add(convertRangeSliderDTO(rangeSliderDTO,
					questionDTO.getType_name()));
		}

		questionEntity.setOptions(optionEntityList);

		return questionEntity;
	}

	public static Option convertAnswerDTO(AnswerDTO answerDTO, String answerType) {
		Option optionEntity = new Option();
		optionEntity.setId((answerDTO.getId() == null ? 0 : answerDTO.getId()));
		optionEntity.setAnswer(answerDTO.getName());
		optionEntity.setAnswer_type(answerType);

		return optionEntity;
	}

	public static Option convertItemsDTO(ItemsDTO itemsDTO, String answerType) {
		Option optionEntity = new Option();

		optionEntity.setId((itemsDTO.getId() == null ? 0 : itemsDTO.getId()));
		optionEntity.setAnswer(itemsDTO.getSrc());
		optionEntity.setAnswer_type(answerType);

		return optionEntity;
	}

	public static Option convertRangeSliderDTO(RangeSliderDTO rangeSliderDTO,
			String answerType) {

		Option optionEntity = new Option();
		optionEntity.setId((rangeSliderDTO.getId() == null ? 0 : rangeSliderDTO
				.getId()));
		optionEntity.setSlider_value((rangeSliderDTO.getValue() == null ? 0
				: rangeSliderDTO.getValue()));

		RangeSliderOptionsDTO rangeSliderOptionsDTO = rangeSliderDTO
				.getOptions();

		if (rangeSliderOptionsDTO != null) {
			optionEntity
					.setSlider_min((rangeSliderOptionsDTO.getFloor() == null ? 0
							: rangeSliderOptionsDTO.getFloor()));
			optionEntity
					.setSlider_max((rangeSliderOptionsDTO.getCeil() == null ? 0
							: rangeSliderOptionsDTO.getCeil()));
		}
		optionEntity.setAnswer_type(answerType);

		return optionEntity;
	}
}
