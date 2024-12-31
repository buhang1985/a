package iih.bl.comm.util;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPiPatHpDORService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BlBaseInfoUtils {
	
	/**
	 * 获取操作员信息
	 * @param code_psn
	 * @throws DAException 
	 */
	public static PsnDocDO getPsnDocDO(String code_psn) throws DAException{
		String[] psn = { "Id_psndoc","Code","Name" };
		@SuppressWarnings("unchecked")
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class, "code='" + code_psn + "' or id_psndoc='" + code_psn + "'",
				"1", psn);
		if (psnList == null || psnList.size() <= 0) {
			return null;
		}
		return psnList.get(0);
	}
	
	/**
	 * 获取医保身份
	 * @param code_hppatca 医保类型编码
	 * @return
	 * @throws BizException 
	 */
	public static BdHpPatcaDO getHpPatcaDO(String code_hppatca) throws BizException{
		IBdHpPatcaDORService ser= ServiceFinder.find(IBdHpPatcaDORService.class);
		BdHpPatcaDO[] bdHpPatcaDO=ser.find("code_hppatca='" + code_hppatca + "'", "", FBoolean.FALSE);
		if (bdHpPatcaDO == null || bdHpPatcaDO.length <= 0) {
			return null;
		}
		return bdHpPatcaDO[0];
	}
	
	/**
	 * 获取患者医保计划
	 * @param id_pat 患者id
	 * @param no_hp 医保卡号
	 * @return
	 * @throws BizException
	 */
	public static PiPatHpDO getPiPatHpDO(String id_pat,String no_hp) throws BizException{
		IPiPatHpDORService ser= ServiceFinder.find(IPiPatHpDORService.class);
		PiPatHpDO[] piPatHpDO=ser.find("id_pat='" + id_pat + "' and substr(no_hp,1,9)=substr('"+no_hp+"',1,9)", "", FBoolean.FALSE);
		if (piPatHpDO == null || piPatHpDO.length <= 0) {
			return null;
		}
		return piPatHpDO[0];
	}
	
	/**
	 * 获取支付信息
	 * @return
	 * @throws BizException 
	 */
	public static Map<String,String> getPmInfo() throws BizException{
		Map<String,String> pmMap= new HashMap<String,String>();
		IPripmRService ser= ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPmDoArr=ser.find("1=1", "", FBoolean.FALSE);
		if(ArrayUtils.isNotEmpty(priPmDoArr)){
			for(PriPmDO priPmDo:priPmDoArr){
				pmMap.put(priPmDo.getId_pm(), priPmDo.getName());
			}
		}
		return pmMap;
	}
	
	/**
	 * 获取支付DO信息
	 * @return
	 * @throws BizException 
	 */
	public static Map<String,PriPmDO> getPmDOInfo() throws BizException{
		Map<String,PriPmDO> pmMap= new HashMap<String,PriPmDO>();
		IPripmRService ser= ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPmDoArr=ser.find("1=1", "", FBoolean.FALSE);
		if(ArrayUtils.isNotEmpty(priPmDoArr)){
			for(PriPmDO priPmDo:priPmDoArr){
				pmMap.put(priPmDo.getId_pm(), priPmDo);
			}
		}
		return pmMap;
	}
	
	/**
	 * 获取支付方式对应的收费类型信息
	 * @return
	 * @throws BizException 
	 */
	public static Map<String,String> getPmTpInfo() throws BizException{
		Map<String,String> pmMap= new HashMap<String,String>();
		IPripmRService ser= ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPmDoArr=ser.find("1=1", "", FBoolean.FALSE);
		if(ArrayUtils.isNotEmpty(priPmDoArr)){
			for(PriPmDO priPmDo:priPmDoArr){
				pmMap.put(priPmDo.getId_pm(), priPmDo.getSd_pmtp());
			}
		}
		return pmMap;
	}
	/**
	 * 获取患者就诊的医保计划
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static EntHpDO getEntHp(String id_ent) throws BizException{
		IEnthpRService ser=ServiceFinder.find(IEnthpRService.class);
		String whereStr="id_ent='"+ id_ent +"' and fg_maj='Y'";
		EntHpDO[] entHpDo= ser.find(whereStr, "", FBoolean.FALSE);
		if(!ArrayUtils.isEmpty(entHpDo)){
			return entHpDo[0];
		}
		return null;
	}
	
	/**
	 * 查询医嘱重复收费项目
	 * @param id_hp 医保计划
	 * @param codeEntp 就诊编码
	 * @return
	 * @throws BizException 
	 */
	public static List<String> getHpDupItmPri(String id_hp,String codeEntp) throws BizException{
		String sWhereCodeEntp="";
		switch (codeEntp){
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP://门诊
			sWhereCodeEntp="fg_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET://急诊
			sWhereCodeEntp="fg_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE://体检
			sWhereCodeEntp="fg_pe";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP://住院
			sWhereCodeEntp="fg_ip";
			break;		
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA://家庭病床
			sWhereCodeEntp="fg_fm";
			break;			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" select id_srv");
		sb.append(" from bd_hp_dup_itm_pri");
		sb.append(" where id_hp=?");
		sb.append(" and "+ sWhereCodeEntp +"='Y'");
		sb.append(" and starttime<=?");
		sb.append(" and endtime>=?");
		
		SqlParam param= new SqlParam();
		param.addParam(id_hp);
		param.addParam(AppUtils.getServerDateTime());
		param.addParam(AppUtils.getServerDateTime());
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(),param,new ColumnListHandler());
		if(!ListUtil.isEmpty(list)){
			return list;
		}
		return null;
	}
	
	/**
	 * 获取住院就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static PatiVisitDO getIpEntInfo(String id_ent) throws BizException{
		IPativisitRService ser = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO enEnt=ser.findById(id_ent);
		return enEnt;
	}
	/**
	 * 获取急诊留观患者出观就诊id集合
	 * @param id_pat 患者id
	 * @return
	 * @throws DAException 
	 */
	public static List<String> getPatEtObsEnts(String id_pat) throws DAException{
		StringBuilder strSql = new StringBuilder();
		strSql.append("select ent.id_ent ");
		strSql.append(" from en_ent ent ");
		strSql.append(" where  ent.ID_PAT=? and ent.code_entp=?");
		strSql.append(" and ent.fg_ip='N' and ent.fg_canc='N' and ent.fg_emgstay='Y'"); 
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(strSql.toString(), sqlParam,new ColumnListHandler() );
		if (!ListUtil.isEmpty(list)) {
			return list;
		}
		return null;
	}
	
	/**
	 * 获取预住院转门诊的就诊ID集合
	 * @param id_pat 患者ID
	 */
	public static List<String> getIppreToOepEnts(String id_pat) throws DAException{
		StringBuilder strSql = new StringBuilder();
		strSql.append(" select ent.id_ent ");
		strSql.append(" from en_ent ent ");
		strSql.append(" where ent.id_pat = ? and ent.code_entp = ? ");
		strSql.append(" and ent.fg_ip = 'Y' and ent.fg_canc = 'N' ");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(strSql.toString(), sqlParam,new ColumnListHandler() );
		if (!ListUtil.isEmpty(list)) {
			return list;
		}
		return null;
	} 
}
