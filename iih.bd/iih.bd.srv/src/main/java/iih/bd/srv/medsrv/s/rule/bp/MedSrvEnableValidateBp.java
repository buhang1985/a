package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.validate.BDErrorInfo;
import iih.bd.srv.medsrv.validate.BDSrvValidateTool;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;
import iih.bd.srv.medvalidate.i.IMedvalidateCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务启用时校验业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvEnableValidateBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null || medSrvDO.getStatus() == DOStatus.DELETED || medSrvDO.getStatus() == DOStatus.UNCHANGED
				|| medSrvDO.getFg_active() == null || medSrvDO.getFg_active() == FBoolean.FALSE) {
			return;
		}

		validate(medSrvDO);
	}

	/**
	 * 校验
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void validate(MedSrvDO medSrvDO) throws BizException {
		List<MedvalidateAggDO> aggList = new ArrayList<MedvalidateAggDO>();
		List<BDErrorInfo> errorList = new ArrayList<BDErrorInfo>();
		BDSrvValidateTool tool = new BDSrvValidateTool();
		tool.CheckValidate2(new MedSrvDO[] { medSrvDO }, errorList);

		for (BDErrorInfo info : errorList) {
			aggList.add(dataFromBDErrorInfo(info));
		}
		IMedvalidateCudService saveService = ServiceFinder.find(IMedvalidateCudService.class);
		if (saveService != null) {
			saveService.save(aggList.toArray(new MedvalidateAggDO[aggList.size()]));
		}
		if (errorList != null && errorList.size() > 0) {
			String msg = getErrorMsg(errorList.get(0));
			throw new BizException(msg);
		}
	}

	/**
	 * 获取异常消息
	 * 
	 * @param bdErrorInfo
	 * @return
	 */
	private String getErrorMsg(BDErrorInfo bdErrorInfo) {
		String errorString = bdErrorInfo.toErrorString();
		if (!StringUtils.isBlank(errorString)) {
			return String.format("服务\"%s\",%s", bdErrorInfo.getName_item(), errorString);
		}

		List<BDErrorInfo> itemErrorList = bdErrorInfo.getSubItems();
		for (BDErrorInfo bdErrorInfo2 : itemErrorList) {
			errorString = getErrorMsg(bdErrorInfo2);
			if (!StringUtil.isEmptyWithTrim(errorString)) {
				return errorString;
			}
		}
		return "";
	}

	/**
	 * ErrorInfo转Agg
	 * 
	 * @param info
	 * @return
	 */
	private MedvalidateAggDO dataFromBDErrorInfo(BDErrorInfo info) {
		BDErrorInfoDO d = new BDErrorInfoDO();
		d.setStatus(DOStatus.NEW);
		d.setId_item(info.getId_item());
		d.setName_item(info.getName_item());
		d.setError_info(info.toErrorString());
		List<BDErrorInfoItemDO> childItems = new ArrayList<BDErrorInfoItemDO>();
		for (BDErrorInfo i : info.getSubItems()) {
			BDErrorInfoItemDO item = new BDErrorInfoItemDO();
			item.setStatus(DOStatus.NEW);
			item.setId_item(i.getId_item());
			item.setName_item(i.getName_item());
			item.setError_info(i.toErrorString());
			childItems.add(item);
		}

		MedvalidateAggDO agg = new MedvalidateAggDO();

		agg.setParent(d);
		;
		if (childItems != null && childItems.size() > 0) {
			agg.setChildrenDO(childItems.toArray(new BDErrorInfoItemDO[childItems.size()]));
		}
		return agg;
	}

}
