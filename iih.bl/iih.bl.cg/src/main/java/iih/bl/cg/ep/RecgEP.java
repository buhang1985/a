package iih.bl.cg.ep;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 重划价EP
 * @author liwq	2017年7月1日12:23:30
 *
 */
public class RecgEP {

	/**
	 * 更新就诊域和PI域中的价格分类ID主键
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param id_pripat_to 新价格分类id
	 * @author liwq 
	 */
	public void updatePirPat(String id_pat, String id_ent, String newPripat) throws BizException {
		//1.1	更新就诊域中价格分类id
		IEnOutCmdService iEnOutCmdService=ServiceFinder.find(IEnOutCmdService.class);
		iEnOutCmdService.updateEntPriPat(id_ent,newPripat);
		//1.2	更新PI域中价格分类id
		IPatiMDORService iPatiMDORService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = iPatiMDORService.findById(id_pat);
		patDo.setId_patpritp(newPripat);
		patDo.setStatus(DOStatus.UPDATED);
		PatDO[] patDos = new PatDO[]{patDo};
		IPatiMDOCudService iPatiMDOCudService = ServiceFinder.find(IPatiMDOCudService.class);
		PatDO[] patDoArr = iPatiMDOCudService.save(patDos);
		if (ArrayUtil.isEmpty(patDoArr)) {
			throw new BizException("更新PI域中价格分类ID失败！");
		}			
	}
	

	/**
	 * 根据价格分类id，获取该价格分类下的服务项目
	 * @param id_pripat
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public SrvPricalRateAndPriceDTO[] getSrvPriceRate(String id_pripat) throws BizException {
		IPriCalService iPriCalService = ServiceFinder.find(IPriCalService.class);
		SrvPricalRateAndPriceDTO[] srvPriceRate = iPriCalService.GetAllSrvRatelByIdPripat(id_pripat);
		return srvPriceRate;
	}
	
	/**
	 * 获取价格分类比例
	 * @param idPriPat
	 * @return
	 * @throws BizException
	 */
	public PriPatDO getPriPatDO(String idPriPat) throws BizException {
		String[] fields = { "Id_pripat", "Rate" };
		DAFacade dAFacade = new DAFacade();
		List<PriPatDO> priPatDOList = (List<PriPatDO>) dAFacade.findByCond(PriPatDO.class, " Id_pripat='" + idPriPat + "' ", "1", fields);
		if (ListUtil.isEmpty(priPatDOList)) {
			throw new BizException("没有找到患者就诊对应的价格分类 ！");
		}
		return priPatDOList.get(0);
	}
	
}
