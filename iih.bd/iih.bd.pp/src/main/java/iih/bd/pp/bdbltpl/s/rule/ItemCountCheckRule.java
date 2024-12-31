package iih.bd.pp.bdbltpl.s.rule;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.i.IBdBltplItmDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 子数据条数检查规则
 * 
 * @author hao_wu
 *
 * @param <T>
 */
public class ItemCountCheckRule<T> implements IRule<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(T... dataArr) throws BizException {
		if (dataArr == null || dataArr.length <= 0) {
			return;
		}
		for (T data : dataArr) {
			CheckItemCount(data);
		}
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void CheckItemCount(T data) throws BizException {
		if (data instanceof BdbltplAggDO) {
			CheckItemCount((BdbltplAggDO) data);
		} else if (data instanceof BdBlTplDO) {
			CheckItemCount((BdBlTplDO) data);
		} else {
			String msg = String.format("不支持的数据类型:%s。", data.getClass().getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void CheckItemCount(BdbltplAggDO data) throws BizException {
		BdBltplItmDO[] itemArr = data.getBdBltplItmDO();
		CheckItemCount(data.getParentDO(), itemArr);
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param blTplDO
	 * @param itemArr
	 * @throws BizException
	 */
	private void CheckItemCount(BdBlTplDO blTplDO, BdBltplItmDO[] itemArr) throws BizException {
		if (itemArr == null || itemArr.length <= 0) {
			ThrowErrorException(blTplDO);
		}
		boolean error = true;
		for (BdBltplItmDO bdBltplItmDO : itemArr) {
			if (error && bdBltplItmDO != null && bdBltplItmDO.getStatus() != DOStatus.DELETED) {
				error = false;
				break;
			}
		}
		if (error) {
			ThrowErrorException(blTplDO);
		}
	}

	/**
	 * 抛错误异常
	 * 
	 * @param blTplDO
	 * @throws BizException
	 */
	private void ThrowErrorException(BdBlTplDO blTplDO) throws BizException {
		String msg = GetMsg(blTplDO);
		throw new BizException(msg);
	}

	/**
	 * 检查子数据数量
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void CheckItemCount(BdBlTplDO data) throws BizException {
		if (StringUtils.isEmpty(data.getId_bltpl())) {
			return;
		}
		BdBltplItmDO[] result = GetItemArray(data);
		CheckItemCount(data, result);
	}

	/**
	 * 获取子数据列表
	 * 
	 * @param data
	 * @return
	 * @throws BizException
	 */
	private BdBltplItmDO[] GetItemArray(BdBlTplDO data) throws BizException {
		IBdBltplItmDORService bdBltplItmDORService = ServiceFinder.find(IBdBltplItmDORService.class);
		BdBltplItmDO[] result = bdBltplItmDORService.findByAttrValString(BdBltplItmDO.ID_BLTPL, data.getId_bltpl());
		return result;
	}

	/**
	 * 获取提示消息
	 * 
	 * @param data
	 * @return
	 */
	private String GetMsg(BdBlTplDO data) {
		String msg = String.format("自定义费用模板\"%s\"的模板项目列表不允许为空。", data.getName());
		return msg;
	}
}
