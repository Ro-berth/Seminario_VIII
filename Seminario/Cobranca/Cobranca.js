btnMobile = document.getElementById("btn-mobile");

//Consumir função pra criar cobrança
function createCob() {
  var cobId = document.getElementById("cliente_id").value;
  var cobAmount = document.getElementById("valor").value;
  var cobDueDate = document.getElementById("data_vancimento").value;
  var cobStatus = document.getElementById("status").value;
  var data = {"customerId": cobId, "amount": cobAmount, "dueDate": cobDueDate, "status": cobStatus};
  fetch('http://127.0.0.1:8084/billings', {
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

//Função de deletar cobranca
function deleteCob(cobId) {
  fetch(`http://127.0.0.1:8084/billings/${cobId}`, { 
    method: 'DELETE' 
  })
  .then(response => response.json())
  .then(data => {
      console.log(data);
      location.reload();  // Recarrega a página após deletar o usuário
  })
  .catch(error => console.log(error));
}

//Listando os Cobraça
fetch('http://localhost:8084/billings')
  .then(res =>{
    return res.json();
  })
  .then(data =>{
    data.forEach(cob => {
      const markup = `<tr>
                   <td>${cob.id}</td>
                   <td>${cob.amount}</td>
                   <td type="date">${cob.dueDate}</td>
                   <td>${cob.status}</td>
                   </tr>`
      document.querySelector('tbody').insertAdjacentHTML('beforeend',markup);        
    });
  })
  .catch(error => console.log(error))

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


// cadastro
const modal = document.querySelector(".modal-container");
const tbody = document.querySelector("tbody");
const sNome = document.querySelector("#m-nome");
const sFuncao = document.querySelector("#m-funcao");
const sSalario = document.querySelector("#m-salario");
const btnSalvar = document.querySelector("#btnSalvar");

let itens;
let id;

function openModal(edit = false, index = 0) {
  modal.classList.add("active");

  modal.onclick = (e) => {
    if (e.target.className.indexOf("modal-container") !== -1) {
      modal.classList.remove("active");
    }
  };

  if (edit) {
    sNome.value = itens[index].nome;
    sFuncao.value = itens[index].funcao;
    sSalario.value = itens[index].salario;
    id = index;
  } else {
    sNome.value = "";
    sFuncao.value = "";
    sSalario.value = "";
  }
}

function editItem(index) {
  openModal(true, index);
}

function deleteItem(index) {
  itens.splice(index, 1);
  setItensBD();
  loadItens();
}

function insertItem(item, index) {
  let tr = document.createElement("tr");

  tr.innerHTML = `
    <td>${item.nome}</td>
    <td>${item.funcao}</td>
    <td>R$ ${item.salario}</td>
    <td class="acao">
      <button onclick="editItem(${index})"><i class='bx bx-edit' ></i></button>
    </td>
    <td class="acao">
      <button onclick="deleteItem(${index})"><i class='bx bx-trash'></i></button>
    </td>
  `;
  tbody.appendChild(tr);
}

btnSalvar.onclick = (e) => {
  if (sNome.value == "" || sFuncao.value == "" || sSalario.value == "") {
    return;
  }

  e.preventDefault();

  if (id !== undefined) {
    itens[id].nome = sNome.value;
    itens[id].funcao = sFuncao.value;
    itens[id].salario = sSalario.value;
  } else {
    itens.push({
      nome: sNome.value,
      funcao: sFuncao.value,
      salario: sSalario.value,
    });
  }

  setItensBD();

  modal.classList.remove("active");
  loadItens();
  id = undefined;
};

function loadItens() {
  itens = getItensBD();
  tbody.innerHTML = "";
  itens.forEach((item, index) => {
    insertItem(item, index);
  });
}

const getItensBD = () => JSON.parse(localStorage.getItem("dbfunc")) ?? [];
const setItensBD = () => localStorage.setItem("dbfunc", JSON.stringify(itens));

loadItens();
