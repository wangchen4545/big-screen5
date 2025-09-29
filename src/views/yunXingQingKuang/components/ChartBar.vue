<!-- @format -->

<template>
	<div class="min-chart">
		<div class="top">
			<div class="time-box"></div>
			<div class="data-details">
				<div class="details1 details">
					<p class="txt1">通报量</p>
					<p class="txt2">139</p>
				</div>
				<div class="details2 details">
					<p class="txt1">及时回复</p>
					<p class="txt2">139</p>
				</div>
				<div class="details3 details">
					<p class="txt1">及时回复率</p>
					<p class="txt2">19%</p>
				</div>
			</div>
		</div>
		<div class="chart-wrap" ref="chart"></div>
	</div>
</template>

<script>
	import * as echarts from 'echarts';
	export default {
		name: 'ChartLine',
		data() {
			return {
				chart: {},
			}
		},
		methods: {
			initChart() {
				this.chart = echarts.init(this.$refs.chart);
				const option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'shadow'
						}
					},
					xAxis: {
						type: 'category',
						data: ['24-08', '24-09', '24-10', '24-11', '24-12', '25-01', '25-02', '25-03', '25-04', '25-05', '25-06', '25-07', '25-08']
					},
					yAxis: {
						type: 'value',
						splitLine: {
							lineStyle: {
								type: "solid",
								color: "rgba(127, 181, 217, 0.1)",
							},
						},
					},
					series: [{
							type: 'bar',
							stack: 'all', // 关键：堆叠
							barWidth: 10,
							data: [120,100, 132, 101, 134, 90,189, 132, 101, 134,196, 90],
							itemStyle: {
								borderRadius: [2, 2, 0, 0], // 左上、右上 2px 圆角
								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: 'rgba(127, 181, 217, 0.5)'
									},
									{
										offset: 1,
										color: 'rgba(127, 181, 217, 1)'
									}
								])
							}
						},
						{
							type: 'bar',
							stack: 'all', // 同一堆叠名
							barWidth: 10,
							data: [220, 182,285, 191, 234, 290,197,220, 182, 191, 234, 290,180],
							itemStyle: {
								borderRadius: [2, 2, 0, 0],
								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: 'rgba(75, 231, 255, 0.5)'
									},
									{
										offset: 1,
										color: 'rgba(75, 231, 255, 1)'
									}
								])
							}
						}
					]
				};
				console.log(option, "option")
				option && this.chart.setOption(option);
			}
		},
		mounted() {
			this.$nextTick(() => {
				this.initChart()
			})
		}
	}
</script>

<style lang="scss" scoped>
	* {
		margin: 0;
	}

	.min-chart {
		width: 100%;
		height: 266px;
		margin-top: 16px;

		.top {
			width: 456px;
			height: 88px;
			background: linear-gradient(180deg, rgba(96, 130, 163, 0.2) 0%, rgba(37, 50, 62, 0.2) 100%);
			border-radius: 6px;
			padding: 4px;
			box-sizing: border-box;
			display: flex;

			.time-box {
				width: 51px;
				height: 22px;
				background-color: red;
			}

			.data-details {
				width: calc(100% - 55px);
				margin-left: 5px;
				height: 50px;
				margin-top: 10px;
				display: flex;
				justify-content: space-around;

				.details {
					.txt1 {
						font-family: PingFangSC, PingFang SC;
						font-weight: 400;
						font-size: 16px;
						color: #C5E4F9;
						&::before {
							content: '';
							display: inline-block;
							width: 12px;
							height: 12px;
							margin-right: 8px;
							transform: rotate(45deg);
						}
					}
				}

				.details1 {
					.txt1::before {
						background: linear-gradient( 135deg, #7FB5D9 0%, rgba(127,181,217,0.5) 100%)
					}
				}

				.details2 {
					.txt1::before {
						background: linear-gradient( 135deg, #4BE7FF 0%, rgba(75,231,255,0.5) 100%);
					}
				}
				.txt2 {
					font-family: Gotthard;
					font-size: 24px;
					color: #FFFFFF;
					margin: 7px 0 0 15px;
				}
			}
		}

		.chart-wrap {
			width: 100%;
			height: 310px;
		}
	}
</style>
