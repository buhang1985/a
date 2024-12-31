package iih.bd.mm.supplierprotocol.s.bp;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolCudService;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolRService;
import iih.mm.comm.i.ICommService;
import iih.mm.comm.i.IUdiHelperService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.xbd.udi.d.UdidocDO;

public class SupproExamBp {
	
	public SupplierprotocolAggDO[] Submit(String[] ids) throws BizException {
		
		// ■ 参数校验
		this.validaPara(ids);
		
		// ■ 数据获取
		SupplierprotocolAggDO[] supProAggDOS = this.getAggList(ids);
		
		return this.submit(supProAggDOS);
	}

	private void validaPara(String[] ids) throws BizException {
		
		if(ids == null || ids.length <= 0) {
			
			throw new BizException("传入参数信息为空 。");
		}
	}
	
	private SupplierprotocolAggDO[] getAggList(String[] ids) throws BizException {
		
		ISupplierprotocolRService supProRSrv = ServiceFinder.find(ISupplierprotocolRService.class);
		
		SupplierprotocolAggDO[] supProAggDOS = supProRSrv.findByBIds(ids, FBoolean.FALSE);
		if(supProAggDOS == null || supProAggDOS.length <= 0) {
			
			throw new BizException("获取供应商物品协议失败。");
		}
		
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			if(IBdMmDictCodeConst.SD_SU_PROT_SUBMIT.equals(supProAggDO.getParentDO().getSd_su_prot())) {
				
				throw new BizException(String.format("供应商物品协议【%s】已提交，不允许再次提交。", supProAggDO.getParentDO().getName()));
			}
		}
		
		return supProAggDOS;
	}
	
	private SupplierprotocolAggDO[] submit(SupplierprotocolAggDO[] supProAggDOS) throws BizException {
		
		ICommService commService = ServiceFinder.find(ICommService.class);
		PsndocAggDO psndocAggDO = commService.getEmployeeInfoByUserId(Context.get().getUserId());
		
		IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
		UdidocDO udidocDO = udiHelperService.getUdidocByCode(Context.get().getOrgId(), IBdMmDictCodeConst.SD_SU_PROT, IBdMmDictCodeConst.SD_SU_PROT_SUBMIT);
		if(udidocDO == null) {
			
			throw new BizException("获取【供应商物品协议状态】自定义档案失败。");
		}
		
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			SuppierProtocolDO supProDO = supProAggDO.getParentDO();
			supProDO.setStatus(DOStatus.UPDATED);
			//供应商物品协议状态
			supProDO.setId_su_prot(udidocDO.getId_udidoc());
			supProDO.setSd_su_prot(udidocDO.getCode());
			supProDO.setSu_prot_name(udidocDO.getName());
			//提交人
			if(psndocAggDO != null) {
				
				supProDO.setId_emp_check(psndocAggDO.getParentDO().getId_psndoc());
			}
		}
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		return supProCudSrv.update(supProAggDOS);
	}
	
	public SupplierprotocolAggDO Accept(SupplierprotocolAggDO supProAggDO) throws BizException {
		
		IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
		UdidocDO udidocDO = udiHelperService.getUdidocByCode(Context.get().getOrgId(), IBdMmDictCodeConst.SD_SU_PROT, IBdMmDictCodeConst.SD_SU_PROT_PASS);
		if(udidocDO == null) {
			
			throw new BizException("获取【供应商物品协议状态】自定义档案失败。");
		}
		
		SuppierProtocolDO supProDO = supProAggDO.getParentDO();
		supProDO.setStatus(DOStatus.UPDATED);
		//供应商物品协议状态
		supProDO.setId_su_prot(udidocDO.getId_udidoc());
		supProDO.setSd_su_prot(udidocDO.getCode());
		supProDO.setSu_prot_name(udidocDO.getName());
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		return supProCudSrv.update(new SupplierprotocolAggDO[]{ supProAggDO })[0];
	}
	
	public SupplierprotocolAggDO Reject(SupplierprotocolAggDO supProAggDO) throws BizException {
		
		IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
		UdidocDO udidocDO = udiHelperService.getUdidocByCode(Context.get().getOrgId(), IBdMmDictCodeConst.SD_SU_PROT, IBdMmDictCodeConst.SD_SU_PROT_REFUSE);
		if(udidocDO == null) {
			
			throw new BizException("获取【供应商物品协议状态】自定义档案失败。");
		}
		
		SuppierProtocolDO supProDO = supProAggDO.getParentDO();
		supProDO.setStatus(DOStatus.UPDATED);
		//供应商物品协议状态
		supProDO.setId_su_prot(udidocDO.getId_udidoc());
		supProDO.setSd_su_prot(udidocDO.getCode());
		supProDO.setSu_prot_name(udidocDO.getName());
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		return supProCudSrv.update(new SupplierprotocolAggDO[]{ supProAggDO })[0];
	}
}
