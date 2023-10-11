

const tempElement = document.getElementById("temperatura");
const minMaxElement = document.getElementById("minMax");
const sensacaoElement = document.getElementById("sensacao");
const humidadeElement = document.getElementById("humidade");
const ventoElement = document.getElementById("ventoDisplay");
const visibilidadeElement = document.getElementById("visibilidadeDisplay");

function fazerRequisicaoPOST() {
    const url = 'http://localhost:8080/Projeto-weather-forecast/WeatherAcess';
    const data = {
        "lat": 36.3243,
        "lon": 9.12767
        // Adicione mais dados conforme necessário
    };

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    };

    fetch(url, requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na requisição');

            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            const tempCelsius = data.temperatura - 273;
            const min = data.minTemp - 273;
            const max = data.maxTemp - 273;
            const sensTerm = data.sensTerm - 273;
            const humidade = data.humidade;
            const vento = data.velVento;
            const visibilidade = data.Visibilidade;

            tempElement.innerText = tempCelsius + "º";
            minMaxElement.innerText = min + "º/" + max + "º";
            sensacaoElement.innerText = "Sensação térmica de " + sensTerm + "°C";
            humidadeElement.innerText = humidade + "%";
            ventoElement.innerText = vento + " km/h";
            visibilidadeElement.innerText = visibilidade + "km";

            atualizarMapa(36.3243,9.12767)
        })
        .catch(error => {
            console.error('Catch Erro na requisição:', error);
        });
}

function atualizarMapa(novaLatitude, novaLongitude) {
    let mapa = document.getElementById("mapaVisualizer");

    latitude = novaLatitude;
    longitude = novaLongitude;

    let link = `https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d15787.627348603686!2d-${latitude}!3d-${longitude}!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sgoogle%20maps%20api%20frame!5e0!3m2!1spt-BR!2sbr!4v1696296209365!5m2!1spt-BR!2sbr`;

    mapa.src = link;
}


