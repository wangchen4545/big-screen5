<!-- @format -->

<template>
	<div>
		<div
			class="table-title"
			:style="{texalign:align}"
		>
			{{title}}
		</div>
		<div class="content">
			<slot></slot>
			<slot name="color-tag"></slot>
		</div>
	</div>
</template>

<script>

export default {
    props: {
        title: String,
        align: {
            type: String,
            default: 'left'
        },
        width: {
            type: String,
            default: 'auto'
        }
    },
    data () {
        return {
        }
    },
    mounted () {
    },
    methods: {
    }
}
</script>

<style lang="scss" scoped>
.table-title{
    width: 92px;
    height: 96px;
    font-family: PingFangSC, PingFang SC;
    font-weight: 400;
    font-size: 44px;
    color: #7FB5D9;
    line-height: 96px;
    font-style: normal;

}
.content{
    height: 128px;
    font-family: PingFangSC, PingFang SC;
    font-weight: 500;
    font-size: 44px;
    color: #FFFFFF;
    line-height: 44px;
    text-align: left;
    font-style: normal;

}
</style>
