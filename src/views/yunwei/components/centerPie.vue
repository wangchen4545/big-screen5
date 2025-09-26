<!-- @format -->

<template>
	<div class="centerPie-box">
		<div
			class="centerPie"
			ref="centerPie"
		></div>
		<div class="centerPie-data">
			<div>
				<div class="centerPie-title">技术支持服务</div>
				<div class="data">
					<div class="centerPie-data-title"><span></span>用户上报</div>
					<div class="centerPie-data-num">2956</div>
				</div>
				<div class="data">
					<div class="centerPie-data-title"><span></span>12360转办</div>
					<div class="centerPie-data-num">2956</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import * as echarts from 'echarts'
export default {
    name: "centerPie",
    data () {
        return {
        }
    },
    mounted () {
        this.initChart()
    },
    beforeUnmount () {
    },
    methods: {
        initChart () {
            var myChart = echarts.init(document.querySelector('.centerPie'))
            // 颜色值配置一个空，用于显示间距
                const colorList1 = ['rgba(50, 108, 226, 1)', '', 'rgba(48, 168, 250, 1)', '','rgba(75, 231, 255, 1)' , '', 'rgba(135, 198, 139, 1)', '','rgba(216, 144, 82, 1)'];
                const colorList2 = ['rgba(50, 108, 226, 0.2)', '', 'rgba(48, 168, 250, 0.2)', '','rgba(75, 231, 255, 0.2)' , '', 'rgba(135, 198, 139, 0.2)', '','rgba(216, 144, 82, 0.2)']
                const colorList3 = ['rgba(165, 241, 255, 1)','','rgba(228, 200, 93, 1)', '' ]
                var data = [
                {
                    "name": "仙桃市乡投农业综合开发有限公司",
                    "value": "1",
                    "total": "0.5"
                },
                {
                    "name": "仙桃市恒泰米业有限公司",
                    "value": "3",
                    "total": "0.2"
                },
                {
                    "name": "仙桃市阳光本农农产品专业合作社",
                    "value": "0.2",
                    "total": "0.2"
                },
                {
                    "name": "仙桃市阳光本农农产品专业合作社",
                    "value": "0.2",
                    "total": "0.2"
                },
                {
                    "name": "仙桃市阳光本农农产品专业合作社",
                    "value": "0.2",
                    "total": "0.2"
                },
                ];
                var data2 = [
                {
                    "name": "仙桃市乡投农业综合开发有限公司",
                    "value": "3",
                    "total": "0.5"
                },
                {
                    "name": "仙桃市恒泰米业有限公司",
                    "value": "1",
                    "total": "0.2"
                },
                ];
                let sum = 0;
                let optionData = []
                let optionData1 = []
                data.forEach(item => {
                sum += Number(item.total);
                })
                data.forEach(item => {
                optionData.push({ value: item.value, name: item.name });
                // 配置一个空值
                optionData.push({ name: '', value: sum / 100, itemStyle: { color: 'transparent' } });
                })
                data2.forEach(item => {
                    optionData1.push({ value: item.value, name: item.name });
                    // 配置一个空值
                    optionData1.push({ name: '', value: sum / 100, itemStyle: { color: 'transparent' } });
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
                    // 饼图圈
                    type: 'pie',
                    zlevel: 3,
                    radius: ['81%', '70%'],
                    center: ['50%', '50%'],
                    itemStyle: {
                        normal: {
                        //  borderColor: '#0A1934',
                        // borderWidth:5,
                        color: function (params) {
                            return colorList2[params.dataIndex]
                        }
                        }
                    },
                    label: {
                        show: false,
                    },
                    data: optionData,
                    },
                    {
                    // 最外圆圈
                    type: 'pie',
                    zlevel: 1,
                    silent: true, //取消高亮
                    radius: ['80%', '81%'] ,
                    center: ['50%', '50%'],
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
                    {
                    // 最内圈
                    type: 'pie',
                    zlevel: 1,
                    silent: true, //取消高亮
                    radius: ['60%', '55%'],
                    center: ['50%', '50%'],
                    itemStyle: {
                        normal: {
                        //  borderColor: '#0A1934',
                        // borderWidth:5,
                        color: function (params) {
                            return colorList3[params.dataIndex]
                        }
                        }
                    },
                    label: {
                        show: false
                    },
                    data: optionData1,
                    },

                ]
                };

         myChart.setOption(option);
        }
    }
}
</script>

<style lang="scss" scoped>
.centerPie {
    height: 100%;
    width: 100%;
}
.centerPie-box{
    position: relative;
    width: 100%;
    height: 100%;
    .centerPie-data{
        position: absolute;
        top: 0;
        left: 0%;
        text-align: center;
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        .centerPie-title{
            height: 80px;
            font-family: jdlangzhengti, jdlangzhengti;
            font-weight: normal;
            font-size: 80px;
            color: #7FB5D9;
            line-height: 80px;
            letter-spacing: 4px;
            text-align: left;
            font-style: normal;
        }
        .data{
            padding-top: 96px;
            .centerPie-data-title{
                height: 44px;
                font-family: PingFangSC, PingFang SC;
                font-weight: 400;
                font-size: 44px;
                color: #7FB5D9;
                line-height: 44px;
                text-align: left;
                font-style: normal;
                text-align: center;
                span{
                    margin-right: 20px;
                    width: 32px;
                    height: 32px;
                    background: #7FB5D9;
                    display: inline-block;
                    transform: rotate(45deg);
                }
            }
            .centerPie-data-num{
                height: 72px;
                font-family: Gotthard;
                font-size: 72px;
                color: #FFFFFF;
                line-height: 72px;
                text-align: center;
                font-style: normal;
                text-align: center;
                padding-top: 16px;

            }
        }
        .data:nth-child(2){
            padding-top: 96px;
            .centerPie-data-title{
                span{
                    background: #E4C85E;
                }
            }

        }
    }
}
</style>
