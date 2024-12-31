package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.external.blood.ruimei.d.PatIpcodeParam;
import iih.ci.ord.external.blood.ruimei.d.Patientinfo;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class QueryPatientInfo8IpCodeBp {
	
	public Patientinfo[] exec( PatIpcodeParam ipcodeParam) throws BizException {
		
		if(ipcodeParam.getTimesip()==null||ipcodeParam.getTimesip().trim().length()==0)
			ipcodeParam.setTimesip("0");
		// 1.查询数据
		Patientinfo[] rtnDatas = queryPatientData(ipcodeParam);
		if(rtnDatas==null||rtnDatas.length==0)
			throw new BizException("未查询到患者住院信息");
//		if(rtnDatas.length>1)
//			throw new BizException("查询到多条患者住院信息");
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[]  visitDOS = service.find("code = '" + rtnDatas[0].getCode() + "' and code_entp = '"
				+ IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' and fg_ip = '" + FBoolean.TRUE + "'", null, FBoolean.FALSE);
		if(visitDOS==null||visitDOS.length==0)
			throw new BizException("未查询到就诊信息");
		IEntdiRService  endiservice = ServiceFinder.find(IEntdiRService .class);
		EntDiDO[] endis=endiservice.find(" id_ent='"+visitDOS[0].getId_ent()+"'", "", FBoolean.FALSE);
		if(endis!=null) {
			FArrayList fa=new FArrayList();
			for (EntDiDO entDiDO : endis) {
				Map<String,String> map=new HashMap<>();
				map.put("name", entDiDO.getName_didef_dis());
				map.put("synname", entDiDO.getName_didef_syn());
				map.put("sd_ditp", entDiDO.getSd_ditp());
				map.put("code", entDiDO.getCode_didef_dis());
				map.put("sd_cdsystp", entDiDO.getSd_cdsystp());
				fa.add(map);
				if(entDiDO.getFg_maj()!=null&&entDiDO.getFg_maj().booleanValue()) {
					rtnDatas[0].setDiagcode(entDiDO.getCode_didef_dis());
					rtnDatas[0].setDiagname(entDiDO.getName_didef_dis());
					rtnDatas[0].setDiagtype(entDiDO.getSd_ditp());
					rtnDatas[0].setMaindiagflag("Y");
				}
			}
			rtnDatas[0].setDiagsarr(fa);
		}
		return rtnDatas;
	}

	/**
	 * 查询数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private Patientinfo[] queryPatientData( PatIpcodeParam ipcodeParam) throws BizException {
		Patientinfo[] patientinfos = null;
		if (ipcodeParam != null) {
			QueryPatientData8IpCodeSql sql = new QueryPatientData8IpCodeSql(ipcodeParam.getIpcode(), ipcodeParam.getTimesip());
			patientinfos = (Patientinfo[]) AppFwUtil.getDORstWithDao(sql, Patientinfo.class);
		}
		return patientinfos;
	}

}
