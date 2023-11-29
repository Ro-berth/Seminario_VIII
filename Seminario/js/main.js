const btnMobile = document.getElementById("btn-mobile");

//Consumir função pra criar cliente
function createUser() {
  var userName = document.getElementById("firstname").value;
  var userEmail = document.getElementById("email").value;
  var userPhone = document.getElementById("number").value;
  var userDocument = document.getElementById("cpf").value;
  var data = {"name": userName, "document": userDocument, "email": userEmail, "phone": userPhone};
  fetch('http://127.0.0.1:8084/customers', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
  })
  .then(response => response.json())
  .then(data => {
      console.log(data);
      location.reload();  // Recarrega a página após a criação do usuário
  })
  .catch(error => console.log(error));
}

function listCustomer(){
  fetch('http://127.0.0.1:8084/customers',
  {headers: {
    'Content-type': 'application/json;charset=UTF-8'
    
  }}
  ).then((response) => {
    console.log(response);
  }) 
}

function toggleMenu(event) {
  if (event.type === "touchstart") event.preventDefault();
  const nav = document.getElementById("nav");
  nav.classList.toggle("active");
  const active = nav.classList.contains("active");
  event.currentTarget.setAttribute("aria-expanded", active);
  if (active) {
    event.currentTarget.setAttribute("aria-label", "Fechar Menu");
  } else {
    event.currentTarget.setAttribute("aria-label", "Abrir Menu");
  }
}

btnMobile.addEventListener("click", toggleMenu);
btnMobile.addEventListener("touchstart", toggleMenu);
