package iih.bl.inc.s.bp.ecinc;

import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blecincprint.d.BlEcSwithPaperInDTO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperCudService;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 打印成功后回写纸质票据
 * @author ly 2020/01/07
 *
 */
public class BlEcIncWriteBackPaperOpBP {

	/**
	 * 打印成功后回写纸质票据
	 * @param dto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlEcSwithPaperInDTO dto) throws BizException{
	
		DAFacade daf = new DAFacade();
		List<BlIncOepDO> list = (List<BlIncOepDO>)daf.findByAttrValString(BlIncOepDO.class, BlIncOepDO.ID_STOEP, dto.getId_st(), null);
		BlIncOepDO incDO = list.get(0);
		List<BlIncOepPaperDO> paperList = (List<BlIncOepPaperDO>)daf.findByAttrValString(BlIncOepPaperDO.class, BlIncOepPaperDO.ID_INCOEP, incDO.getId_incoep(), null);
		if(ListUtil.isEmpty(paperList)){
			this.insertNewPaperDO(incDO, dto.getPinc_code(), dto.getPincno());
		}else{
			BlIncOepPaperDO papaerDO = paperList.get(0);
			this.insertNewCancelDO(papaerDO);

			papaerDO.setInc_code(dto.getPinc_code());
			papaerDO.setIncno(dto.getPincno());
			papaerDO.setStatus(DOStatus.UPDATED);

			IBlincoeppaperCudService paperServive = ServiceFinder.find(IBlincoeppaperCudService.class);
			paperServive.update(new BlIncOepPaperDO[] { papaerDO });
		}
	}
	
	/**
	 * 
	 * @param incDO
	 * @param pinc_code
	 * @param pincno
	 * @throws BizException
	 */
	private void insertNewPaperDO(BlIncOepDO incDO, String pinc_code, String pincno) throws BizException {
		
		BlIncOepPaperDO paperDO = new BlIncOepPaperDO();
		paperDO.setId_incoep(incDO.getId_incoep());
		paperDO.setId_grp(Context.get().getGroupId());
		paperDO.setId_org(Context.get().getOrgId());
		paperDO.setId_pat(incDO.getId_pat());
		//paperDO.setId_ent(incDO.getid_ent);
		paperDO.setId_entp(incDO.getId_enttp());
		paperDO.setCode_entp(incDO.getCode_enttp());
		paperDO.setId_incca(incDO.getId_incca());
		paperDO.setEu_direct(incDO.getEu_direct());
		paperDO.setEc_incno(incDO.getIncno());
		//paperDO.setCode_incpkg(Code_incpkg);
		paperDO.setInc_code(pinc_code);
		paperDO.setIncno(pincno);
		paperDO.setDt_inc(new FDateTime());
		paperDO.setId_emp_inc(Context.get().getStuffId());
		paperDO.setId_dep_inc(Context.get().getDeptId());
		paperDO.setTimes_prn(1);
		paperDO.setFg_canc(FBoolean.FALSE);
		paperDO.setId_stoep(incDO.getId_stoep());
		paperDO.setStatus(DOStatus.NEW);
		
		IBlincoeppaperCudService paperServive = ServiceFinder.find(IBlincoeppaperCudService.class);
		paperServive.insert(new BlIncOepPaperDO[]{paperDO});
	}
 
	/**
	 * 插入空白作废票
	 * @param papaerDO
	 * @throws BizException
	 */
	private void insertNewCancelDO(BlIncOepPaperDO papaerDO) throws BizException {
		
		BlIncCancDO cancDO = new BlIncCancDO();
		cancDO.setId_grp(Context.get().getGroupId());
		cancDO.setId_org(Context.get().getOrgId());
		cancDO.setId_incca(papaerDO.getId_incca());
		cancDO.setCode_incpkg(papaerDO.getCode_incpkg());
		cancDO.setIncno(papaerDO.getIncno());
		cancDO.setFg_canc(FBoolean.TRUE);
		cancDO.setId_reason_canc(IBlDictCodeConst.ID_RES_INCCANC_PRINTERROR);
		cancDO.setSd_reason_canc(IBlDictCodeConst.SD_RES_INCCANC_PRINTERROR);
		cancDO.setDes_reason_canc("打印故障");
		cancDO.setDt_canc(BlFlowContextUtil.getNowTime());
		cancDO.setId_emp_canc(Context.get().getStuffId());
		cancDO.setFg_cc(FBoolean.FALSE);
		cancDO.setId_pc(BlParams.getRealPcId(Context.get().getClientHost()));
		cancDO.setFg_ec_inc(FBoolean.TRUE);
		cancDO.setStatus(DOStatus.NEW);
		
		IBlinccancCudService cudService = ServiceFinder.find(IBlinccancCudService.class);
		cudService.insert(new BlIncCancDO[]{cancDO});
	}
}
