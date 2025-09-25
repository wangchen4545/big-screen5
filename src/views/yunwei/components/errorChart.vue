<!-- @format -->

<template>
	<div
		ref="errorChart"
		id="errorChart"
		style="width: 100%; height: 100%;"
	></div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    name: "errorChart",
    props: {
    },
    data () {
        return {
        }
    },
    mounted () {
        this.initChart()
    },
    methods: {
        initChart () {
            var myChart = echarts.init(document.getElementById('errorChart'));
            var option = {

   //你的代码
   title: {
      textStyle: {
         color: "#fff",
         fontSize: 12
      },
   },
   grid: {
      left: 100,
      right: 30,
      bottom: 80,
   },
   tooltip: {
      trigger: "axis",
      axisPointer: {
         type: "line",
      },
      backgroundColor: "rgba(9, 24, 48, 0.5)",
      borderColor: "rgba(75, 253, 238, 0.4)",
      textStyle: {
         color: "#FFF",
      },
   },
   xAxis: {
      type: "category",
      data: ["8:00", "9:00", "10:00", "11:00", "12:00", "13:00"],
      axisLine: {
         lineStyle: {
            color: "rgba(60,132,163,0.4)", // x轴线颜色
         },
      },
      axisTick: {
         show: false, // 是否显示x轴的刻度
      },
      axisLabel: {
         interval: 0,
         color: "#C5E4F9",
         fontSize: 40,
      },

   },
   yAxis: {
      name:'万单',
      nameTextStyle:{
        color: "rgba(127, 181, 217, 1)",
          align: "right",
         fontSize: 40
      },
      type: "value",
      axisTick: {
         show: false,
      },
      axisLine: {
         show: false,
      },
      axisLabel: {
         color: "rgba(127, 181, 217, 1)",
         fontSize: 40,

      },
      splitLine: {
         show: true,
         lineStyle: {
            type: "solid",
            color: "rgba(127, 181, 217, 0.1)",

         },
      },
   },
   series: [
      {
         name: "",
         type: "line",
         smooth: true,
         areaStyle: {
            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
               {
                  offset: 0,
                  color: "rgba(176, 245, 255, 0.5)",
               },
               {
                  offset: 1,
                  color: "rgba(176, 245, 255, 0)",
               },
            ]),
         },
         lineStyle: {
            width: 2,
            color: "rgba(176, 245, 255, 1)",
         },
          label: {
            show: true,
            fontFamily: "monospace",
      fontSize: 40,
      color: "rgba(255, 255, 255, 1)",
      offset: [0, -11]
          },
         // 设置节点样式
         showSymbol: true,
         symbol: 'triangle', // 可以选择 circle, diamond, pin 等
         symbolSize: 24, // 节点大小
         itemStyle: {
            color: "rgba(176, 245, 255, 1)", // 节点颜色
         },
         data: [15, 29, 32, 5, 14, 42]
      },
      {
         name: "",
         type: "bar",
         smooth: true,
         lineStyle: {
            width: 2,
            color: "#146fd7",
         },
         // 设置节点样式
         showSymbol: true,
         symbol: 'circle', // 可以选择 circle, diamond, pin 等
         symbolSize: 10, // 节点大小
         barWidth : 64,
         itemStyle: {
            normal: {
                show: true,
                color: new echarts.graphic.LinearGradient(
                  0,
                  0,
                  0,
                  1,
                  [
                    {
                      offset: 0,
                      color: "rgba(127, 181, 217, 0)",
                    },
                    {
                      offset: 1,
                      color: "rgba(127, 181, 217, 0.15)",
                    },
                  ],
                  false
                ),
                barBorderRadius: 0,
                label: {
                  show: false,
                  position: "top",
                  color: "#56C1F8",
                  formatter: function (p) {
                    return p.value > 0 ? p.value : "";
                  },
                },
              },
         },
         data: [20, 25, 12, 25, 8, 62]
      },
   ]
};


            myChart.setOption(option);
        }
    }
}
</script>

<style lang="scss" scoped></style>
