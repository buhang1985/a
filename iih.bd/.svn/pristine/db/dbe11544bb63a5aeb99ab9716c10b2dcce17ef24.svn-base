package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.i.IMedSrvVtDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 生命体征类型医疗服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class VitalSignsSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckSigns(medSrvDO);
	}

	/**
	 * 检查生命体征属性
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckSigns(MedSrvDO medSrvDO) throws BizException {
		MedSrvVtDO medSrvVtDo = GetVtData(medSrvDO);
		if (medSrvVtDo == null) {
			String msg = String.format("医疗服务\"%s\"生命体征属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
		CheckSignsNullProp(medSrvVtDo, medSrvDO);
	}

	/**
	 * 检查医疗服务生命体征属性空属性值
	 * 
	 * @param medSrvVtDo
	 * @throws BizException
	 */
	private void CheckSignsNullProp(MedSrvVtDO medSrvVtDo, MedSrvDO medSrvDO) throws BizException {
		String msg = String.format("医疗服务\"%s\"生命体征属性中", medSrvDO.getName());
		if (StringUtil.isEmpty(medSrvVtDo.getId_de())) {
			msg = String.format("%s公共数据元为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvVtDo.getId_dedatatp())) {
			msg = String.format("%s数据类型为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvVtDo.getSd_dedatatp())) {
			msg = String.format("%s数据类型编码为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvVtDo.getFg_pos() != null && medSrvVtDo.getFg_pos().equals(FBoolean.TRUE)
				&& StringUtil.isEmpty(medSrvVtDo.getId_vt_pos_def())) {
			msg = String.format("%s部位为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvVtDo.getFg_aux() != null && medSrvVtDo.getFg_aux().equals(FBoolean.TRUE)
				&& StringUtil.isEmpty(medSrvVtDo.getId_vt_aux_ca())) {
			msg = String.format("%s辅助措施分类为空。", msg);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取生命体征属性值
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvVtDO GetVtData(MedSrvDO medSrvDO) throws BizException {
		IMedSrvVtDORService medSrvVtDORService = ServiceFinder.find(IMedSrvVtDORService.class);
		MedSrvVtDO[] result = medSrvVtDORService.findByAttrValString(MedSrvVtDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

}
