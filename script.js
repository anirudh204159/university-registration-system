
function submitLogin() {
  const email = document.getElementById("loginEmail").value;
  const pass = document.getElementById("loginPass").value;
  const role = document.querySelector('input[name="role"]:checked')?.value;

  if (email === "123" && pass === "123") {
    if (role === "Student") {
      window.location.href = "student.html";
    } else if (role === "Professor") {
      window.location.href = "professor.html";
    } else {
      alert("Please select a role.");
    }
  } else {
    alert("Invalid credentials. Use 123 for both username and password.");
  }
}
