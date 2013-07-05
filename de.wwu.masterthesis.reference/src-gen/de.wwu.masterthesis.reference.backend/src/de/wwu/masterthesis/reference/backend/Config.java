package de.wwu.masterthesis.reference.backend;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * This class allows to define the current model version as well as all model versions that can be handled by this
 * backend module.
 */
public class Config {
	
	/**
	 * Define a string that represents the current version of the backend model.
	 */
	public final static String MODEL_VERSION = "1.0";
	
	/**
	 * Define a list of all model versions that are supported by this backend implementation
	 * to allow backward compatibility.
	 */
	public final static List<String> SUPPORTED_MODEL_VERSIONS = Lists.newArrayList("1.0");
	
}
