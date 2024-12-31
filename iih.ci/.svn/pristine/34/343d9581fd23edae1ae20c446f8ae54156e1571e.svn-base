package iih.ci.ord.s.bp;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.Docornur;
import iih.bd.srv.mrctmca.i.IMrctmcaMDORService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import iih.ci.mrqc.cimrtaskdto.i.ICiMrTaskService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class GetCiMr4DiagTreatBP {
	/**
	 * 获取病历文书信息
	 * @throws BizException 
	 */
	public Map<String,FArrayList2> exe(String id_en,FDateTime start,FDateTime end) throws BizException{
		Map<String,FArrayList2> map=new HashMap<String, FArrayList2>();
		FArrayList2 fa1=new FArrayList2();
		FArrayList2 fa2=new FArrayList2();
		FArrayList2 fa3=new FArrayList2();
		IMrctmcaMDORService caservice=ServiceFinder.find(IMrctmcaMDORService.class);
		ICiemrRService ciemservice=ServiceFinder.find(ICiemrRService.class);
		IMrtaskRService mrtaskservice=ServiceFinder.find(IMrtaskRService.class);
		MrCtmCaDO[] mrcas=caservice.find(" code_entp='10' and docornur='"+Docornur.DOCTOR+"'", null, FBoolean.FALSE);
		CiMrDO[] cimrs=ciemservice.find(" id_ent='"+id_en+"' and dt_rd>='"+start+"' and dt_rd<='"+end+"'", null, FBoolean.FALSE);
		MrTaskDO[] tasks=mrtaskservice.find(" id_ent='"+id_en+"' and dt_begin>='"+start+"' and dt_begin<='"+end+"' and nvl(Sd_mrtask_sta,'~')<>'01' and nvl(Sd_mrtask_sta,'~')<>'02'", null, FBoolean.FALSE);
		if(mrcas!=null && mrcas.length>0)
		Collections.addAll(fa1, mrcas);
		if(cimrs!=null && cimrs.length>0)
		Collections.addAll(fa2, cimrs);
		if(tasks!=null&&tasks.length>0)
			Collections.addAll(fa3, tasks);
		map.put("CiMrDO", fa2);
		map.put("MrCtmCaDO", fa1);
		map.put("MrTaskDO", fa3);
		return map;
	}

}
