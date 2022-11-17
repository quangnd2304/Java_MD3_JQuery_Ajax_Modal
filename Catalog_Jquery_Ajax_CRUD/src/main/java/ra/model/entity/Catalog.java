package ra.model.entity;

public class Catalog extends CatalogCombobox{
    private String descriptions;
    private int parentId;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String descriptions, int parentId, boolean catalogStatus) {
        super(catalogId, catalogName);
        this.descriptions = descriptions;
        this.parentId = parentId;
        this.catalogStatus = catalogStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
