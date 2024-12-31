package iih.bd.mm.certi.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.mm.mmcerti.d.MaterialCertiDO;
import iih.bd.mm.mmcerti.i.IMmcertiRService;
import iih.bd.mm.supcertifications.d.SupCertifiDO;
import iih.bd.mm.supcertifications.i.ISupcertificationsRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class CertiDeBeforeBp {
	
	public void exec(CertificationDO[] certiCationDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(certiCationDOS);
		
		// ■ 验证数据是否已被引用
		this.checkIsReferenced(certiCationDOS);
	}

	private void validaPara(CertificationDO[] certiCationDOS) throws BizException {
		
		if(certiCationDOS == null || certiCationDOS.length <= 0) {
			
			throw new BizException("传入物品资质证书字典为空。");
		}
	}
	
	private void checkIsReferenced(CertificationDO[] certiCationDOS) throws BizException {
		
		//是否被物品证件引用
		this.referencedByMm(certiCationDOS);
		
		//是否被供应商生产商证件引用
		this.referencedBySup(certiCationDOS);
	}

	private void referencedByMm(CertificationDO[] certiCationDOS) throws BizException {
		
		IMmcertiRService mmCertiRSrv = ServiceFinder.find(IMmcertiRService.class);
		
		String[] mmcfIdList = this.getMmcfCondition(certiCationDOS);
		MaterialCertiDO[] result = mmCertiRSrv.findByAttrValStrings(MaterialCertiDO.ID_MMCF, mmcfIdList);
		if(result == null || result.length <= 0) {
			
			return;
		}
		
		throw new BizException(String.format("证件分类【%s】已被 物品资质证书引用。", result[0].getCerti_name()));
	}

	private String[] getMmcfCondition( CertificationDO[] certiCationDOS) {
		
		List<String> ids = new ArrayList<String>();
		for(CertificationDO certiCationDO : certiCationDOS) {
			
			ids.add(certiCationDO.getId_mmcf());
		}
		
		return ids.toArray(new String[ids.size()]);
	}
	
	private void referencedBySup(CertificationDO[] certiCationDOS) throws BizException {
		
		ISupcertificationsRService supCertiRSrv = ServiceFinder.find(ISupcertificationsRService.class);
		
		String[] mmcfIdList = this.getMmcfCondition(certiCationDOS);
		SupCertifiDO[] result = supCertiRSrv.findByAttrValStrings(SupCertifiDO.ID_MMCF, mmcfIdList);
		if(result == null || result.length <= 0) {
			
			return;
		}
		
		throw new BizException(String.format("证件分类【%s】已被 供应商、生产商资质证书引用。", result[0].getCerti_name()));
	}
}
