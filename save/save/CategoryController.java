@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/categories",
        "/admin/category/add", "/admin/category/insert",
        "/admin/category/edit", "/admin/category/update",
        "/admin/category/delete", "/admin/category/search" })
public class CategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ICategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("categories")) {
            List<CategoryModel> list = cateService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            CategoryModel category = cateService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            cateService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        if (url.contains("/admin/category/insert")) {
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String image = "https://cdn.tgdd.vn/Products/Images/42/307171/samsung-galaxy-s24-violet-thumbnew-600x600.jpg";

            CategoryModel category = new CategoryModel();
            category.setCategoryname(categoryname);
            category.setStatus(status);
            category.setImages(image);

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } else if (url.contains("/admin/category/update")) {
            int id = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));

            CategoryModel category = new CategoryModel();
            category.setCategoryid(id);
            category.setCategoryname(categoryname);
            category.setStatus(status);

            String filename = uploadFile(req, "images");
            category.setImages(filename);

            cateService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    private String uploadFile(HttpServletRequest req, String paramName) {
        String filename = "avata.png"; // Đặt tên file mặc định
        String uploadPath = UPLOAD_DIRECTORY; // Đường dẫn thư mục
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir(); // Tạo thư mục nếu chưa tồn tại
        }

        try {
            Part part = req.getPart(paramName);
            if (part.getSize() > 0) {
                String originalFilename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                int index = originalFilename.lastIndexOf(".");
                String ext = originalFilename.substring(index + 1);
                filename = System.currentTimeMillis() + "." + ext; // Đặt tên file mới
                part.write(uploadPath + "/" + filename); // Ghi file
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý lỗi
        }
        return filename; // Trả về tên file đã upload
    }
}
