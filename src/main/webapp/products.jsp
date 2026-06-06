<%@ page import="java.util.List" %>
<%@ page import="com.shopping.entity.Product" %>

<%
List<Product> products =
        (List<Product>)request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<style>

body{
    margin:0;
    font-family:Arial;
    background:#f4f4f4;
}

.header{
    background:#232f3e;
    color:white;
    text-align:center;
    padding:20px;
}

.container{
    width:90%;
    margin:30px auto;
    display:flex;
    flex-wrap:wrap;
    justify-content:center;
    gap:25px;
}

.card{
    width:300px;
    background:white;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0 2px 10px rgba(0,0,0,0.2);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.content{
    padding:15px;
}

.price{
    color:green;
    font-size:22px;
    font-weight:bold;
}

.btn{
    display:inline-block;
    text-decoration:none;
    background:#ff9900;
    color:white;
    padding:10px 15px;
    border-radius:5px;
}

</style>

</head>
<body>

<div class="header">
    <h1>Available Products</h1>
</div>

<div class="container">

<%
if(products != null){
    for(Product product : products){
%>

<div class="card">

    <img src="<%= product.getProductImageUrl() %>">

    <div class="content">

        <h2>
            <%= product.getProductName() %>
        </h2>

       
        <p class="price">
            ₹ <%= product.getPrice() %>
        </p>

        <a class="btn"
           href="cart?productId=<%= product.getProductId() %>">
           Add To Cart
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