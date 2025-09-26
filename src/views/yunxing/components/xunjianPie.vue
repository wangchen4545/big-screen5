<!-- @format -->

<template>
	<div class="xunjianPie-box">
		<div
			class="xunjianPie"
			ref="xunjianPiec"
		></div>
		<div class="xunjianPie-anim">
			<img
				src="../img/anim-img.png"
				alt=""
			/>
		</div>
	</div>
</template>

<script>
import * as echarts from "echarts";
export default {
    name: "xunjianPie",
    data() {
        return {
            myChart: null,
        }
    },
    methods : {
        init() {
            this.myChart = echarts.init(document.querySelector('.xunjianPie'));

// 颜色值配置一个空，用于显示间距
    const colorList1 = ['#729CDD', '', '#E4C85D', '', '#87C68B', '',];
    var data = [
      {
        "name": "仙桃市乡投农业综合开发有限公司",
        "value": "0.5",
        "total": "0.5"
      },
      {
        "name": "仙桃市恒泰米业有限公司",
        "value": "0.2",
        "total": "0.2"
      },
      {
        "name": "仙桃市阳光本农农产品专业合作社",
        "value": "0.2",
        "total": "0.2"
      },
    ];
    let sum = 0;
    let optionData = []
    data.forEach(item => {
      sum += Number(item.total);
    })
    data.forEach(item => {
      optionData.push({ value: item.value, name: item.name });
      // 配置一个空值
      optionData.push({ name: '', value: sum / 100, itemStyle: { color: 'transparent' } });
    })

    var option= {
      tooltip: {
        trigger: 'item',
      },
      legend: {
        show:false,
      },

      series: [
        {
          // 最外圆圈
          type: 'pie',
          zlevel: 1,
          silent: true, //取消高亮
          radius: ['70%', '65%'],
          center: ['50%%', '39%'],
          itemStyle: {
            normal: {
              //  borderColor: '#0A1934',
              // borderWidth:5,
              color: function (params) {
                return colorList1[params.dataIndex]
              }
            }
          },
          label: {
            show: false
          },
          data: optionData,
        },

      ]
    };


            this.myChart.setOption(option)
        }
    },

    mounted() {
         this.init()
    },
}
</script>

<style lang="scss" scoped>
.xunjianPie-box{
  position: relative;
  width: 100%;
  height: 100%;
}
.xunjianPie{
    width: 100%;
    height: 100%;
}
.xunjianPie-anim{
  width: 256px;
  height: 256px;
  position: absolute;
  left: 50%;
  top: 50%;
  margin: -220px 0 0 -128px;
  transform: rotate(360deg);
  animation: xunjianPie-anim 2s linear infinite;
}
@keyframes xunjianPie-anim {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
