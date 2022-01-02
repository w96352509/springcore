package com.study.springcore.proxy.dyn;

import java.util.Arrays;

public class MyLogger {
	// 前置通知
		public static void before(Class cls, String methodName, Object[] args) {
			System.out.printf("前置通知: %s %s %s\n", cls, methodName, Arrays.toString(args));
		}
		// 異常通知
		public static void throwing(Class cls, String methodName, Exception e) {
			System.out.printf("異常通知: %s %s %s\n", cls, methodName, e);
			e.printStackTrace(System.err); // 更多細部錯誤揭露
		}
		// 後置通知
		public static void end(Class cls, String methodName, Object result) {
			System.out.printf("後置通知: %s %s %s\n", cls, methodName, result);
		}
}




