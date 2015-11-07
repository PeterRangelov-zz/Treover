<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<div class=row>
				<h3>New request</h3>
				<hr>
				<form method="post" action="/submit" enctype="multipart/form-data">
					<div class="form-group required">
						<label for="name">Your name (required)</label>
						<br>
						<form:errors path="form.name" cssClass="text-danger"/>
						<input name=name class=form-control value="" maxlength=30 >
					</div>
					
					<div class="form-group">
						<label for="unit">Unit (required)</label>
						<br>
						<form:errors path="form.unit" cssClass="text-danger"/>
						<input name=unit class=form-control value="" maxlength=10 />
					</div>
					
					
					<div class="form-group">
						<label for="subject">Subject (required)</label>
						<br>
						<form:errors path="form.subject" cssClass="text-danger"/>
						<input name=subject class=form-control value="" maxlength=30 >
					</div>
					
					<div class="form-group">
						<label for="text">Please provide details (required)</label>
						<br>
						<form:errors path="form.text" cssClass="text-danger"/>
						<textarea class=form-control rows="10" cols="50" name=text maxlength=1000></textarea>
					</div>
					
					<div class="form-group">
						<label for="file">Upload photo</label>
						<br>
						<form:errors path="form.file"></form:errors>
						<input type="file" name="file">
					</div>
					
					<div class="form-group">
						<br>
						<button type=submit class="btn btn-success">Submit request</button>
					</div>
				</div>
			</form>
		</div>
			
		
		<br>
	</body>
</html>