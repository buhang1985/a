package iih.bl.cg.blcghist.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.blcghist.d.BlCgIpEuAct;
import iih.bl.cg.blcghist.d.BlCgIpHistDO;
import iih.bl.cg.blcghist.i.IBlcghistCudService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存住院记账自费标识历史
 * @author hanjq 下午2:11:17
 *
 */
public class SaveCgIpHistBP {

	
	/**
	 * 保存记账历史
	 * @author : hanjq 2019年9月25日 下午1:56:37
	 * @param updatas
	 * @throws BizException 
	 */
	public void saveHistory(List<BlCgIpDO> updatas,String Sd_actsrc,String note) throws BizException{
		ArrayList<BlCgIpHistDO> cgHises = new ArrayList<>();
		IBlcghistCudService service = ServiceFinder.find(IBlcghistCudService.class);
		FDateTime Dt_act = new FDateTime();
		String idDep = Context.get().getDeptId();
		String idEmp = Context.get().getUserId();
		for(BlCgIpDO cgDo: updatas){
			BlCgIpHistDO cgHis = new BlCgIpHistDO();
			cgHis.setDt_act(Dt_act);
			if(FBoolean.TRUE.equals(cgDo.getFg_selfpay())){
				cgHis.setEu_act(BlCgIpEuAct.SELFTOHP);
			}else{
				cgHis.setEu_act(BlCgIpEuAct.HPTOSELF);
			}
			cgHis.setId_cgip(cgDo.getId_cgip());
			cgHis.setId_dep_act(idDep);
			cgHis.setId_emp_act(idEmp);
			cgHis.setSd_actsrc(Sd_actsrc);
			cgHis.setStatus(DOStatus.NEW);
			cgHis.setNote(note);
			cgHises.add(cgHis);
		}
		service.save(cgHises.toArray(new BlCgIpHistDO[0]));
	}
	
}
