package iih.ci.ord.specanti.bp;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.ci.ord.ap.d.CiApSpecAntiRecordDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 判断签署医嘱中有没有碳青霉烯类的
 * @author zhangwq
 *
 */
public class CarbapenemJudgeBP {
	public CiApSpecAntiRecordDO[] exec(String[] id_ors) throws DAException, BizException{
		if(id_ors==null || id_ors.length==0)
		{
			return null;
		}
		String carbapenemCodes =  ParamsetQryUtil.getParaString(Context.get().getOrgId(),
				ICiOrdNSysParamConst.SYS_PARAM_CARBAPENEM);
		if(StringUtils.isNullOrEmpty(carbapenemCodes)){
			return null;
		}
		List<CiApSpecAntiRecordDO> specAntiRecords = (List<CiApSpecAntiRecordDO>)new DAFacade().execQuery(getQrySql(id_ors,carbapenemCodes), new BeanListHandler(CiApSpecAntiRecordDO.class));
		if(specAntiRecords!=null && specAntiRecords.size()>0){
			return specAntiRecords.toArray(new CiApSpecAntiRecordDO[0]);
		}
		return null;
	}
	/**
	 * 碳青霉烯类的查询sql
	 * @param id_ors
	 * @param carbapenemCodes
	 * @return
	 * @throws BizException
	 */
	private String getQrySql(String[] id_ors,String carbapenemCodes) throws BizException{
		carbapenemCodes = carbapenemCodes.replaceAll("，", ",");
		StringBuilder sb = new StringBuilder();
		sb.append("select "); 
		sb.append("mm.name_mm,s.name as name_srv,c.id_en as id_ent,c.id_pat,ent.name_pat,entip.code_amr_ip,c.id_or, "); 
		sb.append("s.id_orsrv,mm.id_mm,s.id_srv,c.id_dep_sign as id_emp_or,psn.name  as name_emp_or,c.dt_effe "); 
		sb.append("from ci_order c "); 
		sb.append("inner join ci_or_srv s on c.id_or = s.id_or "); 
		sb.append("inner join ci_or_srv_mm mm on s.id_orsrv = mm.id_orsrv "); 
		sb.append("inner join BD_MMCA_US_ITM_REL rel on rel.id_mmorca = mm.id_mm "); 
		sb.append("inner join BD_MMCA_US_ITM itm on itm.id_mmcausitm = rel.id_mmcausitm "); 
		sb.append("inner join en_ent ent on ent.id_ent = c.id_en "); 
		sb.append("inner join en_ent_ip entip on ent.id_ent = entip.id_ent "); 
		sb.append("left join bd_psndoc psn on psn.id_psndoc = c.id_emp_sign "); 
		sb.append(" where ("+SqlUtils.getInSqlByIds("itm.code",carbapenemCodes.split(","))+")");
		sb.append(" and ("+SqlUtils.getInSqlByIds("c.id_or",id_ors)+")");
		return sb.toString();
	}
}
