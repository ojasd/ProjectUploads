<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni Edit Profile</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/alumni.css">
</head>
<body>
<?php include 'header.php'; ?>

  <?php include 'sidebar.php'; ?>

  <section>
    <div class="wrapper">
      <div id="main"> 

<form name = "editprofile" >
<h2 align="center"><u>Alumni Edit Profile</u></h2>

<div>
 
<tr>
  <td>
    
    </td>
  </tr>
</table>
</div>
<div>
   <img src="student-image-2.jpg" style="width:100px;height:100px;float:right">
  <table  align="center" cellpadding="4" style="float:left">
        <tr>
      <td align="left">
        <label for="label"><strong>Name: </strong></label>
      </td>
      <td align="left">
        <input type="text" name="name"  />
     </td>
    </tr>
 <tr>
      <td align="left">
        <label for="label"><strong>Username: </strong></label>
      </td>
      <td align="left">
        <input type="text" name="Username" />
     </td>
    </tr>
<tr>
<tr>
   <td align="left">
        <label for="label"><strong>Password: </strong></label>
   </td>
   <td align="left">
        <input type="password" name="Password" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Email: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="email" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Department: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="Department" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Major: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="major" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Degree Earned: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="degree" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Graduation Year: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="graduationyear" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Address: </strong></label>
   </td>
   <td align="left">
        <textarea rows="3" cols="30" name="address"></textarea>
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Contact No.: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="contact no." />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Marital Status: </strong></label>
   </td>
   <td align="left">
        <input type="text" name="status" />
   </td>
</tr>
<tr>
   <td align="left">
        <label for="label"><strong>Donations Made: </strong></label>
   </td>
</tr>
     </table>
     </div>
     
     <table class="donation" border="1" align ="center" cellpadding="2" >
  <tr>
    <td>
    <strong>Organization Name/ Project Name</strong>
    </td>
    <td>
    <strong>Amount Donated</strong>
    </td>
  <tr/>
  <tr>
  	<td>
  	<label for="textfield">Project1</label>
  	</td>
  	<td>
  	<label for="textfield">$1000</label>
  	</td>
  	<td>
  	
  	</td>
  </tr>
  <tr>
  	<td>
  	<label for="textfield">Project2</label>
  	</td>
  	<td>
  	<label for="textfield">$2000</label>
    </td>
    <td>
  	
  	</td>
  </tr>
  <tr>
  	<td>
  	<input type="text" name="project_name3" />
  	</td>
  	<td>
  	<input type="text" name="amount3" />
    </td>
    <td>
  	<input type="submit" name="Add" value="Add Donation"/>
  	</td>
  </tr>
  </table> 
     <br/>
        <center><input type="submit" name="Save" value="Save"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="Cancel" value="Cancel"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="Reset" type="Reset" value="Back" /></center>
      
 
</form>
<footer>
		<div class="wrapper"></div>
	</footer>

</body>
</html>