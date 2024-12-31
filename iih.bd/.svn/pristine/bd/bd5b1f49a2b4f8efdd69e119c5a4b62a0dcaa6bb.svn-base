package iih.bd.srv.medsrv.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查类型服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class RisSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}
		String sdSrvTp = medSrvDO.getSd_srvtp();
		if (sdSrvTp.length() >= 4 && sdSrvTp.substring(0, 4).equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
			// 病理属于检验，所以需进行检验类型的数据检查
			LisSrvEnableCheckBp bp = new LisSrvEnableCheckBp();
			bp.exec(medSrvDO);
			return;
		}
		CheckRis(medSrvDO);
	}

	/**
	 * 检查医疗服务检查属性数据
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckRis(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)) {
			// 服务套不检查检查属性
			return;
		}
		MedSrvRisDO medSrvRisDo = GetRisData(medSrvDO);
		if (medSrvRisDo == null) {
			String msg = String.format("医疗服务\"%s\"检查属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
		CheckRisNullProp(medSrvRisDo, medSrvDO);
	}

	/**
	 * 检查医疗服务检查属性空属性值
	 * 
	 * @param medSrvRisDo
	 * @throws BizException
	 */
	private void CheckRisNullProp(MedSrvRisDO medSrvRisDo, MedSrvDO medSrvDO) throws BizException {
		String msg = String.format("医疗服务\"%s\"检查属性中", medSrvDO.getName());
		// 可空 吴浩 已与PO确认 20171016
		// if (StringUtil.isEmpty(medSrvRisDo.getId_body())) {
		// msg = String.format("%s身体部位为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvRisDo.getSd_body())) {
		// msg = String.format("%s身体部位编码为空。", msg);
		// throw new BizException(msg);
		// }
		if (medSrvRisDo.getFg_body_update() == null) {
			msg = String.format("%s部位可修改标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvRisDo.getIf_mp_bed() == null) {
			msg = String.format("%s是否床边执行标识为空。", msg);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取检查属性
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvRisDO GetRisData(MedSrvDO medSrvDO) throws BizException {
		IMedSrvRisDORService medSrvRisDORService = ServiceFinder.find(IMedSrvRisDORService.class);
		MedSrvRisDO[] result = medSrvRisDORService.findByAttrValString(MedSrvRisDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

}
