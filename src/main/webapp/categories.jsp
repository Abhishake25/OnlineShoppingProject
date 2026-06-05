<%@ page import="java.util.List" %>
<%@ page import="com.shopping.entity.Category" %>

<%
List<Category> categories =
        (List<Category>) request.getAttribute("categories");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Categories</title>

<style>

body{
    margin:0;
    font-family:Arial, sans-serif;
    background:#f5f5f5;
}

.header{
    background:#232f3e;
    color:white;
    text-align:center;
    padding:20px;
}

.header h1{
    margin:0;
}

.container{
    width:90%;
    margin:30px auto;
    display:flex;
    justify-content:center;
    gap:30px;
    flex-wrap:wrap;
}

.card{
    width:320px;
    background:white;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0px 2px 10px rgba(0,0,0,0.2);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.card-content{
    padding:15px;
}

.card-content h2{
    margin-top:0;
    color:#333;
}

.card-content p{
    color:#666;
    min-height:60px;
}

.btn{
    display:inline-block;
    background:#ff9900;
    color:white;
    text-decoration:none;
    padding:10px 15px;
    border-radius:5px;
    font-weight:bold;
}

.btn:hover{
    background:#e68a00;
}

</style>

</head>
<body>

<div class="header">
    <h1>Online Shopping System</h1>
    <p>Select a Category to Explore Products</p>
</div>

<div class="container">

<%
if(categories != null){
    for(Category category : categories){
%>

    <div class="card">

        <img src="<%= category.getCategoryImageUrl() %>"
             alt="<%= category.getCategoryName() %>">

        <div class="card-content">

            <h2><%= category.getCategoryName() %></h2>

            <p>
                <%= category.getCategoryDescription() %>
            </p>

            <a class="btn"
               href="products?categoryId=<%= category.getCategoryId() %>">
               View Products
            </a>

        </div>

    </div>

<%
    }
}
%>

</div>

</body>
</html>