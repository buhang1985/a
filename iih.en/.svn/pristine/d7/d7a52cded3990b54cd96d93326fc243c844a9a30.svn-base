package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊id判断此次就诊是否是持卡
 * @author fanlq
 *
 */
public class CheckIsHpCardEntBP {
	/***
	 * 根据就诊id判断此次就诊是否是持卡
	 * @author fanlq 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException{
		// 检查参数
		EnValidator.validateParam("entId", entId);
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT HP.FG_HP_CARD AS FG_HP_CARD,");
		sqlBuilder.append("HP.FG_MAJ ");
		sqlBuilder.append("FROM EN_ENT_HP HP ");
		sqlBuilder.append("WHERE HP.ID_ENT = ? ");
		param.addParam(entId);
		FBoolean fg_hp_card = FBoolean.FALSE;
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Object> datas = (Map<String, Object>) new DAFacade().execQuery(sqlBuilder.toString(), param, new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			fg_hp_card = (FBoolean)FTypeManager.convert2FType(FType.FBoolean, datas.get("fg_hp_card"));
		}
		return fg_hp_card;
	}
}
