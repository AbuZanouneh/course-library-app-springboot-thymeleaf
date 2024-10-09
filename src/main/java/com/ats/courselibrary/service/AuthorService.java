package com.ats.courselibrary.service;

        import com.ats.courselibrary.entity.Author;
        import com.ats.courselibrary.repository.AuthorRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

//Service Layer
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author  findAuthorById(Long authorId){
        Author author;
        author =  authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        return author;
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthor(Long  authorId){
        Author author;
        author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.deleteById(author.getAuthorId());
    }
}
