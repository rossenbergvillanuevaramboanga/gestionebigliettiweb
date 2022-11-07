<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<header>
  <!-- Fixed navbar -->
 <nav class="navbar navbar-expand-lg navbar-dark" aria-label="Eighth navbar example">
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath }/admin/PrepareInsertBigliettoServlet">Inserisci</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath }/PrepareSearchBigliettoServlet">Ricerca</a>
          </li>
          <!--  <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="ListBigliettiServlet">Elenca Biglietti</a></li>
              <li><a class="dropdown-item" href="PrepareInsertBigliettoServlet">Inserisci Biglietto</a></li>
              <li><a class="dropdown-item" href="PrepareSearchBigliettoServlet">Ricerca Biglietto</a></li>
            </ul>
          </li>-->
        </ul>
      </div>
      <div class="col-md-3 text-end" >
      <c:if test="${userInfo == null }">
        <a  class="btn bg-white" href="<%= request.getContextPath()%>/LoginServlet" style="color: #000000;">Login</a>
      </c:if>
      <c:if test="${userInfo != null }">
     	<p class="navbar-text"> Benvenuto ${userInfo.username}! 
        <a  class="btn bg-white" href="<%= request.getContextPath()%>/LogoutServlet" style="color: #000000;">Logout</a>
      </c:if>
      </div>
    </div>
  </nav>

  
  
</header>