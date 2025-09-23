<!-- @format -->

<template>
	<div class="data-page">
		<bigTitle :props="'全国海关技术监控实时数据'"></bigTitle>
		<!-- 控制亮度 -->
		<div class="drak-light">
			<div
				class="drak-light-switch"
				:class="{ 'drak-light-switch1' :  light === 1 }"
				@click="changeDark"
				@dblclick="dbChangeDark"
			></div>
			<ul
				v-show="switchLightList"
				@mouseleave="() => { switchLightList=false}"
			>
				<li
					v-for="(value, index) in lightArr"
					:key="value"
					@click="changeLight(value,index)"
					:class="{ 'active': lightIndex === index }"
				>
					{{value}}
				</li>
			</ul>
		</div>
		<!-- 图表 -->
		<div class="chart-wrap">
			<!-- 1 -->
			<div class="chart1">
				<div class="w">
					<ChartO></ChartO>
				</div>
				<div style="padding-top: 120px;">
					<ChartO></ChartO>
				</div>
			</div>
			<!-- 2 -->
			<div class="chart2">
				<ChartBig></ChartBig>
			</div>
			<!-- 3 -->
			<div class="chart3">
				<ChartBig></ChartBig>
			</div>
			<!-- 4 -->
			<div class="chart4">
				<ChartBig></ChartBig>
			</div>
			<!-- 5 -->
			<div class="chart5">
				<div class="w">
					<ChartO></ChartO>
				</div>
				<div style="padding-top: 120px;">
					<ChartO></ChartO>
				</div>
			</div>
		</div>
		<div
			class="bg"
			:style="{'opacity':light}"
		></div>
	</div>
</template>

<script>


import ChartO from './components/chart1.vue';
import ChartBig from './components/chart-big.vue';
import bigTitle from '@/components/bigTitle.vue';
export default {
    name: 'IndexI',
    components: {
        ChartO,
		ChartBig,
		bigTitle
	},
	data () {
        return {
            lightArr: [
                '100%',
                '80%',
                '60%',
                '40%',
                '20%',
                '0%',
            ],
            nowY: '',
            timer: null,
            nowM: '',
            /* 控制亮度 */
            switchLight: false,
            light: 0,
            lightIndex: 0,
            switchLightList:false
        }
    },
    methods: {
        changeLight (value, index) {
            let valueNum =  parseInt(value)
            if (valueNum != 0) {
                this.light = 1 - valueNum / 100
            } else {
                this.light = 1
            }
            this.lightIndex = index
        },
        dbChangeDark () {

        },
        changeDark () {
            this.switchLightList=true

            /* this.switchLight = !this.switchLight
            if (this.switchLight) {
                this.light = 0
                this.lightIndex = 0
            } else {
                this.light = 1
                const len = this.lightArr.length
                this.lightIndex = len - 1
                console.log(this.lightIndex,"this.lightIndex")
            } */
        },
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

<style lang="scss">
*,
body,
html {
	padding: 0;
	margin: 0;
}
ul {
	list-style: none;
}
</style>

<style lang="scss" scoped>
@import './index.scss';
</style>
