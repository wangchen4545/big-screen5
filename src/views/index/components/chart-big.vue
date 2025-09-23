<!-- @format -->

<template>
	<div class="big-chart">
		<div class="top">
			<div class="title">
				<el-select
					v-model="titleValue"
					:teleported="false"
					:suffix-icon="'icon-arrow-down'"
				>
					<el-option
						v-for="item in options"
						:key="item.value"
						:label="item.label"
						:value="item.value"
					/>
				</el-select>
			</div>
			<div class="date">
				<el-date-picker
					v-model="dateVale"
					style=" width: 336px;height: 80px;"
					type="date"
					prefix-icon=""
					:teleported="false"
					popper-class="big-screen-chart-date"
				/>
			</div>
		</div>
		<div class="custom">
			<div class="custom-select">
				<div class="custom-1">
					<el-select
						v-model="customValue"
						:teleported="false"
					>
						<el-option
							v-for="item in options"
							:key="item.value"
							:label="item.label"
							:value="item.value"
						/>
					</el-select>
				</div>
				<div class="custom-2">
					<el-select
						v-model="customValue"
						:teleported="false"
					>
						<el-option
							v-for="item in options"
							:key="item.value"
							:label="item.label"
							:value="item.value"
						/>
					</el-select>
				</div>
			</div>
			<!-- 监控 -->
			<div class="listen">
				<img
					src="../img/switch1_off@4x.png"
					alt=""
				/>
			</div>
		</div>
		<div
			class="chart-content"
			ref="wrapper"
		>
			<div
				class="chart-wrap scroll-content"
				ref="chart"
			></div>
			<div
				class="chart-slide custom-horizontal-scrollbar"
				ref="horizontal"
			>
				<img
					src="../img/slider@4x.png"
					alt=""
					class="custom-horizontal-indicator"
				/>
			</div>
		</div>
	</div>
</template>

<script>
import img from '../img/pull_down.svg'
import * as echarts from 'echarts';
import BScroll from 'better-scroll'

