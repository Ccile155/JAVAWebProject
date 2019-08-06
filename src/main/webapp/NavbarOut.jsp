<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/ProjetWeb/#">MédiaShare</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<%=getServletConfig().getServletContext().getContextPath()%>/Home"><i class="material-icons">home</i> Accueil <span class="sr-only">(current)</span>&nbsp;</a>
            </li> 
            <li class="nav-item">
                <a class="nav-link" href="<%=getServletConfig().getServletContext().getContextPath()%>/Consult.jsp?t=livre"><i class="material-icons">local_library</i> Livres &nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=getServletConfig().getServletContext().getContextPath()%>/Consult.jsp?t=dvd"><i class="material-icons">local_movies</i> DVDs &nbsp;</a>
            </li>
           <li class="nav-item">
                <a class="nav-link" href="<%=getServletConfig().getServletContext().getContextPath()%>/Emprunter"><i class="material-icons">move_to_inbox</i> Emprunter &nbsp;</a>
            </li>
<!--        <li class="nav-item">
                <a class="nav-link" href="/ProjetWeb/Nouveau"><i class="material-icons">create</i> Nouveau media</a>
            </li>-->
            <li>
                <a class="nav-link" href="<%=getServletConfig().getServletContext().getContextPath()%>/BeanTest.jsp"><i class="material-icons">search</i> Rechercher &nbsp;</a>
            </li>
        </ul>
        </div>
        <ul class="navbar-nav" style="float:left;">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="material-icons">account_circle</i> 
                    Session invitée
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="<%=getServletConfig().getServletContext().getContextPath()%>/Inscription.jsp"><i class='material-icons'>create</i> Inscription</a>
                    <a class="dropdown-item" href="<%=getServletConfig().getServletContext().getContextPath()%>/Connexion"><i class='material-icons'>check</i> Connexion</a>
                </div>
            </li>
        </ul>
</nav>