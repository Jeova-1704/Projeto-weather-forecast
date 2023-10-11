let latitude = 0;
let longitude = 0;

function atualizarMapa(novaLatitude, novaLongitude) {
    let mapa = document.getElementById("mapaVisualizer");

    latitude = novaLatitude;
    longitude = novaLongitude;

    let link = `https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d15787.627348603686!2d-${latitude}!3d-${longitude}!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sgoogle%20maps%20api%20frame!5e0!3m2!1spt-BR!2sbr!4v1696296209365!5m2!1spt-BR!2sbr`;

    mapa.src = link;
}
const pessoa = {
    lat: latitude,
    long: longitude,
};

// URL : http://localhost:8080/Projeto-weather-forecast/WeatherAcess

function fazerRequisicaoPOST() {
    const url = 'http://localhost:8080/Projeto-weather-forecast/WeatherAcess';
    const data = {
        "lat": 10,
        "lon": 10
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
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
        });
}


