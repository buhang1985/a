package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mi.basic.MiErrorLevel;
import xap.mw.core.data.FArrayList;
import xap.sie.common.utils.StringUtils;

/**
 * 医保规则校验结果
 * @author HUMS
 *
 */
public class OrdRuleRstDTO extends OrdMiBaseDTO{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误级别 ERROR、WARN、INFO
	 * ERROR：弹出提示、不允许继续执行，
	 * WARN:弹出提示、允许继续执行
	 * INFO:不处理记录信息、继续执行
	 * @param Id_orsrv
	 */
	public String getErrorlevel() {
		
		String errorLevel = MiErrorLevel.INFO;
		List<OrdSrvRuleRstDTO> ordSrvRstList = this.getOrdSrvRuleRstList();
		for(OrdSrvRuleRstDTO ordSrv : ordSrvRstList){
			if(MiErrorLevel.ERROR.equals(ordSrv.getErrorlevel())){
				return MiErrorLevel.ERROR;
			}
			if(MiErrorLevel.WARN.equals(ordSrv.getErrorlevel())){
				errorLevel = MiErrorLevel.WARN;
			}
		}
		
		return errorLevel;
	}
	
	/**
	 * 获取医保规则校验结果信息
	 * @return
	 */
	public String getMsg() {
		List<String> msgList = new ArrayList<String>();
		StringBuffer msgBuffer = new StringBuffer();
		List<OrdSrvRuleRstDTO> ordSrvRstList = this.getOrdSrvRuleRstList();
		for(OrdSrvRuleRstDTO ordSrvRst : ordSrvRstList){
			if(StringUtils.isNotEmpty(ordSrvRst.getErrorMsg())){
				if(msgList.contains(ordSrvRst.getErrorMsg())){
					continue;
				}
				msgList.add(ordSrvRst.getErrorMsg());
				msgBuffer.append(ordSrvRst.getErrorMsg()).append(System.lineSeparator());
			}
		}
		return msgBuffer.toString();
	}
	
	
	/**
	 * 医保规则校验结果
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvRuleRstFList() {
		return ((FArrayList) getAttrVal("OrdSrvRuleRstFList"));
	}
	/**
	 * 医保规则校验结果
	 * @param Erroritm_list
	 */
	public void setOrdSrvRuleRstFList(FArrayList OrdSrvRuleRstFList) {
		setAttrVal("OrdSrvRuleRstFList", OrdSrvRuleRstFList);
	}
	
	/**
	 * 医保规则校验结果
	 * @return FArrayList
	 */
	public List<OrdSrvRuleRstDTO> getOrdSrvRuleRstList() {
		
		List<OrdSrvRuleRstDTO> ordSrvList = new ArrayList<OrdSrvRuleRstDTO>();
		FArrayList ordSrvFList = this.getOrdSrvRuleRstFList();
		if(ordSrvFList == null || ordSrvFList.size() ==0){
			return ordSrvList;
		}
		
		for(Object obj : ordSrvFList){
			ordSrvList.add((OrdSrvRuleRstDTO)obj);	
		}
		return ordSrvList;
	}
	
	public void addChild(OrdSrvRuleRstDTO ordSrvRuleRst){
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvRuleRstFList"));
		if(ordSrvFList == null){
			ordSrvFList = new FArrayList();
			this.setOrdSrvRuleRstFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrvRuleRst);
	}
}
