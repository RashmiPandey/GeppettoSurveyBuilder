package com.geppetto.surveybuilder.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC </br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
public class GpBaseService implements ApplicationContextAware {

	/**
	*
	* For now this class is only used to make the compile succeed
	* and therefore it is not meant to be used - Dan Castillo 01/28/2015
	*
	*/

	protected final Log logger = LogFactory.getLog(getClass());
	protected ApplicationContext ctx;



	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub

	}


}