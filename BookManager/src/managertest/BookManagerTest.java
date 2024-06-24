package managertest;

import java.util.List;

import book.Book;
import book.BookDAO;
import book.BookService;

public class BookManagerTest {

	public static void main(String[] args) {
		BookService service = new BookService(new BookDAO());
		
		//1.���� ���
//		Book book = new Book("�����̴� �� ���θ� ���ұ�","������",2100);
//		if(service.regist(book)) {
//			System.out.println("������� �Ϸ�.");
//		}else {
//			System.out.println("������� ����.");
//		}
		
		//2.���� ���� ����
//		Book book = new Book(4,null,null,8800);
//		service = new BookService(new BookDAO());
//		service.edit(book,3000);
		
		//3.���� ����
		//service.remove(3);
		
		//4.���� ��Ϻ���
//		List<Book> bookList = service.listAll();
//		
//		for(Book book : bookList) {
//			System.out.println(book.toString());
//		}
		
		//5.���� ��ȸ
		Book book = service.read(5);
		if(book != null) {
			System.out.println(book.toString());
		}
	}
}
