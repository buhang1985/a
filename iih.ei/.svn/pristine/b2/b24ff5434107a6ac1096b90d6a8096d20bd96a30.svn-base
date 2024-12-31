package iih.ei.std.s.v1.bp.mp.dispdruginfo;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPCollocateDrugDTO;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPCollocateDrugResult;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPDispDrugParamDTO;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.Ipdispdrug;
import iih.ei.std.s.v1.bp.mp.dispdruginfo.qry.GetIPDispDrugInfoSql;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 
* @ClassName: QryIPDispDrugInfoBP
* @Description: 查询住院发药明细
* @author zhy
* @date 2019年10月16日
*
 */
public class QryIPDispDrugInfoBP {
	/**
	 * 程序入口
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public IPCollocateDrugResult exec(IPDispDrugParamDTO param) throws BizException {
		
		// 1.查询住院发药明细
		IPCollocateDrugDTO[] collocateDTOS = getDispDrugInfo(param);
		
		// 2.发药信息数据转换
		initCollocateDrugInfo(collocateDTOS);
		
		IPCollocateDrugResult result = new IPCollocateDrugResult();
		result.setIpcollocatedrug(ArrayListUtil.ConvertToFArrayList(collocateDTOS));
		return result;
	}
	

	/**
	 * 获取住院发药明细
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private IPCollocateDrugDTO[] getDispDrugInfo(IPDispDrugParamDTO param) throws BizException {
		FArrayList dispdrug = param.getDispdrug();
		String[] id_dgipdes = new String[dispdrug.size()];
		for (int i = 0; i < dispdrug.size(); i++) {
			Ipdispdrug ipdispdrug  = (Ipdispdrug) dispdrug.get(i);
			id_dgipdes[i] = ipdispdrug.getId_dgipde();
		}
		GetIPDispDrugInfoSql sql = new GetIPDispDrugInfoSql(id_dgipdes);
		IPCollocateDrugDTO[] dos = (IPCollocateDrugDTO[]) AppFwUtil.getDORstWithDao(sql, IPCollocateDrugDTO.class);
		return dos;
	}
	
	/**
	 * 发药信息数据转换
	 * @param collocateDTOS
	 */
	private void initCollocateDrugInfo(IPCollocateDrugDTO[] collocateDTOS) {
		Map<String, FDouble> totalNumMap = new HashMap<String, FDouble>();
		//领药量汇总
		for(IPCollocateDrugDTO grugDTO : collocateDTOS) {
			String key = this.getDrugKey(grugDTO);
			FDouble totalNum = FDouble.ZERO_DBL;
			if(totalNumMap.containsKey(key)) {
				totalNum = totalNumMap.get(key).add(grugDTO.getAmount());
			} else {
				totalNum = grugDTO.getAmount();
			}
			totalNumMap.put(key, totalNum);
		}
		//领药量设置
		for(IPCollocateDrugDTO grugDTO : collocateDTOS) {
			String key = this.getDrugKey(grugDTO);
			FDouble totalNum = totalNumMap.get(key);
			grugDTO.setTotal(totalNum);
//			//服用方法(中间表字段名为comment)
//			grugDTO.setComment(grugDTO.getComm1());
		}
	}
		
	/**
	 * 获取键
	 * @param grugDTO
	 * @return
	 */
	private String getDrugKey(IPCollocateDrugDTO grugDTO) {
		return grugDTO.getNo_inpatient() + grugDTO.getCode_detail();
	}
}
