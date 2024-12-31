package iih.bl.hp.s.bp;

import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bl.comm.dto.d.BlCheckResultDTO;
import iih.bl.st.blstoep.d.StTypeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否可进行医保身份转换(住院)
 * @author ly 2018/10/04
 *
 */
public class IpCanChangeHpIdentityBP {

	/**
	 * 是否可进行医保身份转换(住院)
	 * @param entId 就诊id
	 * @return true:可以 false:不可以
	 * @throws BizException
	 */
	public BlCheckResultDTO exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new ArgumentNullException("是否可进行医保身份转换", "就诊id");
		}
		
		BlCheckResultDTO resultDto = new BlCheckResultDTO();
		
//		String sql = "select count(1) from bl_st_ip where id_ent = '%s' and fg_pay = 'Y' and fg_canc = 'N' and eu_direct = 1 ";
//		DAFacade daf = new DAFacade();
//		
//		Integer count = (Integer)daf.execQuery(String.format(sql, entId), new ColumnHandler());
//		if(count != null && count > 0){
//			resultDto.setResult(FBoolean.FALSE);
//			resultDto.SetMsg("患者已进行过结算收付款，无法转换身份");
//			return resultDto;
//		}
		
		String sql = "select distinct st.eu_sttp from bl_st_ip st where st.id_ent = ? and st.fg_pay = 'Y' and st.fg_canc = 'N' and st.eu_direct = 1 ";
		SqlParam param= new SqlParam();
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql,param,new ColumnListHandler<String>());
		if(!ListUtil.isEmpty(list)){
			if(list.contains(StTypeEnum.ST_INP_MIDWAY)){
				resultDto.setEu_sttp(StTypeEnum.ST_INP_MIDWAY);
				resultDto.SetMsg("该患者已有中途结算的收付款记录，请再次确定，是否需要修改患者身份？");
			}
			if(list.contains(StTypeEnum.ST_INP)){
				resultDto.setEu_sttp(StTypeEnum.ST_INP);
				resultDto.SetMsg("患者已进行过结算收付款，无法转换身份");
			}
			resultDto.setResult(FBoolean.FALSE);
			return resultDto;
		}
		resultDto.setResult(FBoolean.TRUE);
		return resultDto;
	}
}
