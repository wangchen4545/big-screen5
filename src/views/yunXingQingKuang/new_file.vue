<template>
</template>

<script>
	var mapName = 'china';
	var data = [{
	   name: '北京',
	   value: 5
	},
	{
	   name: '天津',
	   value: 14
	},
	{
	   name: '河北',
	   value: 157
	},
	{
	   name: '山西',
	   value: 110
	},
	{
	   name: '内蒙古',
	   value: 40
	},
	{
	   name: '辽宁',
	   value: 40
	},
	{
	   name: '吉林',
	   value: 40
	},
	{
	   name: '黑龙江',
	   value: 60
	},
	{
	   name: '上海',
	   value: 10
	},
	{
	   name: '江苏',
	   value: 60
	},
	{
	   name: '浙江',
	   value: 50
	},
	{
	   name: '安徽',
	   value: 151
	},
	{
	   name: '福建',
	   value: 60
	},
	{
	   name: '江西',
	   value: 74
	},
	{
	   name: '山东',
	   value: 200
	},
	{
	   name: '河南',
	   value: 100
	},
	{
	   name: '湖北',
	   value: 40
	},
	{
	   name: '湖南',
	   value: 50
	},
	{
	   name: '重庆',
	   value: 40
	},
	{
	   name: '四川',
	   value: 120
	},
	{
	   name: '贵州',
	   value: 135
	},
	{
	   name: '云南',
	   value: 90
	},
	{
	   name: '西藏',
	   value: 25
	},
	{
	   name: '陕西',
	   value: 100
	},
	{
	   name: '甘肃',
	   value: 60
	},
	{
	   name: '青海',
	   value: 20
	},
	{
	   name: '宁夏',
	   value: 110
	},
	{
	   name: '新疆',
	   value: 32
	},
	{
	   name: '广东',
	   value: 10
	},
	{
	   name: '广西',
	   value: 100
	},
	{
	   name: '海南',
	   value: 40
	},
	];
	var geoCoordMap = {
	   '北京': [116.4551, 40.2539],
	   '黑龙江': [127.9688, 45.368],
	   '内蒙古': [110.3467, 41.4899],
	   "吉林": [125.8154, 44.2584],
	   "辽宁": [123.1238, 42.1216],
	   "河北": [114.4995, 38.1006],
	   "天津": [117.4219, 39.4189],
	   "山西": [112.3352, 37.9413],
	   "陕西": [109.1162, 34.2004],
	   "甘肃": [103.5901, 36.3043],
	   "宁夏": [106.3586, 38.1775],
	   "青海": [101.4038, 36.8207],
	   "新疆": [87.611053, 43.828171],
	   "西藏": [91.117212, 29.646922],
	   "四川": [103.9526, 30.7617],
	   "重庆": [108.384366, 30.439702],
	   "山东": [117.1582, 36.8701],
	   "河南": [113.4668, 34.6234],
	   "江苏": [118.8062, 31.9208],
	   "安徽": [117.29, 32.0581],
	   "湖北": [114.3896, 30.6628],
	   "浙江": [119.5313, 29.8773],
	   "福建": [119.4543, 25.9222],
	   "江西": [116.0046, 28.6633],
	   "湖南": [113.0823, 28.2568],
	   "贵州": [106.6992, 26.7682],
	   "云南": [102.9199, 25.4663],
	   "广东": [113.12244, 23.009505],
	   "广西": [108.479, 23.1152],
	   "海南": [110.3893, 19.8516],
	   "台湾": [120.702967, 24.123621],
	   '上海': [121.4648, 31.2891]
	};
	
	// 将省份名称转换为数组以便循环
	var provinces = Object.keys(geoCoordMap);
	var currentIndex = 0;
	
	// 转换坐标数据为ECharts需要的格式
	var scatterData = [];
	for (var name in geoCoordMap) {
	   scatterData.push({
	      name: name,
	      value: geoCoordMap[name].concat([Math.random() * 100 + 100]), // 添加随机值用于显示
	      symbolSize: 8,
	      itemStyle: {
	         color: '#fff'
	      }
	   });
	}
	
	// 获取地图数据并注册
	fetch('https://www.isqqw.com/asset/get/areas_v3/country/china.json')
	   .then(response => response.json())
	   .then(chinaJson => {
	      echarts.registerMap(mapName, chinaJson);
	
	      // 初始化图表
	      initChart();
	   })
	   .catch(error => {
	      console.error('加载地图数据失败:', error);
	   });
	
	function initChart() {
	   option = {
	      backgroundColor: "#003366",
	      title: {
	         show: true,
	         text: "项目分布图123",
	         x: 'center',
	         top: "10",
	         textStyle: {
	            color: "#fff",
	            fontFamily: "等线",
	            fontSize: 18,
	         },
	      },
	      tooltip: {
	         trigger: 'item',
	         position: function (point, params, dom, rect, size) {
	            var x = 0; // x坐标位置
	            var y = 0; // y坐标位置
	            // 当前鼠标位置
	            var pointX = point[0];
	            var pointY = point[1];
	            // 提示框大小
	            var boxWidth = size.contentSize[0];
	            var boxHeight = size.contentSize[1];
	
	            // boxWidth > pointX 说明鼠标左边放不下提示框
	            if (boxWidth > pointX) {
	               x = pointX + 10;
	            } else { // 左边放的下
	               x = pointX - boxWidth - 10;
	            }
	
	            // boxHeight > pointY 说明鼠标上边放不下提示框
	            if (boxHeight > pointY) {
	               y = 5;
	            } else { // 上边放得下
	               y = pointY - boxHeight;
	            }
	            return [x, y];
	         },
	         show: true,
	         enterable: true,
	         textStyle: {
	            fontSize: 13,
	            color: '#fff',
	         },
	         backgroundColor: 'rgba(0,2,89,0.8)',
	         formatter: function (params) {
	            return `
	                         <div class="ui-map-img">
	                            <div class='ui-maptxt'>${params.name}</div>
	                                 <div class="video-container">
	                                    147
	                                 </div>
	                           </div>
	                        `;
	         }
	      },
	      geo: [{
	         layoutCenter: ['50%', '50%'], //位置
	         layoutSize: '180%', //大小
	         show: true,
	         map: mapName,
	         roam: false,
	         zoom: 0.65,
	         aspectScale: 1,
	         label: {
	            normal: {
	               show: false,
	               textStyle: {
	                  color: '#fff'
	               }
	            },
	            emphasis: {
	               show: false,
	               textStyle: {
	                  color: '#fff'
	               }
	            }
	         },
	      }, 
	      {
	         type: "map",
	         map: mapName,
	         zlevel: -1,
	         aspectScale: 1,
	         zoom: 0.65,
	         layoutCenter: ["50%", "51%"],
	         layoutSize: "180%",
	         roam: false,
	         silent: true,
	         itemStyle: {
	            normal: {
	               borderWidth: 1,
	               // borderColor:"rgba(17, 149, 216,0.6)",
	               borderColor: "rgba(58,149,253,0.8)",
	               shadowColor: "rgba(172, 122, 255,0.5)",
	               shadowOffsetY: 5,
	               shadowBlur: 15,
	               areaColor: "rgba(5,21,35,0.1)",
	            },
	         },
	      }, 
	      {
	         type: "map",
	         map: mapName,
	         zlevel: -2,
	         aspectScale: 1,
	         zoom: 0.65,
	         layoutCenter: ["50%", "52%"],
	         layoutSize: "180%",
	         roam: false,
	         silent: true,
	         itemStyle: {
	            normal: {
	               borderWidth: 1,
	               // borderColor: "rgba(57, 132, 188,0.4)",
	               borderColor: "rgba(58,149,253,0.6)",
	               shadowColor: "rgba(65, 214, 255,1)",
	               shadowOffsetY: 5,
	               shadowBlur: 15,
	               areaColor: "transpercent",
	            },
	         },
	      }
	      ],
	      series: [
	         {
	            type: 'map',
	            map: mapName,
	            geoIndex: 0,
	            aspectScale: 1, //长宽比
	            zoom: 0.65,
	            showLegendSymbol: true,
	            roam: true,
	            label: {
	               normal: {
	                  show: true,
	                  textStyle: {
	                     color: "#fff",
	                     fontSize: "120%"
	                  },
	               },
	               emphasis: {
	                  show: false,
	               },
	            },
	            itemStyle: {
	               normal: {
	                  areaColor: {
	                     type: "linear",
	                     x: 1200,
	                     y: 0,
	                     x2: 0,
	                     y2: 0,
	                     colorStops: [{
	                        offset: 0,
	                        color: "red", // 0% 处的颜色
	                     }, {
	                        offset: 1,
	                        color: "yellow", // 50% 处的颜色
	                     },],
	                     global: true, // 缺省为 false
	                  },
	                  borderColor: "#fff",
	                  borderWidth: 0.2,
	               },
	            },
	            layoutCenter: ["50%", "50%"],
	            layoutSize: "180%",
	            animation: false,
	            markPoint: {
	               symbol: "none"
	            },
	            data: data,
	         },
	         {
	            name: '坐标点',
	            type: 'effectScatter',
	            coordinateSystem: 'geo',
	            data: scatterData,
	            symbolSize: function (val) {
	               return val[2] / 10; // 根据第三个值调整大小
	            },
	            showEffectOn: 'render',
	            rippleEffect: {
	               brushType: 'stroke'
	            },
	            hoverAnimation: true,
	            label: {
	               show: false
	            },
	            zlevel: 1
	         }
	      ],
	   };
	
	   // 使用配置项显示图表
	   myChart.setOption(option);
	   // 添加点击事件
	   myChart.on('click', function (params) {
	      console.log("这是点击部位的参数", params);
	      // if (params.componentType === 'series' && params.seriesType === 'effectScatter') {
	      // 	alert(`您点击了: ${params.name}\n坐标: [${params.value[0].toFixed(2)}, ${params.value[1].toFixed(2)}]`);
	      // }
	      if (params.name) {
	         console.log("这是点击部位的参数", geoCoordMap[params.name]);
	      }
	   });
	}

</script>

<style>
</style>
