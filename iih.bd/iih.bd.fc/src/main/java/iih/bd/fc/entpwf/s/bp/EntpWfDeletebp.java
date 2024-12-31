package iih.bd.fc.entpwf.s.bp;

import iih.bd.fc.entpwf.d.BdEntpWfDO;
import iih.bd.fc.entpwf.i.IEntpwfCudService;
import iih.bd.fc.entpwf.i.IEntpwfRService;
import iih.bd.fc.entpwf.s.bp.qry.EntpWfDeleteSql;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class EntpWfDeletebp {

	/**
	 * 就诊流程定义删除
	 * 
	 * @return
	 * @throws BizException
	 */
	public BdEntpWfDO[] exec(BdEntpWfDO wfdo) throws BizException {

		IEntpwfCudService saveService = ServiceFinder.find(IEntpwfCudService.class);

		IEntpwfRService findService = ServiceFinder.find(IEntpwfRService.class);

		BdEntpWfDO[] deleteDOS = getTreeDOS(wfdo);

		if (deleteDOS != null) {

			saveService.delete(deleteDOS);

			return findService.find("id_entp='" + wfdo.getId_entp() + "'", "", FBoolean.FALSE);
		}
		
		return null;
	}

	/**
	 * 获取树状结构的集合
	 * 
	 * @param wfdo
	 * @return
	 * @throws BizException
	 */
	private BdEntpWfDO[] getTreeDOS(BdEntpWfDO wfdo) throws BizException {

		if (wfdo != null) {

			EntpWfDeleteSql Sql = new EntpWfDeleteSql(wfdo.getId_entpwf());

			BdEntpWfDO[] deleteDOS = (BdEntpWfDO[]) AppFwUtil.getDORstWithDao(Sql, BdEntpWfDO.class);

			if (deleteDOS != null && deleteDOS.length > 0) {

				return deleteDOS;
			}
		}

		return null;
	}
}
