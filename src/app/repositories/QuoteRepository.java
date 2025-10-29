package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Quote;

@Repository
public interface QuoteRepository 
	extends JpaRepository<Quote, Long> 
{
	public List<Quote> findByCategory(String category);
}
