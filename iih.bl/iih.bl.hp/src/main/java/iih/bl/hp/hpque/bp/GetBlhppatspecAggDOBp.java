package iih.bl.hp.hpque.bp;

import iih.bl.hp.blhppatspec.d.BlhppatspecAggDO;
import iih.bl.hp.blhppatspec.i.IBlhppatspecRService;
import iih.pi.reg.pat.d.PiPatHpDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class GetBlhppatspecAggDOBp {

	/**
	 * 根据患者的ID_PAT，获得该患者的特殊病诊断信息
	 * 
	 * @param id_pat
	 *            患者的ID_PAT
	 * @return 医保特殊病患者
	 * @throws BizException
	 */
	public BlhppatspecAggDO[] exec(String id_pat) throws BizException {
		String[] fields1 = { "no_hp" };
		String no_hp = "";
		DAFacade dafacade = new DAFacade();
		if (id_pat.indexOf(';') > 0) {
			throw new BizException("非法字符");
		}
		String sql = " select hp.no_hp from pi_pat a inner join pi_pat_hp hp on a.id_pat=hp.id_pat where a.id_pat='" + id_pat + "'";
		@SuppressWarnings("unchecked")
		List<PiPatHpDO> patDOLst = (List<PiPatHpDO>) dafacade.findByCond(PiPatHpDO.class, sql, fields1);

		if (patDOLst == null || patDOLst.size() == 0) {
			throw new BizException("未查询到患者的医保卡号！");
		}
		no_hp = patDOLst.toArray(new PiPatHpDO[0])[0].getNo_hp();
		IBlhppatspecRService iBlhppatspecRService = ServiceFinder.find(IBlhppatspecRService.class);
		BlhppatspecAggDO[] blhppatspecAggDOs = iBlhppatspecRService.find(" no_hp='" + no_hp + "'", "", FBoolean.TRUE);
		if (blhppatspecAggDOs == null || blhppatspecAggDOs.length == 0) {
			throw new BizException("该患者不是特殊病患者！");
		}
		return blhppatspecAggDOs;
	}
}
