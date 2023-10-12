let cidades = [
    "Arcoverde", "Maceió",
    "Correntes", "Garanhuns",
    "Pedra", "Caruaru", "Aracaju"
]

function procurar() {
    let pesquisa = document.getElementById("entradaPesquisa").value;

    let resultados = cidades.filter(
        (cidade) => {
            return cidade.toLowerCase().includes(pesquisa.toLowerCase())
        });
    displayResultadosPesquisa(pesquisa, resultados.slice(0, 5));
}

function displayResultadosPesquisa(pesquisa, resultados) {
    let divResultados = document.querySelector("section#pesquisa");
    let innerList = "<ul id='resultadosPesquisa'>";

    if (resultados.length === 0 || pesquisa === "") {
        divResultados.querySelector("div#barra-pesquisa").style.borderBottomLeftRadius = "2em";
        divResultados.querySelector("div#barra-pesquisa").style.borderBottomRightRadius = "2em";
        divResultados.querySelector("div#container-resultados").innerHTML = "";
    }
    else {
        for (let cidade of resultados) {
            console.log(cidade);
            innerList += `<li>${cidade}</li>`;
        }

        innerList += "</ul>";

        divResultados.querySelector("div#container-resultados").innerHTML = innerList;
        resizeResultadosPesquisa()
    }
}

function resizeResultadosPesquisa() {
    let sectionPesquisa = document.querySelector("section#pesquisa > div#barra-pesquisa");
    let ulResultados = document.getElementById("resultadosPesquisa");

    ulResultados.style.width = (sectionPesquisa.offsetWidth - 46) + "px";
    sectionPesquisa.style.borderBottomLeftRadius = "0";
    sectionPesquisa.style.borderBottomRightRadius = "0";
}

window.addEventListener("resize", resizeResultadosPesquisa);