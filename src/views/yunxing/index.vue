<!-- @format -->

<template>
	<div class="yunxing">
		<bigTitle title="全国海关信息中心运维情况总览"></bigTitle>
		<div class="yunxing-content">
			<div class="guzhang">
				<div class="min-title">
					<p>攻击告警信息 <span> ATTACK ALERT INFORMATION </span></p>
				</div>
				<!-- 故障分布 -->
				<div class="distribution">
					<minMTitle
						class="m-title"
						title="故障级别分布"
					></minMTitle>
					<div class="info">
						<div class="total">
							<h3>1278</h3>
							<p>总故障</p>
						</div>
						<div class="level">
							<h3>1278</h3>
							<p>三级以上故障</p>
						</div>
					</div>
					<!-- 彩条 -->
					<div class="rota">
						<!-- 色块 -->
						<el-row :gutter="6">
							<el-col :span="4">
								<div class="scale scale0"></div>
							</el-col>
							<el-col :span="5">
								<div class="scale scale1"></div>
							</el-col>
							<el-col :span="5">
								<div class="scale scale2"></div>
							</el-col>
							<el-col :span="5">
								<div class="scale scale3"></div>
							</el-col>
							<el-col :span="5">
								<div class="scale scale4"></div>
							</el-col>
						</el-row>
						<!-- 文字描述 -->
						<el-row :gutter="6">
							<el-col :span="4">
								<div class="describe">
									<div class="legend legend0"></div>
									<span class="txt1">二级故障</span>
									<span class="txt2">2</span>
								</div>
							</el-col>
							<el-col :span="5">
								<div class="describe">
									<div class="legend legend1"></div>
									<span class="txt1">二级故障</span>
									<span class="txt2">2</span>
								</div>
							</el-col>
							<el-col :span="5">
								<div class="describe">
									<div class="legend legend2"></div>
									<span class="txt1">三级故障</span>
									<span class="txt2">2</span>
								</div>
							</el-col>
							<el-col :span="5">
								<div class="describe">
									<div class="legend legend3"></div>
									<span class="txt1">四级故障</span>
									<span class="txt2">2</span>
								</div>
							</el-col>
							<el-col :span="5">
								<div class="describe">
									<div class="legend legend4"></div>
									<span class="txt1">五级故障</span>
									<span class="txt2">2</span>
								</div>
							</el-col>
						</el-row>
					</div>
				</div>
				<!-- 故障路径分析 -->
				<div class="fenxi">
					<minMTitle title="故障发现途径分析"></minMTitle>
					<div class="fenxi-content">
						<div class="data data1">
							<div>
								<p>热线发现</p>
								<h3>725</h3>
							</div>
						</div>
						<div class="data data2">
							<div>
								<p>巡检发现</p>
								<h3>361</h3>
							</div>
						</div>
						<div class="data data3">
							<div>
								<p>工具发现</p>
								<h3>124</h3>
							</div>
						</div>
						<div class="fenxi-chart">
							<xunjianPie></xunjianPie>
						</div>
					</div>
				</div>
			</div>
			<!-- 年故障 -->
			<div class="nian-guzhang">
				<div class="min-title">
					<p>本年故障趋势 <span>FAULT TREND</span></p>
				</div>
				<div class="info">
					<div class="info-left">
						<div>
							<p>今日故障</p>
							<h3>7</h3>
						</div>
						<div>
							<p>已处理</p>
							<h3>7</h3>
						</div>
					</div>
					<div class="info-right">
						<!-- 例子 -->
						<div class="legend-box">
							<!-- 文字描述 -->
							<div class="describe">
								<div class="legend legend0"></div>
								<span class="txt1">一级故障</span>
							</div>
							<div class="describe">
								<div class="legend legend1"></div>
								<span class="txt1">二级故障</span>
							</div>
							<div class="describe">
								<div class="legend legend2"></div>
								<span class="txt1">三级故障</span>
							</div>
							<div class="describe">
								<div class="legend legend3"></div>
								<span class="txt1">四级故障</span>
							</div>
							<div class="describe">
								<div class="legend legend4"></div>
								<span class="txt1">五级故障</span>
							</div>
						</div>
					</div>
				</div>

				<div class="bar-chart-box">
					<guzhangBar></guzhangBar>
				</div>
				<div class="min-title gaojing">
					<p>告警与调度 <span>ALERT AND DISPATCH STATUS</span></p>
				</div>
				<div class="gaojing-content">
					<div class="gaojing-left-data">
						<minMTitle :title="'告警情况'"></minMTitle>
						<ul>
							<li>
								<p class="p1">
									<span
										><img
											src="./img/arrows@4x.png"
											alt=""
									/></span>
									总告警
								</p>
								<p class="p2">13</p>
							</li>
							<li>
								<p class="p1"><span></span> 已恢复</p>
								<p class="p2">03</p>
							</li>
							<li>
								<p class="p1"><span></span> 未恢复</p>
								<p class="p2">04</p>
							</li>
						</ul>
					</div>
					<div class="gaojing-center-data">
						<jinggaoGauge></jinggaoGauge>
					</div>
					<div class="gaojing-right-data">
						<minMTitle :title="'调度情况'"></minMTitle>
						<ul>
							<li>
								<p class="p1">
									<img
										src="./img/arrows@4x.png"
										alt=""
									/>中级以上调度
								</p>
								<p class="p2">13</p>
							</li>
							<li>
								<p class="p1">高级调度</p>
								<p class="p2">03</p>
							</li>
							<li>
								<p class="p1">中级调度</p>
								<p class="p2">04</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--  调度故障-->
			<div class="fault">
				<div class="failt-title">
					<p>共 <span class="failt-total">13</span>个中高级调度故障</p>
					<el-select
						v-model="selectDate"
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
				<div class="failt-list">
					<el-collapse
						v-model="failtListAction"
						accordion
						@change="failtListChange"
					>
						<el-collapse-item
							v-for="(item,index) in failtListActionList"
							:key="index"
							:name="index"
						>
							<template #title>
								<div class="title">
									<div class="status">
										<span
											v-if="item.status == 0"
											class="status-txt"
											>已完成</span
										>
										<span
											v-else
											class="status-txt"
											>处理中</span
										>
										<div
											v-if="item.status == 0"
											class="complete"
										></div>
										<LottieAnimation
											v-else
											:animation-data="tagLoading"
											:width="300"
											:height="90"
										/>
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
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
import minMTitle from '@/components/min-m-title.vue';
import xunjianPie from './components/xunjianPie.vue';
import guzhangBar from './components/guzhangBar.vue';
import jinggaoGauge from './components/jinggaoGauge.vue';
import LottieAnimation from './components/LottieAnimation.vue'
import tagLoading from './img/tag_loading.json'
export default {
    name: "YunXing",
    components: {
        bigTitle,
        minMTitle,
        xunjianPie,
        guzhangBar,
        jinggaoGauge,
        LottieAnimation
    },
    data () {
        return {
            tagLoading,
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
            failtListAction: '1',
            selectDate:'1',
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
        }
    },
    methods: {
    },
}
</script>

<style lang="scss" scoped>
@import './index.scss';
</style>
