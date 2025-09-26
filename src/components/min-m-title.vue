<!-- @format -->

<template>
	<div class="min-m-title">{{title}}</div>
</template>

<script>
export default {
name: 'min-m-title',
    props: {
    title: String
},
}
</script>

<style lang="scss" scoped>
.min-m-title{
    height: 88px;
    font-family:jdlangzhengti;
    font-weight: normal;
    font-size: 52px;
    color: #C5E4F9;
    line-height: 88px;
    text-align: left;
    font-style: normal;
    padding-left: 64px;

}
</style>
