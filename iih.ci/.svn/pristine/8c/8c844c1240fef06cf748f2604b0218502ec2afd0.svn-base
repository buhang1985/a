package iih.ci.ord.specanti.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.SqlConditionsParameter;
import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;

import iih.ci.ord.specanti.d.SpecAntiParamDTO;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 特殊级抗菌药判断，判断耀皮是否是特殊级抗菌药，如果是，判断审核走到哪一步了
 * @author zhangwq
 *
 */
public class SpecAntiJudgeBP {
	public SpecAntiParamDTO[] exec(SpecAntiParamDTO[] params) throws BizException{
		if(params==null&&params.length==0){
			return null;
		}
		List<String> idsrvs = getIdsrvs(params);
		if(idsrvs==null||idsrvs.size()==0){
			return null;
		}
		List<MedSrvDO> specAntiSrvs = new ArrayList<MedSrvDO>();
		//先通过药品服务的药品属性判断是不是属于特殊级抗菌药
		List<MedSrvDO> srvdos= getSrvDrugs(idsrvs);
		if(srvdos!=null&&srvdos.size()>0){
			specAntiSrvs.addAll(srvdos);
		}
		if(srvdos==null||srvdos.size()!=params.length){
			//获得自定义服务药品维护的碳青霉烯类抗菌药及替加环素
			List<String> idmms = getIdmms(params,srvdos);
			if(idmms!=null&&idmms.size()>0){
				List<MedSrvDO> carbapenemSrvs = getCarbapenemSrvs(idmms);
				if(carbapenemSrvs != null && carbapenemSrvs.size()>0){
					specAntiSrvs.addAll(carbapenemSrvs);
				}
			}
		}
		//存在特抗药
		if(specAntiSrvs.size()>0){
			List<SpecAntiParamDTO> paramRsts = new ArrayList<SpecAntiParamDTO>();
			List<String> id_srvs = new ArrayList<String>();
			for (MedSrvDO medsrv : specAntiSrvs) {
				if(!id_srvs.contains(medsrv.getId_srv())){
					id_srvs.add(medsrv.getId_srv());
				}
			}
			Map<String,SpecantionApplyDTO> specAntiMap = hasApprovaled(params[0].getId_en(),id_srvs.toArray(new String[0]));
			//-1：该就诊患者，在相应的业务线，没有该特抗药的申请；0：存在特抗药申请单，但流程没有走完；1：存在特抗药申请单，流程走完；
			for (MedSrvDO medsrv : specAntiSrvs) {
				SpecAntiParamDTO param = new SpecAntiParamDTO();
				if(specAntiMap==null||!specAntiMap.containsKey(medsrv.getId_srv())){
					param.setRstCode("-1");
					param.setInfo("药品" + medsrv.getName() + "为特殊使用级抗菌药，需要审批才可签署，是否发起抗菌药专家会诊审批？");
					paramRsts.add(param);
				}else{
					SpecantionApplyDTO applydto = specAntiMap.get(medsrv.getId_srv());
					if(!"0".equals(applydto.getSd_approve_meddep())) {
						param.setRstCode("0");
						param.setInfo("药品" + "《" + medsrv.getName() + "》已经发起了特抗药申请，需要审批才可签署！");
						paramRsts.add(param);
					}
				}
			}
			if(paramRsts.size()>0){
				return paramRsts.toArray(new SpecAntiParamDTO[0]);
			}
		}
		return null;
	}
	/**
	 * 判断特抗药的审批结果
	 * @param id_en
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public Map<String,SpecantionApplyDTO> hasApprovaled(String id_en, String[] Id_srv) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct capac.sd_approve_meddep,srv.id_srv as id_orsrv from ci_ap_spec_anti_cons capac ")
		.append(" inner join ci_or_srv srv on srv.id_or = capac.id_or")
		.append(" inner join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv ")
		.append(" where capac.fg_approve_meddep = 'Y' and @id_en and @Id_srv");
		SqlConditionsParameter sp = new SqlConditionsParameter(sb.toString());
		sp.replaceSqlParam("@id_en", "srv.id_en", id_en)
		.replaceSqlInParam("@Id_srv", "srv.Id_srv", Id_srv);
		List<SpecantionApplyDTO> rstList = DatabaseUtils.Q(sp, SpecantionApplyDTO.class);
		if(rstList!=null && rstList.size()>0){
			Map<String,SpecantionApplyDTO> map = new HashMap<String,SpecantionApplyDTO>();
			for (SpecantionApplyDTO specantionApplyDTO : rstList) {
				map.put(specantionApplyDTO.getId_orsrv(), specantionApplyDTO);
			}
			return map;
		}
		return null;
//		if(rstList != null && rstList.size() > 0) {
//			for(SpecantionApplyDTO item : rstList) {
//				// 只要 存在医务科 审核过的 特抗药，则返回 不用重新申请
//				if("0".equals(item.getSd_approve_meddep())) {
//					return 1;
//				}
//			}
//			return 0;
//		}
//		return -1;
	}
	/**
	 * 已经通过服务判断出是特抗药的服务排除，取出未判断出的物品id，然后通过自定义服务药品维护的碳青霉烯类抗菌药及替加环素来判断
	 * @param params
	 * @param srvdos
	 * @return
	 */
	private List<String> getIdmms(SpecAntiParamDTO[] params, List<MedSrvDO> srvdos) {
		List<String> idmms = new ArrayList<String>();
		List<String> idsrvs = new ArrayList<String>();
		for (MedSrvDO medSrvDO : srvdos) {
			if(!idsrvs.contains(medSrvDO.getId_srv())){
				idsrvs.add(medSrvDO.getId_srv());
			}
		}
		M:for(SpecAntiParamDTO param : params){
			String id_srv = param.getId_srv();
			if(!idsrvs.contains(id_srv)){
				idmms.add(param.getId_mm());
			}
		}
		return idmms;
	}
	private List<String> getIdsrvs(SpecAntiParamDTO[] params){
		List<String> idsrvs = new ArrayList<String>();
		for(SpecAntiParamDTO param : params){
			if(!idsrvs.contains(param.getId_srv())){
				idsrvs.add(param.getId_srv());
			}
		}
		return idsrvs;
	}
	 /**
	  * 查询特殊级抗菌药
	  * @param idsrvs
	  * @return
	  * @throws DAException
	  */
	private List<MedSrvDO> getSrvDrugs(List<String> idsrvs) throws DAException{
		String sql = "select srv.id_srv,name from bd_srv_drug drug inner join bd_srv srv on drug.id_srv = srv.id_srv where (";
		sql+=SqlUtils.getInSqlByIds("srv.id_srv",idsrvs);
		sql+=")";
		sql += " and sd_anti = '3'";//特殊级抗菌药
		List<MedSrvDO> srvdrugs = (List<MedSrvDO>) new DAFacade().execQuery(sql, new BeanListHandler(MedSrvDO.class));
		return srvdrugs;
	}
	/**
	 * 获得自定义服务药品维护的碳青霉烯类抗菌药及替加环素的服务
	 * @param idmms
	 * @return
	 * @throws BizException
	 */
	private List<MedSrvDO> getCarbapenemSrvs(List<String> idmms) throws BizException{
		String carbapenem =  ParamsetQryUtil.getParaString(Context.get().getOrgId(),
				ICiOrdNSysParamConst.SYS_PARAM_CARBAPENEM);
		if(StringUtils.isNullOrEmpty(carbapenem)){
			return null;
		}
		carbapenem = carbapenem.replaceAll("，", ",");
		StringBuilder sb = new StringBuilder();
		sb.append("select mm.id_srv,mm.name from BD_MMCA_US_ITM_REL rel ");
		sb.append("inner join BD_MMCA_US_ITM itm on rel.id_mmcausitm = itm.id_mmcausitm ");
		sb.append("inner join bd_mm mm on rel.id_mmorca = mm.id_mm ");
		sb.append("where itm.id_org=? ");
		sb.append(" and ("+SqlUtils.getInSqlByIds("itm.code",carbapenem.split(","))+")");
		sb.append(" and ("+SqlUtils.getInSqlByIds("mm.id_mm",idmms)+")");
		SqlParam p=new SqlParam();
		p.addParam(Context.get().getOrgId());
		List<MedSrvDO> srvdrugs = (List<MedSrvDO>) new DAFacade().execQuery(sb.toString(),p, new BeanListHandler(MedSrvDO.class));
		return srvdrugs;
	}
}
