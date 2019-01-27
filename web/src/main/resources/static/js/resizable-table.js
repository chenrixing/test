var resizingCell;
var tables = document.getElementsByClassName("resizable-table");
for (var tableIndex = 0; tableIndex < tables.length; tableIndex++) {
    var table = tables[tableIndex];
    // 循环遍历表头(th)行->表头的每一个th拖动
    for (var i = 0; i < table.rows[0].cells.length; i++) {
        // 按下鼠标，如果鼠标指针的位置距离所点击元素左上角的横向位置大于元素盒模型的宽(width + border + padding)
        // offsetX最大值为offsetWidth,点击事件不考虑margin，超出offsetWidth后鼠标指针已经在元素的实际范围之外，就不是点击这个元素了
        table.rows[0].cells[i].onmousedown = function () {
            resizingCell = this;    //记录下当前更改宽度的Table Cell,避免快速移动鼠标导致event指向改变的问题
            // offsetX：距离元素左上角的横向位置      offsetWidth = width + border + padding
            // offsetWidth-10表示元素实际范围的最右侧往左10px范围内拖动都有效，->那么应该有个mousemove时间来改变指针样式，好区分这一小段区域
            if (event.offsetX > resizingCell.offsetWidth - 10) {
                resizingCell.mouseDown = true;  // 自定义一个属性来记录元素的按压状态
                resizingCell.oldX = event.x;    // 这个x是什么?->相对于父级relative元素的位置，也就是说，定位的元素未设置relative时，同clientX,即返回相对于客户端（显示区域）的横向位置，设置了relative则返回事件对象的相对于本体的坐标？？？
                resizingCell.oldWidth = resizingCell.offsetWidth;
            }
        };
        table.rows[0].cells[i].onmouseup = function () {
            if (resizingCell === undefined) {
                resizingCell = this;
            }
            resizingCell.mouseDown = false;
            resizingCell.style.cursor = 'default';
        };
        table.rows[0].cells[i].onmousemove = function () {
            // 改变指针样式+改变宽度 event.offsetX必定<this.offsetWidth,超出之后event.offsetX就是相对于其他元素了，那么this也随之变为对应的其他元素
            if (event.offsetX > this.offsetWidth - 10) {
                if (this.style.cursor !== 'col-resize') {
                    this.style.cursor = 'col-resize';
                }
            } else {
                if (this.style.cursor !== 'default') {
                    this.style.cursor = 'default';
                }
            }
            // 记录当前要改变宽度的元素
            // if(resizingCell === undefined){
            //     resizingCell = this;
            // }
            var currentCell = this;
            // 调整宽度,->随着mousemove事件宽度也一直在改变
            // 鼠标滑动时，如果mouseDown记录了当前元素是按压着的状态，就把元素的宽度设置为当前指针距离元素左上角的横向宽度，但是这样指针不是很容易就超出元素实际范围了吗？->所以给了10px的有效区域作为缓冲，让元素的宽度紧跟着改变
            if (currentCell.mouseDown !== undefined && currentCell.mouseDown === true) {
                // if (currentCell.oldWidth < event.x - currentCell.oldX) {
                //
                // }
                currentCell.style.width = event.offsetX;
            }
            // 找到此元素所在的table，改变table中与此元素同一列的其他元素的宽度
            var temp = currentCell;
            while (temp.tagName !== 'TABLE') {
                temp = temp.parentElement;
            }
            table = temp;
            for (var j = 1; j < table.rows.length; j++) {
                table.rows[j].cells[currentCell.cellIndex].style.width = currentCell.width;
            }
        }
    }
}

// var resizeTh = function (currentCell) {
//
// };
// var resizeTd = function () {
//
// };