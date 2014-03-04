package com.msplearning.android.app.base;

import java.lang.reflect.Field;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * The BaseActivityRestSupport class extends {@link BaseActivity}. Technical
 * adaptation of the bug already known by Spring (java.io.EOFException)
 * 
 * @author Venilton Falvo Junior (veniltonjr)
 */
@EActivity
public abstract class BaseActivityRestSupport extends BaseActivity {

	@AfterInject
	protected void changeRequestFactoryRestTemplate() {
		Field[] props = this.getClass().getSuperclass().getDeclaredFields();
		for (Field propIt : props) {
			Object prop;
			try {
				propIt.setAccessible(true);
				prop = propIt.get(this);
				if (prop instanceof RestClientSupport) {
					((RestClientSupport) prop).getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}