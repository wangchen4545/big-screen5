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
			<div class="title-text">深圳海关运维服务情况</div>
			<!-- 时间 -->
			<div class="time">
				<span class="icon"></span>
				<span class="time-s1">2025-08-25</span>
				<span class="time-s2">14:14:30</span>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'yunXingQingKuang',
		data() {
			return {
				dateVale: '2025-09-12',
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
