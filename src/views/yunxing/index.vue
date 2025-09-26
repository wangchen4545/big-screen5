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
		</div>
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
import minMTitle from '@/components/min-m-title.vue';
import xunjianPie from './components/xunjianPie.vue';

export default {
    name: "YunXing",
    components: {
        bigTitle,
        minMTitle,
        xunjianPie
    },
    data () {
        return {
        }
    },
    methods: {
    },
}
</script>

<style lang="scss" scoped>
@import './index.scss';
</style>
