package iih.pi.reg.s.bp;

import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据医保卡号查询患者信息
 * @author ly 2018/05/08
 *
 */
public class GetPatiInfoByHpNoBP {

	/**
	 * 根据医保卡号查询患者信息
	 * @param hpno
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String hpno) throws BizException{
		
		if(StringUtil.isEmpty(hpno))
			return null;
		
		//取医保卡号前九位
		String hpno9 = hpno.length() > 9 ? hpno.substring(0, 9) : hpno;
		
		//根据医保卡号查询患者id
		String sql = "select id_pat from pi_pat_hp where id_hp = ? and substr(no_hp,1,9) = ? ";
		SqlParam param = new SqlParam();
		param.addParam(IPiPatConst.BJ_ID_HP);
		param.addParam(hpno9);
		
		String patId = (String)new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(StringUtil.isEmpty(patId))
			return null;
		
		IPatiRService patiRService = ServiceFinder.find(IPatiRService.class);
		return patiRService.findById(patId);
	}
}
