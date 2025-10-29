package app.components;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.entities.Quote;
import app.repositories.QuoteRepository;

@Component
public class Message {
	
	@Autowired
	private QuoteRepository repo;
	
	private Random random = new Random();

	public Quote selectQuote(String category, String message) {
        List<Quote> quotes = repo.findByCategory(category);
        
        if (quotes == null || quotes.isEmpty()) {
            quotes = repo.findByCategory("generic");
        }
        
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
	}
}