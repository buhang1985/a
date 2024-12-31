package iih.ei.sc.s.bp.qry;

import java.util.List;

import iih.ei.sc.ws.bean.GetBrokenAptListBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBrokenAptListBP {

	/**
	 * 获取患者爽约记录
	 * @param 患者编码
	 * @param 爽约类型编码
	 * @return
	 */
	public GetBrokenAptListBean[] exec(String patCode,String eus_bbrtp) throws BizException {
		
		this.validData(patCode, eus_bbrtp);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" bbr.id_patlock as id_key,");
		sql.append(" pat.code as patcode,");
		sql.append(" pat.name as parname,");
		sql.append(" sex.name as sex,");
		sql.append(" srv.code as scsrv_code,");
		sql.append(" srv.name as scsrv_name,");
		sql.append(" pat.mob as mobile,");
		sql.append(" bbr.dt_act,");
		sql.append(" bbr.sd_bbrtp");
		sql.append(" from pi_pat_bbr bbr ");
		sql.append(" inner join pi_pat pat on pat.id_pat = bbr.id_pat");
		sql.append(" inner join bd_udidoc sex on sex.id_udidoc = pat.id_sex");
		sql.append(" inner join sc_apt apt on apt.id_pat = bbr.id_pat");
		sql.append(" inner join sc_srv srv on srv.id_scsrv = apt.id_scsrv");
		sql.append(" where pat.code = ?");
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		if(!StringUtil.isEmpty(eus_bbrtp))
		{
			sql.append(" and bbr.sd_bbrtp in (");
			String[] list = eus_bbrtp.split(",");
			for (String eu_bbrtp : list) {
				sql.append("?,");
				param.addParam(eu_bbrtp);
			}
			sql = sql.deleteCharAt(sql.length()-1);
			sql.append(" )");
		}
		List<GetBrokenAptListBean> list = (List<GetBrokenAptListBean>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(GetBrokenAptListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetBrokenAptListBean[0]);
	}
	
	/**
	 * 校验数据
	 * @param patCode
	 * @param eus_bbrtp
	 * @throws BizException
	 */
	private void validData(String patCode,String eus_bbrtp) throws BizException
	{
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("获取患者爽约记录失败:患者编码传入为空!");
		}
		if(StringUtil.isEmpty(eus_bbrtp))
		{
			throw new BizException("获取患者爽约记录失败:爽约类型编码传入为空!");
		}
		patCode = patCode.replaceAll(".*([';]+|(--)+).*", "");
		eus_bbrtp = eus_bbrtp.replaceAll(".*([';]+|(--)+).*", "");
		if(StringUtil.isEmpty(patCode.trim()))
		{
			throw new BizException("获取患者爽约记录失败:患者编码是非法字符!");
		}
		if(StringUtil.isEmpty(eus_bbrtp.trim()))
		{
			throw new BizException("获取患者爽约记录失败:爽约类型编码是非法字符!");
		}
	}
}
