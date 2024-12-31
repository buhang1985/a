package iih.ci.ord.s.ems.ip.order.copy;

import java.util.Map;

import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestCudService;
import iih.ci.ord.skintest.i.ISkintestRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 复制生成新的皮试结果记录
 * @author zhangwq
 *
 */
public class CiSkinTestRstCopyBP {
	public CiSkinTestRstDO[] exec(Map<String, String> mapIdors, FDateTime dt) throws BizException{
		CiSkinTestRstDO[] rsts = getCiSkinTestRstDOs(mapIdors.keySet().toArray(new String[0]));
		if(rsts!=null && rsts.length > 0){
			setCiSkinTestRstDOs(rsts,mapIdors);
			saveCiSkinTestRstDOs(rsts);
			return rsts;
		}
		return null;
	}
	/**
	 * 保存
	 * @param rsts
	 * @throws BizException
	 */
	private void saveCiSkinTestRstDOs(CiSkinTestRstDO[] rsts) throws BizException {
		ISkintestCudService service = ServiceFinder.find(ISkintestCudService.class);
		service.save(rsts);
	}
	/**
	 * 初始化皮试结果
	 * @param rsts
	 * @param mapIdors
	 */
	private void setCiSkinTestRstDOs(CiSkinTestRstDO[] rsts,Map<String, String> mapIdors){
		if(rsts!=null && rsts.length > 0){
			for(CiSkinTestRstDO skinrst : rsts){
				skinrst.setStatus(DOStatus.NEW);
				skinrst.setId_skintest(null);
				skinrst.setId_or(mapIdors.get(skinrst.getId_or()));
				skinrst.setId_emp_create(null);
				skinrst.setCreatedtime(null);
				skinrst.setConfirmby(null);
				skinrst.setModifiedtime(null);
				skinrst.setReason(null);
				skinrst.setId_rst_skintest(null);
				skinrst.setSd_rst_skintest(null);
			}
		}
		
	}
	/**
	 * 皮试结果
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private CiSkinTestRstDO[] getCiSkinTestRstDOs(String[] id_ors) throws BizException{
		if(id_ors==null || id_ors.length==0){
			return null;
		}
		ISkintestRService service = ServiceFinder.find(ISkintestRService.class);
		CiSkinTestRstDO[] rsts = service.findByAttrValStrings(CiSkinTestRstDO.ID_OR, id_ors);
		return rsts;
	}
}
