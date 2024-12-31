package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.utils.SQLTransferMeaningUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 检查医疗服务名称唯一性
 * 
 * @author hao_wu
 *
 */
public class CheckNameUniqueBp {

	/**
	 * 检查标识</br>
	 * 医院存在重名服务，不进行名称检查
	 */
	private boolean _checkFlag = false;

	public void exec(MedSrvDO[] medSrvArr) throws BizException {
		if (medSrvArr == null || medSrvArr.length <= 0) {
			return;
		}

		if (_checkFlag) {
			ArrayList<MedSrvDO> medSrvList = ArrayListUtil.ConvertToArrayList(medSrvArr);

			CheckNameUnique(medSrvList);
		}
	}

	/**
	 * 检查名称唯一性
	 * 
	 * @param medSrvList
	 * @throws BizException
	 */
	private void CheckNameUnique(ArrayList<MedSrvDO> medSrvList) throws BizException {
		CheckNameUniqueOnList(medSrvList);

		String wherePart = BuildWherePart(medSrvList);
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] result = medsrvMDORService.find(wherePart, "code", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			String msg = GetNameRepeatMsg(result[0]);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取名称重复消息
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private String GetNameRepeatMsg(MedSrvDO medSrvDO) throws BizException {
		String sdSrvtp = medSrvDO.getSd_srvtp().substring(0, 2);
		UdidocDO result = UdidocUtils.getUdidocByCode(IBdSrvDictCodeTypeConst.SD_SRVTP, sdSrvtp);
		String msg = String.format("服务类型下服务名称不允许重复,\"%s\"下已存在服务名称为\"%s\"的服务。", result.getName(), medSrvDO.getName());
		return msg;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart(ArrayList<MedSrvDO> medSrvList) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");
		wherePartBuilder.append(" and ( 1 <> 1 ");
		for (MedSrvDO medSrvDO : medSrvList) {
			String tempStr = String.format(" or (sd_srvtp like '%s%%' and name = '%s' and id_srv <> '%s')",
					medSrvDO.getSd_srvtp().substring(0, 2), SQLTransferMeaningUtil.tmsql(medSrvDO.getName()),
					((medSrvDO.getId_srv() == null || medSrvDO.getId_srv().isEmpty()) ? "~" : medSrvDO.getId_srv()));
			wherePartBuilder.append(tempStr);
		}
		wherePartBuilder.append(" )");

		return wherePartBuilder.toString();
	}

	/**
	 * 列表内检查名称唯一性
	 * 
	 * @param medSrvList
	 * @throws BizException
	 */
	private void CheckNameUniqueOnList(ArrayList<MedSrvDO> medSrvList) throws BizException {
		int listSize = medSrvList.size();
		for (int i = 0; i < listSize; i++) {
			for (int j = i + 1; j < listSize; j++) {
				MedSrvDO data1 = medSrvList.get(i);
				MedSrvDO data2 = medSrvList.get(j);
				CheckNameUnique(data1, data2);
			}
		}
	}

	/**
	 * 检查两数据名称唯一性
	 * 
	 * @param data1
	 * @param data2
	 * @throws BizException
	 */
	private void CheckNameUnique(MedSrvDO data1, MedSrvDO data2) throws BizException {
		CheckSrvTp(data1);
		CheckSrvTp(data2);
		String sd_srvtp1 = data1.getSd_srvtp().substring(0, 2);
		String sd_srvtp2 = data2.getSd_srvtp().substring(0, 2);
		if (sd_srvtp1.equals(sd_srvtp2) && data1.getName().equals(data2.getName())) {
			String msg = GetNameRepeatMsg(data1);
			throw new BizException(msg);
		}
	}

	/**
	 * 检查服务类型
	 * 
	 * @param medsrvDo
	 * @throws BizException
	 */
	private void CheckSrvTp(MedSrvDO medsrvDo) throws BizException {
		String sdSrvtp = medsrvDo.getSd_srvtp();
		if (sdSrvtp == null || sdSrvtp.isEmpty()) {
			String msg = String.format("服务类型不允许为空,服务\"%s\"的服务类型为空。", medsrvDo.getName());
			throw new BizException(msg);
		}
	}
}
