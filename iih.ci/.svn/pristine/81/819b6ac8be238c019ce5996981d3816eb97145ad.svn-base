package iih.ci.ord.s.bp.validate.gj;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/*
 * 服务开立权限检查操作BP
 */
public class OrSrvDoctorRtValidateBP {
	private static final String ERR_MSG = "你没有%s项目签署权限(属于%s权限)，[%s]医嘱签署失败！";

	/**
	 * 服务开立权限检查
	 * 
	 * @param aggors
	 * @throws BizException
	 */
	public FMap2 exec(CiorderAggDO[] aggors) throws BizException {
		// 有效性校验
		if (CiOrdUtils.isEmpty(aggors))
			return null;

		// 参数设置
		Hashtable<Integer, String> orindexht = new Hashtable<Integer, String>();
		SrvRtCtlParam rtctlparam = createRtCtlParam(aggors, orindexht);
		if (CiOrdUtils.isEmpty(rtctlparam))
			return null;

		// 获得医嘱未授权服务项目开立权限信息
		SrvRtCtlDTO[] orsrvrtinfos = CiOrdAppUtils.getBdSrvQryQryService().getUnAuthorizedSrvRtCtlInfo(rtctlparam);
		if (CiOrdUtils.isEmpty(orsrvrtinfos))
			return null;
		//
		// 抛医嘱项目未授权错误信息
		return getErrMsg(orsrvrtinfos, aggors, orindexht);

	}

	/**
	 * 获得异常信息
	 * 
	 * @param orsrvrtinfos
	 * @param aggors
	 * @param orindexht
	 * @return
	 */
	private FMap2 getErrMsg(SrvRtCtlDTO[] orsrvrtinfos, CiorderAggDO[] aggors, Hashtable<Integer, String> orindexht)throws BizException {
		FMap2 map = new FMap2();
		String errrtn = "";
		String id_srv = null;
		String tm = "";
		ArrayList<Integer> orindexes = null;
		List<String> idorlist = new ArrayList<String>();
		for (int i = 0; i < orsrvrtinfos.length; i++) {
			id_srv = orsrvrtinfos[i].getId_srv();
			orindexes = getOrIndexes(id_srv, orindexht);
			if (CiOrdUtils.isEmpty(orindexes))
				continue;
			idorlist.add(aggors[orindexes.get(0)].getParentDO().getId_or());
			tm = getMsgStr(orsrvrtinfos[i], aggors, orindexes, id_srv);
			if (CiOrdUtils.isEmpty(tm))
				continue;
			errrtn += tm;
		}
		if (errrtn != "") {
			map.put("ErrMsg", errrtn);
		}
		if (idorlist.size() != 0) {
			map.put("UnCheckIdors", CiOrdUtils.array2FArrayList(idorlist.toArray(new String[idorlist.size()])));// ??????
		}
		return map;
	}
	
	/**
	 * 服务开立权限检查
	 * 
	 * @param aggors
	 * @throws BizException
	 */
	public String exec4Ip(CiorderAggDO[] aggors) throws BizException {
		// 有效性校验
		if (CiOrdUtils.isEmpty(aggors))
			return null;

		// 参数设置
		Hashtable<Integer, String> orindexht = new Hashtable<Integer, String>();
		SrvRtCtlParam rtctlparam = createRtCtlParam(aggors, orindexht);
		if (CiOrdUtils.isEmpty(rtctlparam))
			return null;

		// 获得医嘱未授权服务项目开立权限信息
		SrvRtCtlDTO[] orsrvrtinfos = CiOrdAppUtils.getBdSrvQryQryService().getUnAuthorizedSrvRtCtlInfo(rtctlparam);
		if (CiOrdUtils.isEmpty(orsrvrtinfos))
			return null;
		//
		// 抛医嘱项目未授权错误信息
		return getErrMsg4Ip(orsrvrtinfos, aggors, orindexht);

	}

