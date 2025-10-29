package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Quote;
import app.repositories.QuoteRepository;

@Component
public class QuoteInitializer {
	@Autowired
	private QuoteRepository repo;
	
	@PostConstruct 
	public void init() {
		if (repo.count()==0) {
			Quote quote = makeQuote("Less is more", "generic");
			repo.save(quote);
			
			quote = makeQuote("Actions speak louder than words", "generic");
			repo.save(quote);
			
			quote = makeQuote("Success is not final, failure is not fatal: it is the courage to continue that counts", "motivation");
			repo.save(quote);
			
			quote = makeQuote("Believe you can and you’re halfway there", "motivation");
			repo.save(quote);
			
			quote = makeQuote("Happiness depends upon ourselves", "positivity");
			repo.save(quote);
			
			quote = makeQuote("Positive anything is better than negative nothing", "positivity");
			repo.save(quote);
			
			quote = makeQuote("The unexamined life is not worth living", "wisdom");
			repo.save(quote);
			
			quote = makeQuote("We are what we repeatedly do. Excellence, then, is not an act, but a habit", "wisdom");
			repo.save(quote);
			
			quote = makeQuote("Do unto others as you would have them do unto you", "compassion");
			repo.save(quote);
			
			quote = makeQuote("No one has ever become poor by giving", "compassion");
			repo.save(quote);
		}
	}
	
	public Quote makeQuote(String message, String category) {
		Quote q = new Quote();
		q.setMessage(message);
		q.setCategory(category);
		return q;
	}
}
