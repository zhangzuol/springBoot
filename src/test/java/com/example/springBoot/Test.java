package com.example.springBoot;


public class Test {

    public static void main(String[] args) {
        Object[] arr = {-1, 0, 1, 2, -1, -4};
        for (int i=0;i<arr.length-2;i++){
            for (int j=i+1;j<arr.length-1;j++){
                int temp = -((int)arr[i]+(int)arr[j]);
                Object[] sub = new Object[arr.length-j-1];
                System.arraycopy(arr,j+1,sub,0,sub.length);
                //判断是否包含
                int index =getIndex(sub,temp);//调用方法
                if(index!=-1){
                    System.out.println("["+arr[i]+","+arr[j]+","+temp+"]");
                }
            }
        }
    }

    public static int getIndex(Object[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;//如果未找到返回-1
    }

}
