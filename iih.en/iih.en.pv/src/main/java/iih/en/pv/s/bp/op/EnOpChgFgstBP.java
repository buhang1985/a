package iih.en.pv.s.bp.op;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 监听收费事件，修改状态
 * 
 * @author renying,liubin
 *
 */
public class EnOpChgFgstBP{

	public void exec(String id_st) throws BizException {
		// 1、获取事件的结算ID
		String entId = this.getEsCgIdList(id_st);
		if (entId == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		//2、更新ent表结算标志
		PvEP pvep = new PvEP();
		pvep.ubpdateFgst(entId);
		//3、更新en_ent_op表结算标志
		OpEP opep = new OpEP();
		opep.updateOpFgCg(entId, FBoolean.TRUE);
		//4、更新en_ent_op_reg表
		this.updateOpReg(entId);
	}
	/**
	 * 根据事件源获取结算ID
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	private String getEsCgIdList(String  stId) throws BizException {
		if (EnValidator.isEmpty(stId)) {
			return null;
		}
		StringBuffer sqlBuffer = new StringBuffer();
		SqlParam param = new SqlParam();
		sqlBuffer.append("SELECT ENT.ID_ENT ");
		sqlBuffer.append("FROM EN_ENT ENT ");
		sqlBuffer.append("INNER JOIN BL_CG_ITM_OEP OEP ON OEP.ID_ENT = ENT.ID_ENT ");
		sqlBuffer.append("WHERE OEP.ID_STOEP = ?");
		param.addParam(stId);

		String entId = (String) new DAFacade().execQuery(sqlBuffer.toString(),
				param, new ColumnHandler());

		return entId;
	}
	/**
	 * 更新en_ent_op_reg表
	 * 
	 * @param entId
	 * @throws BizException 
	 */
	private void updateOpReg(String entId) throws BizException{
		PvEP pvep = new PvEP();
		PatiVisitDO pv = pvep.getPvByPK(entId);
		if (pv == null) 
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		EntHpEP hpep = new EntHpEP();
		List<String> entList = new ArrayList<>();
		entList.add(entId);
		EntHpDO[] enthps = hpep.getEntMajHpList(entList);
		EntHpDO enthp = null;
		if(!EnValidator.isEmpty(enthps))
			enthp = enthps[0];
		new OpRegEP().updateOpReg(pv, enthp);
	}
}
