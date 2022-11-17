<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 16/11/2022
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>List Catalog</title>
</head>
<body>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#newCatalogModal">
    Create New Catalog
</button>
<table border="1">
    <thead>
    <tr>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Parent Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCat}" var="cat">
        <tr>
            <td>${cat.catalogId}</td>
            <td>${cat.catalogName}</td>
            <td>${cat.catalogParentName}</td>
            <td>${cat.catalogStatus}</td>
            <td>
                <a href="">Detail</a>
                <a type="button" href="#updateCatalogModal" class="update" data-bs-toggle="modal">Update</a>
                <a type="button" href="#deleteCatalogModal" class="delete" data-bs-toggle="modal">Delete</a>
                <input type="hidden" id="catId" value="${cat.catalogId}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal Create New Catalog -->
<div class="modal fade" id="newCatalogModal" tabindex="-1" aria-labelledby="newCatalogLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newCatalogLabel">Create New Catalog</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="catatlogName">Catalog Name</span>
                        <input type="text" name="catalogName" class="form-control" placeholder="Input catalog name"
                               aria-label="CatalogName" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="descriptions">Descriptions</span>
                        <input type="text" name="descriptions" class="form-control" placeholder="Input descriptions"
                               aria-label="Descriptions" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="catalogParent">Catalog Parent</label>
                        <select class="form-select" id="catalogParent" name="parentId">
                            <option value="0" selected>Choose...</option>
                            <c:forEach items="${listCatCombo}" var="catCombo">
                                <option value="${catCombo.catalogId}">${catCombo.catalogName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="catalogStatus">Catalog Parent</label>
                        <select class="form-select" id="catalogStatus" name="status">
                            <option value="true" selected>Active</option>
                            <option value="false">Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" name="action" value="Create" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Modal Delete Catalog-->
<div class="modal fade" id="deleteCatalogModal" tabindex="-1" aria-labelledby="deleteCatalogModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteCatalogModalLabel">Delete Catalog</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                <div class="modal-body">
                    <p>Bạn chắc chắn có muốn xóa danh mục này không?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" value="Delete" name="action" class="btn btn-primary"/>
                    <input type="hidden" name="catDeleteId" id="catDeleteId"/>
                </div>
            </form>
        </div>
    </div>
</div>
<%--Modal Update Catalog--%>
<div class="modal fade" id="updateCatalogModal" tabindex="-1" aria-labelledby="updateCatalogLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateCatalogLabel">Update Catalog</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="catatlogIdUpdate">Catalog Id</span>
                        <input type="text" name="catalogId" id="catalogId" class="form-control" placeholder="Input catalog id"
                               aria-label="catalogId" aria-describedby="basic-addon1" readonly>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="catatlogNameUpdate">Catalog Name</span>
                        <input type="text" name="catalogName" id="catalogName" class="form-control" placeholder="Input catalog name"
                               aria-label="CatalogName" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="descriptionsUpdate">Descriptions</span>
                        <input type="text" name="descriptions" id="desUpdate" class="form-control" placeholder="Input descriptions"
                               aria-label="Descriptions" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="catalogParent">Catalog Parent</label>
                        <select class="form-select" id="catalogParentUpdate" name="parentId">
                            <option value="0" selected>Choose...</option>
                            <c:forEach items="${listCatCombo}" var="catCombo">
                                <option value="${catCombo.catalogId}">${catCombo.catalogName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="catalogStatus">Catalog Status</label>
                        <select class="form-select" id="catalogStatusUpdate" name="status">
                            <option value="true" selected>Active</option>
                            <option value="false">Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" name="action" value="Update" class="btn btn-primary"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
    $(document).on('click', 'table .delete', function () {
        let catId = $(this).parent().find('#catId').val();
        $('#catDeleteId').val(catId);
    });
    $(document).on('click','table .update',function (){
        console.log('Vao event update click');
        let catId = $(this).parent().find('#catId').val();
        $.ajax({
            type:'GET',
            url: '${pageContext.request.contextPath}/CatalogServlet?action=GetById&&catalogId='+catId,
            success:function (catalogUpdate){
                $('#catalogId').val(catalogUpdate.catalogId);
                $('#catalogName').val(catalogUpdate.catalogName);
                $('#desUpdate').val(catalogUpdate.descriptions);
                $('#catalogParentUpdate').val(catalogUpdate.parentId);
                let status = catalogUpdate.catalogStatus.toString();
                $('#catalogStatusUpdate').val(status);
            }
        });
    });
</script>
</body>
</html>
