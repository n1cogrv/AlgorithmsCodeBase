package leetcode.editor.en;

import java.util.logging.Logger;

//2021-08-26 19:50:11
//java: Rectangle Area
//QuestionId: 223
public class Prbl223RectangleArea{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl223RectangleArea().new Solution();
    }

    /*
    Rec1  TL(ax1, ay2) TR(ax2, ay2)
          BL(ax1, ay1) BR(ax2, ay1)

    Rec2  TL(bx1, by2) TR(bx2, by2)
          BL(bx1, by1) BR(bx2, by1)
     */


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfRec1 = (ax2 - ax1) * (ay2 - ay1);
        int areaOfRec2 = (bx2 - bx1) * (by2 - by1);

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);

        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);

        int areaOfOverlapped = 0;
        if (left < right && bottom < top) {
            areaOfOverlapped = (right - left) * (top - bottom);
        }

        return areaOfRec1 + areaOfRec2 - areaOfOverlapped;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//Given the coordinates of two rectilinear rectangles in a 2D plane, return the 
//total area covered by the two rectangles. 
//
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its 
//top-right corner (ax2, ay2). 
//
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its 
//top-right corner (bx2, by2). 
//
// 
// Example 1: 
//
// 
//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 
//2
//Output: 45
// 
//
// Example 2: 
//
// 
//Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 
//= 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics Math Geometry 👍 630 👎 928
