import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String theme = request.getParameter("theme"); // Получаем параметр "theme" из запроса
        String imagePath = getImagePathByTheme(theme); // Получаем путь к изображению по тематике

        if (imagePath != null) {
            // Открываем поток для чтения изображения
            try (InputStream inputStream = getServletContext().getResourceAsStream(imagePath)) {
                if (inputStream != null) {
                    // Устанавливаем тип контента как "image/jpeg"
                    response.setContentType("image/jpeg");

                    // Копируем данные из потока в ответ
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        response.getOutputStream().write(buffer, 0, bytesRead);
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private String getImagePathByTheme(String theme) {
        // Здесь вы можете реализовать логику для определения пути к изображению в зависимости от выбранной тематики.
        // Верните путь к изображению или null, если изображение не найдено.
        // Например:
        if ("природа".equalsIgnoreCase(theme)) {
            return "/images/nature.jpeg";
        } else if ("автомобили".equalsIgnoreCase(theme)) {
            return "/images/car.jpg";
        } else if ("дети".equalsIgnoreCase(theme)) {
            return "/images/children.jpg";
        }
        return null;
    }
}