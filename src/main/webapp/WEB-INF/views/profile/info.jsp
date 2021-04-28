<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>


</head>

<body>

   

    <div id="wrapper">


            <table>
                <tr>
                    <td><label for="title">Nickname</label></td>
                    <td><input
                             type="text" 
                             id="nickname" 
                             name="nickname" 
                             size="20" 
                             value="${__PROFILE__.nickname}" 
                             readonly>
                    </td>
                </tr>

                <tr>
                    <td><label for="age">Age</label></td>
                    <td><input
                            name="age"
                            id="age"
                            size="20"
                            value="${__PROFILE__.age}"
                            readonly>
                    </td>
                </tr>

                <tr>
                    <td><label for="gender">Gender</label></td>
                    <td><input
                            type="text" 
                            id="gender" 
                            name="gender" 
                            size="20" 
                            value="${__PROFILE__.gender}" 
                            readonly>
                    </td>
                </tr>
                
                <tr>
                    <td><label for="introduce">Introduce</label></td>
                    <td><input
                            type="text" 
                            id="introduce" 
                            name="introduce" 
                            size="20" 
                            value="${__PROFILE__.introduce}" 
                            readonly>
                    </td>
                </tr>
                 <tr>
                    <td><label for="zone">zone</label></td>
                    <td><input
                            type="text" 
                            id="zone" 
                            name="zone" 
                            size="20" 
                            value="${__PROFILE__.zone}" 
                            readonly>
                    </td>
                </tr>
                <tr>
                    <td><label for="hobby1">hobby1</label></td>
                    <td><input
                            type="text" 
                            id="hobby1" 
                            name="hobby1" 
                            size="20" 
                            value="${__PROFILE__.hobby1}" 
                            readonly>
                    </td>
                </tr>
                <tr>
                    <td><label for="hobby2">hobby2</label></td>
                    <td><input
                            type="text" 
                            id="hobby2" 
                            name="hobby2" 
                            size="20" 
                            value="${__PROFILE__.hobby2}" 
                            readonly>
                    </td>
                </tr>
                <tr>
                    <td><label for="hobby3">hobby3</label></td>
                    <td><input
                            type="text" 
                            id="hobby3" 
                            name="hobby3" 
                            size="20" 
                            value="${__PROFILE__.hobby3}" 
                            readonly>
                    </td>
                </tr>
            </table>

           
   </div>

       
         

</body>
</html>