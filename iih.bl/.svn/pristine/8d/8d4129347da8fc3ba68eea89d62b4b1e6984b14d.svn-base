package iih.bl.st.s.bp.ip;

import iih.mi.itf.bizgrpitf.constant.BdMhiParamValueConst;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 校验本次结算费用明细是否全部上传
 * @author wq.li
 *
 */
public class CheckFeeAllUploadBP {
	
	/**
	 * 校验本次结算费用明细是否全部上传
	 * @param stId
	 * @return
	 * @throws BizException 
	 */
	public FBoolean exec(String stId,String hpId) throws BizException{
		
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(hpId);
		InsureFacade facade = new InsureFacade(insureContext);
		//上传模式
		String uploadMode = facade.GetIpDetailUploadMode();
		
		StringBuilder sql=new StringBuilder();
		
		sql.append(" select count(1) ");
		sql.append(" from bl_cg_ip CGIP ");
		sql.append(" where CGIP.fg_hp='N' ");
		sql.append(" and CGIP.id_stip=? ");
		if(BdMhiParamValueConst.BDMHI2009_ONLYFORWARD.equals(uploadMode)){
			sql.append(" AND CGIP.EU_DIRECT = 1 ");
			sql.append(" AND CGIP.FG_REFUND = 'N' ");
		}
		
		SqlParam param = new SqlParam();
		param.addParam(stId);
		Integer count=(Integer) new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
		
		if(count>0){
			return FBoolean.FALSE;
		}else{
			return FBoolean.TRUE;
		}
	}
	
}
