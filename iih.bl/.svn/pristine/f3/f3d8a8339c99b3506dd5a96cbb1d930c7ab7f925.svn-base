package iih.bl.inc.s.bp.validate;

import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 发票是否属于当前PC或者人员
 * @author ly 2018/09/14
 *
 */
public class IsIncThisPCOrPsnBP {

	/**
	 * 发票是否属于当前PC或者人员
	 * @param inccaId 票据分类id
	 * @param incno 发票号
	 * @return true:属于 false:不属于
	 * @throws BizException
	 */
	public FBoolean exec(String inccaId, String incno) throws BizException{
		
		if(StringUtil.isEmpty(inccaId) || StringUtil.isEmpty(incno)){
			throw new BizException("发票归属校验:票据分类id或发票号为空");
		}
		
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param = new SqlParam();
		
		sqlSb.append("select count(1) ");
		sqlSb.append("from bl_inc_iss ");
		sqlSb.append("where fg_active = 'Y' ");//无法判断是否认为作废，只能判断有效的
		sqlSb.append("and id_incca = ? ");
		sqlSb.append("and num_b <= ? ");
		sqlSb.append("and num_e >= ? ");
		
		param.addParam(inccaId);
		param.addParam(incno);
		param.addParam(incno);
		
		if(BlParamValueConst.BLINC0012_PC.equals(BlParams.BLINC0012())){
			sqlSb.append("and id_pc = ? ");
			param.addParam(BlParams.getRealPcId(Context.get().getClientHost()));
			
		}else{
			sqlSb.append("and id_emp_iss = ? ");
			param.addParam(Context.get().getStuffId());
		}
		
		DAFacade daf = new DAFacade();
		Integer count = (Integer)daf.execQuery(sqlSb.toString(), param, new ColumnHandler());
		
		if(count == 0){
			return FBoolean.FALSE;
		}
		
		return FBoolean.TRUE;
	}
}
