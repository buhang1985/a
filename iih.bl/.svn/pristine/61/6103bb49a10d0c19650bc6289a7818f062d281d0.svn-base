package iih.bl.cg.s.cglogic.other;

import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.comm.util.BlMethodUtil;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 记账相关错误信息收集器
 * 处理单患者模式及数据过滤等
 * @author ly 2018/06/26
 *
 */
public class BlCgAccErrorCollector {

	// 错误就诊或患者列表 
	private List<String> failEnOrPatList;
	// 错误信息
	private List<BlCgErrorDTO> failRltList;
	// 是否单患者模式
	private FBoolean fgSinglePat;
	// 是否需要过滤数据
	private boolean needFilter = false;

	public BlCgAccErrorCollector(FBoolean fgSinglePat){
		this.fgSinglePat = fgSinglePat;
		this.failEnOrPatList = new ArrayList<String>();
		this.failRltList = new ArrayList<BlCgErrorDTO>();
	}
	
	/**
	 * 错误信息收集
	 * @throws BizException
	 */
	public void collect(String entpatId, boolean op, BizException ex) throws BizException{
		
		if(FBoolean.FALSE.equals(fgSinglePat)){
			throw ex;
		}
		ex.printStackTrace();
		
		BlCgErrorDTO rltDto = new BlCgErrorDTO();
		if(op){
			rltDto.setId_pat(entpatId);
		}else{
			rltDto.setId_ent(entpatId);	
		}
		
		rltDto.setError_msg(ex.getMessage());
		rltDto.setExcptionstack(BlMethodUtil.getStackInfo(ex));
		
		this.failEnOrPatList.add(entpatId);
		this.failRltList.add(rltDto);
		
		this.needFilter = true;
	}
	
	/**
	 * 错误信息收集
	 * @throws BizException
	 */
	public void collect(String entpatId, String otherId, boolean op, BizException ex) throws BizException{
		
		if(FBoolean.FALSE.equals(fgSinglePat)){
			throw ex;
		}
		ex.printStackTrace();
		
		BlCgErrorDTO rltDto = new BlCgErrorDTO();
		if(op){
			rltDto.setId_pat(entpatId);
			rltDto.setId_ent(otherId);
		}else{
			rltDto.setId_pat(otherId);
			rltDto.setId_ent(entpatId);	
		}
		
		rltDto.setError_msg(ex.getMessage());
		rltDto.setExcptionstack(BlMethodUtil.getStackInfo(ex));
		
		this.failEnOrPatList.add(entpatId);
		this.failRltList.add(rltDto);
		
		this.needFilter = true;
	}
	
	/**
	 * 过滤已经出错的就诊数据
	 * @param enpatList
	 * @throws BizException
	 */
	public void filterEnOrPatList(List<String> enpatList) throws BizException{
		
		if(ListUtil.isEmpty(enpatList))
			return;
		
		for (int i = enpatList.size() - 1; i >= 0; i--) {
			if(this.failEnOrPatList.contains(enpatList.get(i))){
				enpatList.remove(i);
			}
		}
	}
	
	/**
	 * 过滤不可记账的数据
	 * @param accBizDtos
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountBizDTO[] filterBizData(BlCgAccountBizDTO[] accBizDtos)throws BizException{
		
		if(!this.needFilter)
			return accBizDtos;
		
		List<BlCgAccountBizDTO> remainList = new ArrayList<BlCgAccountBizDTO>();
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			if(this.failEnOrPatList.contains(bizDto.getId_ent()))
				continue;
			
			remainList.add(bizDto);
		}
		
		this.needFilter = false;
		return remainList.toArray(new BlCgAccountBizDTO[0]);
	}
	
	/**
	 * 过滤不可记账的数据(患者维度)
	 * @param accBizDtos
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountBizDTO[] filterBizData2(BlCgAccountBizDTO[] accBizDtos)throws BizException{
		if(!this.needFilter)
			return accBizDtos;
		
		List<BlCgAccountBizDTO> remainList = new ArrayList<BlCgAccountBizDTO>();
		for (BlCgAccountBizDTO bizDto : accBizDtos) {
			if(this.failEnOrPatList.contains(bizDto.getId_pat()))
				continue;
			
			remainList.add(bizDto);
		}
		
		this.needFilter = false;
		return remainList.toArray(new BlCgAccountBizDTO[0]);
	}
	
	/**
	 * 过滤不可退记账的数据
	 * @param refundDtos
	 * @return
	 * @throws BizException
	 */
	public BlCgRefundAccountDTO[] filterRefundBizData(BlCgRefundAccountDTO[] refundDtos)throws BizException{
		
		if(!this.needFilter)
			return refundDtos;
		
		List<BlCgRefundAccountDTO> remainList = new ArrayList<BlCgRefundAccountDTO>();
		for (BlCgRefundAccountDTO bizDto : refundDtos) {
			if(this.failEnOrPatList.contains(bizDto.getId_ent()))
				continue;
			
			remainList.add(bizDto);
		}
		
		this.needFilter = false;
		return remainList.toArray(new BlCgRefundAccountDTO[0]);
	}
	
	/**
	 * 过滤不可退记账的数据(患者维度)
	 * @param refundDtos
	 * @return
	 * @throws BizException
	 */
	public BlCgRefundAccountDTO[] filterRefundBizData2(BlCgRefundAccountDTO[] refundDtos)throws BizException{
		
		if(!this.needFilter)
			return refundDtos;
		
		List<BlCgRefundAccountDTO> remainList = new ArrayList<BlCgRefundAccountDTO>();
		for (BlCgRefundAccountDTO bizDto : refundDtos) {
			if(this.failEnOrPatList.contains(bizDto.getId_pat()))
				continue;
			
			remainList.add(bizDto);
		}
		
		this.needFilter = false;
		return remainList.toArray(new BlCgRefundAccountDTO[0]);
	}
	
	/**
	 * 返回无异常错误记账错误结果
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgAccountRltDTO returnUnsuccessRlt() throws BizException{
		BlCgAccountRltDTO rlt = new BlCgAccountRltDTO();
		rlt.setFg_success(FBoolean.FALSE);
		FArrayList errList = new FArrayList();
		errList.addAll(this.failRltList);
		rlt.setError_entlist(errList);
		
		return rlt;
	}
	
	/**↓↓↓↓↓ getter setter ↓↓↓↓↓**/
	
	/**
	 * @return the failEnList
	 */
	public List<String> getFailEnOrPatList() {
		return failEnOrPatList;
	}
	
	/**
	 * @return the failRltList
	 */
	public List<BlCgErrorDTO> getFailRltList() {
		return failRltList;
	} 
}
