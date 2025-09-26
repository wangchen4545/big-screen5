<!-- @format -->

<template>
	<div class="ywfw-box">
		<div class="box-title">
			<!-- 更新数据 -->
			<div class="updata">
				<span class="updata-s1">数据更新</span>
				<span class="updata-s2">2025-08-25</span>
			</div>
			<!-- title -->
			<div class="title-text">深圳海关运维服务情况</div>
			<!-- 时间 -->
			<div class="time">
				<span class="icon"></span>
				<span class="time-s1">2025-08-25</span>
				<span class="time-s2">14:14:30</span>
			</div>
		</div>
		<div class="box-content">
			<!-- 运维故障统计 -->
			<div class="fault-statistics">
				<div class="top">
					<div class="title">
						运维故障统计
					</div>
					<div class="date">
						<el-date-picker 
							v-model="dateVale" 
							style=" width: 210px;height: 105px;" 
							type="year" prefix-icon="" 
							:teleported="false"
							popper-class="big-screen-chart-date"
						/>
					</div>
				</div>
				<div class="distribution-title">
					故障级别分布
				</div>
				<el-row class="total-failure">
					<el-col :span="3">
						<div class="left">
							<p class="txt1">总故障</p>
							<p class="txt2">{{failureTotal}}</p>
						</div>
					</el-col>
					<el-col :span="21">
						<div class="right">
							<!-- 色块 -->
							<el-row :gutter="6">
								<el-col :span="6">
									<div class="scale scale1"></div>
								</el-col>
								<el-col :span="6">
									<div class="scale scale2"></div>
								</el-col>
								<el-col :span="6">
									<div class="scale scale3"></div>
								</el-col>
								<el-col :span="6">
									<div class="scale scale4"></div>
								</el-col>
							</el-row>
							<!-- 文字描述 -->
							<el-row :gutter="6">
								<el-col :span="6">
									<div class="describe">
										<div class="legend legend1"></div>
										<span class="txt1">二级故障</span>
										<span class="txt2">2</span>
									</div>
								</el-col>
								<el-col :span="6">
									<div class="describe">
										<div class="legend legend2"></div>
										<span class="txt1">三级故障</span>
										<span class="txt2">2</span>
									</div>
								</el-col>
								<el-col :span="6">
									<div class="describe">
										<div class="legend legend3"></div>
										<span class="txt1">四级故障</span>
										<span class="txt2">2</span>
									</div>
								</el-col>
								<el-col :span="6">
									<div class="describe">
										<div class="legend legend4"></div>
										<span class="txt1">五级故障</span>
										<span class="txt2">2</span>
									</div>
								</el-col>
							</el-row>
						</div>
					</el-col>
				</el-row>
				<div class="fault">
					<div class="failt-title">
						共 <span class="failt-total">13</span>个中高级调度故障
					</div>
					<div class="failt-list">
						<el-collapse v-model="failtListAction" accordion @change="failtListChange">
							<el-collapse-item v-for="(item,index) in failtListActionList" :key="index" :name="index">
								<template #title>
									<div class="title">
										<div class="status">
											<span v-if="item.status == 0" class="status-txt">已完成</span>
											<span v-else class="status-txt">处理中</span>
											<div v-if="item.status == 0" class="complete"></div>
											<LottieAnimation v-else :animation-data="tagLoading" :width="300" :height="90" />
										</div>
										<div class="title1">{{item.level}}</div>
										<div class="title2">{{item.instructions}}</div>
									</div>
								</template>
								<el-row>
									<el-col :span="12">
										<span class="txt1">发现时间</span>
										<span class="txt2">{{item.discoverytime}}</span>
									</el-col>
									<el-col :span="12">
										<span class="txt1">调度级别</span>
										<span class="txt2">{{item.dispatchLecel}}</span>
									</el-col>
									<el-col :span="12">
										<span class="txt1">完成时间</span>
										<span class="txt2">{{item.completionTime}}</span>
									</el-col>
									<el-col :span="12">
										<span class="txt1">当前处理人</span>
										<span class="txt2">{{item.userName}}</span>
									</el-col>
									<el-col :span="24">
										<p class="txt1">故障详情</p>
										<span class="txt2">{{item.details}}</span>
									</el-col>
								</el-row>
							</el-collapse-item>
						</el-collapse>
					</div>
				</div>
			</div>
			<!-- 审单情况 -->
			<div class="document-review">
				<p class="document-review-title">审单情况</p>
				<el-table :data="documentReviewData" center stripe header-align="center" style="width: 100%;">
					<el-table-column prop="time" label="时间" align="center"></el-table-column>
					<el-table-column prop="num" label="审单量" align="center"></el-table-column>
				</el-table>
			</div>
			<!-- 当前受影响系统 -->
			<div class="system">
				<div class="system-num">
					<p class="txt1">当前受影响系统</p>
					<p class="txt2">123</p>
				</div>
				<div class="system-rotation"></div>
				<LottieAnimation :animation-data="troubleFree" class="system-loading" :width="1300" :height="500" />
				<!-- <div class="system-list-box">
					<div style="position: relative;width: 1400px;height: 1400px;" ref="circleContainer">
						<div class="system-list" 
							v-for="(item,index) in dots" :key="index" :style="item.style">
							<div class="system-list-img">{{item.num}}</div>
							<div class="txt1">{{item.name}}</div>
						</div>
					</div>
				</div> -->
			</div>
			<!-- 放行情况 -->
			<div class="release-review">
				<p class="release-review-title">放行情况</p>
				<el-table :data="releaseReviewData" center stripe header-align="center" style="width: 100%;">
					<el-table-column prop="time" label="时间" align="center"></el-table-column>
					<el-table-column prop="num" label="放行量" align="center"></el-table-column>
				</el-table>
			</div>
			<!-- 实施变更  未回复告警 -->
			<div class="notice">
				<!-- 实施变更 -->
				<div class="implement-changes">
					<div class="implement-changes-title">
						<span class="txt1">实施变更</span>
						<span class="txt2">IMPLEMENTATION DETAILS OF CHANGES</span>
					</div>
					<div class="implement-changes-box">
						<div class="implement-changes-list" v-for="(item,index) in implementChangesList" :key="index">
							<div class="list-img"></div>
							<div class="list-txt">{{item.txt}}</div>
							<div class="list-time">{{item.time}}</div>
						</div>
					</div>
				</div>
				<!-- 未回复告警 -->
				<div class="unresolved-alarm">
					<div class="unresolved-alarm-title">
						<span class="txt1">未回复告警</span>
						<span class="txt2">UNRESOLVED ALARMS</span>
					</div>
					<div class="unresolved-alarm-box">
						<div class="unresolved-alarm-list" v-for="(item,index) in unresolvedAlarmList" :key="index">
							<div class="list-img"></div>
							<div class="list-txt">{{item.txt}}</div>
							<div class="list-time">{{item.time}}</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</template>

