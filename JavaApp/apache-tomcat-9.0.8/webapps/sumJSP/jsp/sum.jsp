<jsp:useBean id="obj" class="sum.SumBean" scope="application" />
<jsp:setProperty name="obj" property="*" />
<html>

<body>
    Result
    <p>

        suma multiplilor de 3 sau 5 mai mici decat
        <%=obj.getn()%> este
            <%=obj.getSum() %>
</body>

</html>