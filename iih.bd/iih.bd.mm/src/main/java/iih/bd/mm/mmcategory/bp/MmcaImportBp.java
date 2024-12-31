package iih.bd.mm.mmcategory.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryCudService;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

public class MmcaImportBp {
	
	public void exec(MMCategoryDO[] mmcaDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(mmcaDOS);
		
		// ■ 自定义档案值是否合法(物品类型、零售价计算模式)
		Map<String, UdidocDO> mmtpUdidocList = new HashMap<String, UdidocDO>();
		Map<String, UdidocDO> priModeUdidocList = new HashMap<String, UdidocDO>();
		this.checkUdidocValue(mmcaDOS, mmtpUdidocList, priModeUdidocList);
		
		// ■ 编码是否合法
		this.checkCode(mmcaDOS);
		
		// ■ 导入
		this.importMmca(mmcaDOS, mmtpUdidocList, priModeUdidocList);
	}

	private void validaPara(MMCategoryDO[] mmcaDOS) throws BizException {
		
		if(mmcaDOS == null || mmcaDOS.length <= 0) {
			
			throw new BizException("传入导入数据为空。");
		}
		
		int num = 0;
		StringBuffer errMsg = new StringBuffer();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			num = num + 1;
			if(StringUtils.isBlank(mmcaDO.getCode())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类编码为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(mmcaDO.getName())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类名称为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(mmcaDO.getSd_mmtp())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类的物品类型为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(mmcaDO.getSd_primode())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类的零售价计算模式为空；", String.valueOf(num)));
			}
			
		    if(!StringUtils.isBlank(errMsg)) {
				
				errMsg.append("\n");
			}
		}
		
