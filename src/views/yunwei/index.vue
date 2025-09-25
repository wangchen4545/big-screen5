<!-- @format -->

<template>
	<div class="yunwei">
		<bigTitle title="全国海关信息中心运维情况总览"></bigTitle>
		<div class="yunwei-conent">
			<div class="left-content">
				<div class="top1-content">
					<div class="top-left1">
						<div class="min-title">
							<p>攻击告警信息 <span> ATTACK ALERT INFORMATION </span></p>
						</div>
						<el-table
							:data="tableData"
							stripe
						>
							<el-table-column
								label="时间"
								prop="date"
								width="388"
								align="left"
							/>
							<el-table-column
								label="国家"
								prop="cantry"
								width="388"
								align="left"
							/>
							<el-table-column
								label="攻击IP"
								prop="ip"
								width="388"
								align="left"
							/>
							<el-table-column
								label="目标系统"
								prop="system"
								width="736"
								align="left"
							/>
							<el-table-column
								label="攻击类型"
								prop="type"
								width="200"
								align="left"
							/>
							<el-table-column
								width="200"
								label="威胁等级"
								align="center"
							>
								<template #default="scope">
									<div class="tag tagRed">{{scope.row.level}}</div>
								</template>
							</el-table-column>
							<el-table-column
								width="200"
								label="是否处置"
								align="center"
							>
								<template #default="scope">
									<div class="tag tagRed">{{scope.row.status}}</div>
								</template>
							</el-table-column>
						</el-table>
					</div>
					<div class="top-left2">
						<div class="min-title">
							<p>攻击威胁趋势 <span> ATTACK THREAT TRENDS </span></p>
						</div>
						<div class="top-left2-chart-title">
							<div>近24小时受攻击次数</div>
							<div>104</div>
						</div>
						<div class="chart-content">
							<barChart></barChart>
						</div>
					</div>
				</div>
				<div class="bottom1-content">
					<div class="min-title">
						<p>机房设备情况 <span>COMPUTER ROOM EQUIPMENT CONDITION </span></p>
					</div>
					<div class="bottom1-content1">
						<div class="chart-content">
							<!-- 机柜使用率 -->
							<div class="jigui-title">机柜使用率</div>
							<div class="jigui-chart">
								<gauge></gauge>
							</div>
						</div>
						<div class="computer-content">
							<!-- 机柜使用率 -->
							<computer
								class="computer-g1"
								title="李桥机房"
								:activity="true"
							></computer>
							<computer
								class="computer-g2"
								title="金宝街机房"
								:activity="false"
							></computer>
							<computer
								class="computer-g3"
								title="总署机房"
								:activity="false"
							></computer>
							<computer
								class="computer-g4"
								title="上海宝信机房"
								:activity="false"
							></computer>
							<computer
								class="computer-g5"
								title="宁夏中位机房"
								:activity="false"
							></computer>
							<div class="detail">
								<!--  -->
								<div class="computer-title">李桥机房</div>
								<div class="text text1">
									<span>机房能源效率PUE</span>
									<span>1.55</span>
								</div>
								<div class=" text text2">
									<span>设备总量</span>
									<span>1.55</span>
								</div>
								<div class="text text3">
									<span>机柜总量</span>
									<span>1.55</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="t-watch">
				<div class="title">
					<div class="title-text">技术监控</div>
					<div class="time">
						<el-select
							v-model="twatchValue"
							:popper-append-to-body="false"
							placeholder="请选择"
						>
							<el-option
								v-for="item in selectTime"
								:key="item.value"
								:label="item.label"
								:value="item.value"
							>
							</el-option>
						</el-select>
					</div>
				</div>
				<div class="chuzhi p-text">
					<div>
						<img
							src="./img/saomiao.png"
							alt=""
						/>
					</div>
					<p class="p1 p-text1">告警处置率</p>
					<p class="p2 p-text2">98.9%</p>
				</div>
				<div class="auto-watch">
					<p class="p1 p-text1">自动监控</p>
					<p class="p2 p-text2">724</p>
				</div>
				<div class="person-watch">
					<p class="p1 p-text1">人工巡检</p>
					<p class="p2 p-text2">98.9%</p>
				</div>
			</div>
			<!-- 中间 -->
			<div class="center-chart"></div>
			<!--  -->
			<div class="t-zhichi">
				<div class="title">
					<div class="title-text">技术支持</div>
				</div>
				<div class="t-month">
					<div class="t-month-title">近1月处理情况</div>
					<div class="process">
						<div class="line"></div>
					</div>
					<p class="p1">
						<span></span>
						<span>已完成</span>
						<span>2200</span>
					</p>
					<p class="p2">
						<span></span>

						<span>处理中</span>
						<span>2200</span>
					</p>
				</div>
				<div class="t-zhichi-detail">
					<ul>
						<li>
							<div>
								<p>3355热线电话</p>
								<h3>100</h3>
							</div>
						</li>
						<li>
							<div>
								<p>运管平台Web</p>
								<h3>100</h3>
							</div>
						</li>
						<li>
							<div>
								<p>海关易服务App</p>
								<h3>100</h3>
							</div>
						</li>
						<li>
							<div>
								<p>运管平台一键报障</p>
								<h3>100</h3>
							</div>
						</li>
						<li>
							<div>
								<p>技术支持热线邮箱</p>
								<h3>100</h3>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!-- right -->
			<div class="right-content">
				<div class="right-top">
					<div class="right-left">
						<div class="min-title">
							<p>网络连通情况 <span>NETWORK CONNECTION STATUS </span></p>
						</div>
						<div class="right-left-left">
							<div class="liyonglv">
								<div class="lv1">
									<p class="p1">骨干网可用率</p>
									<div class="lv">
										<div>1</div>
										<div>2</div>
										<div>.</div>
										<div>4</div>
										<div>5</div>
										<div>6</div>
										<div>%</div>
									</div>
								</div>
								<div class="lv-2-wrap">
									<div class="lv2">
										<p class="p1">总链路</p>
										<div class="lv">
											<div>1</div>
											<div>2</div>
										</div>
									</div>
									<div class="lv3">
										<p class="p1">故障链路</p>
										<div class="lv">
											<div>1</div>
											<div>2</div>
										</div>
									</div>
								</div>
							</div>
							<div class="custom-info">
								<div class="title">各直属关情况</div>
								<el-table
									:data="customData"
									style="width: 100%"
									stripe
								>
									<el-table-column
										prop="rank"
										label="排名"
										width="352"
										align="center"
									>
										<template #default="scope">
											<div class="rank">{{scope.row.rank}}</div>
										</template>
									</el-table-column>
									<el-table-column
										prop="custom"
										label="关区"
										width="508"
									>
										<template #default="scope">
											<div class="custom">{{scope.row.custom}}</div>
										</template>
									</el-table-column>
									<el-table-column
										prop="rate"
										label="宽带使用率"
										width="250"
										align="right"
									>
										<template #default="scope">
											<div class="tableTate">{{scope.row.rate}}</div>
										</template>
									</el-table-column>
									<el-table-column
										prop="status"
										label="联通情况"
										width="350"
										align="right"
									>
										<template #default="scope">
											<div class="">
												<img
													v-if="scope.row.status==1"
													src="./img/network_a.png"
													alt=""
												/>
												<img
													v-if="scope.row.status==0"
													src="./img/network_b.png"
													alt=""
												/>
											</div>
										</template>
									</el-table-column>
								</el-table>
							</div>
						</div>
					</div>
					<div class="right-right">
						<div class="min-title">
							<p>整体运维 <span>OVERALL O&M STATUS </span></p>
						</div>
						<div class="right-left-left">
							<div class="liyonglv">
								<div class="lv1">
									<p class="p1">核心系统可用率</p>
									<div class="lv">
										<div>1</div>
										<div>2</div>
										<div>.</div>
										<div>4</div>
										<div>5</div>
										<div>6</div>
										<div>%</div>
									</div>
								</div>
								<div class="lv1">
									<p class="p1">重点保障应用系统可用率</p>
									<div class="lv">
										<div>1</div>
										<div>2</div>
										<div>.</div>
										<div>4</div>
										<div>5</div>
										<div>6</div>
										<div>%</div>
									</div>
								</div>
							</div>
							<div class="maintenance">
								<div class="title">故障统计</div>
								<div class="maintenance-wrap">
									<ul>
										<li>
											<h3>18</h3>
											<p>三级及以上故障</p>
										</li>
										<li>
											<h3>
												<span>23H</span>
												<p class="huabi"><i>环比</i> <span>6.8%</span></p>
											</h3>
											<p>三级及以上故障</p>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 下 -->
				<div class="right-bottom">
					<div class="shishi">
						<div class="min-title">
							<p>运维实时播报 <span> REAL-TIME BROADCASTING </span></p>
							<div class="select-status">
								<el-select
									v-model="shishiSelect"
									:popper-append-to-body="false"
									placeholder="请选择"
								>
									<el-option
										v-for="item in shishiSelectArr"
										:key="item.value"
										:label="item.label"
										:value="item.value"
									>
									</el-option>
								</el-select>
							</div>
						</div>
						<ul class="info">
							<li class="info-wrap">
								<div class="icon">
									<img
										src="./img/point@4x.png"
										alt=""
									/>
								</div>
								<div class="detail-warp">
									<div>
										<div class="baojing">
											<p><span>报警时间</span><span>08-14 12:00</span></p>
											<p><span>首次时间</span><span>08-14 12:00</span></p>
										</div>
										<div class="detail-text">故障-A2024050800000043-UC统一通信平台_互联网_网站异常故障-A2024050800000043-UC统一</div>
									</div>
								</div>
								<!-- 持续 -->
							</li>
							<li class="info-wrap">
								<div class="icon">
									<img
										src="./img/point@4x.png"
										alt=""
									/>
								</div>
								<div class="detail-warp">
									<div>
										<div class="baojing">
											<p><span>报警时间</span><span>08-14 12:00</span></p>
											<p><span>首次时间</span><span>08-14 12:00</span></p>
										</div>
										<div class="detail-text">故障-A2024050800000043-UC统一通信平台_互联网_网站异常故障-A2024050800000043-UC统一</div>
									</div>
								</div>
								<!-- 持续 -->
							</li>
							<li class="info-wrap">
								<div class="icon">
									<img
										src="./img/point@4x.png"
										alt=""
									/>
								</div>
								<div class="detail-warp">
									<div>
										<div class="baojing">
											<p><span>报警时间</span><span>08-14 12:00</span></p>
											<p><span>首次时间</span><span>08-14 12:00</span></p>
										</div>
										<div class="detail-text">故障-A2024050800000043-UC统一通信平台_互联网_网站异常故障-A2024050800000043-UC统一</div>
									</div>
								</div>
								<!-- 持续 -->
							</li>
						</ul>
					</div>
					<div class="half-year">
						<div class="min-title">
							<p>近半年异常业务数据处理情况 <span> ABNORMAL DATA </span></p>
						</div>
						<div class="chart-warp">
							<!-- 机柜使用率 -->
							<p class="jigui-title">异常业务数据处理情况</p>
							<h3>129</h3>
							<div class="chart-content">
								<errorChart></errorChart>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
