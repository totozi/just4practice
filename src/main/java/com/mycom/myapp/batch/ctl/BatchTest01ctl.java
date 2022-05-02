package com.mycom.myapp.batch.ctl;

import com.mycom.myapp.batch.svc.BatchTest01svc;

// insert 10,000 tuples into table the way with batch and nobatch 

public class BatchTest01ctl {
	public static void main(String[] args) {
		int which = 2;
		
		BatchTest01svc svc = new BatchTest01svc();
		try {
			if(which == 1)
				svc.testService();
			else
				svc.nobatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			svc.deleteAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*
 * === result (sec) ===
 * batch 
 * 1.09
 * 1.044
 * 1.024
 * 1.031
 * 
 * nobatch
 * 1.802
 * 1.745
 * error
 * 1.784
 * */
	
	}

}