		if(!StringUtils.isBlank(errMsg)) {
			
			throw new BizException(errMsg.toString());
		}
	}
	
	private void checkUdidocValue(MMCategoryDO[] mmcaDOS, Map<String, UdidocDO> mmtpUdidocList,
			Map<String, UdidocDO> priModeUdidocList) throws BizException {
		
		//物品类型自定义档案
		this.getMmtpUdidoc(mmtpUdidocList);
		//零售价计算模式自定义档案
		this.getPriModeUdidoc(priModeUdidocList);
		
		int num = 0;
		StringBuffer errMsg = new StringBuffer();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			num = num + 1;
			if(!mmtpUdidocList.containsKey(mmcaDO.getSd_mmtp())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类的对应的物品类型不存在；", String.valueOf(num)));
			}
			if(!priModeUdidocList.containsKey(mmcaDO.getSd_primode())) {
				
				errMsg.append(String.format("第【%s】行数据物品基本分类的对应的零售价计算模式不存在；", String.valueOf(num)));
			}
			
		    if(!StringUtils.isBlank(errMsg)) {
				
				errMsg.append("\n");
			}
		}
		
		if(!StringUtils.isBlank(errMsg)) {
			
			throw new BizException(errMsg.toString());
		}
	}
	
	private void getMmtpUdidoc(Map<String, UdidocDO> mmtpUdidocList) throws BizException {
		
		IUdidocRService udiSrv = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService dioListSrv = ServiceFinder.find(IUdidoclistRService.class);
		
		String whrStr = String.format("code = '%s'", IBdMmDictCodeConst.SD_MMTP);
		UdidoclistDO[] udiListDOS = dioListSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(udiListDOS == null || udiListDOS.length <= 0) {
			
			throw new BizException("获取物品类型自定义档案失败。");
		}
		
		whrStr = String.format("id_udidoclist = '%s'", udiListDOS[0].getId_udidoclist());
		UdidocDO[] uidList = udiSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(uidList == null || uidList.length <= 0) {
			
			throw new BizException("获取物品类型自定义档案失败。");
		}
		
		for(UdidocDO udiDO : uidList) {
			
			mmtpUdidocList.put(udiDO.getCode(), udiDO);
		}
	}
	
	private void getPriModeUdidoc(Map<String, UdidocDO> priModeUdidocList) throws BizException {
		
		IUdidocRService udiSrv = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService dioListSrv = ServiceFinder.find(IUdidoclistRService.class);
		
		String whrStr = String.format("code = '%s'", IBdMmDictCodeConst.SD_PRIMODE);
		UdidoclistDO[] udiListDOS = dioListSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(udiListDOS == null || udiListDOS.length <= 0) {
			
			throw new BizException("获取零售价计算模式自定义档案失败。");
		}
		
		whrStr = String.format("id_udidoclist = '%s'", udiListDOS[0].getId_udidoclist());
		UdidocDO[] uidList = udiSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(uidList == null || uidList.length <= 0) {
			
			throw new BizException("获取零售价计算模式自定义档案失败。");
		}
		
		for(UdidocDO udiDO : uidList) {
			
			priModeUdidocList.put(udiDO.getCode(), udiDO);
		}
	}
	
	private void checkCode(MMCategoryDO[] mmcaDOS) throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		
		List<String> codeList = new ArrayList<String>();
		List<String> parentCodeList = new ArrayList<String>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			codeList.add(mmcaDO.getCode());
			if(!StringUtils.isBlank(mmcaDO.getParent_code())) {
				
				parentCodeList.add(mmcaDO.getParent_code());
			}
		}
		
		//编码是否重复
		MMCategoryDO[] mmcaDOList = mmcaRSrv.findByAttrValStrings(MMCategoryDO.CODE, 
				codeList.toArray(new String[codeList.size()]));
		if(mmcaDOList != null && mmcaDOList.length > 0) {
			
			throw new BizException(String.format("物品基本分类【%s】在数据库中已存在。", mmcaDOList[0].getName()));
		}
		
		//上级编码是否存在
		Map<String, MMCategoryDO> mmcaMap = new HashMap<String, MMCategoryDO>();
		mmcaDOList = mmcaRSrv.findByAttrValStrings(MMCategoryDO.CODE, 
				parentCodeList.toArray(new String[parentCodeList.size()]));
		if(mmcaDOList != null && mmcaDOList.length > 0) {
			
			for(MMCategoryDO mmcaDO : mmcaDOS) {
				
				mmcaMap.put(mmcaDO.getCode(), mmcaDO);
			}
		}
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(StringUtils.isBlank(mmcaDO.getParent_code())) {
				
				continue;
			}
			if(!codeList.contains(mmcaDO.getParent_code()) && !mmcaMap.containsKey(mmcaDO.getParent_code())) {
				
				throw new BizException(String.format("物品基本分类【%s】在导入数据、数据库数据中没有对应的上级分类。", mmcaDO.getName()));
			}
		}
	}
	
	private void importMmca(MMCategoryDO[] mmcaDOS, Map<String, UdidocDO> mmtpUdidocList, 
			Map<String, UdidocDO> priModeUdidocList) throws BizException {
		
		//录入根节点数据
		this.importParentNode(mmcaDOS, mmtpUdidocList, priModeUdidocList);
		
		//录入子节点数据
		this.importChildNode(mmcaDOS, mmtpUdidocList, priModeUdidocList);
	}

	private void importParentNode(MMCategoryDO[] mmcaDOS, Map<String, UdidocDO> mmtpUdidocList,
			Map<String, UdidocDO> priModeUdidocList) throws BizException {
		
		List<MMCategoryDO> mmcaList = new ArrayList<MMCategoryDO>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(!StringUtils.isBlank(mmcaDO.getParent_code())) {
				
				continue;
			}
			
			MMCategoryDO initMmcaDO = new MMCategoryDO();
			this.setMmCategoryInfo(mmcaDO, initMmcaDO, null, mmtpUdidocList, priModeUdidocList);
			mmcaList.add(initMmcaDO);
		}
		
		if(mmcaList != null && mmcaList.size() > 0) {
			
			IMmcategoryCudService mmcaCudSrv = ServiceFinder.find(IMmcategoryCudService.class);
			mmcaCudSrv.insert(mmcaList.toArray(new MMCategoryDO[mmcaList.size()]));
		}
	}

	private void setMmCategoryInfo(MMCategoryDO mmcaDO, MMCategoryDO initMmcaDO, String parentID,
			Map<String, UdidocDO> mmtpUdidocList, Map<String, UdidocDO> priModeUdidocList) {
		
		initMmcaDO.setStatus(DOStatus.NEW);
		//集团
		initMmcaDO.setId_grp(Context.get().getGroupId());
		//机构
		initMmcaDO.setId_org(Context.get().getOrgId());
		//医疗物品类型
		UdidocDO udidocDO = mmtpUdidocList.get(mmcaDO.getSd_mmtp());
		initMmcaDO.setId_mmtp(udidocDO.getId_udidoc());
		//医疗物品类型编码
		initMmcaDO.setSd_mmtp(udidocDO.getCode());
		//基本分类编码
		initMmcaDO.setCode(mmcaDO.getCode());
		//基本分类名称
		initMmcaDO.setName(mmcaDO.getName());
		//五笔
		initMmcaDO.setWbcode(mmcaDO.getWbcode());
		//拼音
		initMmcaDO.setPycode(mmcaDO.getPycode());
		//基本分类描述
		initMmcaDO.setDes(mmcaDO.getDes());
		//父级主键
		initMmcaDO.setId_parent(parentID);
		//零售价计算方式
		udidocDO = priModeUdidocList.get(mmcaDO.getSd_primode());
		initMmcaDO.setId_primode(udidocDO.getId_udidoc());
		//默认零售价计算方式编码
		initMmcaDO.setSd_primode(udidocDO.getCode());
		//患者使用标志
		initMmcaDO.setFg_pat(mmcaDO.getFg_pat());
		//是否批次管理
		initMmcaDO.setFg_batch(mmcaDO.getFg_batch());
		//是否价格管理
		initMmcaDO.setFg_price(mmcaDO.getFg_price());
		//加成率
		initMmcaDO.setPap(mmcaDO.getPap());
	}
	
	private void importChildNode(MMCategoryDO[] mmcaDOS, Map<String, UdidocDO> mmtpUdidocList,
			Map<String, UdidocDO> priModeUdidocList) throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		IMmcategoryCudService mmcaCudSrv = ServiceFinder.find(IMmcategoryCudService.class);
		
		//对导入数据进行排序(按树形结构)
		List<MMCategoryDO> mmcaList = new ArrayList<MMCategoryDO>();
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			if(StringUtils.isBlank(mmcaDO.getParent_code())) {
				
				continue;
			}
			if(mmcaList.indexOf(mmcaDO) >= 0) {
				
				continue;
			}
			
			MMCategoryDO mmCategoryDO = this.initMMCategoryDOList(mmcaDOS, mmcaDO);
			mmcaList.add(mmCategoryDO);
			this.initMMCategoryDOList(mmcaList, mmcaDOS, mmCategoryDO);
		}
		
		if(mmcaList != null && mmcaList.size() > 0) {
			
			for(MMCategoryDO mmcaDO : mmcaList) {
				
				String whrStr = String.format("code = '%s'", mmcaDO.getParent_code());
				MMCategoryDO parentDO = mmcaRSrv.find(whrStr, "", FBoolean.TRUE)[0];
				MMCategoryDO initMmcaDO = new MMCategoryDO();
				this.setMmCategoryInfo(mmcaDO, initMmcaDO, parentDO.getId_mmca(), mmtpUdidocList, priModeUdidocList);
				
				mmcaCudSrv.insert(new MMCategoryDO[]{ initMmcaDO });
			}
		}
	}

	private MMCategoryDO initMMCategoryDOList(MMCategoryDO[] mmcaDOS, MMCategoryDO mmcaDO) {
		
		for(MMCategoryDO mmCategoryDO : mmcaDOS) {
			
			if(StringUtils.isBlank(mmCategoryDO.getParent_code())) {
				
				continue;
			}
			
			if(mmCategoryDO.getCode().equals(mmcaDO.getParent_code())) {
				
				return initMMCategoryDOList(mmcaDOS, mmcaDO);
			}
		}
		
		return mmcaDO;
	}
	
	private void initMMCategoryDOList(List<MMCategoryDO> mmcaList, MMCategoryDO[] mmcaDOS, MMCategoryDO mmCategoryDO) {
		
		for(MMCategoryDO currentDO : mmcaDOS) {
			
			if(StringUtils.isBlank(currentDO.getParent_code())) {
				
				continue;
			}
			if(currentDO.getParent_code().equals(mmCategoryDO.getCode())) {
				
				if(mmcaList.indexOf(currentDO) < 0) {
					
					mmcaList.add(currentDO);
					initMMCategoryDOList(mmcaList, mmcaDOS, currentDO);
				}
			}
		}
	}
}
