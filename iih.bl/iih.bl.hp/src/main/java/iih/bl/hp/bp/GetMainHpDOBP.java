package iih.bl.hp.bp;

import iih.bd.base.utils.FBooleanUtils;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 获取医保主计划
 * @author LIM
 *
 */
public class GetMainHpDOBP {
	/**
	 * 获取就诊的主医保计划
	 * 
	 * @param entHpList
	 * @return
	 */
	public EntHpDO exec(String id_ent) throws BizException{
		FArrayList2 entHpList=this.getEntHpDoLst(id_ent);
		if (entHpList == null || entHpList.size() <= 0) {
			return null;
		}
		EntHpDO mainHpDO = null;
		for (Object enHpDO1 : entHpList) {
			EntHpDO enhpdo = (EntHpDO) enHpDO1;
			if (FBooleanUtils.isTrue(enhpdo.getFg_maj())) {
				mainHpDO = enhpdo; // 主医保
				break;
			}
		}
		return mainHpDO;
	}
	/**
	 * 查询医保计划
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 getEntHpDoLst(String id_ent) throws BizException {
		IEnthpRService iEnthpRService = (IEnthpRService) ServiceFinder.find(IEnthpRService.class);

		EntHpDO[] entHpDOArr = iEnthpRService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);

		FArrayList2 entHpDOFLst = new FArrayList2();

		if (entHpDOArr != null || entHpDOArr.length > 0) {

			for (EntHpDO entHpDO : entHpDOArr) {

				entHpDOFLst.add(entHpDO);

			}
		}

		return entHpDOFLst;
	}	
}