import barChart from './components/bar.vue';
import computer from './components/computer.vue';
import errorChart from './components/errorChart.vue';
import gauge from './components/gauge.vue';

export default {
    name: "yunWei",
    components: {
		bigTitle,
		barChart,
		computer,
		errorChart,
		gauge
    },
    data() {
		return {
			tableData: [
				{
					date: '2024-08-25',
					cantry: '中国',
					ip: '192.168.1.1',
					system: 'vitual',
					type: '攻击',
					level: '1',
					status: '未处理'
				},
				{
					date: '2024-08-25',
					cantry: '中国',
					ip: '192.168.1.1',
					system: 'vitual',
					type: '攻击',
					level: '1',
					status: '未处理'
				},
				{
					date: '2024-08-25',
					cantry: '中国',
					ip: '192.168.1.1',
					system: 'vitual',
					type: '攻击',
					level: '1',
					status: '未处理'
				},
				{
					date: '2024-08-25',
					cantry: '中国',
					ip: '192.168.1.1',
					system: 'vitual',
					type: '攻击',
					level: '1',
					status: '未处理'
				},
			],
			customData: [
				{
					rank: '1',
					custom: '总署',
					rate: '100%',
					status: '1'
				},
				{
					rank: '2',
					custom: '总署',
					rate: '100%',
					status: '1'
				},
				{
					rank: '3',
					custom: '总署',
					rate: '100%',
					status: '1'
				},
				{
					rank: '4',
					custom: '总署',
					rate: '100%',
					status: '1'
				},
				{
					rank: '5',
					custom: '总署',
					rate: '100%',
					status: '1'
				},
			],
			twatchValue: "1",
			selectTime: [
				{
					value: '1',
					label: '近1月'
				},
				{
					value: '2',
					label: '近七天'
				}
			],
			shishiSelect: '1',
			shishiSelectArr: [
				{
					value: '1',
					label: '未恢复告警'
				},
				{
					value: '2',
					label: '恢复告警'
				}
			],
        }
    },
    methods: {
    },
    mounted () {
    }
}
</script>

<style lang="scss" scoped>
@import './index.scss';
</style>
