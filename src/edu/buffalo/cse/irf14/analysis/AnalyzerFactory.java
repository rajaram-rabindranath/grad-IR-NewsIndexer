/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;

import edu.buffalo.cse.irf14.document.FieldNames;

/**
 * @author nikhillo
 * This factory class is responsible for instantiating "chained" {@link Analyzer} instances
 */
public class AnalyzerFactory 
{
	static private AnalyzerFactory instance = null;
	static private int singleton = 0;
	
	/**
	 * Static method to return an instance of the factory class.
	 * Usually factory classes are defined as singletons, i.e. 
	 * only one instance of the class exists at any instance.
	 * This is usually achieved by defining a private static instance
	 * that is initialized by the "private" constructor.
	 * On the method being called, you return the static instance.
	 * This allows you to reuse expensive objects that you may create
	 * during instantiation
	 * @return An instance of the factory
	 */
	public static AnalyzerFactory getInstance()
	{
		if(singleton == 0) return new AnalyzerFactory();
		return instance;
	}
	
	/**
	 * Returns a fully constructed and chained {@link Analyzer} instance
	 * for a given {@link FieldNames} field
	 * Note again that the singleton factory instance allows you to reuse
	 * {@link TokenFilter} instances if need be
	 * @param name: The {@link FieldNames} for which the {@link Analyzer}
	 * is requested
	 * @param TokenStream : Stream for which the Analyzer is requested
	 * @return The built {@link Analyzer} instance for an indexable {@link FieldNames}
	 * null otherwise
	 */
	public Analyzer getAnalyzerForField(FieldNames name, TokenStream stream)
	{
		Analyzer analyzerInstance = null;
		switch(name)
		{
			case TITLE:
				return new TitleAnalyzer(stream);
			case AUTHOR:
				return new AuthorAnalyzer(stream);
			case AUTHORORG:
				return new AuthorOrgAnalyzer(stream);
			case PLACE:
				return new PlaceAnalyzer(stream);
			case CATEGORY:
				return new CategoryAnalyzer(stream);
			case CONTENT:
				return new ContentAnalyzer(stream);
			case NEWSDATE:
				return new NewsDateAnalyzer(stream);
			default:
				return analyzerInstance;
		}
	}
}
