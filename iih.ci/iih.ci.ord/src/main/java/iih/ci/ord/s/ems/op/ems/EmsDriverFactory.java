package iih.ci.ord.s.ems.op.ems;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.s.ems.base.BaseEmsDriver;
import iih.ci.ord.s.ems.base.IOrderEmsDriver;
import iih.ci.ord.s.ems.op.ems.apbt.EmsApBtDriver;
import iih.ci.ord.s.ems.op.ems.apbu.EmsApBuDriver;
import iih.ci.ord.s.ems.op.ems.cons.EmsConsDriver;
import iih.ci.ord.s.ems.op.ems.drugs.EmsDrugsDriver;
import iih.ci.ord.s.ems.op.ems.herbs.EmsHerbsDriver;
import iih.ci.ord.s.ems.op.ems.lis.EmsLisDriver;
import iih.ci.ord.s.ems.op.ems.opr.EmsOprDriver;
import iih.ci.ord.s.ems.op.ems.pathgy.EmsPathgyDriver;
import iih.ci.ord.s.ems.op.ems.ris.EmsRisDriver;
import iih.ci.ord.s.ems.op.ems.treat.EmsTreatDriver;

public class EmsDriverFactory {
	private static EmsDriverFactory instance = new EmsDriverFactory();
	private Map<String,BaseEmsDriver> mapDriver=new HashMap<String,BaseEmsDriver>();
	
	private EmsDriverFactory(){
		
	}
	
	/**
	 * 临时方法 -- 应该从医疗单维护中获取
	 */
	private void initReg(){
		mapDriver.put(EmsType.COMMONDRUG.toString(), new EmsDrugsDriver()) ; //通用药品
		mapDriver.put( EmsType.RIS.toString(), new EmsRisDriver()) ; //检查
		mapDriver.put( EmsType.LIS.toString(), new EmsLisDriver()) ; //检验
		mapDriver.put( EmsType.IV.toString(), new EmsDrugsDriver()) ; //Iv药
		mapDriver.put( EmsType.HERB.toString(), new EmsHerbsDriver()) ; //草药
		mapDriver.put( EmsType.OPER.toString(), new EmsOprDriver()) ; //手术
		mapDriver.put( EmsType.PATHGY.toString(), new EmsPathgyDriver()) ; //病理
		mapDriver.put( EmsType.BT.toString(), new EmsApBtDriver()) ; //备血
		mapDriver.put( EmsType.COMMON.toString(), new EmsTreatDriver()) ; //简洁
		mapDriver.put( EmsType.CONS.toString(), new EmsConsDriver()) ; //会诊
//		mapDriver.put( EmsType.SKINTEST.toString(), new EmsDrugsDriver()) ; //皮试医疗单
		mapDriver.put( EmsType.BTUSE.toString(), new EmsApBuDriver()) ; //用血
//		mapDriver.put( EmsType.TRANSDEPT.toString(), new EmsDrugsDriver()) ; //转科
//		mapDriver.put( EmsType.OUTHOSP.toString(), new EmsDrugsDriver()) ; //出院
//		mapDriver.put( EmsType.TRANSWARD.toString(), new EmsDrugsDriver()) ; //转病区
	}
	
	public static EmsDriverFactory GetInstance(){
		instance.initReg();
		return instance;
	}
	
	public BaseEmsDriver find(String et){
		BaseEmsDriver drv = mapDriver.get(et);
		return  drv;
	}
}
