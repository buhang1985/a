package iih.bl.cg.ep;

import iih.en.pv.entplan.d.EntHpDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保就诊计划
 * @author yang.lu
 *
 */
public class EntHpEP {

	/**
	 * 根据 id_ent,返回该就诊对应项的就诊医保计划
	 * 
	 * @param id_entList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public EntHpDO[] getEntHpById_ent(List<String> id_entList) throws BizException {
		// 查询就诊下的医保计划
		EntHpDO[] entHpDOArr = null;
		String cond = "";
		String strWhere = "";
		if (id_entList == null) {
			return null;
		}
		for (int i = 0; i < id_entList.size(); i++) {
			if (i != id_entList.size() - 1)
				strWhere = strWhere + "'" + id_entList.get(i) + "',";
			else
				strWhere = strWhere + "'" + id_entList.get(i) + "'";
		}

		cond = " id_ent in (" + strWhere + ")";
		// entHpDOArr = iEnthpRService.find(cond, "", FBoolean.TRUE);

		DAFacade dAFacade = new DAFacade();
		List<EntHpDO> entHpDOList = (List<EntHpDO>) dAFacade.findByCond(EntHpDO.class, cond, "1");

		// ????    |  修改 当前提示是否有用 ？
		if (entHpDOList != null) {
			if (entHpDOList.size() > 0) {
				if (entHpDOList.size() < id_entList.toArray().length) {
					//throw new BizException("请先结算自费费用");
				}else {
					entHpDOArr = entHpDOList.toArray(new EntHpDO[] {});
				}
			}
		}
		return entHpDOArr;
	}
}
