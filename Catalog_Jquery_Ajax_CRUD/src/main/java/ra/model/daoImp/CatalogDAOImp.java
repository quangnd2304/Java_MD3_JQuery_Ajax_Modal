package ra.model.daoImp;

import ra.model.dao.CatalogDAO;
import ra.model.entity.Catalog;
import ra.model.entity.CatalogCombobox;
import ra.model.entity.CatalogInfo;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAOImp implements CatalogDAO<CatalogInfo,Integer> {

    @Override
    public List<CatalogInfo> findAll() {
        List<CatalogInfo> listCat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listCat = new ArrayList<>();
            while (rs.next()){
                CatalogInfo cat = new CatalogInfo();
                cat.setCatalogId(rs.getInt("CatalogId"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setDescriptions(rs.getString("Descriptions"));
                cat.setParentId(rs.getInt("ParentId"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
                cat.setCatalogParentName(rs.getString("ParentName"));
                listCat.add(cat);
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCat;
    }

    @Override
    public CatalogInfo findById(Integer id) {
        CatalogInfo cat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getCatalogById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            cat =  new CatalogInfo();
            if (rs.next()){
                cat.setCatalogId(rs.getInt("CatalogId"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setDescriptions(rs.getString("Descriptions"));
                cat.setParentId(rs.getInt("ParentId"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return cat;
    }

    @Override
    public boolean save(CatalogInfo catalogInfo) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertCatalog(?,?,?,?)}");
            callSt.setString(1,catalogInfo.getCatalogName());
            callSt.setString(2,catalogInfo.getDescriptions());
            callSt.setInt(3,catalogInfo.getParentId());
            callSt.setBoolean(4,catalogInfo.isCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(CatalogInfo catalogInfo) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateCatalog(?,?,?,?,?)}");
            callSt.setInt(1,catalogInfo.getCatalogId());
            callSt.setString(2,catalogInfo.getCatalogName());
            callSt.setString(3,catalogInfo.getDescriptions());
            callSt.setInt(4,catalogInfo.getParentId());
            callSt.setBoolean(5,catalogInfo.isCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_deleteCatalog(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public List<CatalogInfo> searchByName(String name) {
        return null;
    }

    @Override
    public List<CatalogCombobox> findCatalogCombobox() {
        List<CatalogCombobox> listCat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getComboboxCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listCat = new ArrayList<>();
            while (rs.next()){
                CatalogCombobox cat = new CatalogCombobox();
                cat.setCatalogId(rs.getInt("CatalogId"));
                cat.setCatalogName(rs.getString("CatalogName"));
                listCat.add(cat);
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCat;
    }
}
