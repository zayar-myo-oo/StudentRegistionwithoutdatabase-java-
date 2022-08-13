document.querySelector(".addsubmits").addEventListener("click", () => {
  let stuName = document.getElementById("stuName").value;
  let stuDOB = document.getElementById("stuDOB").value;
  let stuGender = document.getElementById("stuGender").value;
  let stuPhone = document.getElementById("stuPhone").value;
    let stuEdu = document.getElementById("stuEdu").value;
    let stuCourse = document.getElementById("stuCourse").value;
    let stuPhoto = document.getElementById("stuPhoto").value;

  if (stuName == "" || stuDOB == "" || stuGender == "" || stuPhone.value.length <=10 || stuEdu == "edu" || stuCourse =="" || stuPhoto=="") {
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