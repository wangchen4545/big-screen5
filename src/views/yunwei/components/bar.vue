<!-- @format -->

<template>
	<div
		ref="barChart"
		id="barChart"
		style="width: 100%; height: 100%;"
	>
		<!-- <div style="width: 600px;height:400px;" id="barChart"></div> -->
	</div>
</template>

<script>
import * as echarts from 'echarts'
export default {
    name: "barChart",
    data() {
        return {

        }

    },
    methods: {
        initChart () {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('barChart'));
            // 指定图表的配置项和数据
            var option = {
                    tooltip: {
                    trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        },
                        backgroundColor: 'rgba(9, 24, 48, 0.5)',
                        borderColor: 'rgba(75, 253, 238, 0.4)',
                        textStyle: {
                            color: '#CFE3FC',
                        },
                        borderWidth: 1,
                    },
                    grid: {
                        top: '15%',
                        right: '1%',
                        left: "5%",
                        bottom: '12%'
                    },
                    xAxis: [{
                        type: 'category',
                        data: ["00:00","02:00","04:00","06:00","08:00","10:00","12:00","14:00","16:00","18:00","20:00","22:00","24:00"],
                        axisLine: {
                            lineStyle: {
                                color: '#FFFFFF'
                            }
                        },
                        axisLabel: {
                            margin: 10,
                            color: '#e2e9ff',
                            textStyle: {
                                fontSize: 40,
                                color: 'rgba(197, 228, 249, 1)'
                            },
                        },
                        axisTick: {
                            show: false
                        }
                    }],
                    yAxis: [{
                        name: "次",
                        nameTextStyle: {
                            color: 'rgba(127, 181, 217, 1)',
                            fontSize: 40
                        },
                        axisLabel: {
                            formatter: '{value}',
                            color: '#e2e9ff',
                            textStyle: {
                                fontSize: 40,
                                color: 'rgba(127, 181, 217, 1)'
                            },
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#FFFFFF'
                            }
                        },
                        splitLine: {
                            lineStyle: {
                                color: 'rgba(255,255,255,0.12)'
                            }
                        }
                    }],
                    series: [{
                        type: 'bar',
                        data: [2000,1520,1850,3400,2756,3000,2560,1980,1230,2560,3450,2560,1980],
                        barWidth: '30%',
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                    offset: 0,
                                    color: 'rgba(166, 215, 255, 1)' // 0% 处的颜色
                                }, {
                                    offset: 1,
                                    color: 'rgba(69, 129, 150, 1)' // 100% 处的颜色
                                }], false),
                                shadowColor: 'rgba(37, 70, 98, 1)',
                                shadowBlur: 4,
                            }
                        },
                    }]
                };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    },
    mounted () {
        this.$nextTick(() => {
            this.initChart()
        })
    },
    }
</script>

<style lang="scss" scoped></style>
