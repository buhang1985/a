package iih.bl.cg.bp;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判定记账是否已经结算
 * @author lpy
 *
 */
public class CheckCgHasSettledBP {
	/**
	 * 判定记账是否已经结算
	 * 记账明细只要有结算，就判定改记账存在结算数据
	 * @param cgId
	 * @return FBoolean 
	 * @throws BizException
	 * @author yankan,lpy
	 */
	@SuppressWarnings("unchecked")
	public FBoolean exec(String cgId) throws BizException{
		StringBuffer sql1=new StringBuffer();
		sql1.append("select cgitm.id_stoep,cgitm.id_cgitmoep,cgitm.id_cgoep,st.id_paypatoep ");
	    sql1.append(" from  bl_cg_itm_oep   cgitm     ");
	    sql1.append("inner  join  bl_st_oep st on  cgitm.id_stoep = st.id_stoep            ");
		sql1.append("where  cgitm.id_cgoep = ?        ");
		sql1.append("and length(st.id_paypatoep)>2    ");
		SqlParam sp = new SqlParam();
		sp.addParam(cgId);
	    List<BlCgItmOepDO> list  = (List<BlCgItmOepDO>)new DAFacade().execQuery(sql1.toString(),sp ,new BeanListHandler(BlCgItmOepDO.class));
		if(list != null && list.size()>0 )
		{
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
