package iih.bd.fc.wf.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfCudService;
import iih.bd.fc.wf.i.IWfRService;
import iih.bd.fc.wf.i.IWfSrvtpDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class SaveBp {

	/**
	 * 医嘱流向保存
	 * 
	 * @author xuxing2016-07-14
	 * @param AggDO
	 * @return
	 * @throws BizException
	 */
	public WfAggDO exec(WfAggDO AggDO) throws BizException {

		// 1、验证
		if (!validation(AggDO)) {
			return null;
		}

		// 2、构建服务类型
		buildSrvtp(AggDO);

		// 3、外键赋值
		setPrimaryKey(AggDO);

		// 4、验证同一就诊类型、同一流向服务类型编码是否重复
		// ValidatWfSrvtpSd(AggDO);

		// 4.5、服务类型叠加校验
		overLapValidation(AggDO);

		// 5、保存返回
		WfAggDO savedAggdo = Save(AggDO);

		// 6、组装AggDO
		packageAggDO(savedAggdo);

		return savedAggdo;
	}

	/**
	 * 验证同一就诊类型、同一流向服务类型编码是否重复
	 * 
	 * @param aggDO
	 * @throws BizException
	 */
	private void ValidatWfSrvtpSd(WfAggDO aggDO) throws BizException {
		ValidatWfSrvtpSd validat = new ValidatWfSrvtpSd();
		validat.exec(aggDO);
	}

	/**
	 * 保存之前生成服务类型子表数据
	 *
	 */
	public void setupSrvtpList(WfAggDO AggDO) throws BizException {
		// 1、验证
		if (!validation(AggDO)) {
			return;
		}
		// 2、构建服务类型
		buildSrvtp(AggDO);
	}

	/**
	 * 数据验证
	 * 
	 * @param AggDO
	 */
	private boolean validation(WfAggDO AggDO) throws BizException {

		boolean reBool = false;

		if (AggDO != null) {

			WfDO wfDO = AggDO.getParentDO();

			if (wfDO != null) {

				if (!StringUtil.isEmpty(wfDO.getId_srvtp())) {

					reBool = true;

				} else {

					throw new BizException("医嘱流向配置保存，服类型不能为空！");
				}
			}
		}

		return reBool;
	}

	/**
	 * 构建服务类型
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	private void buildSrvtp(WfAggDO AggDO) throws BizException {

		List<WfSrvtpDO> saveList = new ArrayList<WfSrvtpDO>();

		InitDelete(AggDO, saveList);

		UdidocDO[] SrvtpDOS = getSrvtpDOS(AggDO.getParentDO());

		if (SrvtpDOS != null && SrvtpDOS.length > 0) {

			for (UdidocDO udidocDO : SrvtpDOS) {

				WfSrvtpDO srvtp = new WfSrvtpDO();
				srvtp.setId_wf(AggDO.getParentDO().getId_wf());
				srvtp.setId_srvtp(udidocDO.getId_udidoc());
				srvtp.setSd_srvtp(udidocDO.getCode());
				srvtp.setName(udidocDO.getName());
				srvtp.setStatus(DOStatus.NEW);
				saveList.add(srvtp);
			}
		}

		AggDO.setWfSrvtpDO(saveList.toArray(new WfSrvtpDO[saveList.size()]));
	}

	/**
	 * 删除现有的服务类型
	 * 
	 * @param AggDO
	 * @param saveList
	 * @throws BizException
	 */
	private void InitDelete(WfAggDO AggDO, List<WfSrvtpDO> saveList) throws BizException {

		WfSrvtpDO[] srvtpDOS = AggDO.getWfSrvtpDO();

		if (srvtpDOS != null && srvtpDOS.length > 0) {

			for (WfSrvtpDO wfSrvtpDO : srvtpDOS) {

				wfSrvtpDO.setStatus(DOStatus.DELETED);
				saveList.add(wfSrvtpDO);
			}
		}
		IWfSrvtpDOCudService iWfSrvtpDOCudService = ServiceFinder.find(IWfSrvtpDOCudService.class);
		iWfSrvtpDOCudService.delete(saveList.toArray(new WfSrvtpDO[saveList.size()]));
		saveList.clear();
	}

	/**
	 * 根据页面传来的服务类型串获取服务类型集合
	 * 
	 * @param wfDO
	 * @return
	 * @throws BizException
	 */
	private UdidocDO[] getSrvtpDOS(WfDO wfDO) throws BizException {

		IUdidocRService findService = ServiceFinder.find(IUdidocRService.class);

		List<String> listSrvtp = new ArrayList<String>();

		for (String id_srvtp : wfDO.getId_srvtp().split(",")) {

			listSrvtp.add(id_srvtp);
		}

		return findService.findByIds(listSrvtp.toArray(new String[listSrvtp.size()]), FBoolean.FALSE);
	}

	/**
	 * 外键赋值
	 * 
	 * @param AggDO
	 */
	private void setPrimaryKey(WfAggDO AggDO) {

		if (AggDO != null) {

			for (BaseDO baseOD : AggDO.getAllChildrenDO()) {

				if (baseOD.getStatus() == DOStatus.NEW) {

					baseOD.setAttrVal("Id_wf", AggDO.getParentDO().getId_wf());
				}
			}
		}

	}

	/**
	 * 服务类型叠加校验
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	private void overLapValidation(WfAggDO AggDO) throws BizException {

		wfSaveValidationBp bp = new wfSaveValidationBp();

		bp.exec(AggDO);
	}

	/**
	 * 保存结果
	 * 
	 * @param AggDO
	 * @return
	 * @throws BizException
	 */
	private WfAggDO Save(WfAggDO AggDO) throws BizException {

		IWfCudService saveService = ServiceFinder.find(IWfCudService.class);

		WfAggDO[] saveAggDO = saveService.save(new WfAggDO[] { AggDO });

		if (saveAggDO != null && saveAggDO.length == 1) {

			return saveAggDO[0];
		}

		return null;
	}

	/**
	 * 组装AggDO
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	private void packageAggDO(WfAggDO AggDO) throws BizException {

		IWfRService findService = ServiceFinder.find(IWfRService.class);

		WfAggDO aggDO = findService.findById(AggDO.getParentDO().getId_wf());

		packageWfAggBp bp = new packageWfAggBp();

		bp.exec(new WfAggDO[] { aggDO });
	}
}
