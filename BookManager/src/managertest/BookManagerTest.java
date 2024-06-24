package managertest;

import java.util.List;

import book.Book;
import book.BookDAO;
import book.BookService;

public class BookManagerTest {

	public static void main(String[] args) {
		BookService service = new BookService(new BookDAO());
		
		//1.도서 등록
//		Book book = new Book("해준이는 왜 공부를 안할까","안형욱",2100);
//		if(service.regist(book)) {
//			System.out.println("도서등록 완료.");
//		}else {
//			System.out.println("도서등록 실패.");
//		}
		
		//2.도서 가격 수정
//		Book book = new Book(4,null,null,8800);
//		service = new BookService(new BookDAO());
//		service.edit(book,3000);
		
		//3.도서 삭제
		//service.remove(3);
		
		//4.도서 목록보기
//		List<Book> bookList = service.listAll();
//		
//		for(Book book : bookList) {
//			System.out.println(book.toString());
//		}
		
		//5.도서 조회
		Book book = service.read(5);
		if(book != null) {
			System.out.println(book.toString());
		}
	}
}
