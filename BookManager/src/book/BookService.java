package book;

import java.util.List;

public class BookService {
	private BookDAO bookDao;
	public BookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
	public boolean regist(Book book) {
		int result = bookDao.insertBook(book);
		return result == 1 ? true:false;
	}
	public boolean edit(Book book, int oldPrice) {
		if(book == null) return false;
		if((Integer)oldPrice == null) return false;
		
		int result = 0;
		
		Book bookInfo = bookDao.selectBook(book.getId());
		if(oldPrice == (bookInfo.getPrice())) {
			result = bookDao.updateBook(book);
		}
		return result ==1 ? true:false;
	}
	public boolean remove(int id) {
		if(bookDao.selectBook(id) == null)return false;
		
		int result = bookDao.deleteBook(id);
		return result ==1 ? true:false;
	}
	public List<Book> listAll() {
		return bookDao.selectBookAll();
	}
	public Book read(int id) {
		return bookDao.selectBook(id);
	}
	
}
