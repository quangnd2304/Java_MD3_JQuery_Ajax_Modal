package ra.model.serviceImp;

import ra.model.dao.CatalogDAO;
import ra.model.daoImp.CatalogDAOImp;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.service.CatalogService;

import java.util.List;

public class CatalogServiceImp implements CatalogService<CatalogInfo,Integer> {
    private CatalogDAO<CatalogInfo,Integer> catalogDAO = new CatalogDAOImp();
    @Override
    public List<CatalogInfo> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public CatalogInfo findById(Integer id) {
        return catalogDAO.findById(id);
    }

    @Override
    public boolean save(CatalogInfo catalogInfo) {
        return catalogDAO.save(catalogInfo);
    }

    @Override
    public boolean update(CatalogInfo catalogInfo) {
        return catalogDAO.update(catalogInfo);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDAO.delete(id);
    }

    @Override
    public List<CatalogInfo> searchByName(String name) {
        return catalogDAO.searchByName(name);
    }

    @Override
    public List<CatalogCombobox> findCatalogCombobox() {
        return catalogDAO.findCatalogCombobox();
    }
}
