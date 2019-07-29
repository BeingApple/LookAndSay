package com.beingapple;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("시작할 숫자를 입력하세요(0 < R < 100) : ");
        int startNumber = Integer.parseInt(scan.nextLine());

        while(startNumber >= 100 || startNumber <= 0){
            System.out.print("범위 내의 숫자를 입력하세요 : ");
            startNumber = Integer.parseInt(scan.nextLine());
        }

        System.out.print("몇 번째 줄의 수열을 확인하시겠습니까? : ");
        int lineNumber = Integer.parseInt(scan.nextLine());

        while(lineNumber > 25 || lineNumber <= 0){
            System.out.print("범위 내의 숫자를 입력하세요 : ");
            lineNumber = Integer.parseInt(scan.nextLine());
        }

	    LookAndSay lookAndSay = new LookAndSay(startNumber, lineNumber);
        Iterator<Integer> result = lookAndSay.makeLookAndSay();


        StringBuffer buffer = new StringBuffer();
        while(result.hasNext()){
            buffer.append(result.next());
        }
        System.out.println(buffer);
    }
}
