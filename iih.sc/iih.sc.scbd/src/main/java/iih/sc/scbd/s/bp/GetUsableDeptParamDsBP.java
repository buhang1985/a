package iih.sc.scbd.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取当前时间科室参数
 * 
 * @author 李宝亮  modified by renying (增加参数：科室)
 *
 */
public class GetUsableDeptParamDsBP {
	/**
	 * 获取当前时间科室参数
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ScDeptParamDsDO[] exec(String depId,String sd_sctp) throws BizException {
		List<ScDeptParamDsDO> usableParam=new ArrayList<ScDeptParamDsDO>();
		StringBuilder sb = new StringBuilder();
		SqlParam sp = new SqlParam();
		sb.append("select * from  ");
			sb.append(" ( select * from sc_dep_param  where ");
				sb.append(" eu_status='1'  ");
				sb.append(" and ds='0' ");
				sb.append(" and id_dep =? ");
				sb.append(" and  d_begin<= ? ");
				sb.append(" and sd_sctp =?");
				
				sb.append( ScGroupControlUtils.getGroupControlFitler(new ScDeptParamDsDO(),""));
			sb.append(" order by ver desc ) ");
		sb.append("where rownum <2");
		sp.addParam(depId);
		sp.addParam(new FDate());
		sp.addParam(sd_sctp);
		  List<ScDeptParamDO> datas = (List<ScDeptParamDO>) new DAFacade().execQuery(sb.toString(),
					sp, new BeanListHandler(ScDeptParamDO.class));
		  if(ListUtil.isEmpty(datas)){
			  throw new BizException("请先维护科室参数");
		   }
		  
		String id_deptparam=	datas.get(0).getId_deptparam();
		StringBuilder sb2 = new StringBuilder();
		SqlParam sp2 = new SqlParam();
		sb2.append("select * from sc_dep_param_ds  p where p.fg_active='Y' and p.ds='0' and p.id_deptparam=");
		sb2.append("?");
		sp2.addParam(id_deptparam);
		List<ScDeptParamDsDO> params = (List<ScDeptParamDsDO>) new DAFacade().execQuery(sb2.toString(),sp2, new BeanListHandler(ScDeptParamDsDO.class));
		if(ListUtil.isEmpty(datas))
			return usableParam.toArray(new ScDeptParamDsDO[0]);
		
		 for (ScDeptParamDsDO scDeptParamDsDO : params) {
			  if(IsDaysLotNotPast(sd_sctp,scDeptParamDsDO)){
				  usableParam.add(scDeptParamDsDO);
			  }
			
		}
		  return usableParam.toArray(new ScDeptParamDsDO[0]);
	}
	/**
	 * 比较时间
	 * @param sd_sctp
	 * @param scDeptParamDsDO
	 * @return
	 */
	private Boolean  IsDaysLotNotPast(String sd_sctp,ScDeptParamDsDO scDeptParamDsDO){
		FTime now = new FTime();
		// 处理急诊跨天的情况
		if (IScDictCodeConst.SD_SCTP_JZ.equals(sd_sctp) || IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)) {
			if (scDeptParamDsDO.getT_end().before(scDeptParamDsDO.getT_begin())) {
				FDateTime nowDateTime = new FDateTime(new FDate(), now);
				FDateTime paramDateTime = new FDateTime(new FDate(), scDeptParamDsDO.getT_begin());
				paramDateTime = paramDateTime.getDateTimeAfter(1);
				if (paramDateTime.after(nowDateTime)) {
					return true;
				}
			} else {
				if (scDeptParamDsDO.getT_end().after(now)) {
					return true;
				}
			}
			return false;
		}

		if (scDeptParamDsDO.getT_end().after(now)) {
			return true;
		}
		return false;
	}
	
}