export default {
    name: 'ChartO',
    components: {
    },
    data() {
        return {
            titleValue: 'Option1',
            titleSuffix: img,
            dateVale: '2025-09-12',
            customValue:'全国海关',
            options :[
                {
                    value: 'Option1',
                    label: '报关单-预录入-1003报文入库量文本文',
                },
                {
                    value: 'Option2',
                    label: 'Option2',
                },
                {
                    value: 'Option3',
                    label: 'Option3',
                },
                {
                    value: 'Option4',
                    label: 'Option4',
                },
                {
                    value: 'Option5',
                    label: 'Option5',
                },
            ],
            chart: {}
        }
    },
    methods: {
        initChart () {
            this.chart = echarts.init(this.$refs.chart);
            /* let updata= [12.84, 12.38, 13.09, 13.99, 15.51, 16.25, 17.52, 19.25, 20.77, 22.53, 24.24, 23.42, 23.69, 24.93, 27.65, 30.41, 32.33, 32.36, 30.59, 25.25, 27.53, 28.78, 31.26, 32.99, 35.11, 37.02, 36.67] */
            let baseData =[1.2, 1.3, 1.4, 1.5, 1.22, 1.14, 1.25, 1.41, 2.15, 2.88, 4.03, 3.9, 4.51, 5.19, 6.32, 7.45, 8.06, 7.11, 6.81, 3.73, 4.31, 4.45, 4.26, 3.5, 3.74, 4.35, 4.52]
            let date = ['1990', '1991', '1992', "1993", "1994", "1995", "1996", '1997', "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"]
            let date1 = []
            let tenCurrentData = baseData.concat(baseData,baseData,baseData,baseData,baseData,baseData,baseData,baseData,baseData)
            /* 基础数据 */
            let tenBaseData = baseData.concat(baseData,baseData,baseData,baseData,baseData,baseData,baseData,baseData,baseData)

            /* let tenDate = date.concat(date, date, date, date, date, date, date, date, date, date) */
            /* 时间轴数据 */
            for (let i = 0; i < date.length * 10; i++) {
                date1.push(date[0]+i)
            }
            for (let i = 0; i < tenCurrentData.length; i++) {
                tenCurrentData[i] = tenCurrentData[i]+9
            }

            /* 下线 */
            let tenDownData = []
            for (let i = 0; i < date.length * 10; i++) {
                tenDownData.push(tenBaseData[i]-1)
            }
            /* 上线 */
            let tenUpData = []
            for (let i = 0; i < date.length * 10; i++) {
                tenUpData.push(tenCurrentData[i]+tenBaseData[i]+5)
            }
            /* 区间 */
            let tenIntervalData = []
            for (let i = 0; i < date.length * 10; i++) {
                tenIntervalData.push(tenCurrentData[i]-tenDownData[i]+5)
            }
            const option = {
                //当trigger为’item’时只会显示该点的数据，
                //为’axis’时显示该列下所有坐标轴所对应的数据。
                //提示框组件
                tooltip: {
                    //？触发类型
                    trigger: "axis",
                    axisPointer: {
                        type: "cross",
                    },
                },
                legend: {
                    show: true,
                    x: "center",
                    y: "35",
                    icon: "stack",
                    itemWidth: 30,
                    itemHeight: 30,
                    textStyle: {
                         color: "rgba(197, 228, 249, 1)",
                        fontSize: '32px',
                    },
                    data: ["上线", "下线", "区间", "基线", "当天"],
                },
                grid: {
                    left: "0%",
                    right: "3%",
                    top: "20%",
                    bottom: "3%",
                    containLabel: true,
                },
                //工具栏组件
                toolbox: {
                    show: true,
                    feature: {
                        saveAsImage: {}, //是否保存图片
                    },
                },
                xAxis: {
                    type: "category", //X轴均为category，Y轴均为value   //设置为类目轴
                    // boundaryGap: false,  //数值轴两端的空白策略  //类目在分割线上
                    data:date1,
                    axisLabel: {
                        fontSize:36,
                         color:'rgba(197, 228, 249, 0.5)'
                    },
                   splitLine:{
                       show: true,
                       lineStyle: {
                            color: ["rgba(95, 155, 194, 0.2)","rgba(95, 155, 194, 0.2)","rgba(95, 155, 194, 0.2)","rgba(95, 155, 194, 1)"]
                        }
                   }
                },
                yAxis: {
                    type: "value",
                    name: "",
                    axisLabel: {
                        formatter: "{value}",
                        fontSize:36,
                        align: "left",
                        color: 'rgba(197, 228, 249, 0.5)',
                        verticalAlign: "bottom",
                        padding: [0, 0, 6, 0],
                        margin: 0
                    },
                    axisPointer: {
                        snap: true,
                    },
                    splitLine:{
                        show: true,
                        lineStyle: {
                            color: "rgba(95, 155, 194, 0.2)"
                        }
                   }
                },
                // visualMap: {
                //     show: false,
                //     dimension: 0,
                //     pieces: [{
                //         lte: 6,
                //         color: 'green'
                //     }, {
                //         gt: 6,
                //         lte: 8,
                //         color: 'red'
                //     }, {
                //         gt: 8,
                //         lte: 14,
                //         color: 'green'
                //     }, {
                //         gt: 14,
                //         lte: 17,
                //         color: 'red'
                //     }, {
                //         gt: 17,
                //         color: 'green'
                //     }]
                // },
                 // 后续数据更新动画也 8 s
                series: [
                    /* 正常的线 */
                    {
                        name: "上线",
                        type: "line",
                        smooth: false,
                        symbol: "circle",
                        symbolSize: 0,
                        itemStyle: {
                            color: "rgba(95, 155, 194, 1)",
                        },
                        lineStyle: {
                            normal: {
                                type: "dotted",
                                color: "rgba(95, 155, 194, 1)",
                            },
                        },
                        // stack:'总量',
                        "data": tenCurrentData,
                    },

                    {
                        name: "下线",
                        type: "line",
                        stack: "总量",
                        symbol: "circle",
                         "coordinateSystem": "cartesian2d",
                        symbolSize: 0,
                        smooth: false,
                        lineStyle: {
                            normal: {
                                type: "dotted",
                                color: "rgba(95, 155, 194, 1)",
                            },
                        },
                        itemStyle: {
                            color: "rgba(95, 155, 194, 1)",
                        },
                        data: tenDownData,
                    },
                    {
                        name: "区间",
                        type: "line",
                        smooth: false,
                        stack: "总量",
                        symbol: "circle",
                        symbolSize: 0,
                        areaStyle: {
                            normal: {
                                color: "rgba(95, 155, 194, 1)",
                                opacity: 0.1,
                            },
                        },
                        lineStyle: {
                            normal: {
                                type: "dotted",
                                color: "rgba(95, 155, 194, 1)",
                            },
                        },
                        data: tenIntervalData,
                    },

                    {
                        name: "基线",
                        type: "line",
                        symbol: "triangle",
                         "symbolSize": 12,
                        itemStyle: {
                            normal: {
                                color: "rgba(75, 231, 255, 1)",
                                opacity: 1,
                            },
                        },
                         lineStyle: {
                            normal: {
                                width:4
                            },
                        },
                        data: tenBaseData,
                    },
                    /* 效果  */
                    /* {
                        name: "基线",
                        data: [{
                            "coords": tenBaseData.map((item,index) => { return [date1[index], item] }),
                        }],
                        type: "lines",
                        coordinateSystem: "cartesian2d",
                        zlevel: 1,
                        polyline: true,
                        smooth: true,
                        symbol: "circle",
                        effect:{
                            "show": true,
                            "trailLength": 0.1,
                            "symbol": "circle",
                            "period": 1000,
                            "symbolSize": 15
                        },
                        lineStyle: {
                            normal:
                            {
                                color: "rgba(95, 155, 194, 1)",
                                "width": 0,
                                "opacity": 0,
                                "curveness": 0
                            }
                        },
                           animationDuration: 10,          // 初始动画 8 s
  animationDurationUpdate: 0,
                        // stack:'总量',


                    }, */
                    {
                        name: "当天",
                        type: "line",
                        symbol: "circle",
                        symbolSize: 12,
                        itemStyle: {
                            normal: {
                                color: "rgba(255, 165, 134, 1)",
                                opacity: 0.6,
                            },
                        },
                         lineStyle: {
                            normal: {
                                width:4
                            },
                        },
                        data: tenCurrentData,
                    },
                ],
            };
            console.log(option,"option")
            option && this.chart.setOption(option);
        }
    },
    mounted () {
        this.$nextTick(() => {
            /* 获取一屏的宽度 */
            let chartWidth = this.$refs.chart.offsetWidth * 12;
            this.$refs.chart.style.width = chartWidth + 'px';
            console.log(this.$refs.chart, this.chartWidth, " this.$refs.chart.offsetWidth")
            new BScroll(this.$refs.wrapper, {
                scrollX: true,
                click: true,
                mouseWheel: true,
                scrollbar: {
                    customElements: [this.$refs.horizontal],
                    fade: false,
                    interactive: true,
                    scrollbarTrackClickable: true
                }
            })
            this.initChart()
        })
    }
}
</script>

