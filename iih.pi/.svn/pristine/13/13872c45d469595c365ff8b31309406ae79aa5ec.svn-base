package iih.pi.reg.s.bp;

import java.util.List;

import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class PiInfoSendEmpiBP {
	
	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getCount(FDateTime dt_date)throws BizException {
		String sql = " select count(1) from pi_pat p where fg_active = 'Y'  and p.createdtime <= ? " ;
		SqlParam param = new SqlParam();
		param.addParam(dt_date);
		return (Integer)new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
	}
	
	/**
	 * 分页获取患者信息
	 * @param min
	 * @param max
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO[] exec(int min, int max,FDateTime dt_date) throws BizException {
		String sql = " select p.id_pat from (select pat.id_pat, ROWNUM as row_ from pi_pat pat where pat.fg_active = 'Y' and pat.createdtime <= ? and ROWNUM <= ?) p where p.row_ >= ? ";
		SqlParam param = new SqlParam();
		param.addParam(dt_date);
		param.addParam(max);
		param.addParam(min);
		List<String> list = (List<String>)new DAFacade().execQuery(sql.toString(), param, new ColumnListHandler());
		if(ListUtil.isEmpty(list))
			return null;
		IPatiRService serv = ServiceFinder.find(IPatiRService.class);
		return serv.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
	}
	

		
}