	/**
	 * 获得异常信息
	 * 
	 * @param orsrvrtinfos
	 * @param aggors
	 * @param orindexht
	 * @return
	 */
	private String getErrMsg4Ip(SrvRtCtlDTO[] orsrvrtinfos, CiorderAggDO[] aggors, Hashtable<Integer, String> orindexht)
			throws BizException {
		String errrtn = "";
//		List<String> idorlist = new ArrayList<String>();
		for (int i = 0; i < orsrvrtinfos.length; i++) {
			String id_srv = orsrvrtinfos[i].getId_srv();
			ArrayList<Integer> orindexes = getOrIndexes(id_srv, orindexht);
			if (CiOrdUtils.isEmpty(orindexes))
				continue;
//			idorlist.add(aggors[orindexes.get(0)].getParentDO().getId_or());
			String tm = getMsgStr(orsrvrtinfos[i], aggors, orindexes, id_srv);
			if (CiOrdUtils.isEmpty(tm))
				continue;
			errrtn += tm;
		}
//		if (errrtn != "") {
//			map.put("ErrMsg", errrtn);
//		}
//		if (idorlist.size() != 0) {
//			map.put("UnCheckIdors", CiOrdUtils.array2FArrayList(idorlist.toArray(new String[idorlist.size()])));
//		}
		return errrtn;
	}

	/**
	 * 获得异常信息
	 * 
	 * @param orsrvrt
	 * @param aggors
	 * @param orindexes
	 * @param id_srv
	 * @return
	 */
	private String getMsgStr(SrvRtCtlDTO orsrvrt, CiorderAggDO[] aggors, ArrayList<Integer> orindexes, String id_srv) throws BizException{
		String errrtn = "";
		CiorderAggDO aggdo = null;
		String[] srvname = null;
		for (int j = 0; j < orindexes.size(); j++) {
			aggdo = aggors[orindexes.get(j)];
			srvname = getSrvName(aggdo, id_srv);
			if (CiOrdUtils.isEmpty(srvname))
				continue;
			errrtn += String.format(ERR_MSG, srvname[0], orsrvrt.getName(), aggdo.getParentDO().getName_or()+"("+srvname[1]+")")
					+ CiOrdUtils.CRLF;
		}
		return errrtn;
	}

