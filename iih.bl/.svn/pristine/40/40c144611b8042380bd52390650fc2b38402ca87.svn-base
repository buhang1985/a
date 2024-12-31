package iih.bl.cc.ebs.bp;

import java.util.ArrayList;

import iih.bl.cc.ebs.d.HisBatchIfaceDTO;
import xap.mw.core.data.BizException;

/**
 * 获取所有接口类型主表
 * 
 * @author Administrator
 * 
 */
public class GetBatchIfaceDTOsBP {

	public HisBatchIfaceDTO[] exec() throws BizException {
		return getDefaultBatchIfaceDTOs();
	}

	private HisBatchIfaceDTO[] getDefaultBatchIfaceDTOs() {
		ArrayList<HisBatchIfaceDTO> retList = new ArrayList<HisBatchIfaceDTO>();

		HisBatchIfaceDTO hisBatchIfaceDTO = new HisBatchIfaceDTO();
		// 1.门诊普通挂号
		hisBatchIfaceDTO.setIface_batch_id(1);
		hisBatchIfaceDTO.setHospital_code("门诊普通挂号");
		hisBatchIfaceDTO.setDescription("结账日期（[NowDate]）普通挂号");
		hisBatchIfaceDTO.setProcess_flag("N");
		hisBatchIfaceDTO.setBatch_type("J3");
		retList.add(hisBatchIfaceDTO);
		hisBatchIfaceDTO = new HisBatchIfaceDTO();
		// 2.门诊预交金
		hisBatchIfaceDTO.setIface_batch_id(5);
		hisBatchIfaceDTO.setHospital_code("门诊预交金");
		hisBatchIfaceDTO.setDescription("结账日期（[NowDate]） 门诊预交金");
		hisBatchIfaceDTO.setProcess_flag("N");
		hisBatchIfaceDTO.setBatch_type("JY");
		retList.add(hisBatchIfaceDTO);
		
		// 3.门诊收费
		HisBatchIfaceDTO hisOepBatchIfaceDTO = new HisBatchIfaceDTO();
		hisOepBatchIfaceDTO.setIface_batch_id(2);
		hisOepBatchIfaceDTO.setHospital_code("门诊收费");
		hisOepBatchIfaceDTO.setDescription("结账日期（[NowDate]） 门诊收费");
		hisOepBatchIfaceDTO.setProcess_flag("N");
		hisOepBatchIfaceDTO.setBatch_type("J4");
		retList.add(hisOepBatchIfaceDTO);

		// 3.JN_预付费收入表
		HisBatchIfaceDTO hisBatchIfaceDTOJN = new HisBatchIfaceDTO();
		hisBatchIfaceDTOJN.setIface_batch_id(2);
		hisBatchIfaceDTOJN.setHospital_code("预付费收入");
		hisBatchIfaceDTOJN.setDescription("结账日期（[NowDate]） 预付费收入");
		hisBatchIfaceDTOJN.setProcess_flag("N");
		hisBatchIfaceDTOJN.setBatch_type("JN");
		retList.add(hisBatchIfaceDTOJN);
		
		// 3.JO_预付费结算表
		HisBatchIfaceDTO hisBatchIfaceDTOJO = new HisBatchIfaceDTO();
		hisBatchIfaceDTOJO.setIface_batch_id(2);
		hisBatchIfaceDTOJO.setHospital_code("预付费结算");
		hisBatchIfaceDTOJO.setDescription("结账日期（[NowDate]） 预付费结算");
		hisBatchIfaceDTOJO.setProcess_flag("N");
		hisBatchIfaceDTOJO.setBatch_type("JO");
		retList.add(hisBatchIfaceDTOJO);		
		
		return (HisBatchIfaceDTO[]) retList.toArray(new HisBatchIfaceDTO[retList.size()]);
	}
}
