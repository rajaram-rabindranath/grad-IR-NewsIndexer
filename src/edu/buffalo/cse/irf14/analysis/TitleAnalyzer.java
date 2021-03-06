package edu.buffalo.cse.irf14.analysis;

import java.util.ArrayList;

public class TitleAnalyzer implements Analyzer 
{

	TokenStream stream = null;
	private ArrayList<TokenFilter> Filters = new ArrayList<TokenFilter>();
	protected TitleAnalyzer(TokenStream stream)
	{
		this.stream = stream;
		Filters.add(new SymbolsTokenFilter(stream));
		//Filters.add(new AccentsTokenFilter(stream));
		Filters.add(new SpecialCharsTokenFilter(stream));
		Filters.add(new DatesTokenFilter(stream));
		Filters.add(new NumbersTokenFilter(stream));
		
		CapsTokenFilter caps = new CapsTokenFilter(stream);
		caps.setTitleData(true);
		Filters.add(caps);
		//Filters.add(new StemmersTokenFilter(stream));
		Filters.add(new StopWordsTokenFilter(stream));
	}
	
	@Override
	public boolean increment() throws TokenizerException 
	{
		for(TokenFilter filter:Filters)
		{
			stream.reset();
			while(filter.increment());
		}
		return false;
	}

	@Override
	public TokenStream getStream() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
