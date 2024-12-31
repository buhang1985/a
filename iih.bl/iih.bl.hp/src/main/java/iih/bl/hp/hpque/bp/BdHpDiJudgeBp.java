package iih.bl.hp.hpque.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpDiDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BdHpDiJudgeBp {
	/**
	 * 用于判断医保诊断是否在保内诊断列表中。 该接口提供给医生站使用，医生站在下诊断时，应当通过该接口判断是否保外诊断，
	 * 如果是保外诊断，则禁止医生开保内处方和医嘱。
	 * 
	 * @param id_hp
	 *            医保计划
	 * @param id_diArr
	 *            诊断ID数组
	 * @param id_entp
	 *            就诊类型ID
	 * @return Map<String,FBoolean>
	 *         <id_di,保内(Fboolean.true)还是保外(Fboolean.false)>
	 * @throws BizException
	 */
	public Map<String, FBoolean> exec(String id_hp, String[] id_diArr, String id_entp) throws BizException {
		Map<String, FBoolean> di_insur_map = new HashMap<String, FBoolean>();
		FBoolean result = FBoolean.FALSE;
		DAFacade dafacade = new DAFacade();
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] HPDO1 = iHpMDORService.find(" id_hp='" + id_hp + "'", "", FBoolean.FALSE);

//		bd_hp.fg_black_di：定义BD_HP_DI中存放的名单的性质是黑名单还是白名单。如果是黑名单，BD_HP_DI名单中的诊断为保外诊断，不在名单中的为保内诊断；
//		如果是白名单，BD_HP_DIE名单中的诊断为保内诊断，不在名单中的为保外诊断。
		
		if (HPDO1 != null && HPDO1.length > 0) {
			// HPDO[] HPDO1=HPDOArr[0];
			for (String id_di : id_diArr) {
				StringBuffer sql1 = new StringBuffer();
				sql1.append(" SELECT id_hpdi");
				sql1.append(" FROM BD_HP_DI");
				sql1.append(" WHERE ID_HP = ?");
				sql1.append(" AND ID_DI = ? and (id_enttp=? or id_enttp='~')");
				SqlParam sqlp1 = new SqlParam();
				sqlp1.addParam(id_hp);
				sqlp1.addParam(id_di);
				sqlp1.addParam(id_entp);
				List<HpDiDO> HpDiDO = (List<HpDiDO>) dafacade.execQuery(sql1.toString(), sqlp1, new BeanListHandler(HpDiDO.class));
				if (HpDiDO != null && HpDiDO.size() > 0) // 在诊断名单中
				{
					if (HPDO1[0].getFg_black_di().booleanValue())// 黑名单
					{
						result = FBoolean.FALSE;// 保外
					} else {
						result = FBoolean.TRUE;// 保内
					}
				} else// 不在诊断名单中
				{
					if (HPDO1[0].getFg_black_di().booleanValue())// 黑名单
					{
						result = FBoolean.TRUE;// 保内
					} else 
					{
						result = FBoolean.FALSE;// 保外
					}
				}
				di_insur_map.put(id_di, result);
			}
		}

		return di_insur_map;
	}
}
