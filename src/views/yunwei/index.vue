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
					<el-table :data="tableData">
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
							width="184"
							align="left"
						/>
						<el-table-column
							width="184"
							label="威胁等级"
						>
							<template #default="scope">
								<div>级别: {{scope.row.level}}</div>
							</template>
						</el-table-column>
						<el-table-column
							width="184"
							label="是否处置"
						>
							<template #default="scope">
								<div>chuzhi: {{scope.row.status}}</div>
							</template>
						</el-table-column>
					</el-table>
				</div>
				<div class="top-left2">攻击威胁趋势</div>
			</div>
			<div class="bottom1-content">
				<div>攻击威胁趋势</div>
			</div>
		</div>
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
export default {
    name: "yunWei",
    components: {
        bigTitle,
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
                {
                    date: '2024-08-25',
                    cantry: '中国',
                    ip: '192.168.1.1',
                    system: 'vitual',
                    type: '攻击',
                    level: '1',
                    status: '未处理'
                }
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
