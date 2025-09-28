<!-- @format -->

<template>
	<div
		class="guzhangBar"
		id="guzhangBar"
	></div>
</template>

<script>
import * as echarts from 'echarts';

export default {
    name: "guzhangBar",
    data () {
        return {
        }

    },
    methods: {
        initChart() {
          var chartDom = document.getElementById('guzhangBar');
          var myChart = echarts.init(chartDom);
          var option;

          const rawData = [
            [20, 302, 301, 334, 390, 330, 320, 320, 320, 320, 320, 320],
            [320, 132, 101, 134, 90, 230, 210, 320, 320, 320, 320, 320],
            [220, 182, 191, 234, 290, 330, 310, 320, 320, 320, 320, 320],
            [150, 212, 201, 154, 190, 330, 410, 320, 320, 320, 320, 320],
            [820, 832, 901, 934, 1290, 1330, 1320, 320, 320, 320, 320, 320]
          ];
          const totalData = [];
          for (let i = 0; i < rawData[0].length; ++i) {
            let sum = 0;
            for (let j = 0; j < rawData.length; ++j) {
              sum += rawData[j][i];
            }
            totalData.push(sum);
          }
          const colSum = new Array(rawData[0].length).fill(0);

          // 累加
          for (let r = 0; r < rawData.length; r++) {
            for (let c = 0; c < rawData[r].length; c++) {
              colSum[c] += rawData[r][c];
            }
          }

          const color = ['#7FB5D9', '#30A8FA', '#4BE7FF', '#E4C85D', '#FF6E38'];
          const series = ['一级故障', '二级故障', '三级故障', '四级故障', '五级故障'].map(
            (name, sid) => {
              return {
                type: 'bar',
                stack: 'total',
                barWidth: '60',
                itemStyle: {
                  color: color[sid]
                },
                data: rawData[sid]
              };
            }
          );
          // 顶上的字
          series.push({
            type: 'bar',
            itemStyle: {
              color: 'rgba(255,255,255,0.1)'
            },
            label: {
              show: true,
              position: 'top',
              color: '#fff',
              fontSize: 40,
              align: 'right',
              barWidth: '60',
              fontFamily:'Gotthard'
            },
            data: totalData
          });
        option = {
            grid: {
            left: "6%",
            right: "4%",
            bottom: "11%",
            },
            yAxis: {
              name: '个',
              type: 'value',
              nameTextStyle: {
                color: '#7FB5D9',
                align: 'right',
                padding: [0, 7, 0, 0],
                fontSize: 40
              },
              axisLabel: {
                fontSize: 40,
                color: '#7FB5D9'
              },
              splitLine: {
                show: true,
                lineStyle: {
                  color: "#7FB5D9"
                }
              }
            },
            xAxis: {
              type: 'category',
              data: [
                '1月',
                '2月',
                '3月',
                '4月',
                '5月',
                '6月',
                '7月',
                '8月',
                '9月',
                '10月',
                '11月',
                '12月'
              ],
              axisLabel: {
                fontSize: 40,
                color: '#7FB5D9'
              }
            },
            series
          };

          option && myChart.setOption(option);

        }
    },
  mounted () {
      this.initChart();
    },

}
</script>

<style lang="scss" scoped>
#guzhangBar{
  width: 100%;
  height: 100%;
}
</style>
