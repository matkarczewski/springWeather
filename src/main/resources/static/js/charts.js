window.onload = function() {
    weather.init();
}

class Weather {
    init() {
        this.showCharts();
    }

    showCharts() {
        const days = ["niedziela", "poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota"];
        const months = ["stycznia", "lutego", "marca", "kwietnia", "maja", "czerwca", "lipca",
            "sierpnia", "września", "października", "listopada", "grudnia"];

        const currentTime = new Date(currentDate * 1000);

        const seriesArr0 = [];
        const seriesArr1 = [];
        const seriesArr2 = [];

        for (let i = 0; i < 24; i++) {
            seriesArr0[i] = [[i], [forecastDay0.hour[i].tempC]];
            seriesArr1[i] = [[i], [forecastDay1.hour[i].tempC]];
            seriesArr2[i] = [[i], [forecastDay2.hour[i].tempC]];
        }

        const options = {
            colors:['#FF6077', '#26E7A6', '#249EFA'],
            annotations: {
                points:
                    [
                        {
                            x: currentTime.getHours(),
                            y: forecastDay0.hour[currentTime.getHours()].tempC,
                            marker: {
                                size: 5,
                                fillColor: "#FF6077",
                                strokeColor: "#FF6077"
                            },
                            label: {
                                borderColor: '#CE382B',
                                text: `Teraz: ${Math.round(forecastDay0.hour[currentTime.getHours()].tempC)} °C`,
                                style: {
                                    fontSize: '13px'
                                }
                            },
                        }
                    ]
            },
            chart: {
                type: 'line',
                zoom: {
                    enabled: false,
                }
            },
            grid: {
                row: {
                    colors: ['#e5e5e5', 'transparent'],
                    opacity: 0.5
                },
                xaxis: {
                    lines: {
                        show: true
                    }
                }
            },
            stroke: {
                curve: 'smooth',
            },
            series: [{
                name: 'dzisiaj',
                data: seriesArr0
            },
                {
                    name: `${days[new Date(forecastDay1.dateEpoch * 1000).getDay()]}`,
                    data: seriesArr1
                },
                {
                    name: `${days[new Date(forecastDay2.dateEpoch * 1000).getDay()]}`,
                    data: seriesArr2
                }],
            xaxis: {
                type: 'numeric',
                min: 0,
                max: 23,
                tickAmount: 12,
                decimalsInFloat: 0,
                labels: {
                    style: {
                        fontSize: '14px'
                    }
                }
            },
            yaxis: {
                lines: {
                    show: true,
                },
                labels: {
                    style: {
                        fontSize: '14px'
                    }
                }
            },
            legend: {
                position: 'top',
                fontSize: '14px'
            }
        }

        const chart = new ApexCharts(document.querySelector("#chart"), options);
        chart.render();
    }

}

const weather = new Weather();