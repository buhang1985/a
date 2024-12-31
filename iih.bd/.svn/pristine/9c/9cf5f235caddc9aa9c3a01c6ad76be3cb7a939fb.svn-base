package iih.bd.pp.listener.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.listener.d.BdHpEventDTO;
import iih.bd.pp.listener.d.IncCaEventDTO;
import iih.bd.pp.listener.d.InccaItemEventDTO;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.listener.d.PriPmEventDTO;
import iih.bd.pp.listener.d.PriSrvEventDTO;
import iih.bd.pp.pripm.d.PriPmDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class BdPpEventBp {

	/**
	 * 支付方式组装数据
	 * */
	public PriPmEventDTO pmAssembly(PriPmDO priPmDO,String type){
		PriPmEventDTO priPmEventDTO =  new PriPmEventDTO();
		priPmEventDTO.setOper_type(type);
		priPmEventDTO.setCode_pm(priPmDO.getCode());
		priPmEventDTO.setName_pm(priPmDO.getName());
		priPmEventDTO.setBzcode(null);
		priPmEventDTO.setPycode(priPmDO.getPycode());
		return priPmEventDTO;
	}
	
	/**
	 * 发票分类(门诊/住院)组装数据
	 * */
	public InccaItemEventDTO incItmAssembly(IncCaItmDO incCaItmDO,String type){
		InccaItemEventDTO inccaItemEventDTO = new InccaItemEventDTO();
		inccaItemEventDTO.setAction(type);
		inccaItemEventDTO.setCode(incCaItmDO.getCode());
		inccaItemEventDTO.setName(incCaItmDO.getName());
		inccaItemEventDTO.setPy_code(incCaItmDO.getPycode());
		inccaItemEventDTO.setCharge_code(null);
		inccaItemEventDTO.setSeq(null);
		inccaItemEventDTO.setBa_code(null);
		inccaItemEventDTO.setCw_code(null);
		inccaItemEventDTO.setCw_name(null);
		inccaItemEventDTO.setStd_code(null);
		return inccaItemEventDTO;
	}
	
	/**
	 * 发票分类组装数据
	 * */
	public IncCaEventDTO incAssembly(IncCaItmDO incCaItmDO,String type){
		IncCaEventDTO incCaEventDTO = new IncCaEventDTO();
		incCaEventDTO.setAction(type);
		incCaEventDTO.setCode(incCaItmDO.getCode());
		incCaEventDTO.setName(incCaItmDO.getName());
		incCaEventDTO.setPycode(incCaItmDO.getPycode());
		return incCaEventDTO;
	}
	
	/**
	 * 医保计划组装数据
	 * */
	public BdHpEventDTO hpAssembly(HpAggDO hpAggDO,String type){
		BdHpEventDTO bdHpEventDTO = new BdHpEventDTO();
		bdHpEventDTO.setAction(type);
		bdHpEventDTO.setCode(hpAggDO.getParentDO().getCode());
		bdHpEventDTO.setName(hpAggDO.getParentDO().getName());
		bdHpEventDTO.setPycode(hpAggDO.getParentDO().getPycode());
		return bdHpEventDTO;
	}
	
	/**
	 * 医保计划组装数据
	 * */
	public BdHpEventDTO hpAssembly(HPDO hpAggDO,String type){
		BdHpEventDTO bdHpEventDTO = new BdHpEventDTO();
		bdHpEventDTO.setAction(type);
		bdHpEventDTO.setCode(hpAggDO.getCode());
		bdHpEventDTO.setName(hpAggDO.getName());
		bdHpEventDTO.setPycode(hpAggDO.getPycode());
		return bdHpEventDTO;
	}
	/**
	 * 价表维护组装数据
	 * */
	public List<PriSrvEventDTO> priSrvAssembly(MedSrvEventDTO[] medSrvDTOArr,String type){
		List<PriSrvEventDTO> list = new ArrayList<PriSrvEventDTO>();
		for(MedSrvEventDTO medSrvDO : medSrvDTOArr){
			PriSrvEventDTO priSrvEventDTO = new PriSrvEventDTO();
			priSrvEventDTO.setAction(type);
			priSrvEventDTO.setCode(medSrvDO.getCode());
			priSrvEventDTO.setName(medSrvDO.getName());
			priSrvEventDTO.setPrint_name(medSrvDO.getName());
			priSrvEventDTO.setPy_code(medSrvDO.getPycode());
			priSrvEventDTO.setAudit_code(medSrvDO.getId_srvca());
			priSrvEventDTO.setZy_bill_item(medSrvDO.getIncca_ip());
			priSrvEventDTO.setMz_bill_item(medSrvDO.getIncca_op());
			priSrvEventDTO.setCharge_price(medSrvDO.getPri().toString());
			priSrvEventDTO.setEffective_price(medSrvDO.getPri().toString());
			list.add(priSrvEventDTO);
		}
		return list;
	}
	
	/**
	 * 获取部门编码
	 * @throws BizException 
	 * */
	public String getDeptCodeById(String id_dept) throws BizException{
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO deptDO = service.findById(id_dept);
		if(deptDO == null){
			throw new BizException("没有查到对应部门！");
		}
		return deptDO.getCode();
	}
}
