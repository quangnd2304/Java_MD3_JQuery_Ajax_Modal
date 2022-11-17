package ra.model.entity;

public class CatalogInfo extends Catalog{
    private String catalogParentName;

    public CatalogInfo() {
    }

    public CatalogInfo(int catalogId, String catalogName, String descriptions, int parentId, boolean catalogStatus, String catalogParentName) {
        super(catalogId, catalogName, descriptions, parentId, catalogStatus);
        this.catalogParentName = catalogParentName;
    }

    public String getCatalogParentName() {
        return catalogParentName;
    }

    public void setCatalogParentName(String catalogParentName) {
        this.catalogParentName = catalogParentName;
    }
}
