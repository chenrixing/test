/**
 * Created by Makkah at 2019/1/27 11:15
 */
// 定义模块时,需要引入本模块依赖的其他模块; exports->提供接口给外部使用（使用layui.index得到的变量就是exports输出的对象）
layui.define(['layer'], function (exports) {
    var layer = layui.layer;
    var test1 = function () {
        layer.msg("嘻嘻嘻嘻嘻test1->222");
    };
    // 提供接口给外部使用,第一个参数是本模块的名字，也就是文件名，第二个参数是在本模块内定义的方法，即use此模块后实际调用的方法(把方法以对象的形式输出，所以方法名后面不带())
    exports('index', test1);
});
