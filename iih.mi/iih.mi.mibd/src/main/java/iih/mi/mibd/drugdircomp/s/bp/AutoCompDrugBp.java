package iih.mi.mibd.drugdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.mi.mibd.drugdircomp.s.bp.sql.AutoCompDrugByCodeSql;
import iih.mi.mibd.drugdircomp.s.bp.sql.AutoCompDrugByNameSql;
import iih.mi.mibd.drugdircomp.s.bp.sql.AutoCompDrugByNameAndCodeSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**药品目录自动对照业务逻辑
 * @author hexx
 * @version 创建时间：2018年2月2日 上午9:21:37 药品目录自动对照业务逻辑
 */
public class AutoCompDrugBp {

	/**业务执行
	 * @param misId
	 * @throws BizException
	 */
	public void exec(String misId) throws BizException {
		DrugdircompDO[] drugdircompDOs = AutoCompDrug(misId);
		DrugdircompDO[] drugDirCompDos = SetDefaultValue(misId,drugdircompDOs);
		save(drugDirCompDos);
		
		DrugdircompDO[] drugDirCompDOByName = AutoCompDrugByName(misId);
		DrugdircompDO[] drugDirCompDosByName = SetDefaultValue(misId,drugDirCompDOByName);
		save(drugDirCompDosByName);
		
		DrugdircompDO[] drugDirCompDOByCode = AutoCompDrugByCode(misId);
		DrugdircompDO[] drugDirCompDosByCode = SetDefaultValue(misId,drugDirCompDOByCode);
		save(drugDirCompDosByCode);
	}

	
	/**保存数据
	 * @param drugDirCompDo
	 * @throws DAException
	 */
	private void save(DrugdircompDO[] drugDirCompDo) throws DAException {
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(drugDirCompDo);
	}

	/**设置默认属性
	 * @param misId
	 * @param drugdircompDOs
	 * @return
	 */
	private DrugdircompDO[] SetDefaultValue(String misId, DrugdircompDO[] drugdircompDOs) {
		for (DrugdircompDO drugdircompDO : drugdircompDOs) {
			drugdircompDO.setId_grp(Context.get().getGroupId());
			drugdircompDO.setId_org(Context.get().getOrgId());
			drugdircompDO.setId_mis(misId);
			drugdircompDO.setEu_status(DirCompState.COMPED);
		}
		return drugdircompDOs;
			}

	/**通过名称进行对照
	 * @return
	 * @throws DAException
	 */
	private DrugdircompDO[] AutoCompDrugByName(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompDrugByNameSql sql = new AutoCompDrugByNameSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<DrugdircompDO> drugdircompDOList = (ArrayList<DrugdircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugdircompDO.class));
		return drugdircompDOList.toArray(new DrugdircompDO[0]);
	}

	/**通过code进行对照
	 * @return
	 * @throws DAException
	 */
	private DrugdircompDO[] AutoCompDrugByCode(String misId) throws DAException {
		DAFacade daFacade = new DAFacade();
		AutoCompDrugByCodeSql sql = new AutoCompDrugByCodeSql(misId);
		@SuppressWarnings("unchecked")
		ArrayList<DrugdircompDO> drugdircompDOList = (ArrayList<DrugdircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugdircompDO.class));
		return drugdircompDOList.toArray(new DrugdircompDO[0]);
	}

	/**
	 * 进行对照
	 * @param misId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private DrugdircompDO[] AutoCompDrug(String misId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompDrugByNameAndCodeSql sql = new AutoCompDrugByNameAndCodeSql(misId);
		ArrayList<DrugdircompDO> drugdircompDOList = (ArrayList<DrugdircompDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugdircompDO.class));
		return drugdircompDOList.toArray(new DrugdircompDO[0]);
	}
}
