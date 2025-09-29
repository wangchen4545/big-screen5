<template>
	<div class="min-chart">
		<div class="chart-wrap" ref="chart"></div>
		<div class="data-description">
			<div class="total">
				<p class="txt1">整体处置率</p>
				<p class="txt2">92.2%</p>
			</div>
			<div class="manual">
				<p class="txt1">人工处置率</p>
				<p class="txt2">82.2%</p>
			</div>
		</div>
	</div>
</template>

<script>
	import * as echarts from 'echarts';
	import pieImg from '../img/pie-img.png'
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

				let okRatio = 80
				const option = {
					graphic: {
						elements: [{
							type: "image",
							// z: 6,
							style: {
								image: pieImg,
								width: 120,
								height: 120,
								shadowBlur: 0
							},
							left: "0%",
							top: "-4%"
						}]
					},
					series: [
						// 整体处置率
						{
							type: 'pie',
							radius: ['75%', '68%'],
							center: ['48%', '50%'],
							silent: true,
							clockwise: true,
							startAngle: 90,
							z: 0,
							zlevel: 1,
							label: {
								position: 'center'
							},
							data: [{
									value: okRatio,
									itemStyle: {
										normal: {
											color: {
												type: 'linear',
												x: 0,
												y: 0,
												x2: 1,
												y2: 1,
												colorStops: [{
														offset: 0,
														color: 'rgba(48, 168, 250, 0.50)'
													},
													{
														offset: 1,
														color: 'rgba(48, 168, 250, 1)'
													}
												]
											},

										}
									}
								},
								{
									value: 100 - okRatio,
									name: '',
									label: {
										show: false
									},
									itemStyle: {
										color: 'rgba(38, 62, 84, 0.4)'
									}
								}
							]
						},
						// 人工处置率
						{
							type: 'pie',
							radius: ['91%', '83%'],
							center: ['48%', '50%'],
							silent: true,
							clockwise: true,
							startAngle: 90,
							z: 0,
							zlevel: 1,
							label: {
								position: 'center'
							},
							data: [{
									value: okRatio,
									itemStyle: {
										normal: {
											color: {
												type: 'linear',
												x: 0,
												y: 0,
												x2: 1,
												y2: 1,
												colorStops: [{
														offset: 0,
														color: 'rgba(228, 200, 93, 0.50)'
													},
													{
														offset: 1,
														color: 'rgba(228, 200, 93, 1)'
													}
												]
											},

										}
									}
								},
								{
									value: 100 - okRatio,
									name: '',
									label: {
										show: false
									},
									itemStyle: {
										color: 'rgba(38, 62, 84, 0.4)'
									}
								}
							]
						},
					]
				}
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
		height: 166px;
		margin-top: 16px;
		display: flex;
		.chart-wrap {
			width: 120px;
			height: 120px;
		}
		.data-description{
			width: calc(100% - 130px);
			height: 120px;
			display: flex;
			align-items: center;
			.total,
			.manual{
				.txt1{
					font-family: PingFangSC, PingFang SC;
					font-weight: 400;
					font-size: 16px;
					color: #C5E4F9;
					&::before{
						content: '';
						display: inline-block;
						width: 12px;
						height: 12px;
						border-radius: 12px;
						margin-right: 5px;
					}
				}
				.txt2{
					font-family: Gotthard;
					font-size: 28px;
					color: #FFFFFF;
					line-height: 28px;
					margin-left: 40px;
					margin-top: 15px;
				}
			}
			.total{
				.txt1{
					&::before{
						background: #30A8FA;
					}
				}
			}
			.manual{
				.txt1{
					&::before{
						background: #E4C85D;
					}
				}
			}
		}
	}
</style>
