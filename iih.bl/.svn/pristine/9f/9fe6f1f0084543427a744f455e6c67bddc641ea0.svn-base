package iih.bl.cc.ebs.st;

import iih.bd.base.utils.AppUtils;
import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.dto.OutpatientincomeDTO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;

public class CombinePatRegistInDataBP {
	/**
	 * 
	 * 合并IIH与老his中间表门诊收入数据
	 * <br>
	 * @author 
	 * @param midTableParam 
	 * @date 2017年05月31日  
	 * @return
	 * @throws BizException
	 */
	public void exec(String midTableParam,String date,String type) throws BizException{
		List<OutpatientincomeDTO> ebsMiddos = new ArrayList<OutpatientincomeDTO>();
		List<MpIFaceBatchDO> ebsBatchdos = new ArrayList<MpIFaceBatchDO>();

		// 1.查询出本次未合并到EBS中间表的IIH日志数据
		List<MpIFaceBatchDO> iihBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[0],AppUtils.getServerDate().toString(),type);
		if(!ListUtil.isEmpty(iihBatchDos)){
			ebsBatchdos.addAll(iihBatchDos);
		}else{
			BLTaskLogger.info("与EBS同步门诊收入数据定时任务定时任务未正常结束,不能进行合并任务。");
			return;
		}
		
		// 2.查询出本次未合并到EBS中间表的IIH中间表数据
		List<OutpatientincomeDTO> iihHdos = this.getNotMergedMidData(midTableParam.split(",")[1],date,type);
		if(!ListUtil.isEmpty(iihHdos)){
			ebsMiddos.addAll(iihHdos);
		}
	
		
		// 3.查询出未合并到EBS中间表的原His门诊收入数据
		List<OutpatientincomeDTO> oldHisHdos = this.getNotMergedMidData(midTableParam.split(",")[3],date,type);
		if(!ListUtil.isEmpty(oldHisHdos)){
			ebsMiddos.addAll(oldHisHdos);
		}
		
		// 4.查询出未合并到EBS中间表的原His日志数据
//		List<MpIFaceBatchDO> oldhisBatchDos = this.getNotMergedBatchData(midTableParam.split(",")[2],date);
//		if(!ListUtil.isEmpty(oldhisBatchDos)){
//			ebsBatchdos.addAll(oldhisBatchDos);
//		}
		
		// 5.合并发药数据与原His数据到EBS中间库
		this.totallyInsertIntoEbs(ebsMiddos, ebsBatchdos,midTableParam,date);
		//更新插入后数据的iface_batch_id
		//this.updateBatchidByChargeIface(date);
		
	}
	
	
	/**
	 * 将iih发药数据与原His发药数据汇总，写入Ebs中间表
	 * @param hisHdos
	 * @param hisBatchDos 
	 * @param midTableParam. 
	 */
	private void totallyInsertIntoEbs(List<OutpatientincomeDTO> hisHdos, List<MpIFaceBatchDO> hisBatchDos, String midTableParam,String selectDate) throws BizException{
//		String strWhere=" batch_type in ('J3','J4','JY','JN','JO')";
		try{
			//发药数据
			if(!ListUtil.isEmpty(hisHdos)){
				OperateEBSUtil.saveTempData(hisHdos,midTableParam.split(",")[5],midTableParam.split(",")[4]);			
			}
			//发药日志数据
			if(!ListUtil.isEmpty(hisBatchDos)){			
				OperateEBSUtil.saveBatchData(hisBatchDos,midTableParam.split(",")[4]);
			}
		}catch(BizException ex){
			BLTaskLogger.info("保存数据到EBS中间表出错！");
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
	/**
	 * 更新Iface_batch_id
	 * @param table
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private void updateBatchidByChargeIface(String date)throws BizException {
		OperateEBSUtil.updateIface_batch_id(date);
	 
	}
	/**
	 * 删除当天的日志和业务数据
	 * @param table
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private void deleteTableData(String table,String date,String sWhere,boolean isbatch)throws BizException {
		OperateEBSUtil.deleteTableData(table, date,sWhere,isbatch);
	 
	}	
}
