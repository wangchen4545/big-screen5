

const drawChartOption = function (value, max) {
   const colorConfig = {

      colorList: {
         text: '#FFFFFF',
         line2: {
            type: 'linear',
            x: 0, // 右
            y: 0, // 下
            x2: 1, // 左
            y2: 0, // 上
            colorStops: [
               {
                  offset: 0,
                  color: 'transparent'
               },
               {
                  offset: 1,
                  color: 'rgba(75, 231, 255, 1)'
               }
            ]
         },
         line3: {
            type: 'linear',
            x: 0, //右
            y: 0, //下
            x2: 1, //左
            y2: 0, //上
            colorStops: [
               
               {
                  offset: 0,
                  color: 'rgba(127, 181, 217, 0)'
               },
               {
                  offset: 1,
                  color: 'rgba(127, 181, 217, 1)'
               }
            ]
         }
      }
   }

   const ratio = max ? ((value / max) * 100).toFixed(1) : 0;

   const { name, colorList } = colorConfig;

   const option = {
      backgroundColor: '#000',
      tooltip: {
         formatter(params) {
            if (params) {
               const { marker, name } = params;
               return `${marker}${name}  ${ratio ? ratio + '%' : ''}`;
            } else {
               return '';
            }
         },
         triggerOn: 'mousemove',
         borderWidth: 0.5,
         color: '#ffffff',
         show:false
      },
      grid: {
         left: '2%',
         right: '2%',
         bottom: '2%',
         top: '2%',
         containLabel: false
      },
      series: [
         //由外往内第一层线色部分
         {
            type: 'pie',
            center: ['49.5%', '64%'],
            radius: ['81%', '82%'],
            startAngle: 180,
            endAngle: 0,
            zlevel: 2,
            emptyCircleStyle: {
               color: 'transparent'
            },
            axisTick : {
              show : true
            },
            axisLine:{
               show: false,
               
            },
            tooltip: {
               show: true
            },
            label: {
               show: true
            },
            emphasis: {
               scale: false
            },
            labelLine: {
               show: true
            },
            data: [
               {
                  value: 180,
                  itemStyle: {
                     color: {
                        type: 'linear',
                        x: 0, //右
                        y: 0, //下
                        x2: 0, //左
                        y2: 1, //上
                        colorStops: [
                           {
                              offset: 0,
                              color: '#232A33'
                           },
                           {
                              offset: 1,
                              color: 'transparent'
                           }
                        ]
                     }
                  }
               },
               {
                  value: 180,
                  itemStyle: {
                     opacity: 0,
                     color: 'transparent'
                  }
               }
            ]
         },
         //由外往内第二层线色部分
         {
            type: 'gauge',
            center: ['49.5%', '64%'],
            radius: '72%',
            startAngle: 180,
            endAngle: 0,
            min: 0,
            max: 100,
            zlevel: 6,
            pointer: {
               show: false //是否显示指针
            },
            tooltip: {
               show: true
            },
            progress: {
               show: true,
               roundCap: false,
               width: 20
            },
           
            detail: {
               offsetCenter: [0, '-4%'], // title圆环中心的距离
               color: colorList.text,
               textAlign: 'center',
               fontSize: 96,
              lineHeight: 96,
               fontWeight: 500,
               fontFamily: 'Gotthard',
               formatter: (value) => [
                          '{title|使用率}',
                          value +'%'
                      ].join('\n'),
                rich: {
                  title: {
                      lineHeight: 44,
                      height: '44px',
                      fontSize: '44px',
                      color: '#C5E4F9',
                      textAlign: 'center',
                      
                  },
                  
                 
              }
            },
            axisLabel: {
               // 刻度文字 如数字
               show: false,
               fontSize: 36,
               color: '#FFFFFFB8',
               distance: -40,
               formatter(value) {
                  if (value === 0 || value === 100) {
                     return `\n\n${(value * 100) / 100}%`;
                  }
               }
            },
            axisTick: {
               show: false //是否显示刻度
            },
            axisLine: {
               roundCap: false,
               lineStyle: {
                  color: [[1, '#232A33']],
                  width: 4
               }
            },
            splitLine: {
               show: false //是否显示分隔线。
            },
            clockwise: true, //仪表盘刻度是否是顺时针增长。
            splitNumber: 1, //分割线之间的刻度
            // 起始点和最终点距离设置
            data: [
               {
                  name,
                  value: ratio,
                  itemStyle: {
                     // 径向渐变，前三个参数分别是和半径，取值同线性渐变
                     // color: {
                     //   type: 'radial',
                     //   x: 0.5, // 圆心 x
                     //   y: 0.5, // 圆心 y
                     //   r: 0.5, // 半径
                     //   colorStops: [
                     //     {
                     //       offset: 0,
                     //       color: '#FFFFE9'
                     //     },
                     //     {
                     //       offset: 1,
                     //       color: '#FFFB00'
                     //     }
                     //   ]
                     // },
                     color: colorList.line2
                     // {
                     //   type: 'linear',
                     //   x: 0, // 右
                     //   y: 0, // 下
                     //   x2: 1, // 左
                     //   y2: 0, // 上
                     //   colorStops: [
                     //     {
                     //       offset: 0,
                     //       color: '#FFFB00'
                     //     },
                     //     {
                     //       offset: 1,
                     //       color: '#FFFFE9'
                     //     }
                     //   ]
                     // }
                  }
               }
            ]
         },
         //由外往内第三层渐变部分
         {
            type: 'gauge',
            radius: '68%',
            center: ['49.5%', '64%'],
            min: 0,
            max: 100,
            zlevel: 4,
            startAngle: 180,
            endAngle: 0,
            pointer: {
               show: false //是否显示指针
            },
            progress: {
               show: true,
               roundCap: false,
               width: 60
            },
            title: {
               show: false
            },
            detail: {
               show: false
            },
            axisLabel: {
               show: false,
               // 刻度文字 如数字
               color: colorList.text,
               fontSize: 24,
               fontWeight: 500,
               lineHeight: 44,
               textAlign: 'center',
               distance: -140,
               formatter: function (v) {
                  if (v === value) {
                     return `${ratio}%`;
                  } else {
                     return '';
                  }
               }
            },
            axisTick: {
               show: false //是否显示刻度
            },
            axisLine: {
               show: false
            },
            emphasis: {
               scale: false
            },
            tooltip: {
               show: false
            },
            clockwise: true, //仪表盘刻度是否是顺时针增长。
            splitNumber: 1000, //分割线之间的刻度
            splitLine: {
               show: false
            },
            data: [
               {
                  name,
                  value: ratio,
                  itemStyle: {
                     color: colorList.line3
                  }
               }
            ]
         },
         {
            type: 'gauge',
            center: ['49.5%', '64%'],
            radius: '48%',
            min: 0,
            max: 100,
            zlevel: 8,
            startAngle: 180,
            endAngle: 0,
            detail: {
               show: false
            },
            axisLabel: {
               show: false
            },
            splitLine: {
               show: false
            },
            axisLine: {
               show: false
            },
            axisTick: {
               show: false
            },
            tooltip: {
               show: false
            },
            pointer: {
               show: true,
               length: 100,
               width: 4,
               icon: 'rect',
               offsetCenter: [0, '-100%'],
               itemStyle: {
                  color: '#B7D8FF'
               }
            },
            data: [ratio]
         }
      ]
   };

   return option;
};


const options = drawChartOption(50, 100)


option = options