document.querySelector(".addsubmits").addEventListener("click", () => {
 
  let courseId = document.getElementById("courseid").value;
    let courseName = document.getElementById("coursename").value;

  if (courseId=="" || courseName=="") {
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