<!-- @format -->

<template>
	<div class="yunxing">
		<bigTitle :props="'全国海关技术监控实时数据'"></bigTitle>
		<div class="yunxing-content">
			<div class="guzhang">
				<div class="min-title">
					<p>攻击告警信息 <span> ATTACK ALERT INFORMATION </span></p>
				</div>
				<!-- 故障分布 -->
				<div class="distribution">
					<div class="distribution-title">故障级别分布</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import bigTitle from '@/components/bigTitle.vue';
export default {
    name: "YunXing",
    comments: {
        bigTitle
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
