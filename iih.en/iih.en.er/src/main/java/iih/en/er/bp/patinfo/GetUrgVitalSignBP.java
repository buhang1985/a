package iih.en.er.bp.patinfo;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgPatInfoSrvDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.i.IEnentoperRService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.i.IEnerpreRService;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.i.IEnvtRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetUrgVitalSignBP {
	/**
	 * 获取急诊患者信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgPatInfoSrvDTO exec(String entId) throws BizException {
		if(entId == null){
			return null;
		}
		UrgPatInfoSrvDTO urgpat = new UrgPatInfoSrvDTO();
		//2.查询预检信息
		this.getEnErPreInfo(urgpat,entId);
		return urgpat;
	}

	/**
	 * 查询预检信息及年龄
	 * @param urgpat
	 * @param entId 
	 * @throws BizException 
	 */
	private void getEnErPreInfo(UrgPatInfoSrvDTO urgpat, String entId) throws BizException {
		//设置预检信息
		IEnentoperRService serv2 = ServiceFinder.find(IEnentoperRService.class);
		EnEntOpErDO[] enEntOpErDOs = serv2.findByAttrValString(EnEntOpErDO.ID_ENT, entId);
		if(enEntOpErDOs == null || enEntOpErDOs.length <= 0){
			return;
		}
		EnEntOpErDO opdo = enEntOpErDOs[0];
		urgpat.setId_erpre(opdo.getId_erpre());
		IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
		EnErPreDO erpre = serv.findById(opdo.getId_erpre());
		if(erpre == null){
			return ;
		}
		this.setVitalSign(urgpat);
	}
	
	private void setVitalSign(UrgPatInfoSrvDTO dto) throws BizException {
		if (dto == null) {
			return;
		}
		// 1.获取AggDO
		EnvtAggDO agg = getEnvtAggDO(dto.getId_erpre());
		if (agg == null) {
			return;
		}
		// 2.查询体征信息
		EnVtSrvDO[] enVtSrvDOs = agg.getEnVtSrvDO();
		if (EnValidator.isEmpty(enVtSrvDOs))
			return;
		FArrayList vs_list = new FArrayList();
		for (EnVtSrvDO enVtSrvDO : enVtSrvDOs) {
			PhySignDTO phySign = new PhySignDTO();
			phySign.setId_srv(enVtSrvDO.getId_srv());
			phySign.setVal0(enVtSrvDO.getVal0());
			phySign.setVal1(enVtSrvDO.getVal1());
			phySign.setVal2(enVtSrvDO.getVal2());
			phySign.setVal3(enVtSrvDO.getVal3());
			phySign.setVal4(enVtSrvDO.getVal4());
			vs_list.add(phySign);
		}
		dto.setVs_list(vs_list);

	}
	
	/**
	 * 获取aggDO
	 * 
	 * @param enerpre
	 * @return
	 * @throws BizException
	 */
	private EnvtAggDO getEnvtAggDO(String id_erpre) throws BizException{
		if(id_erpre == null){
			return null;
		}
		IEnvtRService serv = ServiceFinder.find(IEnvtRService.class);
		EnvtAggDO[] aggs = serv.find(String.format(" ID_ERPRE = '%s' ",id_erpre),"", FBoolean.FALSE);
		if(aggs == null || aggs.length<=0)
			return new EnvtAggDO();
		EnvtAggDO agg = aggs[0];
		return agg;
	}

}
	
	