<!-- @format -->
<template>
	<div class="yxqk-box">
		<div class="box-title">
			<!-- 更新数据 -->
			<div class="updata">
				<span class="updata-s1">数据更新</span>
				<span class="updata-s2">2025-08-25</span>
			</div>
			<!-- title -->
			<div class="title-text">运行情况分析评测</div>
			<!-- 时间 -->
			<div class="time">
				<span class="icon"></span>
				<span class="time-s1">2025-08-25</span>
				<span class="time-s2">14:14:30</span>
			</div>
		</div>
		<!-- 内容区 -->
		<div class="yxqk-content">
			<div class="left">
				<div class="title">
					<div class="txt1">网络可用率</div>
					<div class="txt2">详情 <i class="el-icon-arrow-right"></i> </div>
				</div>
				<div class="content-one">
					<el-row :gutter="20">
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/xxzx.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">95.6%</p>
									<p class="txt2">至信息中心</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/xxzx.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">99.6%</p>
									<p class="txt2">至广东分中心</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/zdcs.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">91</p>
									<p class="txt2">中断次数</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/zdsc.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">95H</p>
									<p class="txt2">终端时长</p>
								</div>
							</div>
						</el-col>
					</el-row>
				</div>
				<div class="title">
					<div class="txt1">总体运维故障统计</div>
				</div>
				<div class="content-two">
					<el-row :gutter="20">
						<el-col :span="12">
							<div class="data-details">
								<div class="data-description">
									<div class="txt1">95</div>
									<p class="txt2">三级及以上故障</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-description">
									<div class="txt1">
										9H
										<span>环比</span>
										<span></span>
										<span>6.3%</span>
									</div>
									<p class="txt2">三级及以上总时长</p>
								</div>
							</div>
						</el-col>
					</el-row>
				</div>
				<div class="title">
					<div class="txt1">总体运维工单情况</div>
					<div class="txt2">详情 <i class="el-icon-arrow-right"></i> </div>
				</div>
				<div class="content-three">
					<chart-line></chart-line>
				</div>
			</div>
			<!-- <div class="center"></div> -->
			<div class="right">
				<div class="title">
					<div class="txt1">本月告警处理情况</div>
					<div class="txt2">详情 <i class="el-icon-arrow-right"></i> </div>
				</div>
				<div class="content-one">
					<el-row :gutter="20">
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/zgjl.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">95</p>
									<p class="txt2">总告警量</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/zdhf.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">99</p>
									<p class="txt2">自动回复</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/xrg.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">91</p>
									<p class="txt2">需人工处置</p>
								</div>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="data-details">
								<div class="data-icon">
									<img src="./img/rg.png" alt="">
								</div>
								<div class="data-description">
									<p class="txt1">95H</p>
									<p class="txt2">人工处置</p>
								</div>
							</div>
						</el-col>
					</el-row>
				</div>
				<div class="title">
					<div class="txt1">本月告警处置率</div>
					<div class="txt2">详情 <i class="el-icon-arrow-right"></i> </div>
				</div>
				<div class="content-two">
					<chart-pie></chart-pie>
				</div>
				<div class="title">
					<div class="txt1">总体快速通报应答情况</div>
					<div class="txt2">详情 <i class="el-icon-arrow-right"></i> </div>
				</div>
				<div class="content-three">
					<Chart-bar></Chart-bar>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import ChartLine from './components/ChartLine.vue';
	import ChartPie from './components/ChartPie.vue';
	import ChartBar from './components/ChartBar.vue';
	export default {
		name: 'yunXingQingKuang',
		components:{
			ChartLine,
			ChartPie,
			ChartBar
		},
		data() {
			return {
				dateVale: '2025-09-12',
			}
		},
		methods: {
			pad(n) {
				return n < 10 ? '0' + n : n
			},
			tick() {
				const d = new Date()
				const yyyy = d.getFullYear()
				const mm = this.pad(d.getMonth() + 1)
				const dd = this.pad(d.getDate())
				const HH = this.pad(d.getHours())
				const MM = this.pad(d.getMinutes())
				const SS = this.pad(d.getSeconds())
				this.nowY =
					`${yyyy}-${mm}-${dd} `

				this.nowM = `${HH}:${MM}:${SS}`
			},
		},
		mounted() {
			this.tick() // 先执行一次
			this.timer = setInterval(this.tick, 1000)
		},
		beforeUnmount() {
			clearInterval(this.timer)
		},

	}
</script>
<style lang="scss" scoped>
	@import './index.scss';
</style>
