package iih.bl.cg.s.bp;

import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否存在预住院费用转门诊/住院费用
 * @author hanjq
 *
 */
public class IsPreipTransfBP {

	public FBoolean exec(String idEnt, FBoolean isOep) throws BizException {
		if(StringUtils.isBlank(idEnt)){
			throw new BizException("就诊主键不能为空");
		}
		String note = FBoolean.TRUE.equals(isOep) ? "预住院转门诊费用" : "预住院转住院费用";
		Integer num = this.getNum(idEnt, note);
		if(num > 0 ){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 查询转入数量
	 * @param idEnt
	 * @param note
	 * @return
	 * @throws DAException
	 */
	private  Integer getNum(String idEnt,String note) throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append("select count(1)	");
		sql.append("FROM bl_cg_ip cg ");
		sql.append("inner join bl_cg_ippre_log prelog on cg.id_cgip = prelog.id_cgip_pre and prelog.fg_active = 'Y' ");
		sql.append("where cg.id_ent = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(idEnt);
		
		DAFacade daf = new DAFacade();
		Integer num = (Integer) daf.execQuery(sql.toString(), param , new ColumnHandler());
		return num; 
	}
	
}
