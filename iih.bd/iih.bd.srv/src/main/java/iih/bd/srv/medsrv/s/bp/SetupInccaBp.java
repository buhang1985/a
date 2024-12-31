package iih.bd.srv.medsrv.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.log.BdSrvLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 安装票据分类项目业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SetupInccaBp {

	public void exec(MedSrvDO[] medSrvArr) throws BizException {
		MedSrvDO[] drugSrv = GetMedDrugSrvArray(medSrvArr);
		if (drugSrv == null || drugSrv.length <= 0) {
			return;
		}

		HashMap<String, IncCaItmRelDO> inccaItmRelMap = getInccaItmRelMap(drugSrv);
		BdSrvLogUtils.info("票据分类项目关系字典大小:%s", inccaItmRelMap.size());
		setupIncca(drugSrv, inccaItmRelMap);
	}

	/**
	 * 获取药品服务列表
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private MedSrvDO[] GetMedDrugSrvArray(MedSrvDO[] medSrvArr) {
		ArrayList<MedSrvDO> drugSrvList = new ArrayList<MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (medSrvDO != null && medSrvDO.getSd_srvtp() != null
					&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				drugSrvList.add(medSrvDO);
			}
		}
		return drugSrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 获取票据分类项目对照字典
	 * 
	 * @param medSrvArr
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, IncCaItmRelDO> getInccaItmRelMap(MedSrvDO[] medSrvArr) throws BizException {
		ArrayList<String> medSrvIdList = getMedSrvIdList(medSrvArr);
		HashMap<String, IncCaItmRelDO> inccaItmRelMap = getInccaItmRelMap(medSrvIdList);
		return inccaItmRelMap;
	}

	/**
	 * 通过医疗服务id列表获取票据分类项目对照字典
	 * 
	 * @param medSrvIdList
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, IncCaItmRelDO> getInccaItmRelMap(ArrayList<String> medSrvIdList) throws BizException {
		IncCaItmRelDO[] incCaItmRelDOArr = getInccaItmRelArr(medSrvIdList);
		HashMap<String, IncCaItmRelDO> inccaItmRelMap = getInccaItmRelMap(incCaItmRelDOArr);
		return inccaItmRelMap;
	}

	/**
	 * 通过票据分类项目对照列表构建票据分类项目对照字典
	 * 
	 * @param incCaItmRelDOArr
	 * @return
	 */
	private HashMap<String, IncCaItmRelDO> getInccaItmRelMap(IncCaItmRelDO[] incCaItmRelDOArr) {
		HashMap<String, IncCaItmRelDO> inccaItmRelMap = new HashMap<String, IncCaItmRelDO>();
		for (IncCaItmRelDO incCaItmRelDO : incCaItmRelDOArr) {
			String key = getInccaItmRelMapKey(incCaItmRelDO.getId_srv(), incCaItmRelDO.getId_incca());
			inccaItmRelMap.put(key, incCaItmRelDO);
		}
		return inccaItmRelMap;
	}

	/**
	 * 通过医疗服务id列表获取票据分类项目数组
	 * 
	 * @param medSrvIdList
	 * @return
	 * @throws BizException
	 */
	private IncCaItmRelDO[] getInccaItmRelArr(ArrayList<String> medSrvIdList) throws BizException {
		IInccaitmrelRService inccaitmrelRService = ServiceFinder.find(IInccaitmrelRService.class);
		String whereStr = String.format("id_srv in (%s) and sd_incca in (%s)", getMedSrvIdWhereInStr(medSrvIdList),
				getInccaCodeWhereInStr());
		IncCaItmRelDO[] incCaItmRelDOArr = inccaitmrelRService.find(whereStr, "", new FBoolean(false));
		return incCaItmRelDOArr;
	}

	/**
	 * 获取医疗服务id过滤条件字符串
	 * 
	 * @param medSrvIdList
	 * @return
	 */
	private String getMedSrvIdWhereInStr(ArrayList<String> medSrvIdList) {
		StringBuffer whereIn = new StringBuffer();
		int listSize = medSrvIdList.size();
		for (int i = 0; i < listSize; i++) {
			if (i != 0) {
				whereIn.append(", ");
			}
			String medSrvId = medSrvIdList.get(i);
			String str = String.format("'%s'", medSrvId);
			whereIn.append(str);
		}
		return whereIn.toString();
	}

	/**
	 * 获取票据分类id过滤条件字符串
	 * 
	 * @return
	 */
	private String getInccaCodeWhereInStr() {
		return String.format("'%s', '%s'", IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE,
				IBdInccaCodeConst.CODE_INHOS_INVOICE);
	}

	/**
	 * 获取医疗服务主键列表
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private ArrayList<String> getMedSrvIdList(MedSrvDO[] medSrvArr) {
		ArrayList<String> medSrvIdLis = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			String idSrv = medSrvDO.getId_srv();
			medSrvIdLis.add(idSrv);
		}
		return medSrvIdLis;
	}

	/**
	 * 安装票据分类项目信息
	 * 
	 * @param medSrvArr
	 * @param inccaItmRelMap
	 */
	private void setupIncca(MedSrvDO[] medSrvArr, HashMap<String, IncCaItmRelDO> inccaItmRelMap) {
		for (MedSrvDO medSrvDO : medSrvArr) {
			setupInccaOp(medSrvDO, inccaItmRelMap);
			setupInccaIp(medSrvDO, inccaItmRelMap);
		}
	}

	/**
	 * 安装门诊账单项
	 * 
	 * @param medSrvDO
	 * @param inccaItmRelMap
	 */
	private void setupInccaOp(MedSrvDO medSrvDO, HashMap<String, IncCaItmRelDO> inccaItmRelMap) {
		String mapKey = getInccaItmRelMapKey(medSrvDO.getId_srv(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		IncCaItmRelDO incCaItmRelDO = inccaItmRelMap.get(mapKey);
		BdSrvLogUtils.info("安装门诊账单项,Key:%s,Value:%s", mapKey,
				incCaItmRelDO == null ? "null" : incCaItmRelDO.toString());
		if (incCaItmRelDO != null) {
			medSrvDO.setIncca_op(incCaItmRelDO.getId_inccaitm());
			medSrvDO.setInccaitmop_name(incCaItmRelDO.getInccaitm_name());
		}
	}

	/**
	 * 安装住院账单项
	 * 
	 * @param medSrvDO
	 * @param inccaItmRelMap
	 */
	private void setupInccaIp(MedSrvDO medSrvDO, HashMap<String, IncCaItmRelDO> inccaItmRelMap) {
		String mapKey = getInccaItmRelMapKey(medSrvDO.getId_srv(), IBdInccaCodeConst.ID_INHOS_INVOICE);
		IncCaItmRelDO incCaItmRelDO = inccaItmRelMap.get(mapKey);
		BdSrvLogUtils.info("安装住院账单项,Key:%s,Value:%s", mapKey,
				incCaItmRelDO == null ? "null" : incCaItmRelDO.toString());
		if (incCaItmRelDO != null) {
			medSrvDO.setIncca_ip(incCaItmRelDO.getId_inccaitm());
			medSrvDO.setInccaitmip_name(incCaItmRelDO.getInccaitm_name());
		}
	}

	/**
	 * 构建票据分类项目对照字段Key
	 * 
	 * @param id_srv
	 * @param id_incca
	 * @return
	 */
	private String getInccaItmRelMapKey(String id_srv, String id_incca) {
		return String.format("%s%s", id_srv, id_incca);
	}
}
