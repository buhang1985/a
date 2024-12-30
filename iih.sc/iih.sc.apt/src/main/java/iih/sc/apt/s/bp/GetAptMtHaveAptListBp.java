package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**医技预约获取已预约list
 * @author ccj
 *
 */
public class GetAptMtHaveAptListBp {
	 /**获取已预约列表
     * @param beginDate  开始时间
     * @param endDate	结束时间
     * @param id_dep	部门id
     * @param sd_entp 	就诊类型串 
     * @return
     * @throws BizException
     */
	public List exec(FDate beginDate,FDate endDate,String id_dep,String sd_entp)throws BizException{
		if(beginDate == null || endDate == null || StringUtils.isBlank(sd_entp) || StringUtils.isBlank(id_dep)) return null;
		StringBuffer sb = new StringBuffer();
		SqlParam param = new SqlParam();
		sb.append("SELECT apt.queno,en.id_entp,mt.fg_urgent,en.id_pat,en.name_pat,en.id_ent ");
		sb.append(",en.dt_birth_pat,en.id_sex_pat,mt.id_dep_apply,mt.content_or ");
		sb.append("from sc_apt apt ");
		sb.append("left join sc_apt_mt mt on apt.id_apt = mt.id_apt ");
		sb.append("left join en_ent en on mt.id_ent = en.id_ent ");
		sb.append("left join ci_or_srv srv on mt.id_or = srv.id_or and srv.sd_srvtp like '%02%' ");
		sb.append("where apt.dt_appt >= ? and apt.dt_appt < ? " );
		sb.append("and mt.id_dep_mp = ? and apt.sd_status in (?,?,?) ");
		sb.append("and en.code_entp in (");
		sb.append(sd_entp);
		sb.append(")");
		param.addParam(beginDate);
		param.addParam(endDate);
		param.addParam(id_dep);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);
		return (List)new DAFacade().execQuery(sb.toString(),param,new MapListHandler());
	}
}
