package iih.bl.params.check;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.ICheckPara;
import xap.sys.devcfg.paramset.util.CheckParaDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 参数BLSTOEP0059校验器
 * @author ly 2019/11/21
 *
 */
public class BLSTOEP0059Checker implements ICheckPara {

	@SuppressWarnings("unchecked")
	@Override
	public CheckParaDO paraBeforeSavingCheck(ParamSetDO arg0) {
		
		CheckParaDO rlt = new CheckParaDO();
		rlt.setIsLegal(FBoolean.TRUE);

		String pmValue = arg0.getValue();
		if (StringUtil.isEmpty(pmValue)) {
			return rlt;
		}

		String[] srvIds = pmValue.split(",");
		DAFacade daf = new DAFacade();
		try {
			List<MedSrvDO> srvList = (List<MedSrvDO>) daf.findByPKs(MedSrvDO.class, srvIds);
			if (!ListUtil.isEmpty(srvList)) {
				for (MedSrvDO medSrvDO : srvList) {
					if (MedSrvBlModeEnum.MANUALBL.equals(medSrvDO.getEu_blmd())) {
						rlt.setIsLegal(FBoolean.FALSE);
						rlt.setErrMsg("不能设置手工划价项目：" + medSrvDO.getName());
						break;
					}
				}
			}
		} catch (DAException e) {
			e.printStackTrace();
		}
		
		return rlt;
	}
}
