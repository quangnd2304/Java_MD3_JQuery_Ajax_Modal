package ra.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ra.model.entity.Catalog;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.service.CatalogService;
import ra.model.serviceImp.CatalogServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private static CatalogService<CatalogInfo,Integer> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            getAllCatalog(request,response);
        } else if (action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog catUpdate = catalogService.findById(catalogId);
            //Chuyen du lieu tu java object sang JSON
            String json = GSON.toJson(catUpdate);
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }
    }

    public void getAllCatalog(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<CatalogInfo> listCat = catalogService.findAll();
        List<CatalogCombobox> listCatCombo = catalogService.findCatalogCombobox();
        request.setAttribute("listCat",listCat);
        request.setAttribute("listCatCombo",listCatCombo);
        request.getRequestDispatcher("views/catalogs.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("Create")){
            CatalogInfo catalog = new CatalogInfo();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescriptions(request.getParameter("descriptions"));
            catalog.setParentId(Integer.parseInt(request.getParameter("parentId")));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.save(catalog);
            if (result){
                getAllCatalog(request,response);
            }
        } else if (action.equals("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catDeleteId"));
            boolean result = catalogService.delete(catalogId);
            if (result){
                getAllCatalog(request,response);
            }
        } else if (action.equals("Update")) {
            CatalogInfo catInfo = new CatalogInfo();
            catInfo.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catInfo.setCatalogName(request.getParameter("catalogName"));
            catInfo.setDescriptions(request.getParameter("descriptions"));
            catInfo.setParentId(Integer.parseInt(request.getParameter("parentId")));
            catInfo.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(catInfo);
            if (result){
                getAllCatalog(request,response);
            }
        }
    }
}
