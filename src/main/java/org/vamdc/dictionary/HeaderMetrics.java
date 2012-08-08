package org.vamdc.dictionary;

/**
 * HTTP metrics header names, see 
 * http://www.vamdc.org/documents/standards/dictionary/taphttpheaders.html
 * for semantics and meaning
 */
public enum HeaderMetrics{
	VAMDC_COUNT_SPECIES,
	VAMDC_COUNT_ATOMS,
	VAMDC_COUNT_MOLECULES,
	VAMDC_COUNT_SOURCES,
	VAMDC_COUNT_STATES,
	VAMDC_COUNT_COLLISIONS,
	VAMDC_COUNT_RADIATIVE,
	VAMDC_COUNT_NONRADIATIVE,
	VAMDC_APPROX_SIZE,
	VAMDC_TRUNCATED,
	LAST_MODIFIED,
}