<style lang="scss" scoped>
.big-chart{
    width: 3672px;
    height: 1592px;
    .top{
        display: flex;
        justify-content: space-between;
        margin-left: 24px;
        .title{
            color: #fff;
            font-size: 20px;
            font-weight: 500;
            line-height: 24px;
            margin-left: 20px;
             .el-select__icon::before{
                content: '';
                display: inline-block;
                width: 40px;
                height: 40px;
                background: url('../img/pull_down.svg') center/contain no-repeat;
            }
            .el-select-dropdown__item{
                font-family: jdlangzhengti, jdlangzhengti;
            }
        }
        .date{
            width: 336px;
            height: 80px;
            background: rgba(28,69,99,0.5);
            box-shadow: 0px 8 0px -4px #4BE7FF;
            border-radius: 8px;
        }

    }

    .custom{
        display: flex;
        justify-content: space-between;
        >.custom-select{
            display: flex;
        }
        .custom-1{
            .el-select__placeholder{
                color: #C5E4F9;
            }
            .el-select__wrapper{
                width: 384px;
                height: 80px;
                color: #FFFFFF;
                font-family: PingFangSC, PingFang SC;
                font-weight: 500;
                font-size: 40px;
                color: #C5E4F9;
                line-height: 80px;
                text-align: left;
                font-style: normal;
            }
            .el-select-dropdown__item{
                height: 64px;
                font-size: 40px;
                color: #C5E4F9;
                line-height: 64px;
            }
        }
        .custom-2{
            margin-left: 32px;
             .el-select__placeholder{
                color: #C5E4F9;
            }
            .el-select__wrapper{
                width: 608px;
                height: 80px;
                font-family: PingFangSC, PingFang SC;
                font-weight: 500;
                font-size: 40px;
                color: #C5E4F9;
                line-height: 80px;
                text-align: left;
                font-style: normal;
            }
            .el-select-dropdown__item{
                height: 64px;
                font-size: 40px;
                color: #C5E4F9;
                line-height:64px;
            }
        }
        .listen{
            width:640px;
            height: 112px;
            background: ur('./img/switch1_on@4x.png') no-repeat;
        }
    }
    .chart-content{
        width: 3644px;
        height: 1328px;
        overflow: hidden;
        margin-right: 20px;
        .chart-wrap{
            width: 3664px;
            height: 1250px;
        }
        .chart-slide{
            width: 3600px;
            height: 24px;
            background: #151F28;
            border-radius: 8px;
            position: relative;
            margin-left: 24px;
            margin-right: 24px;
            margin-top: 24px;
            >img{
                position: absolute;
                left: 0;
                top: 0;
                width: 256px;
                height: 16px;
            }
        }
    }

}
</style>
<style lang="scss">
.big-chart{

    .title{
        .el-select__wrapper{
             height: 128px;
            width: 1228px;
        }
          .el-select__icon::before{
                content: '';
                display: inline-block;
                width: 40px;
                height: 40px;
                background: url('../img/pull_down.svg') center/contain no-repeat;
            }
    }
    .custom{
        padding-top: 32px;
        margin-left: 24px;
         .custom-1{
            .el-select__placeholder{
                color: #C5E4F9;
            }
            .el-select__wrapper{
                width: 384px;
                height: 80px;
                color: #FFFFFF;
                font-family: PingFangSC, PingFang SC;
                font-weight: 500;
                font-size: 40px;
                color: #C5E4F9;
                line-height: 40px;
                text-align: left;
                font-style: normal;
                background: rgba(28,69,99,0.5);
                box-shadow: 0px 8px 0px -4px #4BE7FF;
                border-radius: 8px;
            }
            .el-select-dropdown__item{
                height: 64px;
                font-size: 40px;
                color: #C5E4F9;
                line-height:40px;
                margin: 0;

            }
        }
        .custom-2{
            margin-left: 32px;
             .el-select__placeholder{
                color: #C5E4F9;
            }
            .el-select__wrapper{
                width: 608px;
                height: 80px;
                font-family: PingFangSC, PingFang SC;
                font-weight: 500;
                font-size: 40px;
                color: #C5E4F9;
                line-height: 40px;
                text-align: left;
                font-style: normal;
                background: rgba(28,69,99,0.5);
                box-shadow: 0px 8px 0px -4px #4BE7FF;
                border-radius: 8px;
            }
            .el-select-dropdown__item{
                height: 64px;
                font-size: 40px;
                color: #C5E4F9;
                line-height:40px;
            }
        }
    }
    .el-select-dropdown__wrap{
        box-sizing: border-box;
        padding: 10px;

    }
    .el-input__inner{
        background-color: transparent;
        border: none;
        height: 128px;
    }
    .el-input__icon{
      width: 28px;
        height: 28px;
    }
    .el-select .el-input .el-select__caret.el-icon-arrow-up:before {
        content: '';
        display: inline-block;
        width: 28px;
        height: 28px;
        background: url('../img/pull_down.svg') center/contain no-repeat;
    }
    .el-select__wrapper{
        font-family: jdlangzhengti, jdlangzhengti;
        font-weight: normal;
        font-size: 56px;
        color: #FFFFFF;
        line-height: 56px;
        text-align: left;
        font-style: normal;
        background: transparent;
        border: none;
        box-shadow: none;
        &:hover{
             box-shadow: none;
        }
    }
    .el-select__placeholder{
         color: #FFFFFF;
    }
    .el-select__suffix{
        width: 40px;
        height: 40px;
        color: #FFFFFF;
        .el-icon{
            width: 40px;
            height: 40px;
            font-size: 50px;
            color: #FFFFFF;
        }
    }
    .el-select__popper.el-popper{
        background: transparent;
    }
    .el-popper.is-light{
         background: transparent;
        border: none;
        background: rgba(8,16,22,0.9);
        border-radius: 16px;
        border: 4px solid #5E9DBF;
    }
    .el-select-dropdown__item.is-selected{
        color: #FFFFFF;

    }
    .el-select-dropdown__item.is-hovering{
        background-color:rgba(30, 90, 134, 1);
    }
    .el-select-dropdown__item{
        height: 64px;
        font-size: 48px;
        line-height:48px;
        font-weight: 400;
        font-size: 40px;
        color: #C5E4F9;
        line-height: 64px;
        text-align: left;
        font-style: normal;
        border-radius: 8px;
    }
    .el-input__wrapper{
        width: 336px;
        height: 80px;
        background: rgba(28,69,99,0.5);
        box-shadow: none;
        border-radius: 8px;
        width: 256px;
        font-family: PingFangSC, PingFang SC;
        font-weight: 500;
        font-size: 40px;
        line-height: 80px;
        color: #C5E4F9;
        line-height: 40px;
        text-align: right;
        font-style: normal;
    }
    .el-icon .el-input__icon{
        display: none;
    }
    .el-input__prefix-inner>:first-child, .el-input__prefix-inner>:first-child.el-input__icon{
        display: none;
    }
    .el-date-editor--date{
        .el-input__inner{
            font-family: PingFangSC, PingFang SC;
            font-size: 40px;
            color: #C5E4F9;
            font-style: normal;
            text-align: center;
        }
    }
     .el-date-editor{
        box-shadow: 0px 8px 0px -4px #4BE7FF;
        border-radius: 8px;
    }
}
.big_arrow{
    width: 100%;
    height: 100%;
    background: url("../img/pull_down.svg") no-repeat
}
.data{

}
</style>
