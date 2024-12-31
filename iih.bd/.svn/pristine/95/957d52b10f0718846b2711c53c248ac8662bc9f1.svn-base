package iih.bd.pp.prisrv.s.rule;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 检查本服务定价价表唯一性规则</br>
 * 一个服务只允许有一条启用的价表数据
 * 
 * @author hao_wu
 *
 */
public class CheckPriSrvDoUniqueRule implements IRule<PriSrvDO> {

	@Override
	public void process(PriSrvDO... priSrvArray) throws BizException {
		if (priSrvArray == null || priSrvArray.length <= 0) {
			return;
		}

		boolean hasActiveData = HasActiveData(priSrvArray);
		if (!hasActiveData) {
			return;
		}
		CheckPriSrvDoUnique(priSrvArray);
	}

	/**
	 * 是否存在启用数据
	 * 
	 * @param priSrvArray
	 * @return
	 */
	private boolean HasActiveData(PriSrvDO[] priSrvArray) {
		for (PriSrvDO priSrvDO : priSrvArray) {
			if (priSrvDO != null && priSrvDO.getDt_e() != null
					&& priSrvDO.getDt_e().equals(new FDateTime("2099-12-31 23:59:59"))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 针对需要保存的数据列表进行唯一性校验
	 * 
	 * @param priSrvArray
	 * @throws BizException
	 */
	private void CheckPriSrvDoUnique(PriSrvDO[] priSrvArray) throws BizException {
		CheckInChangList(priSrvArray);
		CheckInDb(priSrvArray);
	}

	/**
	 * 检查变更列表中数据是否符合唯一性规则
	 * 
	 * @param priSrvArray
	 * @throws BizException
	 */
	private void CheckInChangList(PriSrvDO[] priSrvArray) throws BizException {
		int dataCount = priSrvArray.length;
		for (int i = 0; i < dataCount; i++) {
			PriSrvDO lData = priSrvArray[i];
			for (int j = i + 1; j < dataCount; j++) {
				PriSrvDO rData = priSrvArray[j];
				CheckPriSrvDoUnique(lData, rData);
			}
		}
	}

	/**
	 * 检查数据库中数据是否符合唯一性规则
	 * 
	 * @param priSrvArray
	 * @throws BizException
	 */
	private void CheckInDb(PriSrvDO[] priSrvArray) throws BizException {
		String wherePart = GetWherePart(priSrvArray);
		PriSrvDO[] result = FindErrorDatas(wherePart);
		if (result != null && result.length > 0) {
			ThrowBizException(result[0]);
		}
	}

	/**
	 * 查询数据库中错误数据
	 * 
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private PriSrvDO[] FindErrorDatas(String wherePart) throws BizException {
		DAFacade daFacade = new DAFacade();
		Collection result = daFacade.findByCond(PriSrvDO.class, wherePart);
		if (result != null && result.size() > 0) {
			PriSrvDO[] priSrvArr = (PriSrvDO[]) result.toArray(new PriSrvDO[0]);
			return priSrvArr;
		}
		return null;
	}

	/**
	 * 检查两条价表数据是否符合唯一性规则
	 * 
	 * @param lData
	 * @param rData
	 * @throws BizException
	 */
	private void CheckPriSrvDoUnique(PriSrvDO lData, PriSrvDO rData) throws BizException {
		if (!StringUtils.isEmpty(lData.getId_srv()) && !StringUtils.isEmpty(rData.getId_srv())
				&& lData.getId_srv().equals(rData.getId_srv())) {
			ThrowBizException(lData);
		}
	}

	/**
	 * 抛出业务异常
	 * 
	 * @param lData
	 * @throws BizException
	 */
	private void ThrowBizException(PriSrvDO lData) throws BizException {
		DAFacade daFacade = new DAFacade();
		MedSrvDO medSrvDO = (MedSrvDO) daFacade.findByPK(MedSrvDO.class, lData.getId_srv());
		String msg = String.format("医疗服务\"%s\"存在已启用的定价。", medSrvDO.getName());
		throw new BizException(msg);
	}

	/**
	 * 获取查询数据库中已启用且排除修改数据的条件片段
	 * 
	 * @param priSrvArray
	 * @return
	 */
	private String GetWherePart(PriSrvDO[] priSrvArray) {
		StringBuilder wherePartBuilder = new StringBuilder();

		wherePartBuilder.append("fg_active = 'Y'");

		String[] idPriSrvs = GetIdPriSrvs(priSrvArray);
		if (idPriSrvs.length > 0) {
			String wherePart = SqlUtils.getNotInSqlByIds(PriSrvDO.ID_PRISRV, idPriSrvs);
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		String[] idSrvs = GetActiveIdSrvs(priSrvArray);
		if (idSrvs.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds(PriSrvDO.ID_SRV, idSrvs);
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		} else {
			wherePartBuilder.append(" AND 1 = 0");
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取已启用的医疗服务主键数组
	 * 
	 * @param priSrvArray
	 * @return
	 */
	private String[] GetActiveIdSrvs(PriSrvDO[] priSrvArray) {
		ArrayList<String> idSrvList = new ArrayList<>();
		for (PriSrvDO priSrvDO : priSrvArray) {
			if (priSrvDO != null && priSrvDO.getDt_e() != null
					&& priSrvDO.getDt_e().equals(new FDateTime("2099-12-31 23:59:59"))) {
				idSrvList.add(priSrvDO.getId_srv());
			}
		}
		return idSrvList.toArray(new String[0]);
	}

	/**
	 * 获取主键列表
	 * 
	 * @param priSrvArray
	 * @return
	 */
	private String[] GetIdPriSrvs(PriSrvDO[] priSrvArray) {
		ArrayList<String> idPriSrvList = new ArrayList<>();
		for (PriSrvDO priSrvDO : priSrvArray) {
			if (priSrvDO != null && !StringUtils.isEmpty(priSrvDO.getId_prisrv())) {
				idPriSrvList.add(priSrvDO.getId_prisrv());
			}
		}
		return idPriSrvList.toArray(new String[0]);
	}
}
