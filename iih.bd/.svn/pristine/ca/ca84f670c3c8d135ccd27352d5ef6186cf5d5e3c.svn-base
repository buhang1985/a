package iih.bd.fc.wf.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.s.bp.qry.GetWfSrvtpDocSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 医嘱流向服务类型叠加校验
 * 
 * @author xuxing 2017-02-27
 *
 */
public class wfSaveValidationBp {

	/**
	 * 主入口
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	public void exec(WfAggDO AggDO) throws BizException {

		// 1、获取有效服务类型集合
		WfSrvtpDO[] srvtpArray = getEffectiveSrvtp(AggDO);

		// 2、 自检
		List<String> listMsgSelf = validationAggSelf(srvtpArray);
		if (listMsgSelf.size() > 0) {
			handelMessage(listMsgSelf);
		}

		// 3、取全部服务类型集合
		UdidocDO[] docList = getSrvtpDocList(AggDO);

		// 4、校验其他
		List<String> listMsgOth = validationOther(srvtpArray, docList);
		if (listMsgOth.size() > 0) {
			handelMessage(listMsgOth);
		}
	}

	/**
	 * 取当前 有效的服务类型集合
	 * 
	 * @param AggDO
	 * @return
	 */
	private WfSrvtpDO[] getEffectiveSrvtp(WfAggDO AggDO) {

		List<WfSrvtpDO> reList = new ArrayList<WfSrvtpDO>();

		for (WfSrvtpDO wfSrvtpDO : AggDO.getWfSrvtpDO()) {

			if (DOStatus.DELETED == wfSrvtpDO.getStatus()) {
				continue;
			}
			reList.add(wfSrvtpDO);
		}

		return reList.toArray(new WfSrvtpDO[reList.size()]);
	}

	/**
	 * 自检
	 * 
	 * @param AggDO
	 */
	private List<String> validationAggSelf(WfSrvtpDO[] srvtpArray) {

		List<String> reList = new ArrayList<String>();

		if (srvtpArray != null && srvtpArray.length > 0) {

			for (WfSrvtpDO srvtp : srvtpArray) {

				validationSelf(srvtpArray, srvtp, reList);
			}
		}

		return reList;
	}

	/**
	 * 自检内容
	 * 
	 * @param srvtpArray
	 * @param srvtpDO
	 * @param reList
	 */
	private void validationSelf(WfSrvtpDO[] srvtpArray, WfSrvtpDO srvtpDO, List<String> reList) {

		for (WfSrvtpDO srvtp : srvtpArray) {

			if (!srvtpDO.equals(srvtp)) {

				if (srvtp.getSd_srvtp().indexOf(srvtpDO.getSd_srvtp()) == 0) {

					reList.add("服务类型【" + srvtpDO.getName() + "】与【" + srvtp.getName() + "】有叠加");
				}
			}
		}
	}

	/**
	 * 获取当前就诊类型、流向类型下的全部服务项目
	 * 
	 * @param AggDO
	 * @return
	 * @throws BizException
	 */
	private UdidocDO[] getSrvtpDocList(WfAggDO AggDO) throws BizException {

		WfDO parentDO = AggDO.getParentDO();

		GetWfSrvtpDocSql Sql = new GetWfSrvtpDocSql(parentDO.getCode_entp(), parentDO.getEu_wftp(), parentDO.getId_wf());

		return (UdidocDO[]) AppFwUtil.getDORstWithDao(Sql, UdidocDO.class);
	}

	/**
	 * 校验其他
	 * 
	 * @param AggDO
	 * @param docList
	 */
	private List<String> validationOther(WfSrvtpDO[] srvtpArray, UdidocDO[] docList) {

		List<String> reList = new ArrayList<String>();

		if (srvtpArray != null && srvtpArray.length > 0) {

			for (WfSrvtpDO srvtpDO : srvtpArray) {

				List<String> list = validationOverLap(docList, srvtpDO);

				reList.addAll(list);
			}
		}

		return reList;
	}

	/**
	 * 检测叠加服务类型
	 * 
	 * @param srvtpList
	 * @param srvtpDO
	 * @return
	 */
	private List<String> validationOverLap(UdidocDO[] srvtpList, WfSrvtpDO srvtpDO) {

		List<String> reList = new ArrayList<String>();

		if (srvtpList != null && srvtpList.length > 0) {

			for (UdidocDO doc : srvtpList) {

				if (doc.getCode().indexOf(srvtpDO.getSd_srvtp()) == 0) {

					reList.add("服务类型【" + srvtpDO.getName() + "】与现有的【" + doc.getName() + "】有叠加");
					continue;
				}

				if (srvtpDO.getSd_srvtp().indexOf(doc.getCode()) == 0) {

					reList.add("服务类型【" + doc.getName() + "】已经包含了【" + srvtpDO.getName() + "】");
					continue;
				}
			}
		}

		return reList;
	}

	/**
	 * 异常信息处理
	 * 
	 * @param listMessage
	 * @throws BizException
	 */
	private void handelMessage(List<String> listMessage) throws BizException {

		if (listMessage.size() == 0) {
			return;
		}

		String reString = "";

		for (String msg : listMessage) {

			reString += (reString.length() == 0 ? "" : "\r\n") + msg;
		}

		throw new BizException(reString);
	}
}
