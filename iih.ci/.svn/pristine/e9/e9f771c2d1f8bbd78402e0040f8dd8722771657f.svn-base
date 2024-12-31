package iih.ci.ord.s.ems.op.ems.deforder;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class DefaultRisCreateOrderInfo extends DefaultSetCreateOrderInfo {
	
	
	
	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		OrderPackageInfo[] szOrderPakageInfo =  super.createOrderPakageInfo(ctx, szParam);
//		获取检验申请单id_srv与agg对应map
		Map<String,OrdApObsDO> ordApLabDOMap=new HashMap<String,OrdApObsDO>();
		MedSrvRisDO[] srvlisdos= ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValStrings("Id_srv", 
				new DefaultCreateParamList(szParam).asIdSrvArray());

		if(srvlisdos!=null){
			for(MedSrvRisDO srvlis:srvlisdos){
				ordApLabDOMap.put(srvlis.getId_srv(), assembleOrderRisInfo(srvlis));
			}
		}
		
		//放回检验申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			String id_srv=info.getOrderInfo().getId_srv();
			if(ordApLabDOMap.containsKey(id_srv)){
				ObjectList appSheetList=new ObjectList();
				OrdApObsDO ordApLabDO = ordApLabDOMap.get(id_srv);
				ordApLabDO.setId_or(info.getOrderInfo().getId_or());
				appSheetList.add(ordApLabDO);
				info.setOrderAppSheetList(appSheetList);
			}else if(FBoolean.TRUE.equals(info.getMainSrvInfo().getFg_set())){
				ObjectList appSheetList=new ObjectList();
				OrdApObsDO ordApLabDO = assembleOrderRisInfo(new MedSrvRisDO());
				ordApLabDO.setId_or(info.getOrderInfo().getId_or());
				appSheetList.add(ordApLabDO);
				info.setOrderAppSheetList(appSheetList);
			}
		}

		return szOrderPakageInfo;
	}

	

	/**
	 * 生成检查申请单DO模型对象
	 * @param srvris
	 * @return
	 */
	
	public OrdApObsDO assembleOrderRisInfo(MedSrvRisDO srvris){
		OrdApObsDO ordris=new OrdApObsDO();
		ordris.setStatus(DOStatus.NEW);
		ordris.setId_orobs(this.generatePks());//医嘱检查申请单主键标识	
//		ordris.setId_or(orderInfo.getId_or());//医嘱	
//		ordris.setId_di();//临床诊断	
//		ordris.setName_diag();//诊断名称	
//		ordris.setStr_code_di();//诊断编码拼接
//		ordris.setStr_name_di();//诊断名称拼接
//		ordris.setNo_applyform();//申请单号	
//		ordris.setDt_plan();//计划检查日期	
//		ordris.setBiopsy();//检查组织描述	
//		ordris.setDes_sympsign();//病情描述	
//		ordris.setClinicalzztz();//临床症状及体征
//		ordris.setPastillness();//既往病史	
//		ordris.setAuximtexam();//其它检查所见
//		ordris.setFg_urgent();//加急标识	
		ordris.setAnnouncements	(srvris.getNote());//注意事项	
//		ordris.setId_pps(srvris.getid);//检查目的	
//		ordris.setSd_pps();//检查目的编码	
//		ordris.setDes_pps();//检查目的描述	
		ordris.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);//检查申请状态	
		ordris.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);//
//		ordris.setStr_id_diitm();//临床诊断Id字符串	
//		ordris.setId_diitm();//诊断子项id	
//		ordris.setFg_prn();//打印标识	
//		ordris.setCnt_prn();//打印次数	
//		ordris.setId_body(srvris.getId_body());//检查部位	
//		ordris.setSd_body(srvris.getSd_body());//检查部位编码
//		ordris.setId_pos(srvris.getId_pos());//检查体位	
//		ordris.setSd_pos(srvris.getSd_pos());//检查体位编码
//		ordris.setFg_mp_bed();//床旁执行标识
		return ordris;
	}
	
}
