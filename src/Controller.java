
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String driver = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "books";
		String userid = "root";
		String password = "password";
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Model model = new Model();
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			connection.setAutoCommit(false);
			System.out.println("Connected");

			if (request.getParameter("nameList") != null) {
				String name = request.getParameter("nameList");
				name = ((char) 34 + name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + name;

			} else if (request.getParameter("authorList") != null) {
				String author = request.getParameter("authorList");
				author = ((char) 34 + author + (char) 34);
				sql = "select * from Books where BOOK_AUTHOR=" + author;

			} else if (request.getParameter("priceList") != null) {
				String price = request.getParameter("priceList");
				sql = "select * from Books where BOOK_PRICE=" + price;
			} else if ((request.getParameter("nameList") != null) && (request.getParameter("authorList") != null)) {
				String name = request.getParameter("nameList");
				name = ((char) 34 + name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + name;
			} else if ((request.getParameter("authorList") != null) && (request.getParameter("priceList") != null)) {
				String author = request.getParameter("authorList");
				author = ((char) 34 + author + (char) 34);
				sql = "select * from Books where BOOK_AUTHOR=" + author;
			} else if ((request.getParameter("priceList") != null) && (request.getParameter("nameList") != null)) {
				String name = request.getParameter("nameList");
				name = ((char) 34 + name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + name;
			} else {
				String name = request.getParameter("nameList");
				name = ((char) 34 + name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + name;
			}
			connection.commit();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				model.setId(resultSet.getString("BOOK_ID"));
				model.setName(resultSet.getString("BOOK_NAME"));
				model.setAuthor(resultSet.getString("BOOK_AUTHOR"));
				model.setPrice(resultSet.getString("BOOK_PRICE"));
			}
			connection.commit();
			request.setAttribute("id", model.id);
			request.setAttribute("name", model.name);
			request.setAttribute("author", model.author);
			request.setAttribute("price", model.price);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/OutputView.jsp");
			dispatcher.forward(request, response);

			connection.close();
			statement.close();
			resultSet.close();

			System.out.println("Disconnected");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}
}
