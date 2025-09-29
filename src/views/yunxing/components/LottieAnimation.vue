<!-- @format -->

<template>
	<div
		ref="lavContainer"
		:style="{ width: width + 'px', height: height + 'px' }"
	></div>
</template>

<script>
import lottie from 'lottie-web'

export default {
  props: {
    animationData: { type: Object, required: true },
    width: { type: Number, default: 200 },
    height: { type: Number, default: 200 },
    loop: { type: Boolean, default: true },
    autoplay: { type: Boolean, default: true }
  },
  mounted () {
    this.anim = lottie.loadAnimation({
      container: this.$refs.lavContainer,
      renderer: 'svg',
      loop: this.loop,
      autoplay: this.autoplay,
      animationData: this.animationData
    })
  },
  beforeDestroy () {
    this.anim && this.anim.destroy()
  }
}
</script>