<script>
	import LottieAnimation from './components/LottieAnimation.vue'
	import tagLoading from './img/tag_loading.json'
	import troubleFree from './img/trouble-free.json'
	export default {
		name: 'ywfwBox',
		components: { LottieAnimation },
		data() {
			return {
				dateVale: '2025-09-12',
				failureTotal: '500',
				// 故障等级及数据
				failureList:[
					{name:'二级故障',num: '180' },
					{name:'三级故障',num: '20' },
					{name:'四级故障',num: '80' },
					{name:'五级故障',num: '220' },
				],
				failtListAction: '1',
				// 运维故障数据
				failtListActionList:[
					{
						status:'1',
						level:'三级故障',
						instructions:'UC同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常',
						discoveryTime:'2025-10-02 12:30',
						completionTime:'2025-10-04 12:30',
						userName:'张三',
						dispatchLecel:'中级调度',
						details:'故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述'
					},
					{
						status:'0',
						level:'四级故障',
						instructions:'UC同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常',
						discoveryTime:'2025-10-02 12:30',
						completionTime:'2025-10-04 12:30',
						userName:'李四',
						dispatchLecel:'中级调度',
						details:'故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述'
					},
					{
						status:'0',
						level:'五级故障',
						instructions:'UC同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常',
						discoveryTime:'2025-10-02 12:30',
						completionTime:'2025-10-04 12:30',
						userName:'张三',
						dispatchLecel:'低级调度',
						details:'故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述'
					},
					{
						status:'1',
						level:'三级故障',
						instructions:'UC同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常',
						discoveryTime:'2025-10-02 12:30',
						completionTime:'2025-10-04 12:30',
						userName:'张三',
						dispatchLecel:'中级调度',
						details:'故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述'
					},
					{
						status:'0',
						level:'三级故障',
						instructions:'UC同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常同意通信平台网站异常',
						discoveryTime:'2025-10-02 12:30',
						completionTime:'2025-10-04 12:30',
						userName:'王五',
						dispatchLecel:'中级调度',
						details:'故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述故障描述'
					}
				],
				// 审单情况
				documentReviewData:[ 
					{time: '15:40', num:'195'},
					{time: '15:39', num:'195'},
					{time: '15:38', num:'195'},
					{time: '15:37', num:'195'},
					{time: '15:36', num:'195'},
					{time: '15:35', num:'195'},
					{time: '15:34', num:'195'},
					{time: '15:33', num:'195'},
					{time: '15:32', num:'195'},
					{time: '15:31', num:'195'},
					{time: '15:30', num:'195'},
				],
				// 放行情况数据
				releaseReviewData:[
					{time: '15:40', num:'195'},
					{time: '15:39', num:'195'},
					{time: '15:38', num:'195'},
					{time: '15:37', num:'195'},
					{time: '15:36', num:'195'},
					{time: '15:35', num:'195'},
					{time: '15:34', num:'195'},
					{time: '15:33', num:'195'},
					{time: '15:32', num:'195'},
					{time: '15:31', num:'195'},
					{time: '15:30', num:'195'},
				],
				//实施变更数据
				implementChangesList:[
					{
						txt:'阿萨德嘎是的机会手打收到阿斯兰党课课件卡洛斯的',
						time:'10:45'
					},
					{
						txt:'雷电接口规范角度来看的方法的后果',
						time:'9:49'
					},
					{
						txt:'b.mnnkjdghfdh对方会给is如何',
						time:'7:05'
					},
					{
						txt:'可接待沙发款式都认同；浪费国家法规',
						time:'6:40'
					},
				],
				// 未恢复告警数据
				unresolvedAlarmList:[
					{
						txt:'阿萨德嘎是的机会手打收到阿斯兰党课课件卡洛斯的',
						time:'10:45'
					},
					{
						txt:'雷电接口规范角度来看的方法的后果',
						time:'9:49'
					},
					{
						txt:'b.mnnkjdghfdh对方会给is如何',
						time:'7:05'
					},
					{
						txt:'可接待沙发款式都认同；浪费国家法规',
						time:'6:40'
					},
				],
				// 受影响系统
				systemList:[
					{ name: '风控规则引擎', num: '12' },
					{ name: 'H2010通关系统', num: '102' },
					{ name: '税控系统', num: '12' },
					{ name: '风控系统微服务', num: '12' },
					{ name: '风控规则引擎', num: '12' },
					{ name: '风控规则引擎', num: '12' },
					{ name: '风控规则引擎', num: '12' },
				],
				dots: [],
				dotSize: 200, // 点的大小
				minDistance: 250, // 点之间的最小距离
				maxRetries: 50, // 尝试生成位置的最大次数
				tagLoading,
				troubleFree,
			}
		},
		methods: {
			changeLight(value, index) {
				let valueNum = parseInt(value)
				if (valueNum != 0) {
					this.light = 1 - valueNum / 100
				} else {
					this.light = 1
				}
				this.lightIndex = index
			},
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
			// 故障列表
			failtListChange () {
				console.log('123');
			},
			/**
			 * 检查新点是否与已有点重叠
			 */
			isOverlapping(newX, newY) {
				for (const dot of this.dots) {
					const existingX = parseFloat(dot.style.left) + this.dotSize / 2
					const existingY = parseFloat(dot.style.top) + this.dotSize / 2
			
					const dx = newX - existingX
					const dy = newY - existingY
					const distance = Math.sqrt(dx * dx + dy * dy)
			
					// 如果距离小于最小距离，则认为重叠
					if (distance < this.minDistance) {
						return true
					}
				}
				return false
			},
			/**
			 * 在圆形区域内生成随机位置（避免重叠）
			 */
			getRandomPositionInCircle() {
				const container = this.$refs.circleContainer
				if (!container) return null
				const {
					width,
					height
				} = container.getBoundingClientRect()
				// 计算中心点和半径
				const centerX = width / 2
				const centerY = height / 2
				const radius = Math.min(centerX, centerY) - this.minDistance / 2
				// 如果半径小于点大小，则无法放置点
				if (radius <= 0) return null
				// 尝试生成不重叠的位置
				for (let i = 0; i < this.maxRetries; i++) {
					// 生成随机角度 (0-2π)
					const angle = Math.random() * Math.PI * 2
					// 生成随机半径（使用平方根确保均匀分布）
					const r = radius * Math.sqrt(Math.random())
					// 计算坐标
					const x = centerX + r * Math.cos(angle)
					const y = centerY + r * Math.sin(angle)
					// 检查是否重叠
					if (!this.isOverlapping(x, y)) {
						return {
							left: `${x - this.dotSize / 2}px`,
							top: `${y - this.dotSize / 2}px`
						}
					}
				}
				// 如果尝试多次仍无法找到合适位置，则返回null
				return null
			},
			/**
			 * 添加一个随机点
			 */
			addDot(item) {
				const position = this.getRandomPositionInCircle()
				if (position) {
					this.dots.push({
						num: item.num,
						name: item.name,
						style: {
							left: position.left,
							top: position.top
						}
					})
				} else {
					alert('无法在圆形区域内找到合适的位置放置新点！')
				}
			},
		},
		mounted() {
			this.tick() // 先执行一次
			this.timer = setInterval(this.tick, 1000)
			// this.systemList.forEach((item) => {
			// 	this.addDot(item)
			// })
		},
		beforeUnmount() {
			clearInterval(this.timer)
		},

	}
