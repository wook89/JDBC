package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.JDBConnection;
import oracle.jdbc.logging.annotations.StringBlinder;

public class BookDAO {
	
	public Book selectBook(int id) {
		Book book = null;
		//DB join
		JDBConnection jdbc = new JDBConnection();
		//create SQL
		String sql = new StringBuilder().append("select * from book where id=?").toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if(jdbc.rs.next()) {
				book = new Book(
						jdbc.rs.getInt("id"),
						jdbc.rs.getString("name"),
						jdbc.rs.getString("author"),
						jdbc.rs.getInt("price_won")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return book;
	}
	
	public List<Book> selectBookAll(){
		
		List<Book> bookList = new ArrayList<>();
		// DB����
		JDBConnection jdbc = new JDBConnection();

		// SQL�� �����
		String sql = "SELECT * FROM BOOK";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			while(jdbc.rs.next()) {
				Book book = new Book(
						jdbc.rs.getInt("id"),
						jdbc.rs.getString("name"),
						jdbc.rs.getString("author"),
						jdbc.rs.getInt("price_won")
						);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		
		return bookList;
	}
	
	public int insertBook(Book book) {
		
		//DB join
		JDBConnection jdbc = new JDBConnection();
		//create SQL
		String sql = new StringBuilder()
				.append("insert into book(id,name,author,price_won)")
				.append("values(book_seq.nextval, ? , ? , ?)")
				.toString();
		int result =0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, book.getName());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setInt(3, book.getPrice());
			
			result = jdbc.pstmt.executeUpdate();
			if(result ==1) {
				System.out.println(result + "���� �߰��Ǿ����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return result;
	}
	
	// ������Ʈ ¥�� �����
	public int updateBook(Book book) {
		
		JDBConnection jdbc = new JDBConnection();
		int result = 0;
		String sql = new StringBuilder()
						.append("update book ")
						.append("set price_won = ?")
						.append("where id=?").toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, book.getPrice());
			jdbc.pstmt.setInt(2, book.getId());
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result +"���� ���� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return result;
	}
	public int deleteBook(int id) {
		int result =0;
		
		JDBConnection jdbc = new JDBConnection();
		
		String sql = "delete book where id = ?";
		
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			result = jdbc.pstmt.executeUpdate();
			
			System.out.println(result + "���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.close();
		}
		return result;
	}
}
