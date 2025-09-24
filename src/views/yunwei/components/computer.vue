<!-- @format -->

<template>
	<div
		class="computerGroup "
		:class="{ 'activity': activity }"
	>
		<div class="computer-img">
			<img
				src="../img/computer-img1.png"
				alt=""
				class="img1"
			/>
			<img
				src="../img/computer-img2.png"
				alt=""
				class="img2"
			/>
		</div>
		<div class="computer-text activity-text">
			<p>{{title}}</p>
		</div>
	</div>
</template>

<script>
export default {
    name: "computerGroup",
    props: {
        title: String,
        activity: {
            default:false,
        }
    },
}
</script>

<style lang="scss" scoped>
.computerGroup{
    width: 448px;
    height: 269px;
    .computer-img{
        width: 100%;
        height: 100%;
        img{
            width: 100%;
            height: 100%;
        }
        .img1{
            display: block;
        }
        .img2{
            display: none;
        }
    }
    .computer-text{
        height: 80px;
        line-height: 80px;
        border-radius: 8px;
        text-align: center;
        p{
             height: 80px;
            line-height: 80px;
            font-family: PingFangSC, PingFang SC;
            font-weight: 500;
            font-size: 40px;
            color: #5D7C9C;
            text-shadow: 0px 8px 16px rgba(0,0,0,0.2);
            text-align: center;
            font-style: normal;
            display: inline-block;
            background: #193146;
            margin: 0;
            padding:0 20px;

        }
    }
}
.activity{
    .computer-img{
        .img1{
            display: none;
        }
        .img2{
            display: block;
        }
    }
    .computer-text{
        p{
             color: #FFFFFF;
              background: rgba(21, 87, 129, 1);
        }
    }
}
</style>
