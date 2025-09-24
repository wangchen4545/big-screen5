<!-- @format -->

<template>
	<div class="yunwei">
		<bigTitle title="全国海关信息中心运维情况总览"></bigTitle>
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
						<div class=""></div>
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
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
import barChart from './components/bar.vue';
import computer from './components/computer.vue';
export default {
    name: "yunWei",
    components: {
		bigTitle,
		barChart,
		computer
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
            ]
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
