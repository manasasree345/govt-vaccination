package govt.vaccination.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import govt.vaccination.constants.CommonConstants;
import govt.vaccination.constants.CommonConstants.Gender;
import govt.vaccination.model.ListResponse;
import govt.vaccination.model.Response;
import govt.vaccination.model.UserRegistration;
import govt.vaccination.repository.UserRegistrationRepository;
import govt.vaccination.utils.DateUtils;
import govt.vaccination.utils.VaccinationUtils;

@Service
public class UserRegistrationService {

	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);

	public ListResponse getAllUserRegistration() {
		ListResponse response = new ListResponse();
		ListResponse.Status status = new ListResponse.Status();

		try {

			List<UserRegistration> userRegistrationDbList = userRegistrationRepository.findAll();
			if (CollectionUtils.isNotEmpty(userRegistrationDbList)) {
				response.setData(userRegistrationDbList);
				response.setSize(userRegistrationDbList.size());
				status.setMessage(CommonConstants.User.LISTFOUND);
				status.setMessage(CommonConstants.ResponseStatus.SUCCESS);

			} else {
				response.setData(null);
				status.setMessage(CommonConstants.User.LISTNOTFOUND);
				status.setMessage(CommonConstants.ResponseStatus.FAIL);

			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			status.setMessage(CommonConstants.ResponseStatus.SERVER_UNDER_MAINTANANCE);
			status.setMessage(CommonConstants.ResponseStatus.FAIL);
		}
		response.setStatus(status);
		return response;
	}

	public Response save(UserRegistration userRegistration) throws ParseException {
		Response response = new Response();
		Response.Status status = new Response.Status();
		try {

			UserRegistration userRegistrationObject = userRegistrationRepository.findByUserEmailAndUserPassword(
					userRegistration.getUserEmail(), userRegistration.getUserPassword());
			if (userRegistrationObject == null) {
				userRegistration.setUserUserregistrationdate(DateUtils.getTodayDate());

				UserRegistration userRegistrationDBObject = userRegistrationRepository.save(userRegistrationObject);

				response.setData(userRegistrationDBObject);
				status.setMessage(CommonConstants.User.SAVE);
				status.setMessage(CommonConstants.ResponseStatus.SUCCESS);

			} else {
				response.setData(null);
				status.setMessage(CommonConstants.User.EMAILEXISTS);
				status.setMessage(CommonConstants.ResponseStatus.FAIL);
			}
		} catch (Exception e) {

			status.setMessage(CommonConstants.User.ERROR);
			status.setMessage(CommonConstants.ResponseStatus.FAIL);
		}
		response.setStatus(status);
		return response;
	}

	public Map<String, Object> getUserRegistrationStatistics() throws ParseException {

		List<UserRegistration> userRegistrationList = userRegistrationRepository.findAll();

		Map<String, Object> responseMap = new HashMap<>();

		responseMap.put("totalStrength", userRegistrationList.size());
		responseMap.put(Gender.MALE, VaccinationUtils.getGenderListCount(Gender.MALE, userRegistrationList));
		responseMap.put(Gender.FEMALE, VaccinationUtils.getGenderListCount(Gender.FEMALE, userRegistrationList));

		responseMap.put("state", VaccinationUtils.getRegistrationListBasedOnState(userRegistrationList));

		Date yesterdayDate = DateUtils.minusDays(DateUtils.getTodayDate(), 1);

		responseMap.put("tewntyfourhours",
				VaccinationUtils.getRegistrationListCountBasedOnDate(yesterdayDate, userRegistrationList));

		Date twoDaysBackDate = DateUtils.minusDays(DateUtils.getTodayDate(), 2);

		responseMap.put("twodays",
				VaccinationUtils.getRegistrationListCountBasedOnDate(twoDaysBackDate, userRegistrationList));

		Date monthBackDate = DateUtils.minusDays(DateUtils.getTodayDate(), 30);
		responseMap.put("onemonth",
				VaccinationUtils.getRegistrationListCountBasedOnDate(monthBackDate, userRegistrationList));
		return responseMap;
	}

	public Response getUserRegistrationId(Integer userRegistrationId) {
		Response response = new Response();
		Response.Status status = new Response.Status();
		try {
			UserRegistration userRegistrationObject = userRegistrationRepository.findByUserRegistrationId(userRegistrationId);
			if (userRegistrationObject != null) {
				response.setData(userRegistrationObject);
				status.setSuccess(CommonConstants.User.RECORDFOUND);
				status.setSuccess(CommonConstants.ResponseStatus.SUCCESS);

			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			status.setMessage(CommonConstants.ResponseStatus.SERVER_UNDER_MAINTANANCE);
			status.setMessage(CommonConstants.ResponseStatus.FAIL);
		}

		response.setStatus(status);

		return response;
	}

	public Response userLogin(String userEmail, String userPassword) {
		Response response = new Response();
		Response.Status status = new Response.Status();
		try {
			UserRegistration userRegistrationLoginObject = userRegistrationRepository
					.findByUserEmailAndUserPassword(userEmail, userPassword);

			if (userRegistrationLoginObject != null) {
				response.setData(userRegistrationLoginObject);
				status.setSuccess(CommonConstants.User.RECORDFOUND);
				status.setSuccess(CommonConstants.ResponseStatus.SUCCESS);

			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			status.setMessage(CommonConstants.ResponseStatus.SERVER_UNDER_MAINTANANCE);
			status.setMessage(CommonConstants.ResponseStatus.FAIL);
		}

		response.setStatus(status);
		return response;
	}

	/*
	 * public UserRegistration save(UserRegistration userRegistration) throws
	 * ParseException {
	 * userRegistration.setUserUserregistrationdate(DateUtils.getTodayDate());
	 * 
	 * return userRegistrationRepository.save(userRegistration);
	 * 
	 * }
	 */
}
