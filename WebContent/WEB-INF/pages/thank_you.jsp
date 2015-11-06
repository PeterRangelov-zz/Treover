<html>
	<head>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h3>Your request has been submitted</h3>
			<table class="table table-bordered">
				<tr>
					<td>Name</td>
					<td>${form.name}</td>
				</tr>
				<tr>
					<td>Unit</td>
					<td>${form.unit}</td>
				</tr>
				<tr>
					<td>Subject</td>
					<td>${form.subject}</td>
				</tr>
				<tr>
					<td>Comments</td>
					<td>${form.text}</td>
				</tr>
			</table>
		</div>
	</body>
</html>