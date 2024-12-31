package iih.ci.ord.s.external.bp.en;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 核对，在给定时间之前是否存在有效的医嘱（未作废的医嘱）
 * @author zhangwq
 *
 */
public class CheckLiveOrdBeforeDtAcptBP {
	private String warnInfo = "入院时间之前存在有效医嘱，请将医嘱删除或作废后，重新选择入院时间";
	public void exec(String id_en,FDateTime dt_acpt) throws BizException{
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		param.addParam(dt_acpt);
		List<CiOrderDO> ords = (List<CiOrderDO>) new DAFacade().execQuery(getQryStr(),param, new BeanListHandler(CiOrderDO.class));
		if(ords!=null&&ords.size()>0){
			throw new BizException(warnInfo);
		}
	}
	private String getQryStr(){
		return "select c.id_or from ci_order c where c.id_en=? and c.dt_effe < ? and c.fg_chk='N'";
	}
}
