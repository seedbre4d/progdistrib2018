<jsp:useBean id="obj" class="sum.SumBean" scope="application" />
<jsp:setProperty name="obj" property="*" />
<html>

<body>
    Result
    <p>
        <%=obj.getn()%>
            is
            <%=obj.getEcuation() %>
</body>

</html>