package com.java.algorithm.hot100;
import java.util.Arrays;
import java.util.Stack;

public class 单调栈经典题 {

    public static void main(String[] args) {

        /** 
         * 栈顶，是桶的顶部，是数组的尾巴
        * 单调栈：
        * 遇到一个新元素，如果它比栈顶元素小，那就让它入栈，
        * 否则就弹出栈顶元素，直到这个新元素比栈顶元素小，再让它入栈。
        * 这样的话，最终的结果就是栈内的元素是从栈底到栈顶是递减的，
        * 其出栈的顺序就是递增的，这样的栈叫做单调递增栈。
        * 反之，就是单调递减栈
        ******************************
            单调栈主要解决以下问题：
            寻找下一个更大元素
            寻找前一个更大元素
            寻找下一个更小元素
            寻找前一个更小元素
            符合条件窗口的 max/min
            滑动窗口的 max/min
        *******************************
        */


        /*
         * 给一个数组，返回一个大小相同的数组。
         * 对于原数组中的第 i 个元素，至少往右走多少步，才能遇到一个比自己大的元素，
         * 如果之后没有比自己大的元素，或者已经是最后一个元素，则在返回数组的对应位置放上 -1。
         * 输入  [5,3,1,2,4]
         * 输出  [-1 3 1 1 -1]
         */


         /**

            这就需要使用单调栈了。通过单调递增栈的定义，
            每当遇到元素大于栈顶元素时，我们就遇到了一个"大数"。
            这个"大数"比它之前多少个数大我们不知道，但是至少比当前栈顶所对应的数大。
            我们弹出栈内所有对应数比这个数小的栈内元素，
            并更新它们在返回数组中对应位置的值。
            因为这个栈本身的单调性，当栈顶元素所对应的数比这个元素大的时候，
            我们可以保证，栈内所有元素都比这个元素大。
            这种方法可以理解为《沉淀大数》，
            对于每一个元素，当它出栈的时候，说明它遇到了第一个比自己大的元素，
            这样下来，不难理解这个思路：


            for 元素 in 列表:
                while 栈不为空 and 栈顶元素 < 元素：
                    x = 栈顶出栈
                    根据对应业务处理值
                入栈
          */


        int[] input = new int[]{5,3,1,2,4};
        int[] ans = classic(input);
        Arrays.stream(ans).forEach(item->{
            System.out.println(item);
        });
        

    }

    public static int[] classic(int[] input){

        int[] ans = new int[input.length]; //用于存放结果集
        //快速填充数组初始值
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();    

        for (int index = 0; index < input.length; index++) {
            //java没有(item,index)=>{} 用这种方式取代
            int item = input[index];
            //如果item大于栈顶值，我们就将栈顶弹出，大数下沉，单调递增栈
            //那我们什么时候用单调递增栈，什么时候用单调递减栈呢？
            //如果是为了找大数，就用单调递增栈，让大数下沉
            //如果是为了找小数，就用单调递减栈，让小数下沉
            while(!stack.isEmpty() && item > input[(int) stack.peek()] ){
                int x = (int)stack.pop(); //
                System.out.println("pop:"+ x);
                ans[x] = index -x;
            }
            
            stack.push(index);
            System.out.println("push"+index);
        }
        return ans;
    }

    
}
