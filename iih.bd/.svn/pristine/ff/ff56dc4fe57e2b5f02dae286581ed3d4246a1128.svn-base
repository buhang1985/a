package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医疗服务后保存票据分类项目对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveIncCaItmRelAfterSaveDrugNamesBp {

	public void exec(MedSrvDO[] medSrvArray) throws BizException {
		if (medSrvArray == null || medSrvArray.length <= 0) {
			return;
		}
		MedSrvDO[] drugSrvArray = GetDrugSrvArray(medSrvArray);
		ClearIncCaItmRel(drugSrvArray);
		InsertIncCaItmRel(drugSrvArray);
	}

	/**
	 * 插入医疗服务相关的票据分类项目对照信息
	 * 
	 * @param drugSrvArray
	 * @throws BizException
	 */
	private void InsertIncCaItmRel(MedSrvDO[] drugSrvArray) throws BizException {
		IncCaItmRelDO[] incCaItmRelArray = BuildIncCaItmRelArray(drugSrvArray);
		if (incCaItmRelArray == null || incCaItmRelArray.length <= 0) {
			return;
		}
		IInccaitmrelCudService inccaitmrelCudService = ServiceFinder.find(IInccaitmrelCudService.class);
		inccaitmrelCudService.insert(incCaItmRelArray);
	}

	private IncCaItmRelDO[] BuildIncCaItmRelArray(MedSrvDO[] drugSrvArray) throws BizException {
		ArrayList<IncCaItmRelDO> incCaItmRelList = new ArrayList<IncCaItmRelDO>();
		for (MedSrvDO medSrvDO : drugSrvArray) {
			if (medSrvDO == null) {
				throw new BizException("医疗服务不允许为空。");
			}
			if (StringUtils.isBlank(medSrvDO.getId_srv())) {
				throw new BizException("医疗服务主键不允许为空。");
			}
			if (medSrvDO != null && medSrvDO.getId_srv() != null) {
				if (StringUtils.isNotBlank(medSrvDO.getIncca_op())) {
					// 门诊账单项
					IncCaItmRelDO incCaItmRelDO = CreateOpIncCaItmRelDO();
					incCaItmRelDO.setId_inccaitm(medSrvDO.getIncca_op());
					incCaItmRelDO.setId_srv(medSrvDO.getId_srv());
					incCaItmRelDO.setId_srvca(medSrvDO.getId_srvca());
					incCaItmRelList.add(incCaItmRelDO);
				}
				if (StringUtils.isNotBlank(medSrvDO.getIncca_ip())) {
					// 住院账单项
					IncCaItmRelDO incCaItmRelDO = CreateIpIncCaItmRelDO();
					incCaItmRelDO.setId_inccaitm(medSrvDO.getIncca_ip());
					incCaItmRelDO.setId_srv(medSrvDO.getId_srv());
					incCaItmRelDO.setId_srvca(medSrvDO.getId_srvca());
					incCaItmRelList.add(incCaItmRelDO);
				}
			}
		}
		return incCaItmRelList.toArray(new IncCaItmRelDO[0]);
	}

	/**
	 * 创建门诊票据分类项目对照信息
	 * 
	 * @return
	 */
	private IncCaItmRelDO CreateIpIncCaItmRelDO() {

		IncCaItmRelDO incCaItmRelDO = CreateIncCaItmRelDO();
		incCaItmRelDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
		incCaItmRelDO.setSd_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE);
		return incCaItmRelDO;
	}

	/**
	 * 创建住院票据分类项目对照信息
	 * 
	 * @return
	 */
	private IncCaItmRelDO CreateOpIncCaItmRelDO() {
		IncCaItmRelDO incCaItmRelDO = CreateIncCaItmRelDO();
		incCaItmRelDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		incCaItmRelDO.setSd_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
		return incCaItmRelDO;
	}

	/**
	 * 创建票据分类项目对照信息
	 * 
	 * @return
	 */
	private IncCaItmRelDO CreateIncCaItmRelDO() {
		IncCaItmRelDO incCaItmRelDO = new IncCaItmRelDO();
		incCaItmRelDO.setId_grp(Context.get().getGroupId());
		incCaItmRelDO.setId_org(Context.get().getOrgId());
		return incCaItmRelDO;
	}

	/**
	 * 清除医疗服务相关的票据分类项目对照
	 * 
	 * @param drugSrvArray
	 * @throws BizException
	 */
	private void ClearIncCaItmRel(MedSrvDO[] drugSrvArray) throws BizException {
		DelIncCaItmRelBp bp = new DelIncCaItmRelBp();
		bp.exec(drugSrvArray);
	}

	/**
	 * 从医疗服务列表中获取药品服务列表
	 * 
	 * @param medSrvArray
	 * @return
	 */
	private MedSrvDO[] GetDrugSrvArray(MedSrvDO[] medSrvArray) {
		ArrayList<MedSrvDO> drugSrvList = new ArrayList<MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvArray) {
			if (medSrvDO != null && medSrvDO.getSd_srvtp() != null
					&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				drugSrvList.add(medSrvDO);
			}
		}
		return drugSrvList.toArray(new MedSrvDO[0]);
	}

}
