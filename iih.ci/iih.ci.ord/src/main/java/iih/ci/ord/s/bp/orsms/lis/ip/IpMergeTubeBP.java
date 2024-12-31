package iih.ci.ord.s.bp.orsms.lis.ip;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 住院合管后生成容器费医嘱和采集费医嘱
 * 
 * @author zhangwq
 *
 */
public class IpMergeTubeBP extends MergeTubeBP {
	public IpMergeTubeBP(CiEnContextDTO ctx) {
		super(ctx);
	}

	/**
	 * 是否生成采集费
	 * @return
	 */
	protected FBoolean isCreateSampcol(){
		try {
			return ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_IP_LIS_CREATEBLORDER);
		} catch (BizException e) {
			return FBoolean.FALSE;
		}
	}

	@Override
	protected CiOrderDO saveOrder(CiEmsDTO ciEmsDTO) throws BizException {
		CiOrderDO[] ciOrderDOs = this.getMainService().SaveCiEmsDTO_TL(ciEmsDTO, this.getCtx());
		// 新生成的管费和采集费的医嘱保存成功后不签署，改为和医生开立的医嘱一块签署 20190603
		if (ciOrderDOs != null) {
			return ciOrderDOs[0];
		}
		return null;
	}
	
}
