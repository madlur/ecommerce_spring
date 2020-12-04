import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        List<Product> products = new ArrayList();

        for (int i = 0; i < 10; i++) {
            Product product = new Product((long) i+1, "title # " + (i + 1), BigDecimal.valueOf ((Math.random() + 10) * 100000));
            products.add(product);

        }

        for(Product item : products) {
            out.println("<html><body><h1>" + String.format("%d + %s + %.2f", item.getId(), item.getTitle(), item.getCost())+ "</h1></body></html>");
        }
        out.close();
    }
}
