package iih.bl.cc.ebs.st;

import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.dto.OutpatientincomeDTO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

public class STCombineErpDataBP {
	/**
	 * 
	 * 合并IIH与老his中间表数据
	 * <br>
	 * @author li
	 * @param midTableParam 
	 * @date 2016年10月19日  下午2:49:01
	 * @return
	 * @throws BizException
	 */
	public void exec(String midTableParam,String date,String type) throws BizException{
		List<OutpatientincomeDTO> ebsMiddos = new ArrayList<OutpatientincomeDTO>();
		List<MpIFaceBatchDO> ebsBatchdos = new ArrayList<MpIFaceBatchDO>();

		// 1.查询出本次未合并到EBS中间表的IIH日志数据
		List<MpIFaceBatchDO> iihBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[0],date,type);
		if(!ListUtil.isEmpty(iihBatchDos)){
			ebsBatchdos.addAll(iihBatchDos);
		}else{
			BLTaskLogger.info("与ERP同步发药数据定时任务定时任务未正常结束,不能进行合并任务。");
			return;
		}
		
		// 2.查询出本次未合并到EBS中间表的IIH中间表数据
		List<OutpatientincomeDTO> iihHdos = this.getNotMergedMidData(midTableParam.split(",")[1],date,type);
		if(!ListUtil.isEmpty(iihHdos)){
			ebsMiddos.addAll(iihHdos);
		}
	
		
		// 3.查询出未合并到EBS中间表的原His发药数据
		List<OutpatientincomeDTO> oldHisHdos = this.getNotMergedMidData(midTableParam.split(",")[3],date,type);
		if(!ListUtil.isEmpty(oldHisHdos)){
			ebsMiddos.addAll(oldHisHdos);
		}
		
		// 4.查询出未合并到EBS中间表的原His日志数据
//		List<MpIFaceBatchDO> oldhisBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[2]);
//		if(!ListUtil.isEmpty(oldhisBatchDos)){
//			ebsBatchdos.addAll(oldhisBatchDos);
//		}
		
		// 5.合并发药数据与原His数据到EBS中间库
		this.totallyInsertIntoEbs(ebsMiddos, ebsBatchdos,midTableParam);
		
	}
	
	
	/**
	 * 将iih门诊收入数据与原His门诊收入数据汇总，写入Ebs中间表
	 * @param hisHdos
	 * @param hisBatchDos 
	 * @param midTableParam. 
	 */
	private void totallyInsertIntoEbs(List<OutpatientincomeDTO> hisHdos, List<MpIFaceBatchDO> hisBatchDos, String midTableParam) throws BizException{
		try{
			if(!ListUtil.isEmpty(hisHdos))
				OperateEBSUtil.saveTempData(hisHdos,midTableParam.split(",")[5],midTableParam.split(",")[4]);
			if(!ListUtil.isEmpty(hisBatchDos))
				OperateEBSUtil.saveBatchData(hisBatchDos,midTableParam.split(",")[4]);			
		}catch(BizException ex){
			BLTaskLogger.error("保存数据到EBS中间表出错！",ex);
		}
	}
	
	/**
	 * 
	 * 查询出未合并到EBS中间表的中间表数据
	 * @param table
	 * @return
	 * @throws BizException
	 */
	private List<OutpatientincomeDTO> getNotMergedMidData(String table,String date,String type)throws BizException {
		return OperateEBSUtil.searchNotMergedMidData(table,date,type);
	}
	
	/**
	 * 
	 * 查询出未合并到EBS中间表的日志表数据
	 * @param table
	 * @return
	 * @throws BizException
	 */
	private List<MpIFaceBatchDO> getNotMergedBatchData(String table,String date,String batch_type)throws BizException {
		return OperateEBSUtil.searchNotMergedBatchData(table,date,batch_type);
	}
}
