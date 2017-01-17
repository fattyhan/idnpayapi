package com.wangyin.idn.wallet.api.security;

/**
 * Created by hanxiaofei on 2016/12/19.
 */
public class RotateUtil {
    /**
     * 左旋一个数组
     * @param arr
     * @param d 偏移量
     * @param n 长度
     */
    private static void leftRotate(int arr[], int d, int n)
    {
        int i;
        for (i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    /**
     *
     * @param arr
     * @param n
     */
    private static void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    /**
     *
     * @param arr
     * @param size
     * @return
     */
    private static String printArray(int arr[], int size)
    {
        int i;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < size; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    /**
     *
     * @param arr
     * @return
     */
    private static String rotater(int arr[],int rt)
    {
        //STEP1 获取偏移量[折半左旋，若非偶数取余]
        int offset = arr.length%2>0?arr.length%2:arr.length/2;
        //STEP2 实施旋转
        if (rt == 0)
              leftRotate(arr, offset, arr.length);
        else
              rightRotate(arr, offset, arr.length);
        return printArray(arr,arr.length);
    }

    /**
     * 旋转字符串，rt:0左旋 !0右旋
     * @param arr
     * @param rt
     * @return
     */
    public String rotateStr(String arr,int rt) {
        //防止重复加一个随机数
        int[] wr = new int[arr.toString().length()];
        for (int i = 0; i < arr.length(); i++) {
            wr[i] = Integer.parseInt(arr.charAt(i)+"");
        }
        return rotater(wr,rt);
    }

    /**
     *
     * @param arr
     * @param d
     * @param n
     */
    private static void rightRotate(int arr[], int d, int n){
        int i;
        for (i = 0; i < d; i++)
            rightRotatebyOne(arr, n);
    }

    /**
     *
     * @param arr
     * @param n
     */
    private static void rightRotatebyOne(int arr[], int n){
        int i, temp;
        temp = arr[n-1];
        for (i = n-1; i > 0; i--)
            arr[i] = arr[i-1];
        arr[i] = temp;
    }
}
