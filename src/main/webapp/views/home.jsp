<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.User" %>
<%@ page import="dao.UserDao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>雑すぎる掲示板</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <header id="header">
    	<div class="mb-3">
	    	<div class="container text-center">
	    		<div class="row">
	    			<div class="col-6">
						<h1>雑な掲示板</h1>
					</div>
				</div>
			</div>
		</div>
    </header>
    
    <main>
	    <form action="<%=request.getContextPath()%>/home" method="post">
	    	<div class="mb-3">
	    		<div class="container">
	    			<div class="row">
	    				<div class="col-6">
							<label for="exampleFormControlInput1" class="form-label">ユーザー名</label>
							<input type="text" class="form-control" id="exampleFormControlInput1" name="username" placeholder="空欄の場合匿名になります">
						</div>
					</div>
				</div>
			</div>
			
			<div class="mb-3">
	    		<div class="container">
	    			<div class="row">
	    				<div class="col-6">
							<label for="exampleFormControlInput1" class="form-label">タイトル</label>
							<input type="text" class="form-control" id="exampleFormControlInput1" name="title" required>
						</div>
					</div>
				</div>
			</div>
			
			<div class="mb-3">
	    		<div class="container">
	    			<div class="row">
	    				<div class="col-6">
							<label for="exampleFormControlTextarea1" class="form-label">コメント</label>
							<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comments" required></textarea>
							<br>
							<input type="submit" value="投稿する">
						</div>
					</div>
				</div>
			</div>
		</form>
        
        <br>
        
        <!-- 投稿されたデータ表示 -->
        <div class="mb-3">
	    	<div class="container">
	    		<div class="row">
	    			<div class="col-6">
						<h2>投稿一覧</h2>
							<div class="mb-3">
						    	<div class="container">
						    		<div class="row">
						    			<div class="col-2">
						    				<form action="<%=request.getContextPath()%>/newsort" method="post">
												<input type="submit" value="新しい順">
											</form>
										</div>
									</div>
								</div>
							</div>
					        
					        <div class="mb-3">
						    	<div class="container">
						    		<div class="row">
						    			<div class="col-2">
						    				<form action="<%=request.getContextPath()%>/oldsort" method="post">
												<input type="submit" value="古い順">
											</form>
										</div>
									</div>
								</div>
							</div>
					        <%
					            UserDao dao = new UserDao();
					            ArrayList<User> userList = new ArrayList<User>();
					            userList = dao.select();
					            
					            ArrayList<User> newSortList = (ArrayList<User>)request.getAttribute("sortedList");
					            
					            if(newSortList != null && !newSortList.isEmpty()){
					                for(int i = 0; i < newSortList.size(); i++){
					                    User user = newSortList.get(i);
					        %>
					        <div>
					            <!-- 投稿日時表示 -->
					            <p>投稿日時 : <%=user.getDate() %></p>
					            <p>ユーザー名 : <%=user.getUsername() %></p>
					            <p>タイトル : <%=user.getTitle() %></p>
					            <p>コメント : <%=user.getComments() %></p>
					            <br>
					        </div>
					        <%
					                }
					            } else {
					                for(int i = 0; i < userList.size(); i++){
					                    User user = userList.get(i);
					        %>
					        <div>
					            <!-- 投稿日時表示 -->
					            <p>投稿日時 : <%=user.getDate() %></p>
					            <p>ユーザー名 : <%=user.getUsername() %></p>
					            <p>タイトル : <%=user.getTitle() %></p>
					            <p>コメント : <%=user.getComments() %></p>
					            <br>
					        </div>
					        <%
					                }
					            }
					        %>
					</div>
				</div>
			</div>
		</div>
    </main>
    
    <footer>
    	<div class="mb-3">
	    	<div class="container">
	    		<div class="row">
	    			<div class="col-6">
						<a href=#header>トップに戻る</a>
					</div>
				</div>
			</div>
		</div>
    </footer>
</body>
</html>
