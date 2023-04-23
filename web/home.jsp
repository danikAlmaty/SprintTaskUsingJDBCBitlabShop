<%@ page import="java.util.ArrayList" %>
<%@ page import="bitlab.techorda.kz.classes.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shop</title>
    <%@include file="head.jsp"%>
</head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="text-center mb-3">
            <h1>Welcome to BITLAB SHOP</h1>
            <h5 class="text-secondary">Electronic devices with high quality and service</h5>
        </div>
        <div class="container w-50 align-content-center align-items-center">

            <div class="row mt-3">
                <%
                    ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("zattar");

                    for (Item it : items) {


                %>

                <div class="col-4 mb-3">
                    <div class="card h-100 text-center">
                        <div class="card-header"><h5><%=it.getName()%>
                        </h5></div>
                        <div class="card-body d-flex flex-column">
                            <h2 class="card-title text-success">$<%=it.getPrice()%>
                            </h2>
                            <p class="flex-grow-1 text-center px-5"><%=it.getDescription()%>
                            </p>
                            <a href="#" class="btn btn-success mt-auto">Buy Now</a>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
