document.querySelector(".addsubmits").addEventListener("click", () => {
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  let conpassword = document.getElementById("confirmPassword").value;
  let username = document.getElementById("name").value;
  let userid = document.getElementById("id").value;
  let userRole = document.getElementById("userRole").value;

  if (password == "" || email == "" || conpassword == "" || userRole == "role" || password != conpassword || username =="" || id=="") {
    console.log("null")
    document.getElementById("addusersuccessfuls").innerHTML = "INSERT UNSUCCESSFULLY";
    document.getElementById("addusersuccessfuls").style = "color:red";
    document.getElementById("okbtns").setAttribute("type", "button");
    console.log(document.getElementById("okbtns"));
  } else {
    console.log("ok")
    document.getElementById("addusersuccessfuls").innerHTML = "INSERT SUCCESSFULLY";
    document.getElementById("addusersuccessfuls").style = "color: rgb(127, 209, 131)";
    document.getElementById("okbtns").setAttribute("type", "submit");
    console.log(document.getElementById("okbtns"));
  }




});