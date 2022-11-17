package ra.model.service;

import ra.model.entity.CatalogCombobox;

import java.util.List;

public interface CatalogService<T,V> extends AppService<T,V> {
    List<T> searchByName(String name);
    List<CatalogCombobox> findCatalogCombobox();
}
