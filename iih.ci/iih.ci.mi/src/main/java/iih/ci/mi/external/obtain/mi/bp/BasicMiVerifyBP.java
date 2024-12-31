package iih.ci.mi.external.obtain.mi.bp;

import java.util.ArrayList;
import java.util.List;

import com.enterprisewechat.cp.util.StringUtils;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.mi.diag.i.meta.CiMiDiagDTO;
import iih.ci.mi.sysparam.CiMiParamUtil;
import iih.ci.mi.sysparam.CiMiParamValConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public abstract  class BasicMiVerifyBP {

	private ICidiagQryService diagService;
	private IMiMcRuleService miMcRuleService;

	public BasicMiVerifyBP() {
		miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
		diagService = ServiceFinder.find(ICidiagQryService.class);
	}
	
	public boolean isMiVerifyEnabled(CiEnContextDTO ctx) throws BizException{
		return isEnabledVerify(ctx);
	}
	
	/**
	 * 判断当前患者是否为医保就诊患者
	 * @param CiEnContextDTO 当前患者就诊环境对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public boolean isHpPat(CiEnContextDTO ctx) {

		return MiEnContextUtil.isHpPat(ctx);
	}
	
	public abstract boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException;
	
	/**
	 * 获取就诊诊断
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	protected List<CiMiDiagDTO> getMiDiagLsit(String id_en) throws BizException {
		
		List<String> idDidefList = new ArrayList<String>();
		List<CiMiDiagDTO> diagList = new ArrayList<CiMiDiagDTO>();
		
		// 	MHIR0001 特殊病判断模式 ，0：病种模式时；1：诊断模式， 诊断模式时传入诊断，病种模式不传入诊断
        
        /*if (CiMiParamUtil.MHIR0001() != 1)
        {
            return diagList;
        }*/

		CidiagAggDO[] diagAggs = diagService.getLastCiDiags(id_en);
		for (CidiagAggDO diagAgg : diagAggs) {
			CiDiagItemDO[] diagItems = diagAgg.getCiDiagItemDO();
			
			if(diagItems == null || diagItems.length ==0){
				continue;
			}
			
			for (CiDiagItemDO diagItem : diagItems) {
				// 自定义诊断，诊断定义ID为空
				if (StringUtils.isEmpty(diagItem.getId_didef()) || idDidefList.contains(diagItem.getId_didef())) {
					continue;
				}

				idDidefList.add(diagItem.getId_didef());
				
				CiMiDiagDTO diag = new CiMiDiagDTO();

				diag.setId_didef(diagItem.getId_didef());
				diag.setCode_didef(diagItem.getDidef_code());
				diag.setName_didef(diagItem.getDidef_name());
				diag.setFg_chronic(diagItem.getFg_chronic()); // 是否慢性病诊断 ,行动不便 医保平台根据 诊断名称判断
				FBoolean fg_hasmovediff = FBoolean.FALSE;
				if("行动不便".equals(diagItem.getDidef_name())){
					fg_hasmovediff = FBoolean.TRUE;
				}
				
				diag.setFg_hasmovediff(fg_hasmovediff); // 是否慢性病诊断 ,行动不便 医保平台根据 诊断名称判断
				diag.setFg_special(diagItem.getFg_special()); // 特殊病诊断
				
				diagList.add(diag);
			}
		}
		return diagList;
	}
	
	/**
	 * 当前是否为急诊科室
	 * @param ctx
	 * @return true 是急诊科室，false 不是急诊科室
	 */
	protected boolean isEmergencyDepartment(CiEnContextDTO ctx){
		
		if(!CiMiParamValConst.LL_CIOR0315_1.equals(CiMiParamUtil.LL_CIOR0315())){
			return false;
		}
		
		String deptIds = CiMiParamUtil.LL_CIOR0320();
		if(StringUtils.isEmpty(deptIds)){
			return false;
		}
		
		if(deptIds.indexOf(ctx.getId_dep_en())>=0){
			return true;
		}
		
		return false;
	}
	
}
