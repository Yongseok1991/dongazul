<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>

    <style>

          #listBtn, #removeBtn, #modifyBtn {
            width: 100px;
            height: 30px;

            border: 0;

            font-size: 15px;
            font-weight: bold;

            color: white;
            background-color: rgb(255, 177, 75);

            cursor: pointer;
          
            margin-top: 10px;
        }


    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>
    
    <script>

        $(function () {
            console.clear();
            console.log('jquery started.....');
        
            
            $('#listBtn').on('click', function(e) { 
                console.log('onclicked....');

                self.location = '/board/listPerPage${cri.pagingUri}';  // GET
            }); // onclick	
			
           
            $('#modifyBtn').on('click', function() { 
                console.log('onclicked....');

                self.location = '/board/modify${cri.pagingUri}&bno=${board.bno}';  // GET
            }); // onclick
        }); // jq
        
    </script>

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
                    <td><label for="interests">Interests</label></td>
                    <td><input
                            type="text" 
                            id="interests" 
                            name="interests" 
                            size="20" 
                            value="${__PROFILE__.iname}" 
                            readonly>
                    </td>
                </tr>
</table>
   </div>

    	
   		

</body>
</html>