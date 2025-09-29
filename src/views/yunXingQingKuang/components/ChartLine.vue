<!-- @format -->

<template>
	<div class="min-chart">
		<div class="top">
			<div class="time-box"></div>
			<div class="data-details">
				<div class="details1 details">
					<p class="txt1">故障工单</p>
					<p class="txt2">139</p>
				</div>
				<div class="details2 details">
					<p class="txt1">故障工单</p>
					<p class="txt2">139</p>
				</div>
				<div class="details3 details">
					<p class="txt1">故障工单</p>
					<p class="txt2">139</p>
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
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					color: ['rgba(255, 110, 56, 1)', 'rgba(228, 200, 93, 1)', 'rgba(75, 231, 255, 1)'],
					xAxis: {
						type: 'category',
						boundaryGap: false,
						data: ['24-08', '24-08', '24-10', '24-12', '25-02', '25-04', '25-08']
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
							name: 'Email',
							type: 'line',
							symbol: 'none', // 圆点
							data: [120, 132, 101, 134, 90, 230, 210]
						},
						{
							name: 'Union Ads',
							type: 'line',
							symbol: 'none', // 圆点
							data: [220, 182, 191, 234, 290, 330, 310]
						},
						{
							name: 'Video Ads',
							type: 'line',
							symbol: 'none', // 圆点
							data: [150, 232, 201, 154, 190, 330, 410]
						},
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
						background-color: rgba(255, 110, 56, 1);
					}
				}

				.details2 {
					.txt1::before {
						background-color: rgba(228, 200, 93, 1);
					}
				}

				.details3 {
					.txt1::before {
						background-color: rgba(75, 231, 255, 1);
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
			height: 260px;
		}
	}
</style>
