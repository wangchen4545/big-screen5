<!-- @format -->

<template>
	<div
		class="jinggaoGauge"
		id="jinggaoGauge"
	></div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    name: "jinggaoGauge",
    data () {
        return {
        }
    },
    methods: {
        initChart() {
            var chartDom = document.getElementById('jinggaoGauge');
            var myChart = echarts.init(chartDom);
            var option;

            const gaugeData = [
            {
                value: 80,
                name: '恢复程度',
                title: {
                offsetCenter: ['0%', '25%'],
                fontSize: 40,
                color: '#7FB5D9'
                }
            }
            ];
            option = {
            series: [
                {
                type: 'gauge',
                startAngle: 90,
                endAngle: -270,
                pointer: {
                    show: false
                },
                center: ['50%', '50%'],

                radius: '100%',
                progress: {
                    show: true,
                    overlap: true,
                    roundCap: false,
                    clip: false,
                    width: 30,
                    itemStyle: {
                    borderWidth: 1,
                    color: new echarts.graphic.LinearGradient(1, 0, 0, 1, [
                        {
                        offset: 0,
                        color: 'rgba(127,181,217,0.1)'
                        },
                        {
                        offset: 1,
                        color: '#4BE7FF'
                        }
                    ])
                    }
                },
                axisLine: {
                    lineStyle: {
                    width: 30,
                    color: [
                        [1, 'rgba(127,181,217,0.1)'] // 0~10% 红轴
                    ]
                    }
                },
                splitLine: {
                    show: false,
                    distance: 0,
                    length: 10
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    show: false,
                    distance: 50
                },
                data: gaugeData,
                title: {
                    offsetCenter: ['20%', '50%'],
                    fontWeight: 'bold'
                },
                detail: {
                    width: 50,
                    height: 14,
                    fontSize: 64,
                    color: '#fff',
                    fontFamily: 'Gotthard',
                    offsetCenter: ['0%', -30],
                    formatter: ['{value}', '{b|%}'].join(''),
                    rich: {
                    b: {
                        height: 60,
                        fontSize: 40,
                        color: '#557D97'
                    }
                    }
                }
                }
            ]
            };

            option && myChart.setOption(option);

        }
    },
    mounted() {
        this.initChart()
    },
}
</script>

<style lang="scss" scoped>
#jinggaoGauge{
  width: 100%;
  height: 100%;
}
</style>
