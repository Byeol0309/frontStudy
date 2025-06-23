// auth.js

// 사용자 정보 저장용

let users = JSON.parse(localStorage.getItem("users")) || [];
let currentUser = localStorage.getItem("currentUser") || null;
const form = document.querySelector(".card-body")


// 회원가입 함수
function register() {
  const email = document.getElementById("regEmail").value.trim();
  const pw = document.getElementById("regPw").value.trim();
  const name = document.getElementById("regName").value.trim();
  
  if (!email || !pw) {
    alert("이메일과 비밀번호를 입력하세요.");
    return;
  }

  const exists = users.find(user => user.email === email);
  if (exists) {
    alert("이미 등록된 이메일입니다.");
    return;
  }

  users.push({ email, password: pw, name: name });
  localStorage.setItem("users", JSON.stringify(users));
  alert("회원가입 성공! 로그인 해주세요.");
  location.href = "login.html";
}
// 로그인 함수
function login() {
  const email = document.getElementById("loginEmail").value.trim();
  const pw = document.getElementById("loginPw").value.trim();
  
  const user = users.find(user => user.email === email && user.password === pw);
  if (user) {
    localStorage.setItem("currentUser", email);
    alert("로그인 성공!");
    location.href = "index.html";  // 메인 페이지로 이동
  } else {
    alert("이메일 또는 비밀번호가 잘못되었습니다.");
  }
}

// 로그아웃 함수
function logout() {
  localStorage.removeItem("currentUser");
  alert("로그아웃 되었습니다.");
  location.href = "index.html";
}

// 현재 사용자 표시 함수 (index.html에 활용 가능)
function showUser() {
  const user = localStorage.getItem("currentUser");
  if (user) {
    document.getElementById("welcome").innerHTML = "${user}님 환영합니다!";
  }
}

// 사용자 정보 불러오기
function loadUserData() {
  const currentEmail = localStorage.getItem("currentUser");
  const users = JSON.parse(localStorage.getItem("users")) || [];

  const currentUser = users.find(user => user.email === currentEmail);
  if (!currentUser) {
    alert("로그인이 필요합니다.");
    location.href = "login.html";
    return;
  }

  document.getElementById("emailDisplay").innerText = currentUser.email;
  document.getElementById("nameDisplay").innerText = currentUser.name || "(이름 없음)";
}

// 정보 수정
/*function updateUserData() {
  const currentEmail = localStorage.getItem("currentUser");
  const users = JSON.parse(localStorage.getItem("users")) || [];

  const userIndex = users.findIndex(user => user.email === currentEmail);
  if (userIndex === -1) {
    alert("사용자 정보를 찾을 수 없습니다.");
    return;
  }

  const newPw = document.getElementById("newPw").value.trim();
  const newName = document.getElementById("newName").value.trim();

  if (newPw) {
    users[userIndex].password = newPw;
  }
  if (newName) {
    users[userIndex].name = newName;
  }

  localStorage.setItem("users", JSON.stringify(users));
  alert("정보가 수정되었습니다.");
  loadUserData(); // 다시 불러오기
}*/

function updateUserData() {
  const newPw = document.getElementById("newPw").value.trim();
  const confirmPw = document.getElementById("confirmPw").value.trim();
  const currentUserEmail = localStorage.getItem("currentUser");

  if (!currentUserEmail) {
    alert("로그인이 필요합니다.");
    location.href = "login.html";
    return;
  }

  if (!newPw) {
    alert("새 비밀번호를 입력하세요.");
    return;
  }

  if (newPw !== confirmPw) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }

  const users = JSON.parse(localStorage.getItem("users")) || [];
  const userIndex = users.findIndex(user => user.email === currentUserEmail);

  if (userIndex !== -1) {
    users[userIndex].password = newPw;
    localStorage.setItem("users", JSON.stringify(users));
    alert("비밀번호가 성공적으로 변경되었습니다!");
    location.href = "home.html"; // 또는 다른 페이지로 이동
  } else {
    alert("사용자 정보를 찾을 수 없습니다.");
  }
}
