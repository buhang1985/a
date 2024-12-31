package iih.en.er.bp.pre;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.validator.EnValidator;
import iih.en.pub.IEnFunCodeConst;
import iih.mp.mpbd.dto.vstmatch.d.VstmatchparanDTO;
import iih.mp.mpbd.vstrule.d.EnumSexTp;
import iih.mp.nr.i.IMpNrQueryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取急诊预检模板
 * 
 * @author liubin
 *
 */
public class GetErPreTplBP {
	/**
	 * 获取急诊预检模板
	 * 
	 * @return
	 * @throws BizException
	 */
	public PhySignDTO[] exec() throws BizException {
		VstmatchparanDTO vstmatchparanDTO = new VstmatchparanDTO();
		String depId = null;
		depId = EnValidator.isEmpty(depId)?Context.get().getDeptId(): depId;
		vstmatchparanDTO.setId_dep(depId);
		vstmatchparanDTO.setFg_newborn(FBoolean.FALSE);
		vstmatchparanDTO.setFun_code(IEnFunCodeConst.FUN_CODE_URGPRECHECKLEVEL);
		vstmatchparanDTO.setEu_sex(EnumSexTp.GENERAL);
		vstmatchparanDTO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_ET);
		IMpNrQueryService serv = ServiceFinder.find(IMpNrQueryService.class);
		return serv.getPhySignDTOInfo(vstmatchparanDTO);
	}
}