	/**
	 * 获得医疗服务名称
	 * 
	 * @param agg
	 * @param id_srv
	 * @return
	 */
	private String[] getSrvName(CiorderAggDO agg, String id_srv)throws BizException {
		OrdSrvDO[] srvdos = agg.getOrdSrvDO();
		String[] NameSrvAndMM = new String[2];
		if (CiOrdUtils.isEmpty(srvdos))
			return null;
		for (int i = 0; i < srvdos.length; i++) {
			if (id_srv.equals(srvdos[i].getId_srv())) {
				NameSrvAndMM[0] = srvdos[i].getName_srv();
				NameSrvAndMM[1] = getCiOrSrvMM(srvdos[i].getId_orsrv());
				return NameSrvAndMM;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
    private String getCiOrSrvMM(String id_orsrv)throws BizException{
    	if(id_orsrv != null){
    		String  whereStr = "id_orsrv ='"+id_orsrv+"'";
    		OrdSrvMmDO[]  ordsrvMM = CiOrdAppUtils.getOrSrvMmQryService().find(whereStr, "", FBoolean.FALSE);
    	    if(ordsrvMM != null && ordsrvMM.length >0){
    	    	return  ordsrvMM[0].getName_mm();
    	    }
    	}
    	return "";
    }
	
	/**
	 * 获得为开立项目对应的医嘱集合
	 * 
	 * @param id_srv
	 * @param orindexht
	 * @return
	 */
	private ArrayList<Integer> getOrIndexes(String id_srv, Hashtable<Integer, String> orindexht) {
		String orsrvidstr = "";
		ArrayList<Integer> rtn = new ArrayList<Integer>();
		for (Integer key : orindexht.keySet()) {
			orsrvidstr = orindexht.get(key);
			if (CiOrdUtils.isInStr(id_srv, orsrvidstr)) {
				rtn.add(key);
			}
		}
		return rtn;
	}

	private String grpid = null; //集团id
	private String orgid = null; //组织id
	private String empid = null; //人员id

	/**
	 * 创建医嘱开立服务权限检查入口参数
	 * 
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private SrvRtCtlParam createRtCtlParam(CiorderAggDO[] aggors, Hashtable<Integer, String> orindexht) throws BizException {
		String id_srvs = getIdSrvs(aggors, orindexht);
		String id_mms = getIdMms(aggors);
		if (CiOrdUtils.isEmpty(id_srvs) && CiOrdUtils.isEmpty(id_mms))
			return null;
		setCommonData();
		SrvRtCtlParam param = new SrvRtCtlParam();
		param.setId_org(orgid);
		param.setId_entp(aggors[0].getParentDO().getId_entp());
		param.setId_emp_doctor(empid);
		param.setId_srvs(id_srvs);
		param.setId_mms(id_mms);
		return param;
	}
	//签署的物品Id_mm需要用Id_or查出来
	private String getIdMms(CiorderAggDO[] aggors) throws DAException 
	{
		
		String id_ors ="";
		OrdSrvDO[] orsrvs = null;
		//组装入参
		for (int i = 0; i < aggors.length; i++) {
			orsrvs = aggors[i].getOrdSrvDO();
			if (CiOrdUtils.isEmpty(orsrvs))
				continue;
			id_ors += (getIdOrs(orsrvs));
		}
		if(CiOrdUtils.isEmpty(id_ors))return null;
		id_ors = id_ors.substring(0,id_ors.length()-1);
		//查询对应的Id_mm
		List<Map<String, Object>> mmMap = getmmMap(id_ors);
		String ormms ="";
		for (Map<String, Object> map : mmMap) {
			for (Map.Entry<String,Object> e : map.entrySet()) {
				ormms += e.getValue().toString() + CiOrdUtils.COMMA_STR;
			}	
		}
		
		if(CiOrdUtils.isEmpty(ormms))return null;
		return ormms.substring(0,ormms.length()-1);
	}

	/**
	 * @code Id_ors查出Id_mm放到Map集合
	 * @author LiYue
	 * @param id_ors
	 * @return
	 * @throws DAException
	 */
	private List<Map<String, Object>> getmmMap(String id_ors) throws DAException {
		String sql = getId_mmSql(id_ors);
		List<Map<String, Object>> queryResult = (List<Map<String, Object>>) new DAFacade().execQuery(sql, new MapListHandler());		
		return queryResult;
	}

	private String getId_mmSql(String id_ors) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select id_mm from CI_OR_SRV srv INNER JOIN ci_or_srv_mm srvmm on srvmm.id_orsrv = srv.ID_ORSRV ");
		sb.append(String.format("where srv.id_or in (%s)", id_ors));
		return sb.toString();
	}

	/**
	 * 获得医嘱项目信息
	 * 
	 * @param aggors
	 * @return
	 */
	private String getIdSrvs(CiorderAggDO[] aggors, Hashtable<Integer, String> orindexht) {
		String rtn = "";
		OrdSrvDO[] orsrvs = null;
		String srvstr = "";
		for (int i = 0; i < aggors.length; i++) {
			orsrvs = aggors[i].getOrdSrvDO();
			if (CiOrdUtils.isEmpty(orsrvs))
				continue;
			srvstr = getOrSrvs(orsrvs);
			if (CiOrdUtils.isEmpty(srvstr))
				continue;
			orindexht.put(i, srvstr);
			rtn += CiOrdUtils.COMMA_STR + srvstr;
		}
		if (CiOrdUtils.isEmpty(rtn))
			return rtn;
		return rtn.substring(1, rtn.length());
	}

	/**
	 * 获得医嘱项目串
	 * 
	 * @param orsrvs
	 * @return
	 */
	private String getOrSrvs(OrdSrvDO[] orsrvs) {
		String rtn = "";
		for (int j = 0; j < orsrvs.length; j++) {
			if (!OrSrvSplitUtil.isTrue(orsrvs[j].getFg_or()))
				continue;
			rtn += CiOrdUtils.COMMA_STR + orsrvs[j].getId_srv();
		}
		if (CiOrdUtils.isEmpty(rtn))
			return "";
		return rtn.substring(1);
	}

	/**
	 * 获得医嘱编码串
	 * 
	 * @param orsrvs
	 * @return
	 */
	private String getIdOrs(OrdSrvDO[] orsrvs) {
		String rtn = "";
		for (int j = 0; j < orsrvs.length; j++) {
			if (!OrSrvSplitUtil.isTrue(orsrvs[j].getFg_or()))
				continue;
			rtn += CiOrdUtils.SQUOTE_MARK_STR + orsrvs[j].getId_or() + CiOrdUtils.SQUOTE_MARK_STR + CiOrdUtils.COMMA_STR;
		}
		return rtn;
	}
	
	/**
	 * 设置公共数据信息
	 * 
	 * @throws BizException
	 */
	private void setCommonData() throws BizException {
		grpid = CiOrdAppUtils.getEnvContext().getGroupId(); //集团id
		orgid = CiOrdAppUtils.getEnvContext().getOrgId(); //组织id
		empid = CiOrdAppUtils.getEnvContext().getUserId(); //人员id
		empid = CiOrdUtils.getPsnDocID(empid);
	}
}
