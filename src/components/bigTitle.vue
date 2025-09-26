<!-- @format -->

<template>
	<div class="title">
		<!-- 更新数据 -->
		<div class="updata">
			<span class="updata-s1">数据更新</span>
			<span class="updata-s2">2025-08-25</span>
		</div>
		<!-- title -->
		<div class="title-text">{{title}}</div>
		<!-- 时间 -->
		<div class="time">
			<span class="icon"></span> <span class="time-s1">{{nowY}}</span> <span class="time-s2">{{nowM}}</span>
		</div>
	</div>
</template>

<script>
export default {
    props: {
        title: String
    },
    data() {
            return {
                nowY: new Date().getFullYear(),
                nowM: new Date().getMonth() + 1,
                 timer: null,
            }
    },
    methods: {
       pad(n) {
            return n < 10 ? '0' + n : n
        },
        tick() {
            const d = new Date()
            const yyyy = d.getFullYear()
            const mm   = this.pad(d.getMonth() + 1)
            const dd   = this.pad(d.getDate())
            const HH   = this.pad(d.getHours())
            const MM   = this.pad(d.getMinutes())
            const SS   = this.pad(d.getSeconds())
            this.nowY =
                `${yyyy}-${mm}-${dd} `

             this.nowM =  `${HH}:${MM}:${SS}`
        }
    },
      mounted() {
        this.tick()                 // 先执行一次
        this.timer = setInterval(this.tick, 1000)
    },
    beforeUnmount() {
        clearInterval(this.timer)
    },
}
</script>

<style lang="scss" scoped>
.title {
		width: 6480px;
		height: 160px;
		margin: auto;
		padding-top: 40px;
		position: relative;
		z-index: 2;
		.updata {
			width: 736px;
			position: absolute;
			left: 0;
			top:40px;

			.updata-s1 {
				width: 204px;
				height: 56px;
				font-family: AlibabaPuHuiTi, AlibabaPuHuiTi;
				font-weight: 400;
				font-size: 48px;
				color: #d1eeff;
				line-height: 56px;
				text-shadow: 0px 0px 16px rgba(0, 60, 124, 0.5);
				text-align: left;
				font-style: normal;
			}
			.updata-s2 {
				width: 496px;
				height: 56px;
				font-family: Gotthard;
				font-size: 56px;
				color: #d1eeff;
				line-height: 56px;
				letter-spacing: 4px;
				text-shadow: 0px 0px 16px rgba(0, 60, 124, 0.5);
				text-align: left;
				font-style: normal;
				margin-left: 36px;
			}
		}
		.title-text {
			height: 136px;
			font-family: jdlangzhengti, jdlangzhengti;
			font-weight: normal;
			font-size: 136px;
			color: #ffffff;
			line-height: 56px;
			letter-spacing: 12px;
			text-shadow: 0px 16px 0px rgba(27, 53, 79, 0.4);
			text-align: center;
			font-style: normal;
			padding-top: 24px;
			/* 	background: linear-gradient(270deg, #d1eeff 0%, #ffffff 100%); */
		}
		.time {
			width: 1000px;
			position: absolute;
			right: 0;
			top:40px;

			.icon {
				width: 48px;
				height: 48px;
			}
			.time-s1,
			.time-s2 {
				width: 496px;
				height: 56px;
				font-family: Gotthard;
				font-size: 56px;
				color: #d1eeff;
				line-height: 56px;
				letter-spacing: 4px;
				text-shadow: 0px 0px 16px rgba(0, 60, 124, 0.5);
				text-align: left;
				font-style: normal;
			}
			.time-s2 {
				margin-left: 68px;
			}
		}
	}
</style>