</script>
<style lang="scss" scoped>
	@import './index.scss';
</style>
<style lang="scss" scoped>
.date {
	width: 210px;
	height: 105px;
	border-radius: 8px;
	:deep(.el-input__inner) {
		background-color: transparent;
		border: none;
		height: 96px;
		color: #C5E4F9;
	}
	:deep(.el-input__icon) {
		width: 28px;
		height: 28px;
	}
	:deep(.el-date-editor--year) {
		:deep(.el-input__inner) {
			font-family: PingFangSC, PingFang SC;
			font-size: 40px;
			color: #C5E4F9;
			font-style: normal;
			text-align: center;
		}
	}
	:deep(.el-date-editor){
		box-shadow: 0px 8px 0px -4px #4BE7FF;
		border-radius: 8px;
	}
}
.fault-statistics{
	:deep(.el-collapse){
		border: none;
	}
	:deep(.el-collapse-item){
		margin-top: 32px;
	}
	:deep(.el-collapse-item__header){
		background-color: transparent;
		border: none;
		padding-left: 65px;
		background: url("./img/fault-title.png") no-repeat;
	}
	:deep(.el-collapse-item__header.is-active){
		background: url("./img/fault-title-active.png") no-repeat;
	}
	:deep(.el-collapse-item__wrap){
		border: none;
		padding: 20px 0;
		background: transparent;
	}
	
}

</style>
