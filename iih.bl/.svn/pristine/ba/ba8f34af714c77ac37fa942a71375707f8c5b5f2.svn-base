package iih.bl.inc.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.inc.blcpnin.d.BlCpnDO;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.BlcpninAggDO;
import iih.bl.inc.blcpnin.i.IBlCpnDORService;
import iih.bl.inc.blcpnin.i.IBlcpninCudService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 优惠券入库的 保存
 * @author li_pengying
 *
 */
public class CpnInSaveBp {
	/**
	 * 录入入库单和优惠券的保存
	 * */
	public FBoolean execInsertBlCpnInInfo(BlCpnInDO blCpnInDO,Integer blCpnAddCodeLen) throws BizException{
        //blcpnInDO的coderule_cpn字段的值 = bdcpncaDO.coderule_cpn ,值为 "{分类编码}XXX{附加码}"
		String codeRule_cpn = blCpnInDO.getCoderule_cpn().replace("{分类编码}", blCpnInDO.getCode_cpnca()); // codeRule_cpn的 值变为 code_cpnca+"xxx{附加码}"  
		String ruleStart = codeRule_cpn.substring(0, codeRule_cpn.indexOf("{"));                         //  ruleStart  的值变为  code_cpnca+"xxx"
		String ruleEnd = codeRule_cpn.substring(codeRule_cpn.indexOf("}") + 1, codeRule_cpn.length());   //  ruleEnd    的值为"" 
		
		IBlCpnDORService cpnService = ServiceFinder.find(IBlCpnDORService.class);
		String startCode = ruleStart + this.setBlCpnCodeNumInfo(blCpnInDO.getNum_b().toString(), blCpnAddCodeLen) + ruleEnd; //num_b 是从前台界面输入的开始值
		String endCode = ruleStart + this.setBlCpnCodeNumInfo(blCpnInDO.getNum_e().toString(), blCpnAddCodeLen) + ruleEnd;   //num_e 是从前台界面输入的结束值
		BlCpnDO[] blCpnDOArr = cpnService.find(" a1.code >= '" + startCode + "' and a1.code <= '" + endCode +"'", null, FBoolean.FALSE);
		if(blCpnDOArr != null && blCpnDOArr.length > 0){
			throw new BizException("优惠券已存在！");
		}
		
		BlcpninAggDO aggDO= this.assembleData(blCpnInDO, blCpnAddCodeLen, ruleStart, ruleEnd);
		IBlcpninCudService service = ServiceFinder.find(IBlcpninCudService.class);
		service.save(new BlcpninAggDO[]{aggDO});
		return FBoolean.TRUE;
	}
	
	private BlcpninAggDO  assembleData(BlCpnInDO blCpnInDO,Integer blCpnAddCodeLen,String ruleStart,String ruleEnd) throws BizException {
		
		BlcpninAggDO aggDO = new BlcpninAggDO();
		//主
		blCpnInDO.setDt_entry(AppUtils.getServerDateTime());
		blCpnInDO.setId_emp_entry(Context.get().getStuffId());
		blCpnInDO.setId_org(Context.get().getOrgId());
		blCpnInDO.setId_grp(Context.get().getGroupId());
		blCpnInDO.setStatus(DOStatus.NEW);
		
		List<BlCpnDO> blCpnList = new ArrayList<BlCpnDO>();
		//子表数据集中添加元素，个数为结束号减去开始号+1个，并为每个子数据的各个字段赋值
		for(int i = blCpnInDO.getNum_b(); i <= blCpnInDO.getNum_e(); i++){
			BlCpnDO blCpnDO = new BlCpnDO();
			StringBuffer sb = new StringBuffer();
			//每个优惠券的编码为 开始字符串 + 生成号  + 结束字符串
			sb.append(ruleStart).append(this.setBlCpnCodeNumInfo(String.valueOf(i), blCpnAddCodeLen)).append(ruleEnd); 
			//每个优惠券的编码= code_cpnca+"xxx"+生成的八位编码串+"" ，即生成的八位编码串就是附加码的实施内容
			if(i == blCpnInDO.getNum_b()){
				blCpnInDO.setCode_cpn_b(sb.toString());
			}else if(i == blCpnInDO.getNum_e()){
				blCpnInDO.setCode_cpn_e(sb.toString());
			}
			blCpnDO.setCode(sb.toString());
			blCpnDO.setId_cpnca(blCpnInDO.getId_cpnca());
			blCpnDO.setCode_cpnca(blCpnInDO.getCode_cpnca());
			blCpnDO.setId_org(Context.get().getOrgId());
			blCpnDO.setId_grp(Context.get().getGroupId());
			blCpnDO.setFg_iss(FBoolean.FALSE);
			blCpnDO.setFg_used(FBoolean.FALSE);
			blCpnDO.setStatus(DOStatus.NEW);
			blCpnList.add(blCpnDO);
		}
		aggDO.setParentDO(blCpnInDO);
		aggDO.setBlCpnDO(blCpnList.toArray(new BlCpnDO[]{}));
		
		return aggDO;
		
	}
	
	
	/**
	 * 根据某个数字字符和长度生成对应长度的编码串，比如数字字符为1 长度为8位 则生成的8位编码串为“00000001”
	 * @param numStr
	 * @param count
	 * @return
	 */
	private String setBlCpnCodeNumInfo(String numStr,Integer count){
		if(numStr.length() < count)
		{
			numStr = "0" + numStr;
			numStr = setBlCpnCodeNumInfo(numStr,count);
		}
		return numStr;
	}
	
	
}
